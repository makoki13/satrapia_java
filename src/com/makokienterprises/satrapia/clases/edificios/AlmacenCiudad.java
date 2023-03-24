package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.geo.Ciudad;

import java.util.ArrayList;
import java.util.List;

public class AlmacenCiudad extends Almacen {
    Ciudad ciudad;

    public AlmacenCiudad(String nombre, Ciudad ciudad) {
        super(nombre,null) ;
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return this.ciudad;
    }
}
