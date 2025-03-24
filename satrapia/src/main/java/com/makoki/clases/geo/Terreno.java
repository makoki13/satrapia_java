package com.makoki.clases.geo;

import com.makoki.clases.usuarios.Jugador;

public class Terreno {
    private Coordenadas coordenadas;
    private TipoTerreno terreno;
    private Jugador duenyo;

    public Terreno(Coordenadas coordenadas, TipoTerreno terreno) {
        this.coordenadas = coordenadas;
        this.terreno = terreno;
        this.duenyo = null;
    }

    public Terreno(Coordenadas coordenadas, TipoTerreno terreno, Jugador duenyo) {
        this.coordenadas = coordenadas;
        this.terreno = terreno;
        this.duenyo = duenyo;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    public void setTerreno(TipoTerreno terreno) {
        this.terreno = terreno;
    }

    public TipoTerreno getTerreno() {
        return terreno;
    }

    public void setDuenyo(Jugador duenyo) {
        this.duenyo = duenyo;
    }

    public Jugador getDuenyo() {
        return duenyo;
    }
}
