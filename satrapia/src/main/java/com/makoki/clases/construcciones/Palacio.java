package com.makoki.clases.construcciones;

import com.makoki.clases.geo.Ciudad;
import com.makoki.clases.investigacion.Recurso;

public class Palacio extends Edificio{
    Almacen almacen;

    public Palacio(Ciudad ciudad) {
        super(ciudad, ciudad.getCoordenadas(), true);
        almacen = new Almacen();
        Silo siloOro = new Silo(Recurso.ORO,0,false);
        Silo siloPoblacion = new Silo(Recurso.POBLACION,1000000, true);
        siloPoblacion.setCapacidadActual(100);
        almacen.agregarSilo(siloOro);
        almacen.agregarSilo(siloPoblacion);

        ExtractorOro miExtractorOro = new ExtractorOro();
        siloOro.setExtractor(miExtractorOro);

        Extractor miExtractorPoblacion = new Extractor(
                Recurso.POBLACION,
                10,1000000,false,3);
        siloPoblacion.setExtractor(miExtractorPoblacion);

        siloOro.runExtractor();
        siloPoblacion.runExtractor();
    }

    @Override
    public String toString() {
        return "Palacio Real";
    }
}
