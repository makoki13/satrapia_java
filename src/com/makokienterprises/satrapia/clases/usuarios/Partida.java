package com.makokienterprises.satrapia.clases.usuarios;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.geo.Imperio;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;
    private long id;

    public String nombre;

    private List<Imperio> imperios = new ArrayList<>();

    public Partida(String nombre) {
        this.id = ++ultimoID;
        this.nombre = nombre;
    }

    public void addImperio(Imperio imperio) {
        imperios.add(imperio);
    }

    public List<Imperio> listaImperios() {
        return imperios;
    }

    public long getId() {
        return id;
    }
}
