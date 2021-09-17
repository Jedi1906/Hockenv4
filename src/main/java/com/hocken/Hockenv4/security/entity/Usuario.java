package com.hocken.Hockenv4.security.entity;

import com.hocken.Hockenv4.model.Empresa;
import com.hocken.Hockenv4.model.Perfil_candidato;
import com.hocken.Hockenv4.model.VacantePostulada;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    @Column(unique = true)
    private String correo;
    private String telefono;
    private String fecha_nac;
    private String contrasena;
    private String tokencontrasena;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Empresa> empresas = new HashSet<>();

    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VacantePostulada> postuladas = new HashSet<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Perfil_candidato> candidatos = new HashSet<>();
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name ="usuario_rol", joinColumns =  @JoinColumn(name ="usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario( String nombre, String apellido, String correo, String telefono, String fecha_nac, String contrasena, Set<Empresa> empresas, Set<VacantePostulada> postuladas, Set<Perfil_candidato> candidatos, Set<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.contrasena = contrasena;
        this.empresas = empresas;
        this.postuladas = postuladas;
        this.candidatos = candidatos;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellido, String correo, String telefono, String fecha_nac, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.fecha_nac = fecha_nac;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
    public String getTokencontrasena() {
        return tokencontrasena;
    }

    public void setTokencontrasena(String tokencontrasena) {
        this.tokencontrasena = tokencontrasena;
    }



    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Set<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Set<VacantePostulada> getPostuladas() {
        return postuladas;
    }

    public void setPostuladas(Set<VacantePostulada> postuladas) {
        this.postuladas = postuladas;
    }

    public Set<Perfil_candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Set<Perfil_candidato> candidatos) {
        this.candidatos = candidatos;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
}
