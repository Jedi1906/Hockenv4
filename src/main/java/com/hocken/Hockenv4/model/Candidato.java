package com.hocken.Hockenv4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "candidato")
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String fecha_nac;
    private String contrasena;

    /*Datos detalle usuario*/
    private String ciudad_residencia;
    private String puesto_anterior;
    private String area_funcional;
    private String cv;
    private String estado;


    @OneToMany(mappedBy = "candidato",fetch = FetchType.EAGER)
    private Set<VacantePostulada> postuladas = new HashSet<>();

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

    public String getCiudad_residencia() {
        return ciudad_residencia;
    }

    public void setCiudad_residencia(String ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }

    public String getPuesto_anterior() {
        return puesto_anterior;
    }

    public void setPuesto_anterior(String puesto_anterior) {
        this.puesto_anterior = puesto_anterior;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getArea_funcional() {
        return area_funcional;
    }

    public void setArea_funcional(String area_funcional) {
        this.area_funcional = area_funcional;
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

    public Set<VacantePostulada> getPostuladas() {
        return postuladas;
    }

    public void setPostuladas(Set<VacantePostulada> postuladas) {
        this.postuladas = postuladas;
    }
}
