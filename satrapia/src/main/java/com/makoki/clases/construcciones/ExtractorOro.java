package com.makoki.clases.construcciones;

import com.makoki.clases.investigacion.Recurso;

public class ExtractorOro extends Extractor {
    public ExtractorOro() {
        super(Recurso.ORO, 10, 100, true, 3);
    }

    @Override
    public void cosecha(Silo silo) {    
         Thread hilo1 = new Thread(() -> {   
            while (true) {
                long cantidad;
                try { Thread.sleep(tiempoCiclo*1000); } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cantidad = 10; //TODO   

                silo.cosecha(cantidad);
            }
            
        });

        hilo1.start();
    }
}
