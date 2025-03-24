package com.makoki.clases.geo;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private final String nombre;
    private final List<Terreno> terrenos;

    public Pais(String nombre) {
        this.nombre = nombre;
        this.terrenos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Terreno> getTerrenos() {
        // Defensive copy
        return new ArrayList<>(terrenos);
    }

    public void addTerreno(Terreno terreno) {
        if (terreno == null) {
            throw new IllegalArgumentException("El terreno no puede ser nulo.");
        }
        this.terrenos.add(terreno);
    }

    public void removeTerreno(Terreno terreno) {
        this.terrenos.remove(terreno);
    }

    public boolean containsTerreno(Terreno terreno) {
        return this.terrenos.contains(terreno);
    }

    public int getNumeroTerrenos() {
        return this.terrenos.size();
    }

    @Override
    public String toString() {
        return "Posesion{" +
                "nombre='" + nombre + '\'' +
                ", numeroTerrenos=" + terrenos.size() +
                '}';
    }

    // Example usage in main
    public static void main(String[] args) {
        // Create some terrains
        Coordenadas c1 = new Coordenadas(0, 0);
        Coordenadas c2 = new Coordenadas(0, 1);
        Coordenadas c3 = new Coordenadas(1, 0);
        Coordenadas c4 = new Coordenadas(1, 1);

        Terreno t1 = new Terreno(c1, TipoTerreno.LLANURA);
        Terreno t2 = new Terreno(c2, TipoTerreno.SIERRA);
        Terreno t3 = new Terreno(c3, TipoTerreno.MAR);
        Terreno t4 = new Terreno(c4, TipoTerreno.LLANURA);

        // Create a country
        Pais posesion1 = new Pais("Satrapia");

        // Add terrains to the country
        posesion1.addTerreno(t1);
        posesion1.addTerreno(t2);
        posesion1.addTerreno(t3);

        // Print the country's information
        System.out.println(posesion1); // Output: Posesion{nombre='Satrapia', numeroTerrenos=3}

        // Check if the country contains a terrain
        System.out.println("Contains t1: " + posesion1.containsTerreno(t1)); // Output: Contains t1: true
        System.out.println("Contains t4: " + posesion1.containsTerreno(t4)); // Output: Contains t4: false

        //Create a new country
        Pais posesion2 = new Pais("Imperio");
        posesion2.addTerreno(t3);
        posesion2.addTerreno(t4);
        System.out.println(posesion2); // Output: Posesion{nombre='Imperio', numeroTerrenos=2}
        System.out.println("Contains t3: " + posesion2.containsTerreno(t3)); // Output: Contains t3: true
        System.out.println("Contains t3 in posesion1: " + posesion1.containsTerreno(t3)); // Output: Contains t3 in posesion1: true
    }
}
