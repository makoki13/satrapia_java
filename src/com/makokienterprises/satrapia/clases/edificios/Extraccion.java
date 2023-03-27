package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.persistencia.Persistencia;

public class Extraccion extends FuenteDeRecursos {
    public Extraccion() {
        this.recurso = Recursos.PIEDRA;
        this.inagotable = false;
    }

    @Override
    public int extrae(int numeroParticipantes, double aporte) {
        int cantidadAExtraer = (int)(numeroParticipantes * aporte);
        if (cantidadAExtraer > this.stock) {
            cantidadAExtraer = this.stock;
        }

        int stockRemanente = this.stock - cantidadAExtraer;

        Persistencia.fuenteDeIngresosSetStock(this.id, stockRemanente);

        return cantidadAExtraer;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
