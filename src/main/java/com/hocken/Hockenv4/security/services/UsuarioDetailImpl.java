package com.hocken.Hockenv4.security.services;

import com.hocken.Hockenv4.security.entity.Usuario;
import com.hocken.Hockenv4.security.entity.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
//Clase de implementación de servicio
@Service
public class UsuarioDetailImpl implements UserDetailsService {
    @Autowired
    UsuarioService usuarioService;
    /*Inicio de sesión por nombre o correo*/
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByNombreOrCorreo(s).get();
        return UsuarioPrincipal.build(usuario);
    }


}
