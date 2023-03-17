package com.makokienterprises.satrapia.clases.geo;

import java.util.List;

public class Region {
    private int id;
    public String nombre;

    private List<Punto> puntos;

    private List<Ciudad> ciudades;

    public Region(int id, String nombre, List<Punto> puntos) {
        this.id = id;
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addPunto(Punto p) {
        //TODO
    }

    public boolean tieneEsePunto(Punto p) {
        //TODO
        return false;
    }

    public List<Punto> puntos() {
        return puntos;
    }

    public void addCiudad(Ciudad c) {
        //TODO
    }

    public List<Ciudad> ciudades() {
        return ciudades;
    }
}
