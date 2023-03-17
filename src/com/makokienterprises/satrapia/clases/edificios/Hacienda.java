package com.makokienterprises.satrapia.clases.edificios;

public class Hacienda extends FuenteDeRecursos {
    public Hacienda() {
        this.recurso = Recursos.ORO;
        this.inagotable = true;
    }

    @Override
    public int extrae(int numeroParticipantes, double aporte) {
        return (int)(numeroParticipantes * aporte);
    }
}
