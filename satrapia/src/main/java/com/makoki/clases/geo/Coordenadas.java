package com.makoki.clases.geo;

public class Coordenadas {
    private int x;
    private int y;
    private int z;

    public Coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    public Coordenadas(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args) {
        Coordenadas c = new Coordenadas(10,10);
        System.out.println(c.x + " , " + c.y + " , " + c.z);
    }

    public int getX() { return x;}
    public void setX(int x) { this.x = x;}
    public int getY() { return y;}
    public void setY(int y) { this.y = y;}
    public int getZ() { return z;}
    public void setZ(int z) { this.z = z;}

    @Override
    public String toString() {
        return "Coordenadas{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
