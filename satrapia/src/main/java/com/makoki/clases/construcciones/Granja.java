package com.makoki.clases.construcciones;

import com.makoki.clases.investigacion.Recurso;

public class Granja extends Edificio {

    public Granja(
            com.makoki.clases.geo.Ciudad ciudad,
            com.makoki.clases.geo.Coordenadas coordenadas,
            boolean enCiudad) {
        super(ciudad, coordenadas, false);

        Almacen almacen = new Almacen(this);

        Silo silo = new Silo(Recurso.COMIDA, 300, false, true, almacen);
        Extractor miExtractor = new Extractor(Recurso.COMIDA, 100, 0, true, 5);
        silo.setExtractor(miExtractor);

        almacen.agregarSilo(silo);

        silo.runExtractor();
    }
}
