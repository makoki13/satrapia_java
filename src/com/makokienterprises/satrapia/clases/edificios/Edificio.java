package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.geo.Ciudad;
import com.makokienterprises.satrapia.clases.geo.Punto;

public class Edificio {
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    private long id;
    public String nombre;
    private Ciudad ciudad;

    private Punto posicion;

    private short porcentajeConstruido; // de 0 a 100
    private boolean activo;

    private Almacen almacen;

    public Edificio( Ciudad ciudad) {
        this.id = ++ultimoID;
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public long getId() {
        return id;
    }
}
