package com.makoki.clases.geo;

import com.makoki.clases.usuarios.Jugador;

public class Reino {
    long ID;
    String nombre;
    Jugador propietario;

    public Reino(long ID, String nombre, Jugador propietario) {
        this.ID = ID;
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public long getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
}
