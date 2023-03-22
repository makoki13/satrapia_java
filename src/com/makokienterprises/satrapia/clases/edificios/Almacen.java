package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.geo.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class Almacen {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    private long id;
    private String nombre;

    private Edificio edificio;

    public List<Silo> silos = new ArrayList<>();

    public Almacen( String nombre, Edificio edificio) {
        this.id = ++ultimoID;
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

    public long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Ciudad getCiudad() {
        return this.edificio.getCiudad();
    }
}
