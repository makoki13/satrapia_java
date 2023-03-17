package com.makokienterprises.satrapia.clases.geo;

import com.makokienterprises.satrapia.clases.edificios.Almacen;
import com.makokienterprises.satrapia.clases.edificios.Palacio;

import java.util.List;

public class Ciudad {
    private int id;
    public String nombre;
    public int idRegion;

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
}
