package com.makoki.clases.construcciones;

import com.makoki.clases.geo.Ciudad;
import com.makoki.clases.geo.Coordenadas;

public class Edificio {
    private Almacen almacen;
    private final Ciudad ciudad;
    private final boolean enCiudad;
    private final Coordenadas coordenadas;

    /* public Edificio(Almacen almacen, Ciudad ciudad, Coordenadas coordenadas, boolean enCiudad) {
        this.almacen = almacen;
        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
        this.enCiudad = enCiudad;
    } */

    public Edificio(Ciudad ciudad, Coordenadas coordenadas, boolean enCiudad) {
        this.ciudad = ciudad;
        this.coordenadas = coordenadas;
        this.enCiudad = enCiudad;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public boolean isEnCiudad() {
        return enCiudad;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }
}
