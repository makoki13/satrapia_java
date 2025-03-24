package com.makoki.clases.construcciones;

public class Granja extends Edificio {
    public Granja(
        Almacen almacen, 
        com.makoki.clases.geo.Ciudad ciudad, 
        com.makoki.clases.geo.Coordenadas coordenadas, 
        boolean enCiudad) {
        super(ciudad, coordenadas, false);
    }
}
