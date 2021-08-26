package com.hocken.Hockenv4.criterio;

import io.github.jhipster.service.filter.StringFilter;
/**Clase de criterios de busqueda en caso necesario modificar la base para sueldo*/
public class FiltroVacante {
    /*Filtros fijos Hocken.mx*/
    private StringFilter nombre_vac;
    private StringFilter modalidad;
    private StringFilter fecha_publ;
    private StringFilter area;
    private StringFilter rango_sul;
    private StringFilter tipo_contrato;
    private StringFilter ubicacion;

    /*Filtro admin*/
    private StringFilter estado;


    public StringFilter getNombre_vac() {
        return nombre_vac;
    }

    public void setNombre_vac(StringFilter nombre_vac) {
        this.nombre_vac = nombre_vac;
    }

    public StringFilter getModalidad() {
        return modalidad;
    }

    public void setModalidad(StringFilter modalidad) {
        this.modalidad = modalidad;
    }

    public StringFilter getFecha_publ() {
        return fecha_publ;
    }

    public void setFecha_publ(StringFilter fecha_publ) {
        this.fecha_publ = fecha_publ;
    }

    public StringFilter getArea() {
        return area;
    }

    public void setArea(StringFilter area) {
        this.area = area;
    }

    public StringFilter getRango_sul() {
        return rango_sul;
    }

    public void setRango_sul(StringFilter rango_sul) {
        this.rango_sul = rango_sul;
    }

    public StringFilter getTipo_contrato() {
        return tipo_contrato;
    }

    public void setTipo_contrato(StringFilter tipo_contrato) {
        this.tipo_contrato = tipo_contrato;
    }

    public StringFilter getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(StringFilter ubicacion) {
        this.ubicacion = ubicacion;
    }

    public StringFilter getEstado() {
        return estado;
    }

    public void setEstado(StringFilter estado) {
        this.estado = estado;
    }
}
