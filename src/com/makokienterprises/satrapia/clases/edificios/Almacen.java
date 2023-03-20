package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.geo.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    private int id;
    private String nombre;

    private Edificio edificio;

    public List<Silo> silos = new ArrayList<>();

    public Almacen(int id, String nombre, Edificio edificio) {
        this.id = id;
        this.nombre = nombre;
        this.edificio = edificio;
    }

    public void addSilo(Silo silo) {
        silos.add(silo);
    }
    public Silo getSilo(Recursos recurso) {
        //TODO
        for(Silo silo: silos) {
            if (silo.recurso == recurso) {
                return silo;
            }
        }
        return null;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Ciudad getCiudad() {
        return this.edificio.getCiudad();
    }
}
