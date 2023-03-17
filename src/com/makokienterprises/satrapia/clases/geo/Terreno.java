package com.makokienterprises.satrapia.clases.geo;

/*
0: llanura
1: desierto
2: Hielo / Nieve
20: Colinas
21: Montaña
22: Alta montaña
50: agua vadeable
51: agua no vadeable
52: Marismas fanganosas
99: Infranqueable
100: mar litoral
101: mar profunda
 */
public class Terreno {
    private int id;
    private String nombre;

    private double penalizacionMar;
    private double penalizacionTierra;

    public Terreno(int id, String nombre, double penalizacionMar, double penalizacionTierra) {
        this.id = id;
        this.nombre = nombre;
        this.penalizacionMar = penalizacionMar;
        this.penalizacionTierra = penalizacionTierra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPenalizacionMar() {
        return penalizacionMar;
    }

    public void setPenalizacionMar(double penalizacionMar) {
        this.penalizacionMar = penalizacionMar;
    }

    public double getPenalizacionTierra() {
        return penalizacionTierra;
    }

    public void setPenalizacionTierra(double penalizacionTierra) {
        this.penalizacionTierra = penalizacionTierra;
    }
}


