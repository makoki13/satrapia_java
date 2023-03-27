package com.makokienterprises.satrapia.clases.edificios;

abstract public class FuenteDeRecursos {
    public Recursos recurso;

    public int stock;
    public boolean inagotable;

    abstract public int extrae(int numeroParticipantes, double aporte);
}
