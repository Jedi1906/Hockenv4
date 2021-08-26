package com.hocken.Hockenv4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class VacantePostulada {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fecha;
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = "postuladas")
    private Candidato candidato;
   @ManyToOne(optional = false)
   @JsonIgnoreProperties(value = "postuladas")
    private Vacante vacante;

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

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato =candidato;
    }

    public Vacante getVacante() {
        return vacante;
    }

    public void setVacante(Vacante vacante) {
        this.vacante =vacante;
    }
}
