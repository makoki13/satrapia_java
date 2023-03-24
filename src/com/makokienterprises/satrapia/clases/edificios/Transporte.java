package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.dispatcher.Tarea;
import com.makokienterprises.satrapia.clases.geo.Punto;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Transporte {
    private Object emisor;
    private Punto inicio;
    private Punto posicion;
    private Punto destino;

    private List<Punto> puntos = new ArrayList<>();

    public Transporte(Punto inicio, Punto destino, Object emisor) {
        this.inicio = inicio;
        this.posicion = inicio;
        this.destino = destino;
        this.emisor = emisor;
    }

    public void envia(Method destructor) throws NoSuchMethodException {
        this.calculaTrayectoria();
        Method funcionAcercar = Transporte.class.getMethod("acercar");
        Tarea tarea = new Tarea(this,funcionAcercar,5,emisor, destructor);
        Dispatcher.addTarea(tarea);
    }

    public void calculaTrayectoria() {
        Punto puntoActual = new Punto(this.inicio.getX(),this.inicio.getY(),0,null);

        int diferenciaEjeX = this.destino.getX() - this.posicion.getX();
        boolean esNegativoX = false;
        if (diferenciaEjeX < 0) {
            esNegativoX = true;
            diferenciaEjeX *= -1;
        }

        int diferenciaEjeY = this.destino.getY() - this.posicion.getY();
        boolean esNegativoY = false;
        if (diferenciaEjeY < 0) {
            esNegativoY = true;
        }

        for (int i = 1; i <= diferenciaEjeX; i++) {
            int nuevoX = this.posicion.getX();
            if (esNegativoX) {
                if (puntoActual.getX() > this.destino.getX()) {
                    nuevoX = this.posicion.getX() - i;
                }
            }
            else {
                if (this.posicion.getX() < this.destino.getX()) {
                    nuevoX = this.posicion.getX() + i;
                }
            }

            Punto p = new Punto(nuevoX,puntoActual.getY(), 0,null);
            this.puntos.add(p);

            puntoActual = p;

            boolean anyadirPunto = false;
            int nuevoY = puntoActual.getY();
            if (esNegativoY) {
                if (puntoActual.getY() > this.destino.getY()) {
                    nuevoY = this.posicion.getY() - i;
                    anyadirPunto = true;
                }
            }
            else {
                if (puntoActual.getY() < this.destino.getY()) {
                    nuevoY = this.posicion.getY() + i;
                    anyadirPunto = true;
                }
            }

            if (anyadirPunto) {
                p = new Punto(nuevoX, nuevoY, 0, null);
                this.puntos.add(p);
            }

            puntoActual = p;

        }

        diferenciaEjeY = this.destino.getY() - puntoActual.getY() ;
        if (diferenciaEjeY < 0) {
            diferenciaEjeY *= -1;
        }

        for (int i = 1; i <= diferenciaEjeY; i++) {
            int nuevoX = puntoActual.getX();

            int nuevoY = puntoActual.getY();
            if (puntoActual.getY() < this.destino.getY()) {
                nuevoY = puntoActual.getY() + i;
            }

            Punto p = new Punto(nuevoX,nuevoY, 0,null);
            this.puntos.add(p);
        }
    }

    public boolean acercar() {
        this.puntos.remove(0);
        boolean valorHaLlegado = this.haLLegado();
        return !valorHaLlegado; //es ! porque con false se suicida.
    }

    public boolean haLLegado() {
        return (this.puntos.size() == 0);
    }
}
