package com.makoki.clases.geo;

import java.util.ArrayList;

import com.makoki.clases.construcciones.Almacen;
import com.makoki.clases.construcciones.Extractor;
import com.makoki.clases.construcciones.Granja;
import com.makoki.clases.construcciones.Palacio;
import com.makoki.clases.construcciones.PalacioImperial;
import com.makoki.clases.construcciones.Silo;
import com.makoki.clases.investigacion.Recurso;
import com.makoki.clases.usuarios.Jugador;

public class Ciudad {
    private Coordenadas coordenadas;
    private Reino reino;

    private Palacio palacio = null;
    private Almacen almacen;

    private ArrayList<Granja> granjas;

    private boolean esCapital;

    public Ciudad(Coordenadas coordenadas, Reino reino,  boolean esCapital) {
        this.coordenadas = coordenadas;
        this.reino = reino;
        this.esCapital = esCapital;

        this.granjas = new ArrayList<>();

        this.almacen = new Almacen();
        
        if (esCapital) {
            palacio = new PalacioImperial(this);
        }
        else {
            palacio = new Palacio(this);
        }

        System.out.println(palacio);

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

        this.almacen.agregarSilo(miSiloComida);
        this.almacen.agregarSilo(miSiloMadera);

        miSiloMadera.runExtractor();
        miSiloComida.runExtractor();
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

    
    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public void setGranjas(ArrayList<Granja> granjas) {
        this.granjas = granjas;
    }

    public ArrayList<Granja> getGranjas() {
        return granjas;
    }

    
    public void addGranja(Granja granja) {
        granjas.add(granja);
    }

    public void removeGranja(Granja granja) {
        granjas.remove(granja);
    }   

    public static void main(String[] args) {
        Coordenadas c4 = new Coordenadas(1, 1);
        Jugador jugador = new Jugador();
        Reino reino = new Reino(0, "Safor", jugador);
        System.out.println(reino);
        @SuppressWarnings("unused")
        Ciudad ciudad = new Ciudad(c4, reino, true);
    }   
}
