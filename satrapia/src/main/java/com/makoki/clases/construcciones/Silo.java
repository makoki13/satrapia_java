package com.makoki.clases.construcciones;

import com.makoki.clases.investigacion.Recurso;

public class Silo {

    private final Recurso recurso;
    private final long maxCapacidad;
    private long cantidadActual;
    private boolean tieneLimite;
    private final boolean enviarCaravana;
    Extractor extractor;
    Almacen almacen;

    public Silo(Recurso recurso, long maxCapacidad, boolean tieneLimite) {
        this.recurso = recurso;
        this.maxCapacidad = maxCapacidad;
        this.cantidadActual = 0L;
        this.tieneLimite = tieneLimite;
        this.enviarCaravana = false;
    }

    public Silo(Recurso recurso, long maxCapacidad, boolean tieneLimite, boolean enviarCaravana, Almacen almacen) {
        this.recurso = recurso;
        this.maxCapacidad = maxCapacidad;
        this.cantidadActual = 0L;
        this.tieneLimite = tieneLimite;
        this.enviarCaravana = enviarCaravana;
        this.almacen = almacen;
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
        if (!tieneLimite) {
            cantidadActual += cantidad;
            //System.out.println("Recurso: " + this.recurso + " - Cantidad actual: " + cantidadActual);
            return;
        }

        if (cantidadActual + cantidad <= maxCapacidad) {
            cantidadActual += cantidad;
        } else {
            cantidadActual = maxCapacidad;
        }
        //System.out.println("Recurso: " + this.recurso + " - Cantidad actual: " + cantidadActual);
    }

    public void restarRecurso(long cantidad) {
        if (cantidadActual - cantidad >= 0) {
            cantidadActual -= cantidad;
        } else {
            cantidadActual = 0L;
        }
    }

    public long vaciar() {
        long cantidadParaDevolver = cantidadActual;
        cantidadActual = 0L;
        return cantidadParaDevolver;
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
        if (getCapacidadActual() == this.maxCapacidad) {
            if (enviarCaravana == true) {
                Transporte caravana = new Transporte(
                        this.almacen.edificio.getCiudad().getCoordenadas(),
                        this.almacen.edificio.getCiudad().getAlmacenGeneral(),
                        5);
                Silo siloCaravana = new Silo(Recurso.COMIDA, this.cantidadActual, true);
                siloCaravana.cantidadActual = vaciar();
                caravana.addSilo(siloCaravana);
                caravana.inicia();
            }

        }

        /*String leyenda = "Recurso: " + recurso + " - Cantidad actual: " + cantidadActual;
        if (almacen != null ) leyenda += almacen.edificio.getCiudad().getNombre();
        System.out.println(leyenda);
         */
    }

    public static void main(String[] args) {
        Silo miSilo = new Silo(Recurso.COMIDA, 100, true);
        Extractor miExtractor = new Extractor(
                Recurso.COMIDA,
                10, 100, false, 1);
        miSilo.setExtractor(miExtractor);
        miSilo.runExtractor();
    }
}
