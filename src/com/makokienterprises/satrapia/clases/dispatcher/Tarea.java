package com.makokienterprises.satrapia.clases.dispatcher;

import com.makokienterprises.satrapia.clases.edificios.Transporte;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.concurrent.Callable;

public class Tarea {
    public Object agente;
    public Object emisor;
    public Method funcion;
    public Method destructor;

    public int deltaTiempo;
    public Instant siguienteEjecucion;

    public boolean terminado = false; //Si true terminar

    public Tarea(Object agente, Method funcion, int deltaTiempo, Object emisor, Method destructor) {
        this.agente = agente;
        this.funcion = funcion;
        this.deltaTiempo = deltaTiempo;
        this.siguienteEjecucion = Instant.now();
        this.emisor = emisor;
        this.destructor = destructor;
        this.terminado = false;
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

    public void haMuerto() throws InvocationTargetException, IllegalAccessException {
        this.terminado = true;
        if (this.destructor != null) {
//            System.out.println("agente = " + agente +
//                    " funcion: " + funcion +
//                    " emisor: " + emisor +
//                    " destructor: " + destructor);
            boolean resultado = (boolean) this.destructor.invoke(this.emisor);
        }
    }
}
