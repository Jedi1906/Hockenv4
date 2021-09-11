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
}
