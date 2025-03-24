package com.makoki.clases.geo;

public final class Mapa { // Final: No inheritance, is immutable
    private final int filas; // Number of rows (height)
    private final int columnas; // Number of columns (width)
    private final Terreno[][] mapa; // 2D array of Terreno objects

    public Mapa(int filas, int columnas, TipoTerreno defaultTerreno) {
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Las dimensiones del mapa deben ser mayores que cero.");
        }
        this.filas = filas;
        this.columnas = columnas;
        this.mapa = new Terreno[filas][columnas];

        // Initialize the map with the default terrain
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.mapa[i][j] = new Terreno(new Coordenadas(i, j), defaultTerreno);
            }
        }
    }
    public Mapa(Terreno[][] mapa){
        this.mapa=mapa;
        this.filas=mapa.length;
        this.columnas=mapa[0].length;
        for (int i=0;i<filas;i++){
            if (mapa[i].length!=columnas){
                throw new IllegalArgumentException("Las filas del mapa no son iguales");
            }
        }
        
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Terreno getTerreno(int fila, int columna) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Coordenadas fuera de los límites del mapa.");
        }
        return mapa[fila][columna];
    }

    public Mapa setTerreno(int fila, int columna, TipoTerreno nuevoTerreno) {
        if (fila < 0 || fila >= filas || columna < 0 || columna >= columnas) {
            throw new IndexOutOfBoundsException("Coordenadas fuera de los límites del mapa.");
        }
        //Create a new Map with the old values and the new one.
        Terreno[][] nuevoMapa= new Terreno[filas][columnas];
        for (int i=0; i<filas; i++){
            for(int j=0; j<columnas;j++){
                if (i == fila && j == columna){
                    nuevoMapa[i][j]=new Terreno(new Coordenadas(i, j), nuevoTerreno);
                } else {
                    nuevoMapa[i][j]=mapa[i][j];
                }
                
            }
        }
        return new Mapa(nuevoMapa);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                sb.append(mapa[i][j].toString()).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args){
        TipoTerreno t1 = TipoTerreno.LLANURA;
        TipoTerreno t2 = TipoTerreno.DESIERTO;
        Mapa m = new Mapa(10,10,t1);
        System.out.println(m);
        m = m.setTerreno(1,1,t2);
        System.out.println(m);
    }
}

