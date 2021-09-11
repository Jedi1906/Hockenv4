package com.hocken.Hockenv4.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioPrincipal implements UserDetails {
    /*admin*/
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String fecha_nac;
    private String contrasena;
    /*Seguridad autentificación*/
    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public UsuarioPrincipal() {
    }
    /*Modificar si ocasiona conflicto solo generalizando usuario en ambos*/
    public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =usuario.getRoles().stream().
                map(rol -> new SimpleGrantedAuthority(rol.getRolnombre().name()))
                .collect(Collectors.toList());
                 return new UsuarioPrincipal
                (usuario.getNombre(),usuario.getApellido(),usuario.getContrasena(),usuario.getCorreo(),
                        usuario.getTelefono(),usuario.getFecha_nac(),authorities);
    }
    public UsuarioPrincipal(String nombre, String apellido, String contrasena, String correo, String telefono, String fecha_nac , Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.authorities = authorities;
    }
    @Override
    public String getPassword() {
        return contrasena;
    }
    @Override
    public String getUsername() {
        return correo;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFecha_nac() {
        return fecha_nac;
    }
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
