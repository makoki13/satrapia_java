package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.usuarios.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Nacion {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;
    private long id;

    public String nombre;

    public List<Region> regiones = new ArrayList<>();

    public Jugador jugador;

    public Nacion(String nombre) {
        this.id = ++ultimoID;
        this.nombre = nombre;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void addRegion(Region region) {
        regiones.add(region);
    }

    public List<Region> regiones () {
        return regiones;
    }

}
