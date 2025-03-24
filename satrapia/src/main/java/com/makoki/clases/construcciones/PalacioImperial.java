package com.makoki.clases.construcciones;

public class PalacioImperial extends Palacio {
    public PalacioImperial(com.makoki.clases.geo.Ciudad ciudad) {
        super(ciudad);
    }
    
    @Override
    public String toString() {
        return "Palacio Imperial";
    }
}