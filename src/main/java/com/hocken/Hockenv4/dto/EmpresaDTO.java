package com.hocken.Hockenv4.dto;

import com.hocken.Hockenv4.security.entity.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmpresaDTO {
    @NotBlank
    private String nombre_empresa;
    @NotBlank
    private String titular;
    @Email
    private String email;
    @NotBlank
    private String telefono;
    @NotBlank
    private String posicion_reclutar;
    @NotBlank
    private String rengo_sueldo;
    private Usuario usuario;
    private int id_usuario;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPosicion_reclutar() {
        return posicion_reclutar;
    }

    public void setPosicion_reclutar(String posicion_reclutar) {
        this.posicion_reclutar = posicion_reclutar;
    }

    public String getRengo_sueldo() {
        return rengo_sueldo;
    }

    public void setRengo_sueldo(String rengo_sueldo) {
        this.rengo_sueldo = rengo_sueldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
