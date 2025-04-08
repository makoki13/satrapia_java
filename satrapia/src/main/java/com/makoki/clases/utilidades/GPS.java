package com.makoki.clases.utilidades;


import com.makoki.clases.geo.Coordenadas;

public class GPS {
    public static Coordenadas getPosicion(Coordenadas actual, Coordenadas destino) {
        Coordenadas nuevaPosicion = actual;
        if (actual.getX() > destino.getX()) {
            nuevaPosicion.setX(actual.getX() - 1);
        }
        else if (actual.getX() < destino.getX()) {
            nuevaPosicion.setX(actual.getX() + 1);
        }

        if (actual.getY() > destino.getY()) {
            nuevaPosicion.setY(actual.getY() - 1);
        }
        else if (actual.getY() < destino.getY()) {
            nuevaPosicion.setY(actual.getY() + 1);
        }
        
        return nuevaPosicion;
    }
}
