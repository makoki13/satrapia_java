package com.makokienterprises.satrapia.pruebas;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.edificios.Granja;
import com.makokienterprises.satrapia.clases.edificios.Recursos;
import com.makokienterprises.satrapia.clases.edificios.Silo;
import com.makokienterprises.satrapia.clases.edificios.Transporte;
import com.makokienterprises.satrapia.clases.geo.Punto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestTransporte {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        Object lock= new Object();
        synchronized(lock){
            Dispatcher.inicializa();
            Dispatcher.ejecuta();

            Punto inicio = new Punto(10,10,0,null);
            Punto fin = new Punto(20,20,0,null);
            Transporte miTransporte = new Transporte(inicio,fin, null);
            Method funcionEntrega = Granja.class.getMethod("entregaCantidad");
            miTransporte.envia(funcionEntrega);
            // write your code here. You may use wait() or notify() as per your requirement.
            System.out.println("Sincronizando");
            lock.wait();
            //lock.notify();
            System.out.println("deSincronizando");
        }
    }

    public void entregaCantidad() {

    }
}
