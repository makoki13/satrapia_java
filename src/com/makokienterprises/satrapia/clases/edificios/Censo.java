package com.makokienterprises.satrapia.clases.edificios;

public class Censo extends FuenteDeRecursos{
    @Override
    public int extrae(int numeroParticipantes, double aporte) {
        return (int)(numeroParticipantes * aporte);
    }
}
