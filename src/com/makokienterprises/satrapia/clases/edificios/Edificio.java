package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.geo.Ciudad;
import com.makokienterprises.satrapia.clases.geo.Punto;

public class Edificio {
    private int id;
    public String nombre;
    private Ciudad ciudad;

    private Punto posicion;

    private short porcentajeConstruido; // de 0 a 100
    private boolean activo;

    private Almacen almacen;

    public Edificio(int id, Ciudad ciudad) {
        this.id = id;
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
}
