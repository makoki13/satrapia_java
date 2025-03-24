package com.makoki.clases.construcciones;

import java.util.ArrayList;

public class Almacen {
    private final ArrayList<Silo> silos;
    
    public Almacen() {
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
}
