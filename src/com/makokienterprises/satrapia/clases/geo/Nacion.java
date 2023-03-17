package com.makokienterprises.satrapia.clases.geo;

import java.util.ArrayList;
import java.util.List;

public class Nacion {
    private int id;

    public String nombre;

    public List<Region> regiones = new ArrayList<>();

    public int idJugador;

    public Nacion(String nombre) {
        this.nombre = nombre;
    }

    public void setJugador(int id) {
        this.idJugador = id;
    }

    public void addRegion(Region region) {
        regiones.add(region);
    }

    public List<Region> regiones () {
        return regiones;
    }

}
