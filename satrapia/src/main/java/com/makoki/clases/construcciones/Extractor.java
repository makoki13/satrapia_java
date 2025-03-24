package com.makoki.clases.construcciones;

import com.makoki.clases.investigacion.Recurso;

public class Extractor {
    private final Recurso recurso;
    private long produccionPorCiclo;
    private long cantidadActual;
    private final boolean ilimitado;
    protected  long tiempoCiclo;

    public Extractor(
                    Recurso recurso, long produccionPorCiclo, long cantidadInicial, boolean  ilimitado,
                    int tiempoCiclo) {
        this.recurso = recurso;
        this.produccionPorCiclo = produccionPorCiclo;
        this.cantidadActual = cantidadInicial;
        this.ilimitado = ilimitado;
        this.tiempoCiclo = tiempoCiclo;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public long getProduccion() {
        return produccionPorCiclo;
    }

    public void setProduccion(long produccionPorCiclo) {
        this.produccionPorCiclo = produccionPorCiclo;
    }

    public void cosecha(Silo silo) {

        Thread hilo1 = new Thread(() -> {   
            boolean cosechar = true; 
            while (cosechar) {
                long cantidad;
                try { Thread.sleep(tiempoCiclo*1000); } catch (InterruptedException e) {}
                if (ilimitado) {
                    cantidad = produccionPorCiclo;
                }
                else {
                    if (produccionPorCiclo >= cantidadActual) {
                        cantidad = cantidadActual;
                        cantidadActual = 0;
                        cosechar = false;
                    }
                    else {
                        cantidad = produccionPorCiclo;
                        cantidadActual -= produccionPorCiclo;
                    }
                }
                silo.cosecha(cantidad);
            }
        });

        hilo1.start();
    }

    public long getCantidadInicial() {
        return cantidadActual;
    }

    public boolean isIlimitado() {
        return ilimitado;
    }

    public long getTiempoCiclo() {
        return tiempoCiclo;
    }

    public void setTiempoCiclo(long tiempoCiclo) {
        this.tiempoCiclo = tiempoCiclo;
    }
}
