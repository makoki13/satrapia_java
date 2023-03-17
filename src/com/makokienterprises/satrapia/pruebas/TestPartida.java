package com.makokienterprises.satrapia.pruebas;

import com.makokienterprises.satrapia.clases.geo.Imperio;
import com.makokienterprises.satrapia.clases.geo.Nacion;
import com.makokienterprises.satrapia.clases.geo.Region;
import com.makokienterprises.satrapia.clases.usuarios.Jugador;
import com.makokienterprises.satrapia.clases.usuarios.Partida;

import java.util.List;

public class TestPartida {
    public static void main(String[] args) {
        Partida partida = new Partida("Primera Partida");

        Imperio imperio1 = new Imperio(1,"Imperio Antiguo");

        Jugador jugador1 = new Jugador(1);
        jugador1.setNombre("Jugador 1");
        jugador1.setRol(Jugador.Roles.EMPERADOR);
        jugador1.setIdImperio(imperio1.getId());
        Nacion nacion1 = new Nacion("Nacion 1");
        nacion1.setJugador(jugador1.getId());
        Region region1 = new Region(1,"Region 1",null);
        Region region2 = new Region(2,"Region 2",null);
        nacion1.addRegion(region1);
        nacion1.addRegion(region2);
        jugador1.setNacion(nacion1);


        Jugador jugador2 = new Jugador(2);
        jugador2.setNombre("Jugador 2");
        jugador2.setRol(Jugador.Roles.SATRAPA);
        jugador2.setIdImperio(imperio1.getId());
        Nacion nacion2 = new Nacion("Nacion 2");
        nacion2.setJugador(jugador2.getId());
        Region region3 = new Region(3,"Region 3",null);
        Region region4 = new Region(4,"Region 4",null);
        nacion2.addRegion(region3);
        nacion2.addRegion(region4);
        jugador2.setNacion(nacion2);

        imperio1.addJugador(jugador1);
        imperio1.addJugador(jugador2);

        /* Otro imperio */

        Imperio imperio2 = new Imperio(2,"Imperio Clásico");

        Jugador jugador3 = new Jugador(3);
        jugador3.setNombre("Jugador 3");
        jugador3.setRol(Jugador.Roles.EMPERADOR);
        jugador3.setIdImperio(imperio2.getId());
        Nacion nacion3 = new Nacion("Nacion 3");
        nacion3.setJugador(jugador3.getId());
        Region region5 = new Region(5,"Region 5",null);
        Region region6 = new Region(6,"Region 6",null);
        nacion3.addRegion(region5);
        nacion3.addRegion(region6);
        jugador3.setNacion(nacion3);

        Jugador jugador4 = new Jugador(4);
        jugador4.setNombre("Jugador 4");
        jugador4.setRol(Jugador.Roles.SATRAPA);
        jugador4.setIdImperio(imperio2.getId());
        Nacion nacion4 = new Nacion("Nacion 4");
        nacion4.setJugador(jugador4.getId());
        Region region7 = new Region(7,"Region 7",null);
        Region region8 = new Region(8,"Region 8",null);
        nacion4.addRegion(region7);
        nacion4.addRegion(region8);
        jugador4.setNacion(nacion4);

        imperio2.addJugador(jugador3);
        imperio2.addJugador(jugador4);

        /* Tribu */
        Imperio tribu1 = new Imperio(3,"Tribu 1");
        tribu1.setEsTribu(true);
        Jugador jugador5 = new Jugador(5);
        jugador5.setNombre("Jugador 5");
        jugador5.setRol(Jugador.Roles.JEFE_DE_TRIBU);
        jugador5.setIdImperio(tribu1.getId());
        Nacion nacion5 = new Nacion("Nacion 5");
        nacion5.setJugador(jugador5.getId());
        jugador5.setNacion(nacion5);
        tribu1.addJugador(jugador5);

        partida.addImperio(imperio1);
        partida.addImperio(imperio2);
        partida.addImperio(tribu1);
        
        List<Imperio> listaImperios = partida.listaImperios();
        for(Imperio i: listaImperios) {
            System.out.println("Imperio id = " + i.getId());
            System.out.println("Imperio nombre = " + i.getNombre());
            for(Jugador j: i.jugadores()) {
                System.out.println("jugador nombre = " + j.getNombre());
                System.out.println("jugador rol = " + j.getRol());
                System.out.println("jugador id imperio = " + j.getIdImperio());
                Nacion n = j.getNacion();
                System.out.println("jugador nación = " + n.nombre );
                List<Region> regiones = n.regiones();
                for(Region r: regiones) {
                    System.out.println("region nombre = " + r.getNombre());
                }
            }

            boolean esTribu = i.getEsTribu();
            if (esTribu) {
                System.out.println("Es tribu");
            }
            else {
                System.out.println("Es imperio");
            }

            System.out.println("-----------------------");
        }

    }
}
