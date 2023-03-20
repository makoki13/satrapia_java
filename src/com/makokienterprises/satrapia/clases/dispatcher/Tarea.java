package com.makokienterprises.satrapia.clases.dispatcher;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.concurrent.Callable;

public class Tarea {
    public Object agente;
    public Method funcion;

    public int deltaTiempo;
    public Instant siguienteEjecucion;

    private boolean terminado = false; //Si true terminar

    public Tarea(Object agente, Method funcion, int deltaTiempo) {
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
