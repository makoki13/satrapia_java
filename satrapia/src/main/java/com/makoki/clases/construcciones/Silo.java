package com.makoki.clases.construcciones;

import com.makoki.clases.investigacion.Recurso;

public class Silo {
    private final Recurso recurso;
    private final long maxCapacidad;
    private long cantidadActual;
    private boolean tieneLimite;
    Extractor extractor;

    public Silo(Recurso recurso, long maxCapacidad, boolean tieneLimite) {
        this.recurso = recurso;
        this.maxCapacidad = maxCapacidad;
        this.cantidadActual = 0L;
        this.tieneLimite = tieneLimite;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public long getMaxCapacidad() {
        return maxCapacidad;
    }

    public long getCapacidadActual() {
        return cantidadActual;
    }
    
    public void setCapacidadActual(long capacidadActual) {
        this.cantidadActual = capacidadActual;
    }

    public void agregarRecurso(long cantidad) {
        if (!tieneLimite)  {
            cantidadActual += cantidad;
            return; 
        }
        
        if (cantidadActual + cantidad <= maxCapacidad) {
            cantidadActual += cantidad;
        } else {
            cantidadActual = maxCapacidad;
        }
    }
    
    public void restarRecurso(long cantidad) {
        if (cantidadActual - cantidad >= 0) {
            cantidadActual -= cantidad;
        } else {
            cantidadActual = 0L;
        }
    }

    public Extractor getExtractor() {
        return extractor;
    }

    public void setExtractor(Extractor extractor) {
        this.extractor = extractor;
    }

    public void runExtractor() {
        extractor.cosecha(this);
    }

    public boolean isTieneLimite() {
        return tieneLimite;
    }

    public void setTieneLimite(boolean tieneLimite) {
        this.tieneLimite = tieneLimite;
    }

    public void cosecha(long cantidad) {
        agregarRecurso(cantidad);
        System.out.println("Recurso: " + recurso + " - Cantidad actual: " + cantidadActual);
    }

    public static void main(String[] args) {
        Silo miSilo = new Silo(Recurso.COMIDA, 100, true);
        Extractor miExtractor = new Extractor(
                Recurso.COMIDA,
                10,100,false,1);
        miSilo.setExtractor(miExtractor);
        miSilo.runExtractor();
    }
}
