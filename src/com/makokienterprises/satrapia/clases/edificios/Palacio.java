package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.parametros.Parametros;

public class Palacio {
    private int id;

    public int idCiudad;
    public Almacen almacen; // Dos silos, ORO y POBLACION

    private Censo censo;
    private Hacienda hacienda;

    public Palacio(int idCiudad) {
        this.idCiudad = idCiudad;

        //Crear almacen
        //Silo de oro
        Silo tesoro = new Silo(Recursos.ORO,0,0,5,1);
        Silo poblacion = new Silo(Recursos.POBLACION,10,0,5,1);
        this.almacen = new Almacen();
        this.almacen.addSilo(tesoro);
        this.almacen.addSilo(poblacion);

        this.hacienda = new Hacienda();
        this.censo = new Censo();

        //TODO
        //activar censo y recaudacion
    }

    public void recaudaImpuestos() {
        int poblacion = this.cantidadPoblacion();
        int oro = hacienda.extrae(poblacion, (double)Parametros.porcentajeImpuestos);
        Silo siloOro = almacen.getSilo(Recursos.ORO);
        siloOro.addStock(oro);
    }

    public void hazCenso() {
        Silo siloPoblacion = almacen.getSilo(Recursos.POBLACION);
        int poblacion = siloPoblacion.getStock();

        int nuevosCiudadanos = censo.extrae(poblacion, Parametros.porcentajeNacimientos);

        siloPoblacion.addStock(nuevosCiudadanos);
    }

    public int cantidadOro() {
        Silo siloOro = almacen.getSilo(Recursos.ORO);
        return siloOro.getStock();
    }

    public int cantidadPoblacion(){
        Silo siloPoblacion = almacen.getSilo(Recursos.POBLACION);
        return siloPoblacion.getStock();
    }
}
