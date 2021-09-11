package com.hocken.Hockenv4.dto;

import com.hocken.Hockenv4.security.entity.Usuario;

public class PerfilDTO {
    private String ciudad;
    private String p_anterior;
    private String area;
    private String cv;
    private String estado;
    private Usuario usuario;
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getP_anterior() {
        return p_anterior;
    }

    public void setP_anterior(String p_anterior) {
        this.p_anterior = p_anterior;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
