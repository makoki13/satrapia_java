package com.makokienterprises.satrapia.clases.usuarios;

import com.makokienterprises.satrapia.clases.geo.Imperio;
import com.makokienterprises.satrapia.clases.geo.Nacion;

public class Jugador {
    enum Roles {
        EMPERADOR,
        SATRAPA,
        JEFE_DE_TRIBU
    }
    private int id;
    private Usuario usuario;

    private String nombre;

    private Roles rol;

    private Nacion nacion;

    private int idImperio;

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
}
