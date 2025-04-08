package com.makoki.clases.construcciones;

import java.util.ArrayList;

import com.makoki.clases.investigacion.Recurso;

public class Almacen {
    Edificio edificio;
    private final ArrayList<Silo> silos;
    
    public Almacen(Edificio edificio) {
        this.edificio = edificio;
        silos = new ArrayList<>();
    }
    public void agregarSilo(Silo silo) {
        silos.add(silo);
    }
    public void eliminarSilo(Silo silo) {
        silos.remove(silo);
    }
    public ArrayList<Silo> getSilos() {
        return silos;
    }

    public Silo getSiloPorRecurso(Recurso recurso) {
        for (Silo silo : silos) {
            if (silo.getRecurso().equals(recurso)) {
                return silo;
            }
        }
        
        return null;
    }
}
