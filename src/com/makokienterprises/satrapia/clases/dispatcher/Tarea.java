package com.makokienterprises.satrapia.clases.dispatcher;

import java.time.Instant;

public class Tarea {
    private Object agente;
    private String funcion;

    public int deltaTiempo;
    public Instant siguienteEjecucion;

    private boolean terminado = false; //Si true terminar

    public Tarea(Object agente, String funcion, int deltaTiempo) {
        this.agente = agente;
        this.funcion = funcion;
        this.deltaTiempo = deltaTiempo;
        this.siguienteEjecucion = Instant.now();
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "agente=" + agente +
                ", funcion='" + funcion + '\'' +
                ", deltaTiempo=" + deltaTiempo +
                ", siguienteEjecucion=" + siguienteEjecucion +
                ", terminado=" + terminado +
                '}';
    }
}
