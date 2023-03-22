package com.makokienterprises.satrapia.clases.usuarios;

import com.makokienterprises.satrapia.clases.geo.Imperio;
import com.makokienterprises.satrapia.clases.geo.Nacion;

public class Jugador {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    public enum Roles {
        EMPERADOR,
        SATRAPA,
        JEFE_DE_TRIBU
    }
    private long id;
    private Usuario usuario;

    private String nombre;

    private Roles rol;

    private Nacion nacion;

    private Imperio imperio;

    public Jugador() {
        this.id = ++ultimoID;
    }

    public long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public void setNacion(Nacion nacion) {
        this.nacion = nacion;
    }

    public Nacion getNacion() {
        return nacion;
    }

    public Imperio getImperio() {
        return this.imperio;
    }

    public void setImperio(Imperio imperio) {
        this.imperio = imperio;
    }
}
