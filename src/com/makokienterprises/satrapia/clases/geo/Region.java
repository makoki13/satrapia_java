package com.makokienterprises.satrapia.clases.geo;

import java.util.List;

public class Region {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    private long id;
    public String nombre;

    private List<Punto> puntos;

    private List<Ciudad> ciudades;

    public Region(String nombre, List<Punto> puntos) {
        this.id = ++ultimoID;
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

    public long getId() {
        return this.id;
    }

    public void addCiudad(Ciudad c) {
        //TODO
    }

    public List<Ciudad> ciudades() {
        return ciudades;
    }
}
