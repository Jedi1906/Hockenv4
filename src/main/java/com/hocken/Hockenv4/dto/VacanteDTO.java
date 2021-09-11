package com.hocken.Hockenv4.dto;

import com.hocken.Hockenv4.model.Empresa;
import com.hocken.Hockenv4.security.entity.Usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class VacanteDTO {
    /*Filtros de busqueda conexión FR con BK*/
    private String nombre_vac;
    private String modalidad;
    private String area;
    private String tipo_contrato;
    private String estado;
    private String rango_sul;
    private String ubicacion;
    private String descripcion;
    private String perfil_ideal;
    private String ofrecemos;

    public String getOfrecemos() {
        return ofrecemos;
    }

    public void setOfrecemos(String ofrecemos) {
        this.ofrecemos = ofrecemos;
    }

    public String getPerfil_ideal() {
        return perfil_ideal;
    }

    public void setPerfil_ideal(String perfil_ideal) {
        this.perfil_ideal = perfil_ideal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private String fecha_publ;
    private Empresa empresa;

    /*Empresa*/
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public VacanteDTO() {
    }

    public String getNombre_vac() {
        return nombre_vac;
    }

    public void setNombre_vac(String nombre_vac) {
        this.nombre_vac = nombre_vac;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(String tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRango_sul() {
        return rango_sul;
    }

    public void setRango_sul(String rango_sul) {
        this.rango_sul = rango_sul;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha_publ() {
        return fecha_publ;
    }

    public void setFecha_publ(String fecha_publ) {
        this.fecha_publ = fecha_publ;
    }
}
