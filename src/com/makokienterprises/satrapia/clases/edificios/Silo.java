package com.makokienterprises.satrapia.clases.edificios;

public class Silo {
    /*
    # stock: Cantidad en el silo
    # limite: maximo valor de stock
    # factorTiempo, factorRendimiento: porcentajes penalizadores
    # envioAutomatico: Después de la cosecha see envía al almacén destino. No se espera a llenar el stock del silo
    # soloAlmacenar: No envía. Se lo queda
    */

    private int id;

    public Recursos recurso;
    private int stock;
    private int limite;

    private int factorTiempo; //segundos por cosecha
    private double factorRendimiento; //0 a 100. Penalizador.

    private Almacen almacen;
    private Almacen almacenDestino;

    public Silo(Recursos recurso, int stock, int limite, int factorTiempo, double factorRendimiento, Almacen almacen) {
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

    public void addStock(int cantidad) {
        int cantidadAporte = (int)(cantidad * this.factorRendimiento);
        this.stock += cantidadAporte;
        if ((this.stock > this.limite) && (this.limite > 0) ) {
            this.stock = this.limite;
        }
        String strCiudad = this.almacen.getCiudad().getNombre();
        String leyenda = "Añadido " + cantidadAporte + " de " + this.recurso + " al tesoro. Hay " + this.stock +
                " en almacen de " + this.almacen.getNombre() + " de la ciudad " + strCiudad;
        System.out.println(leyenda);
    }
}
