package com.makokienterprises.satrapia.clases.dispatcher;

import com.makokienterprises.satrapia.pruebas.TestDispatcher;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.*;

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
    private static List<Tarea> tareas = new ArrayList<>();
    public static void ejecuta() throws InvocationTargetException, IllegalAccessException {
        for (Iterator<Tarea> iter = tareas.iterator(); iter.hasNext(); ) {
            Tarea element = iter.next();

            //System.out.println("Tarea = " + element.funcion);
            //System.out.println("element = " + element.siguienteEjecucion);

            if (Instant.now().isAfter(element.siguienteEjecucion)) {
                element.funcion.invoke(element.agente);
                element.siguienteEjecucion = element.siguienteEjecucion.plusSeconds(element.deltaTiempo);
                //System.out.println("new element = " + element.siguienteEjecucion);
                //System.out.println();
            }
        }
    }

    public static void inicializa() throws NoSuchMethodException {
        //tareas = null;
        Timer timer = new Timer();
        TimerTask task = new DispatcherRun();
        timer.schedule(task, 1000, 3000);
    }

    public static void addTarea(Tarea tarea) {
        tareas.add(tarea);
    }
}
