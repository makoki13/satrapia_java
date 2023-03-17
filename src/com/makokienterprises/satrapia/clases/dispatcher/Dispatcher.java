package com.makokienterprises.satrapia.clases.dispatcher;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Dispatcher {
    private static List<Tarea> tareas = new ArrayList<>();
    public static void ejecuta() {
        for (Iterator<Tarea> iter = tareas.iterator(); iter.hasNext(); ) {
            Tarea element = iter.next();

            System.out.println("Instant = " + Instant.now());
            System.out.println("element = " + element.siguienteEjecucion);

            if (Instant.now().isAfter(element.siguienteEjecucion)) {
                //System.out.println("element = " + element.toString());
                element.siguienteEjecucion = element.siguienteEjecucion.plusSeconds(element.deltaTiempo);
                System.out.println("new element = " + element.siguienteEjecucion);
                System.out.println();
            }
        }
    }

    public static void inicializa() {
        //tareas = null;
    }

    public static void addTarea(Tarea tarea) {
        tareas.add(tarea);
    }
}
