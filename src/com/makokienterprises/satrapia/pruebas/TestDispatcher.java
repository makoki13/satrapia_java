package com.makokienterprises.satrapia.pruebas;

import java.util.Timer;
import java.util.TimerTask;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.dispatcher.Tarea;

class Helper extends TimerTask
{
    public static int i = 0;
    public void run()
    {
        Dispatcher.ejecuta();

        System.out.println("Timer ran" + ++i);
        if(false)
        {
            synchronized(TestDispatcher.obj)
            {
                TestDispatcher.obj.notify();
            }
        }
    }

}


public class TestDispatcher {
    public static TestDispatcher obj;
    public static void main(String[] args) throws InterruptedException{
        Tarea tarea1 = new Tarea(null,"funcion 1",5);
        Tarea tarea2 = new Tarea(null,"funcion 2",3);
        Tarea tarea3 = new Tarea(null,"funcion 3",10);

        //Dispatcher dispatcher = new Dispatcher();
        Dispatcher.inicializa();
        Dispatcher.addTarea(tarea1);
        Dispatcher.addTarea(tarea2);
        Dispatcher.addTarea(tarea3);

        obj = new TestDispatcher();

        // creating an instance of timer class
        Timer timer = new Timer();

        // creating an instance of task to be scheduled
        TimerTask task = new Helper();

        // scheduling the timer instance
        timer.schedule(task, 1000, 3000);

        // fetching the scheduled execution time of
        // the most recent actual execution of the task
        System.out.println(task.scheduledExecutionTime());

        synchronized(obj)
        {
            //this thread waits until i reaches 4
            obj.wait();
        }

        //canceling the task assigned
        System.out.println("Cancel the timer task: " + task.cancel());

        // at this point timer is still running
        // without any task assigned to it

        // canceling the timer instance created
        timer.cancel();
    }
}
