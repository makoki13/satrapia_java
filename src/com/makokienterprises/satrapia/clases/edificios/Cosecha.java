package com.makokienterprises.satrapia.clases.edificios;

public class Cosecha extends FuenteDeRecursos {
    public Cosecha() {
        this.recurso = Recursos.COMIDA;
        this.inagotable = true;
    }

    @Override
    public int extrae(int numeroParticipantes, double aporte) {
        return (int)(numeroParticipantes * aporte);
    }
}
