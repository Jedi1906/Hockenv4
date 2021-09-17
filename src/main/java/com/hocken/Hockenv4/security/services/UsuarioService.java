package com.hocken.Hockenv4.security.services;

import com.hocken.Hockenv4.model.Perfil_candidato;
import com.hocken.Hockenv4.security.dao.UsuarioDAO;
import com.hocken.Hockenv4.security.dto.NuevoUsuario;
import com.hocken.Hockenv4.security.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService{
    @Autowired
    UsuarioDAO usuarioDAO;
    public Optional<Usuario> getByNombre(String correo){
        return usuarioDAO.findByCorreo(correo);
    }
    public  boolean existbyCorreo(String correo){
        return usuarioDAO.existsByCorreo(correo);
    }
    public List<Usuario> findAll(){
        return usuarioDAO.findAll();
    }
    public void save(Usuario usuario) {
         usuarioDAO.save(usuario);
    }
    //Sentencia OR
    public Optional<Usuario> findByNombreOrCorreo(String nombreOrcorreo){
        return usuarioDAO.findByNombreOrCorreo(nombreOrcorreo,nombreOrcorreo);
    }
    public Optional<Usuario> findByTokencontrasena(String token){
        return usuarioDAO.findByTokencontrasena(token);
    }
    public List<Usuario> findbyId(int id){
        return usuarioDAO.findById(id);
    }
}
