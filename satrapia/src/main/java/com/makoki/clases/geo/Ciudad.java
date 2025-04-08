package com.makoki.clases.geo;

import java.util.ArrayList;
import java.util.List;

import com.makoki.clases.construcciones.Almacen;
import com.makoki.clases.construcciones.Edificio;
import com.makoki.clases.construcciones.Granja;
import com.makoki.clases.construcciones.Palacio;
import com.makoki.clases.construcciones.PalacioImperial;
import com.makoki.clases.construcciones.Silo;
import com.makoki.clases.investigacion.Recurso;
import com.makoki.clases.usuarios.Jugador;
import com.makoki.clases.utilidades.Rutinas;

public class Ciudad {

    private Coordenadas coordenadas;
    private Reino reino;

    private Palacio palacio = null;
    private Edificio almacenGeneral;

    private List<Granja> granjas;

    private boolean esCapital;

    private String nombre;

    public Ciudad(Coordenadas coordenadas, Reino reino, boolean esCapital) {
        this.coordenadas = coordenadas;
        this.reino = reino;
        this.esCapital = esCapital;

        this.granjas = new ArrayList<>();

        this.almacenGeneral = new Edificio(this, coordenadas, true);
        Almacen almacen = new Almacen(almacenGeneral);
        Silo silo = new Silo(Recurso.COMIDA, 3000, true);
        almacen.agregarSilo(silo);
        this.almacenGeneral.setAlmacen(almacen);

        if (esCapital) {
            palacio = new PalacioImperial(this);
        } else {
            palacio = new Palacio(this);
        }

        System.out.println(palacio);

        /* Esto debe de ir con la creación de granjas etc...
        Silo miSiloComida = new Silo(Recurso.COMIDA, 100, true);
        Extractor miExtractorComida = new Extractor(
                Recurso.COMIDA,
                10,100,false,1);
        miSiloComida.setExtractor(miExtractorComida);

        Silo miSiloMadera = new Silo(Recurso.MADERA, 100, true);
        Extractor miExtractorMadera = new Extractor(
                Recurso.MADERA,
                10,100,false,1);
        miSiloMadera.setExtractor(miExtractorMadera);

        this.almacenGeneral.getAlmacen().agregarSilo(miSiloComida);
        this.almacenGeneral.getAlmacen().agregarSilo(miSiloMadera);

        miSiloMadera.runExtractor();
        miSiloComida.runExtractor();
         */
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public Reino getReino() {
        return reino;
    }

    public boolean isEsCapital() {
        return esCapital;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void setReino(Reino reino) {
        this.reino = reino;
    }

    public void setEsCapital(boolean esCapital) {
        this.esCapital = esCapital;
    }

    public Edificio getAlmacenGeneral() {
        return this.almacenGeneral;
    }

    public void setAlmacenGeneral(Edificio almacenGeneral) {
        this.almacenGeneral = almacenGeneral;
    }

    public Almacen getAlmacen() {
        return this.almacenGeneral.getAlmacen();
    }

    public void setAlmacen(Almacen almacen) {
        this.almacenGeneral.setAlmacen(almacen);
    }

    public void setGranjas(ArrayList<Granja> granjas) {
        this.granjas = granjas;
    }

    public List<Granja> getGranjas() {
        return granjas;
    }

    public void addGranja(Granja granja) {
        granjas.add(granja);
    }

    public void removeGranja(Granja granja) {
        granjas.remove(granja);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarRecursos() {
        Thread hilo = new Thread(() -> {
            while (true) {
                for (Silo s : almacenGeneral.getAlmacen().getSilos()) {
                    System.out.println("Recurso: " + s.getRecurso() + " Cantidad: " + s.getCapacidadActual());
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        });
        hilo.start();
    }

    public static void main(String[] args) {
        Coordenadas c4 = new Coordenadas(1, 1);
        Jugador jugador = new Jugador();
        Reino reino = new Reino(0, "Safor", jugador);
        System.out.println(reino);
        @SuppressWarnings("unused")
        Ciudad ciudad = new Ciudad(c4, reino, true);
        ciudad.setNombre("GANDIA");

        Coordenadas c1 = new Coordenadas(10, 10);
        Rutinas.crearGranja(c1, ciudad);

        Coordenadas c2 = new Coordenadas(15, 15);
        Rutinas.crearGranja(c2, ciudad);

        ciudad.mostrarRecursos();
    }
}
