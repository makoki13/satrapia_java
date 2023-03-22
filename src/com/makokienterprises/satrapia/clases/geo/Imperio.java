package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.usuarios.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Imperio {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    private long id;

    public String nombre;

    private boolean esTribu;

    public List<Jugador> jugadores = new ArrayList<>();

    public Imperio(String nombre) {
        this.id = ++ultimoID;
        this.nombre = nombre;
    }

    public long getId() {
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
