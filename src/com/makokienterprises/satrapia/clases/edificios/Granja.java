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
    private int cantidadAEnviarACiudad = 1000;

    public Granja(Ciudad ciudad, Punto posicion) {
        super(ciudad);
        this.ciudad = ciudad;
        this.posicion = posicion;

        this.almacen = new Almacen( "Almacén de granja " + this.getId() +  " de " + ciudad.getNombre(), this);
        Silo comida = new Silo(Recursos.COMIDA,0,1000000,5,1, this.almacen);
        this.almacen.addSilo(comida);


    }

    public void activa()  throws NoSuchMethodException{
        this.cosecha = new Cosecha();

        Method funcionCosecha = Granja.class.getMethod("cosecha");
        Tarea tarea = new Tarea (this,funcionCosecha,5, null,null);
        Dispatcher.addTarea(tarea);
    }

    public boolean cosecha() throws NoSuchMethodException {
        int comida = this.cosecha.extrae(cantidadCosecha, this.porcentajeCosecha);
        Silo siloComida = this.almacen.getSilo(Recursos.COMIDA);
        siloComida.addStock(comida);
        int cantidadComida = siloComida.getStock();
        if (cantidadComida >= this.cantidadAEnviarACiudad) {
            Method funcionEnvio = Granja.class.getMethod("envio");
            Tarea tarea = new Tarea(this,funcionEnvio,1, null,null);
            Dispatcher.addTarea(tarea);
            int cantidadEnStock = cantidadComida -  this.cantidadAEnviarACiudad;
            if (cantidadEnStock < 0 ) {
                cantidadEnStock = 0;
            }
            siloComida.setStock(cantidadEnStock);
        }

        return true;
    }

    public boolean envio() throws NoSuchMethodException {
        Punto inicio = new Punto(10,10,0,null);
        Punto fin = new Punto(12,12,0,null);
        Transporte miTransporte = new Transporte(inicio,fin, this);
        Method funcionEntrega = Granja.class.getMethod("entregaCantidad");
        miTransporte.envia(funcionEntrega);

        return false;
    }

    public boolean entregaCantidad() {
        Silo siloComidaCiudad = this.ciudad.almacen.getSilo(Recursos.COMIDA);
        siloComidaCiudad.addStock(this.cantidadAEnviarACiudad);
        System.out.println("Se ha ejecutado entregaCantidad");

        return true;
    }
}
