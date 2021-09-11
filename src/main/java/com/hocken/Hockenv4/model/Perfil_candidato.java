package com.hocken.Hockenv4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hocken.Hockenv4.security.entity.Usuario;

import javax.persistence.*;

@Entity
public class Perfil_candidato {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ciudad;
    private String p_anterior;
    private String area;
    private String cv;
    private String estado;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "candidatos")
    @JsonIgnore
    private Usuario usuario;
    public Perfil_candidato() {
    }
    public Perfil_candidato(String ciudad, String p_anterior, String area, String cv, String estado, Usuario usuario) {
        this.ciudad = ciudad;
        this.p_anterior = p_anterior;
        this.area = area;
        this.cv = cv;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
