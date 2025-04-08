package com.makoki.clases.construcciones;

import java.util.ArrayList;

import com.makoki.clases.geo.Ciudad;
import com.makoki.clases.geo.Coordenadas;
import com.makoki.clases.geo.Reino;
import com.makoki.clases.investigacion.Recurso;
import com.makoki.clases.usuarios.Jugador;
import com.makoki.clases.utilidades.GPS;

public class Transporte extends Almacen {

    Coordenadas posicion;
    Edificio destino;
    int tiempoCiclo;

    public Transporte(Coordenadas coordenadas, Edificio destino, int tiempoCiclo) {
        super(destino); //Tal vez haya que revisar esto. Lo mejor sería que fuera la granja o quien lo enviara
        this.posicion = coordenadas;
        this.destino = destino;
        this.tiempoCiclo = tiempoCiclo;
    }

    public void addSilo(Silo silo) {
        this.agregarSilo(silo);
    }

    public void inicia() {
        Thread hilo = new Thread(() -> {
            boolean desplazarse = true;
            while (desplazarse) {
                posicion = GPS.getPosicion(posicion, destino.getCoordenadas());

                System.out.println("Posicion: " + posicion.toString());

                if (posicion.getX() == destino.getCoordenadas().getX()
                        && posicion.getY() == destino.getCoordenadas().getY()) {
                    System.out.println("Llegue al destino");

                    //Falta entregar mercancia
                     for(Silo siloOrigen: this.getSilos()) {
                        Silo siloDestino = destino.getAlmacen().getSiloPorRecurso(siloOrigen.getRecurso());
                        siloDestino.agregarRecurso(siloOrigen.vaciar());
                    } 
                    desplazarse = false;
                } else {
                    try {
                        Thread.sleep(this.tiempoCiclo * 1000);
                    } catch (InterruptedException e) {
                    }
                }

                ArrayList<Silo> silosDestino = destino.getAlmacen().getSilos();
                for (Silo silo : silosDestino) {
                    Recurso recurso = silo.getRecurso();
                    System.out.println(
                            "Recurso: " + recurso
                            + " cantidad: " + silo.getCapacidadActual()
                    );
                }
            }
        });

        hilo.start();
    }

    public Edificio getDestino() {
        return destino;
    }

    public void setDestino(Edificio destino) {
        this.destino = destino;
    }

    public Coordenadas getPosicion() {
        return posicion;
    }

    public void setPosicion(Coordenadas posicion) {
        this.posicion = posicion;
    }

    public static void main(String[] args) {
        Coordenadas origen = new Coordenadas(10, 10);
        Coordenadas destino = new Coordenadas(0, 0);
        Jugador jugador = new Jugador();
        Reino reino = new Reino(0, "Safor", jugador);
        //@SuppressWarnings("unused")
        Ciudad ciudad = new Ciudad(destino, reino, true);
        int tiempoCiclo = 2;

        Transporte transporte = new Transporte(origen, ciudad.getAlmacenGeneral(), tiempoCiclo);
        Silo silo = new Silo(Recurso.COMIDA, 10, true);
        silo.agregarRecurso(10);
        transporte.addSilo(silo);

        transporte.inicia();
    }
}
