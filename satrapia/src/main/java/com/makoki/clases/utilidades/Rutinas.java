package com.makoki.clases.utilidades;

import com.makoki.clases.construcciones.Granja;
import com.makoki.clases.geo.Ciudad;
import com.makoki.clases.geo.Coordenadas;

public class Rutinas {
    public static void crearGranja(Coordenadas coordenadas, Ciudad ciudad) {
        Granja granja1 = new Granja(ciudad, coordenadas, false);
        ciudad.addGranja(granja1);
    }
}
