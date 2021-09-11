package com.hocken.Hockenv4.controller;

import com.hocken.Hockenv4.dto.EmpresaDTO;
import com.hocken.Hockenv4.dto.Mensajes;
import com.hocken.Hockenv4.model.Empresa;
import com.hocken.Hockenv4.security.entity.Usuario;
import com.hocken.Hockenv4.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;
    Usuario usuario;
    @GetMapping("empresas")
    public List<Empresa> findAll(){
        return  empresaService.findAll();
    }

    /*Falta insertar el id de usuario*/
    @PostMapping("nuevaEmpresa")
    public ResponseEntity<?> nuevaEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensajes("Campos mal colocados o email incorrecto"), HttpStatus.BAD_REQUEST);

        Empresa empresa =
                new Empresa(empresaDTO.getNombre_empresa(),empresaDTO.getTitular(),empresaDTO.getEmail(),empresaDTO.getTelefono(),
                empresaDTO.getPosicion_reclutar(),empresaDTO.getRengo_sueldo(),usuario);
        empresaService.save(empresa);
        return new ResponseEntity(new Mensajes("Empresa registrada con exito"),HttpStatus.CREATED);
    }
    @DeleteMapping("eliminar/{id}")
    public void delete(@PathVariable int id){
        empresaService.remove(id);
    }
}
