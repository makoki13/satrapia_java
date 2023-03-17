package com.makokienterprises.satrapia.clases.geo;

public class Punto {
    public int x;
    public int y;

    public int z;

    public Terreno terreno;

    public Punto(int x, int y, int z, Terreno terreno) {
        if (x < 0) {
            x = 0;
        }
        this.x = x;
        if (y < 0) {
            y = 0;
        }
        this.y = y;
        if (z < 0) {
            z = 0;
        }
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) {
            x = 0;
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) {
            y = 0;
        }
        this.y = y;
    }

    public int getZ() {
        if (z < 0) {
            z = 0;
        }
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
}
