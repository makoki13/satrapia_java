package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.geo.Punto;

public class Edificio {
    private int id;
    public String nombre;
    private int idCiudad;

    private Punto posicion;

    private short porcentajeConstruido; // de 0 a 100
    private boolean activo;

    private Almacen almacen;

}
