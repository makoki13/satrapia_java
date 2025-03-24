package com.makoki.clases.geo;

import java.util.ArrayList;

import com.makoki.clases.usuarios.Jugador;

public class Imperio {
    Jugador emperador;
    
    ArrayList<Reino> reinos = new ArrayList<>();

    public Imperio(Jugador emperador) {
        this.emperador = emperador;
    }

    public void addReino(Reino reino) {
        reinos.add(reino);
    }

    public void removeReino(Reino reino) {
        reinos.remove(reino);
    }

    public Reino getReino(int index) {
        return reinos.get(index);
    }

    public int getNumeroReinos() {
        return reinos.size();
    }

    public Jugador getEmperador() {
        return emperador;
    }

    public void setEmperador(Jugador emperador) {
        this.emperador = emperador;
    }
}
