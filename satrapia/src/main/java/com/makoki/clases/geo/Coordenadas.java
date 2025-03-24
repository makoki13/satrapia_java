package com.makoki.clases.geo;

public class Coordenadas {
    private final int x;
    private final int y;
    private final int z;

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
}
