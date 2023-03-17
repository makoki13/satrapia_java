package com.makokienterprises.satrapia.clases.edificios;

public abstract class FuenteDeRecursos {
    public Recursos recurso;

    public int stock;
    public boolean inagotable;

    public abstract int extrae(int numeroParticipantes, double aporte);
}
