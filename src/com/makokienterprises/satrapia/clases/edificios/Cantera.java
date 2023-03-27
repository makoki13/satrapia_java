package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.dispatcher.Tarea;
import com.makokienterprises.satrapia.clases.geo.Ciudad;
import com.makokienterprises.satrapia.clases.geo.Punto;

import java.lang.reflect.Method;

public class Cantera extends Edificio{
    public Ciudad ciudad;
    public Almacen almacen; //Un silo de comida

    private Punto posicion;

    private Extraccion extraccion;
    private double porcentajeExtraccion = 1;
    private int cantidadExtraccion = 100;

    public Cantera(Ciudad ciudad, Punto posicion) throws NoSuchMethodException {
        super(ciudad);
        this.posicion = posicion;

        this.almacen = new Almacen( "Almacén de cantera " + this.getId() +  " de " + ciudad.getNombre(), this);
        Silo piedra = new Silo(Recursos.PIEDRA,0,1000000,5,1, this.almacen);
        this.almacen.addSilo(piedra);
    }

    public boolean extraer() {
        int piedra = this.extraccion.extrae(cantidadExtraccion, this.porcentajeExtraccion);
        Silo siloPiedra = this.almacen.getSilo(Recursos.PIEDRA);
        siloPiedra.addStock(piedra);

        return true;
    }

    public void activa()  throws NoSuchMethodException{
        this.extraccion = new Extraccion();

        Method funcionExtraccion = Cantera.class.getMethod("extraer");
        Tarea tarea1 = new Tarea(this,funcionExtraccion,5, null, null);
        Dispatcher.addTarea(tarea1);
    }
}
