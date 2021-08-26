package com.hocken.Hockenv4.dto;

public class VacanteDTO {
    /*Filtros de busqueda conexión FR con BK*/
    private String nombre_vac;
    private String modalidad;
    private String area;
    private String tipo_contrato;
    private String estado;
    private String rango_sul;
    private String ubicacion;
    private String fecha_publ;

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
