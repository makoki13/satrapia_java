package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.usuarios.Jugador;

import java.util.List;

public class Imperio {
    private int id;

    public String nombre;

    private boolean esTribu;

    public List<Jugador> jugadores;

    public Imperio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addJugador(Jugador j) {
        //TODO
    }


    public List<Jugador> jugadores() {
        return jugadores;
    }
}
