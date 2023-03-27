package com.makokienterprises.satrapia.clases.edificios;

abstract public class FuenteDeRecursos {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    protected long id;
    public Recursos recurso;

    public Edificio edificio;

    public int stock;
    public boolean inagotable;

    public FuenteDeRecursos() {
        id = ultimoID;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    abstract public int extrae(int numeroParticipantes, double aporte);
}
