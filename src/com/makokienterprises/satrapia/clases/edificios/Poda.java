package com.makokienterprises.satrapia.clases.edificios;

public class Poda extends FuenteDeRecursos {
    public Poda() {
        this.recurso = Recursos.MADERA;
        this.inagotable = true;
    }

    @Override
    public int extrae(int numeroParticipantes, double aporte) {
        return (int)(numeroParticipantes * aporte);
    }
}
