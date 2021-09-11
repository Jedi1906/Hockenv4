package com.hocken.Hockenv4.security.entity;

import com.hocken.Hockenv4.security.enums.Rolnombre;

import javax.persistence.*;

@Entity
public class Rol {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Rolnombre rolnombre;
    public Rol() {
    }
    public Rol(Rolnombre rolnombre) {
        this.rolnombre = rolnombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rolnombre getRolnombre() {
        return rolnombre;
    }

    public void setRolnombre(Rolnombre rolnombre) {
        this.rolnombre = rolnombre;
    }
}
