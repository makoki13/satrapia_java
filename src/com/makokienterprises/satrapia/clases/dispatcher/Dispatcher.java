package com.makokienterprises.satrapia.clases.dispatcher;

import com.makokienterprises.satrapia.pruebas.TestDispatcher;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class DispatcherRun extends TimerTask
{
    public void run()
    {
        try {
            Dispatcher.ejecuta();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        //System.out.println("Timer ran" + ++i);
        if(false)
        {
            synchronized(TestDispatcher.obj)
            {
                TestDispatcher.obj.notify();
            }
        }
    }

}

public class Dispatcher {
    private static List<Tarea> tareas = new CopyOnWriteArrayList<>();
    private static List<Tarea> tareasBackUp = new CopyOnWriteArrayList<>();
    public static void ejecuta() throws InvocationTargetException, IllegalAccessException {
        //System.out.println("Ejecutando dispatcher....");

        tareasBackUp.clear();
        for (Iterator<Tarea> iter = tareas.iterator(); iter.hasNext(); ) {
            Tarea element = iter.next();
            if (element.terminado == false) {
                tareasBackUp.add(element);
            }
        }

        tareas.clear();
        for (Iterator<Tarea> iter = tareasBackUp.iterator(); iter.hasNext(); ) {
            Tarea element = iter.next();
            tareas.add(element);
        }


//        for (Iterator<Tarea> iter = tareas.iterator(); iter.hasNext(); ) {
//            Tarea element = iter.next();
//            System.out.println("element = " + element.agente + " funcion = " + element.funcion + " estado = " + element.terminado);
//        }

        //System.out.println("----------------------------------");
        //System.out.println();

        System.out.println("Número de tareas: " + tareas.size());

        for (Iterator<Tarea> iter = tareas.iterator(); iter.hasNext(); ) {
            Tarea element = iter.next();
            if (
                    (Instant.now().isAfter(element.siguienteEjecucion)) && (element.terminado == false)
            ) {
                boolean resultado = (boolean) element.funcion.invoke(element.agente);
                if (resultado== false) {
                    //suicidio
                    element.haMuerto();
                    //iter.remove(); TODO
                }
                else {
                    element.siguienteEjecucion = element.siguienteEjecucion.plusSeconds(element.deltaTiempo);
                }
            }
        }
    }

    public static void inicializa() throws NoSuchMethodException {
        Timer timer = new Timer();
        TimerTask task = new DispatcherRun();
        timer.schedule(task, 1000, 3000);
    }

    public static void addTarea(Tarea tarea) {
        tareas.add(tarea);
    }
}
