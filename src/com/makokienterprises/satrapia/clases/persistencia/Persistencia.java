package com.makokienterprises.satrapia.clases.persistencia;

import com.makokienterprises.satrapia.clases.edificios.Recursos;
import com.makokienterprises.satrapia.clases.geo.Punto;

final public class Persistencia {
    /*Fuentes de recursos */
    static public boolean addFuenteDeRecursos(long id, long idEdificio) {
        System.out.println("se añade fuente de recursos id: " + id + " edificio: " + idEdificio);
        return true;
    }
    static public boolean fuenteDeIngresosSetStock(long id, int stock) {
        return true;
    }

    /* Granjas */
    static public boolean addGranja(long id, long idCiudad, long idAlmacen, Punto posicion, double porcentajeCosecha,
                                    int cantidadCosecha, int cantidadAEnviarACiudad) {
      return true;
    }
    static public boolean deleteGranja(long id) {
        return true;
    }
    static public boolean granjaSetPorcentajeCosecha(long id,double porcentajeCosecha) {
        return true;
    }
    static public boolean granjaSetCantidadCosecha(long id,int cantidadCosecha) {
        return true;
    }
    static public boolean granjaSetCantidadAEnviarACiudad(long id,int cantidadAEnviarACiudad) {
        return true;
    }

    /* Silos */
    static public boolean addSilo(long id, long idAlmacen, Recursos recurso, int stock, int limite, int factorTiempo,
                                  int factorRendimiento, long idAlmacenDestino) {
        return true;
    }
    static public boolean deleteSilo(long id) {
        return true;
    }
    static public boolean siloSetStock(long idSilo, int stock) {
        return true;
    }
}
