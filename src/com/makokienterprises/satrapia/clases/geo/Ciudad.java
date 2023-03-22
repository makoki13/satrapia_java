package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.edificios.Almacen;
import com.makokienterprises.satrapia.clases.edificios.Palacio;

import java.util.List;

public class Ciudad {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    private long id;
    public String nombre;
    public Region region;

    private Punto posicion;

    private boolean esCapital;

    public Palacio palacio;
    //TODO public Cuartel cuartel;
    //TODO public Embajada embajada;
    public Almacen almacen;
    //TODO public Laboratorio laboratorio;

    //TODO public Mercado mercado;

    //TODO public List<Granja> granjas;
    //TODO public List<Aserradero> aserraderos;
    //TODO public List<Cantera> canteras;
    //TODO public List<MinaDeHierro> minasDeHierro;
    //TODO public List<MinaDeOro> minasDeOro;


    public Ciudad(String nombre, Region region, Punto posicion, boolean esCapital) throws NoSuchMethodException {
        this.id = ++ultimoID;
        this.nombre = nombre;
        this.region = region;
        this.posicion = posicion;
        this.esCapital = esCapital;

        //Creamos el palacio
        this.palacio = new Palacio(this);
        //System.out.println("id palacio de " + nombre + ": " + this.palacio.getId());
    }

    public String getNombre() {
        return this.nombre;
    }
}
