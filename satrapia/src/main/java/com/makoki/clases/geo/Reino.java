package com.makoki.clases.geo;

import java.util.ArrayList;
import java.util.List;

import com.makoki.clases.usuarios.Jugador;

public class Reino {
    long ID;
    String nombre;
    Jugador propietario;
    List<Ciudad> ciudades;

    public Reino(long ID, String nombre, Jugador propietario) {
        this.ID = ID;
        this.nombre = nombre;
        this.propietario = propietario;
        this.ciudades = new ArrayList<>();
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

    public void addCiudad(Ciudad ciudad) {
        ciudades.add(ciudad);
    }
}
