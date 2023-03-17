package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.usuarios.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Imperio {
    private int id;

    public String nombre;

    private boolean esTribu;

    public List<Jugador> jugadores = new ArrayList<>();

    public Imperio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addJugador(Jugador j) {
        jugadores.add(j);
    }

    public void setEsTribu(boolean esTribu) {
        this.esTribu = esTribu;
    }

    public boolean getEsTribu() {
        return this.esTribu;
    }


    public List<Jugador> jugadores() {
        return jugadores;
    }
}
