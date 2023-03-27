package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.edificios.*;

import java.util.ArrayList;
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

    public List<Granja> granjas = new ArrayList<>();
    public List<Aserradero> aserraderos = new ArrayList<>();
    public List<Cantera> canteras;
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

        //Creamos el almacén
        this.almacen = new AlmacenCiudad( "Almacén de ciudad", this);

        Silo comida = new Silo(Recursos.COMIDA,0,1000000,5,1, this.almacen);
        Silo madera = new Silo(Recursos.MADERA,0,1000000,5,1,this.almacen);
        Silo piedra = new Silo(Recursos.PIEDRA,0,1000000,5,1,this.almacen);
        Silo hierro = new Silo(Recursos.HIERRO,0,1000000,5,1,this.almacen);

        this.almacen.addSilo(comida);
        this.almacen.addSilo(madera);
        this.almacen.addSilo(piedra);
        this.almacen.addSilo(hierro);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void addGranja(Punto punto, boolean activar) throws NoSuchMethodException {
        Granja granja = new Granja(this,punto);
        this.granjas.add(granja);
        if (activar) {
            granja.activa();
        }
    }

    public void addAserradero(Punto punto, boolean activar) throws NoSuchMethodException {
        Aserradero aserradero = new Aserradero(this,punto);
        this.aserraderos.add(aserradero);
        if (activar) {
            aserradero.activa();
        }
    }

    public void addCantera(Punto punto, boolean activar) throws NoSuchMethodException {
        Cantera cantera = new Cantera(this,punto);
        this.canteras.add(cantera);
        if (activar) {
            cantera.activa();
        }
    }
}
