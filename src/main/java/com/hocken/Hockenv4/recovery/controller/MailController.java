package com.hocken.Hockenv4.recovery.controller;

import com.hocken.Hockenv4.dto.Mensajes;
import com.hocken.Hockenv4.recovery.dto.CambioDTO;
import com.hocken.Hockenv4.recovery.dto.MailDTO;
import com.hocken.Hockenv4.recovery.service.EmailService;
import com.hocken.Hockenv4.security.entity.Usuario;
import com.hocken.Hockenv4.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class MailController {
    @Value("${spring.mail.username}")
    private String mailFrom;
    @Autowired
    EmailService emailService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/correo-html")
    public ResponseEntity<?> sendEmailTemplate(@RequestBody MailDTO dto){
        Optional<Usuario> usuarioOpt = usuarioService.findByNombreOrCorreo(dto.getMailTo());
        if(!usuarioOpt.isPresent()){
            return new ResponseEntity(new Mensajes("No existe ningun usuario con esos datos "),HttpStatus.NOT_FOUND);
        }
        Usuario usuario = usuarioOpt.get();
        dto.setMailFrom(mailFrom);
        dto.setMailTo(usuario.getCorreo());
        dto.setMailSubject("Modificación de contraseña");
        dto.setNombre(usuario.getNombre());
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        dto.setToken(token);
        usuario.setTokencontrasena(token);
        usuarioService.save(usuario);
        emailService.sendMail(dto);
        return new ResponseEntity("Correo bonito enviado con exito", HttpStatus.OK);
    }
    @PostMapping("/cambio")
    public ResponseEntity<?> CambiarContrasena(@Valid @RequestBody CambioDTO dto, BindingResult binding){
    if(binding.hasErrors())
        return new ResponseEntity(new Mensajes("Campos mal puestos"),HttpStatus.BAD_REQUEST);
    if(!dto.getContrasena().equals(dto.getConfirmacion()))
        return new ResponseEntity(new Mensajes("Las contraseñas no coinciden"),HttpStatus.BAD_REQUEST);
    Optional<Usuario> usuarioOpt = usuarioService.findByTokencontrasena(dto.getToken());
        if(!usuarioOpt.isPresent())
            return new ResponseEntity(new Mensajes("No existe ningun usuario con esos datos "),HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioOpt.get();
        String cambioPassword = passwordEncoder.encode(dto.getContrasena());
        usuario.setContrasena(cambioPassword);
        usuario.setTokencontrasena(null);
        usuarioService.save(usuario);
    return new ResponseEntity(new Mensajes("La contraseña se modifico de manera correcta"),HttpStatus.OK);
    }
}
