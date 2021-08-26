package com.hocken.Hockenv4.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Empresa {
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre_empresa;
    private String titular;
    private String email;
    private String telefono;
    private String posicion_reclutar;
    private String rengo_sueldo;
    /**Relación de tabla 1-M modificar fetch si se necesita es para filtrar por id las vacantes*/

   @OneToMany(mappedBy = "empresa")
    private Set<Vacante> vacantes = new HashSet<>();

    /**Relación de tabla M-1*/
    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = "empresas")
    @JsonIgnore
    private Admin admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Set<Vacante> getVacantes() {
        return vacantes;
    }

    public void setVacantes(Set<Vacante> vacantes) {
        this.vacantes = vacantes;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
