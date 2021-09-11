package com.hocken.Hockenv4.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hocken.Hockenv4.security.entity.Usuario;

import javax.persistence.*;

@Entity
public class VacantePostulada {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fecha;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "postuladas")
    private Usuario usuario;
   @ManyToOne(optional = false, cascade = CascadeType.ALL)
   @JsonIgnoreProperties(value = "postuladas")
    private Vacante vacante;

    public VacantePostulada() {
    }
    public VacantePostulada(String fecha, Usuario usuario, Vacante vacante) {
        this.fecha = fecha;
        this.usuario = usuario;
        this.vacante = vacante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante = vacante;
    }
}
