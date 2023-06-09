package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.dispatcher.Tarea;
import com.makokienterprises.satrapia.clases.geo.Ciudad;
import com.makokienterprises.satrapia.clases.parametros.Parametros;

import java.lang.reflect.Method;

public class Palacio extends Edificio {
    //private long id;

    public Ciudad ciudad;
    public Almacen almacen; // Dos silos, ORO y POBLACION

    private Censo censo;
    private Hacienda hacienda;

    public Palacio(Ciudad ciudad) throws NoSuchMethodException {
        super(ciudad);

        System.out.println("Creando palacio...");
        //this.id = getId();
        this.ciudad = ciudad;


        //Crear almacen
        //Silo de oro
        this.almacen = new Almacen( "Almacén de palacio", this);
        Silo tesoro = new Silo(Recursos.ORO,0,0,5,1, this.almacen);
        Silo poblacion = new Silo(Recursos.POBLACION,10,0,5,1,this.almacen);

        this.almacen.addSilo(tesoro);
        this.almacen.addSilo(poblacion);

        this.hacienda = new Hacienda();
        this.censo = new Censo();

        //activar censo y recaudacion
        
        Method funcionRecaudaImpuestos = Palacio.class.getMethod("recaudaImpuestos");
        Tarea tarea1 = new Tarea(this,funcionRecaudaImpuestos,5, null,null);
        Dispatcher.addTarea(tarea1);

        Method funcionHazCenso = Palacio.class.getMethod("hazCenso");
        Tarea tarea2 = new Tarea(this,funcionHazCenso,5, null,null);
        Dispatcher.addTarea(tarea2);
    }

    public boolean recaudaImpuestos() {
        int poblacion = this.cantidadPoblacion();
        int oro = hacienda.extrae(poblacion, (double)Parametros.porcentajeImpuestos);
        Silo siloOro = almacen.getSilo(Recursos.ORO);
        siloOro.addStock(oro);

        return true;
    }

    public boolean hazCenso() {
        Silo siloPoblacion = almacen.getSilo(Recursos.POBLACION);
        int poblacion = siloPoblacion.getStock();

        int nuevosCiudadanos = censo.extrae(poblacion, Parametros.porcentajeNacimientos);

        siloPoblacion.addStock(nuevosCiudadanos);

        return true;
    }

    public int cantidadOro() {
        Silo siloOro = almacen.getSilo(Recursos.ORO);
        return siloOro.getStock();
    }

    public int cantidadPoblacion(){
        Silo siloPoblacion = almacen.getSilo(Recursos.POBLACION);
        return siloPoblacion.getStock();
    }

    public Ciudad getCiudad() {
        return this.ciudad;
    }
}
