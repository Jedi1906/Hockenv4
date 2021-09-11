package com.hocken.Hockenv4.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vacante {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_vac;
    private String ubicacion;
    private String modalidad;
    private String rango_sul;
    private String area;
    private String descripcion;
    private String fecha_publ;
    private String tipo_contrato;
    private String perfil_ideal;
    private String ofrecemos;
    private String estado;
    /**Relación de tabla M-1*/
   @ManyToOne(optional = false,cascade = CascadeType.ALL)
   @JsonIgnoreProperties(value = "vacantes")
    private Empresa empresa;
    @OneToMany(mappedBy = "vacante", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<VacantePostulada> postuladas = new HashSet<>();

    public Vacante() {
    }

    public Vacante(String nombre_vac, String ubicacion, String modalidad, String rango_sul, String area, String descripcion, String fecha_publ, String tipo_contrato, String perfil_ideal, String ofrecemos, String estado, Empresa empresa, Set<VacantePostulada> postuladas) {
        this.nombre_vac = nombre_vac;
        this.ubicacion = ubicacion;
        this.modalidad = modalidad;
        this.rango_sul = rango_sul;
        this.area = area;
        this.descripcion = descripcion;
        this.fecha_publ = fecha_publ;
        this.tipo_contrato = tipo_contrato;
        this.perfil_ideal = perfil_ideal;
        this.ofrecemos = ofrecemos;
        this.estado = estado;
        this.empresa = empresa;
        this.postuladas = postuladas;
    }

    public Vacante(String nombre_vac, String ubicacion, String modalidad, String rango_sul, String area, String descripcion, String fecha_publ, String tipo_contrato, String perfil_ideal, String ofrecemos, String estado, Empresa empresa) {
        this.nombre_vac = nombre_vac;
        this.ubicacion = ubicacion;
        this.modalidad = modalidad;
        this.rango_sul = rango_sul;
        this.area = area;
        this.descripcion = descripcion;
        this.fecha_publ = fecha_publ;
        this.tipo_contrato = tipo_contrato;
        this.perfil_ideal = perfil_ideal;
        this.ofrecemos = ofrecemos;
        this.estado = estado;
        this.empresa = empresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public String getNombre_vac() {
        return nombre_vac;
    }

    public void setNombre_vac(String nombre_vac) {
        this.nombre_vac = nombre_vac;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getRango_sul() {
        return rango_sul;
    }

    public void setRango_sul(String rango_sul) {
        this.rango_sul = rango_sul;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_publ() {
        return fecha_publ;
    }

    public void setFecha_publ(String fecha_publ) {
        this.fecha_publ = fecha_publ;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getPerfil_ideal() {
        return perfil_ideal;
    }

    public void setPerfil_ideal(String perfil_ideal) {
        this.perfil_ideal = perfil_ideal;
    }

    public String getOfrecemos() {
        return ofrecemos;
    }

    public void setOfrecemos(String ofrecemos) {
        this.ofrecemos = ofrecemos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Set<VacantePostulada> getPostuladas() {
        return postuladas;
    }

    public void setPostuladas(Set<VacantePostulada> postuladas) {
        this.postuladas = postuladas;
    }
}
