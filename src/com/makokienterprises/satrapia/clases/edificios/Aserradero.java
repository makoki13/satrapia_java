package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.dispatcher.Tarea;
import com.makokienterprises.satrapia.clases.geo.Ciudad;
import com.makokienterprises.satrapia.clases.geo.Punto;

import java.lang.reflect.Method;

public class Aserradero extends Edificio{
    public Ciudad ciudad;
    public Almacen almacen; //Un silo de comida

    private Punto posicion;

    private Poda poda;
    private double porcentajePoda = 1;
    private int cantidadPoda = 100;

    public Aserradero(Ciudad ciudad, Punto posicion) throws NoSuchMethodException {
        super(ciudad);
        this.posicion = posicion;

        this.almacen = new Almacen( "Almacén de aserradero " + this.getId() +  " de " + ciudad.getNombre(), this);
        Silo madera = new Silo(Recursos.MADERA,0,1000000,5,1, this.almacen);
        this.almacen.addSilo(madera);
    }

    public boolean poda() {
        int madera = this.poda.extrae(cantidadPoda, this.porcentajePoda);
        Silo siloMadera = this.almacen.getSilo(Recursos.MADERA);
        siloMadera.addStock(madera);

        return true;
    }

    public void activa()  throws NoSuchMethodException{
        this.poda = new Poda();

        Method funcionPoda = Aserradero.class.getMethod("poda");
        Tarea tarea1 = new Tarea(this,funcionPoda,5, null, null);
        Dispatcher.addTarea(tarea1);
    }
}
