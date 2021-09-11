package com.hocken.Hockenv4.controller;

import com.hocken.Hockenv4.model.Perfil_candidato;
import com.hocken.Hockenv4.security.dto.NuevoUsuario;
import com.hocken.Hockenv4.security.entity.Usuario;
import com.hocken.Hockenv4.security.services.UsuarioService;
import com.hocken.Hockenv4.services.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class CandidatoController {
    @Autowired
    PerfilService perflService;
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("perfiles")
    public List<Perfil_candidato> findAll(){
        return perflService.findAll();
    }
    @GetMapping("perfilbyCiudad/{ciudad}")
    public List<Perfil_candidato> findByCiudad(@PathVariable String ciudad){
        return perflService.findByCiudad(ciudad);
    }
    @GetMapping("perfilbyArea/{area}")
    public List<Perfil_candidato> findByArea(@PathVariable String area){
        return perflService.findByArea(area);
    }

}
