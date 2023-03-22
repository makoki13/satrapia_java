package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.dispatcher.Tarea;
import com.makokienterprises.satrapia.clases.geo.Ciudad;
import com.makokienterprises.satrapia.clases.geo.Punto;
import com.makokienterprises.satrapia.clases.parametros.Parametros;

import java.lang.reflect.Method;

public class Granja extends Edificio{
    public Ciudad ciudad;
    public Almacen almacen; //Un silo de comida

    private Punto posicion;

    private Cosecha cosecha;
    private double porcentajeCosecha = 1;
    private int cantidadCosecha = 100;

    public Granja(Ciudad ciudad, Punto posicion) throws NoSuchMethodException {
        super(ciudad);
        this.posicion = posicion;

        this.almacen = new Almacen( "Almacén de granja " + this.getId() +  " de " + ciudad.getNombre(), this);
        Silo comida = new Silo(Recursos.COMIDA,0,1000000,5,1, this.almacen);
        this.almacen.addSilo(comida);

        this.cosecha = new Cosecha();

        Method funcionCosecha = Granja.class.getMethod("cosecha");
        Tarea tarea1 = new Tarea(this,funcionCosecha,5);
        Dispatcher.addTarea(tarea1);
    }

    public void cosecha() {
        int comida = this.cosecha.extrae(cantidadCosecha, this.porcentajeCosecha);
        Silo siloComida = this.almacen.getSilo(Recursos.COMIDA);
        siloComida.addStock(comida);
    }
}
