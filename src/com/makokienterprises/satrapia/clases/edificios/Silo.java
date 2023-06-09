package com.makokienterprises.satrapia.clases.edificios;

import com.makokienterprises.satrapia.clases.persistencia.Persistencia;

public class Silo {
    /*
    # stock: Cantidad en el silo
    # limite: maximo valor de stock
    # factorTiempo, factorRendimiento: porcentajes penalizadores
    # envioAutomatico: Después de la cosecha see envía al almacén destino. No se espera a llenar el stock del silo
    # soloAlmacenar: No envía. Se lo queda
    */
    static {
        ultimoID = 0;
    }
    private static long ultimoID;

    private long id;

    public Recursos recurso;
    private int stock;
    private int limite;

    private int factorTiempo; //segundos por cosecha
    private double factorRendimiento; //0 a 100. Penalizador.

    private Almacen almacen;
    private Almacen almacenDestino;

    public Silo(Recursos recurso, int stock, int limite, int factorTiempo, double factorRendimiento, Almacen almacen) {
        this.id = ++ultimoID;
        this.recurso = recurso;
        this.stock = stock;
        this.limite = limite;
        this.factorTiempo = factorTiempo;
        this.factorRendimiento = factorRendimiento;
        this.almacen = almacen;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        Persistencia.siloSetStock(this.id,this.stock);
    }

    public void addStock(int cantidad) {
        int cantidadAporte = (int)(cantidad * this.factorRendimiento);
        if ( ((this.stock + cantidadAporte) > this.limite) && (this.limite > 0) ) {
            this.setStock(this.limite);
        }
        else {
            int cantidadStock = this.stock + cantidadAporte;
            this.setStock(cantidadStock);
        }
    }
}
