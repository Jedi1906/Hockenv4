package com.hocken.Hockenv4.security.controller;

import com.hocken.Hockenv4.dto.Mensajes;
import com.hocken.Hockenv4.model.Perfil_candidato;
import com.hocken.Hockenv4.security.dto.JwtDTO;
import com.hocken.Hockenv4.security.dto.LoginUsuario;
import com.hocken.Hockenv4.security.dto.NuevoUsuario;
import com.hocken.Hockenv4.security.entity.Rol;
import com.hocken.Hockenv4.security.entity.Usuario;
import com.hocken.Hockenv4.security.enums.Rolnombre;
import com.hocken.Hockenv4.security.jwt.JwtProvider;
import com.hocken.Hockenv4.security.services.RolService;
import com.hocken.Hockenv4.security.services.UsuarioService;
import com.hocken.Hockenv4.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
@CrossOrigin (origins = "*")
public class AuthController {
    @Autowired
    PerfilService perfilService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager manager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/usuarios")
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }


    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
    return new ResponseEntity(new Mensajes("Campos mal colocados o email incorrecto"), HttpStatus.BAD_REQUEST);
    if(usuarioService.existbyCorreo(nuevoUsuario.getCorreo()))
        return new ResponseEntity(new Mensajes("Ese correo ya se encuentra registrado"),HttpStatus.BAD_REQUEST);
    Usuario usuario =
            new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getApellido(),nuevoUsuario.getCorreo(),
                    nuevoUsuario.getTelefono(),nuevoUsuario.getFecha_nac(),passwordEncoder.encode(nuevoUsuario.getContrasena()));
    Set<Rol> roles = new HashSet<>();
        Perfil_candidato candidato =
                new Perfil_candidato(nuevoUsuario.getCiudad(),
                        nuevoUsuario.getP_anterior(),nuevoUsuario.getArea()
                        ,nuevoUsuario.getCv(),nuevoUsuario.getEstado(),usuario);
    roles.add(rolService.getByRolnombre(Rolnombre.ROLE_CANDIDATO).get());
    if(nuevoUsuario.getRoles().contains("admin"))
        roles.add(rolService.getByRolnombre(Rolnombre.ROLE_ADMIN).get());
   usuario.setRoles(roles);
    usuarioService.save(usuario);
    perfilService.save(candidato);
    return new ResponseEntity(new Mensajes("Registrado de manera exitosa"),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
    if(bindingResult.hasErrors())
        return new ResponseEntity(new Mensajes("Campos mal colocados o email incorrecto"), HttpStatus.BAD_REQUEST);
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getCorreo(),loginUsuario.getContrasena()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDTO jwtDTO = new JwtDTO(jwt);
        return new ResponseEntity(jwtDTO, HttpStatus.OK);
    }

}
