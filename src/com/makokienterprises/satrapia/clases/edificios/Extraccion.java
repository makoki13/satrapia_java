package com.makokienterprises.satrapia.clases.edificios;

public class Extraccion extends FuenteDeRecursos {
    public Extraccion() {
        this.recurso = Recursos.PIEDRA;
        this.inagotable = false;
    }

    @Override
    public int extrae(int numeroParticipantes, double aporte) {
        return (int)(numeroParticipantes * aporte);
    }
}
