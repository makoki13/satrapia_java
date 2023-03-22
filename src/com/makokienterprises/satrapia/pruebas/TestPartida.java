package com.makokienterprises.satrapia.pruebas;

import com.makokienterprises.satrapia.clases.dispatcher.Dispatcher;
import com.makokienterprises.satrapia.clases.geo.*;
import com.makokienterprises.satrapia.clases.usuarios.Jugador;
import com.makokienterprises.satrapia.clases.usuarios.Partida;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class TestPartida {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Partida partida = new Partida("Primera Partida");
        System.out.println("partida.getId() = " + partida.getId());

        Imperio imperio1 = new Imperio("Imperio Antiguo");

        Jugador jugador1 = new Jugador();
        jugador1.setNombre("Jugador 1");
        jugador1.setRol(Jugador.Roles.EMPERADOR);
        jugador1.setImperio(imperio1);
        Nacion nacion1 = new Nacion("Nacion 1");
        nacion1.setJugador(jugador1);
        Region region1 = new Region("Region 1",null);
        Punto punto1 = new Punto(1,1,1,null);
        Ciudad ciudad1R1 = new Ciudad("Gandia",region1,punto1,true);
        Punto puntoGranja = new Punto(10,10,10,null);
        ciudad1R1.addGranja(puntoGranja);
        region1.addCiudad(ciudad1R1);
        Punto punto2 = new Punto(2,2,2,null);
        Ciudad ciudad2R1 = new Ciudad("Beniopa",region1,punto2,false);
        Punto puntoGranja2 = new Punto(20,20,20,null);
        ciudad2R1.addGranja(puntoGranja2);
        region1.addCiudad(ciudad2R1);
        Region region2 = new Region("Region 2",null);

        nacion1.addRegion(region1);
        nacion1.addRegion(region2);
        jugador1.setNacion(nacion1);

        Jugador jugador2 = new Jugador();
        jugador2.setNombre("Jugador 2");
        jugador2.setRol(Jugador.Roles.SATRAPA);
        jugador2.setImperio(imperio1);
        Nacion nacion2 = new Nacion("Nacion 2");
        nacion2.setJugador(jugador2);
        Region region3 = new Region("Region 3",null);
        Punto punto3 = new Punto(3,3,3,null);
        Ciudad ciudad1R3 = new Ciudad("Alicante",region3,punto2,true);

        Region region4 = new Region("Region 4",null);
        nacion2.addRegion(region3);
        nacion2.addRegion(region4);
        jugador2.setNacion(nacion2);

        imperio1.addJugador(jugador1);
        imperio1.addJugador(jugador2);

        /* Otro imperio */

        Imperio imperio2 = new Imperio("Imperio Clásico");

        Jugador jugador3 = new Jugador();
        jugador3.setNombre("Jugador 3");
        jugador3.setRol(Jugador.Roles.EMPERADOR);
        jugador3.setImperio(imperio2);
        Nacion nacion3 = new Nacion("Nacion 3");
        nacion3.setJugador(jugador3);
        Region region5 = new Region("Region 5",null);
        Region region6 = new Region("Region 6",null);
        nacion3.addRegion(region5);
        nacion3.addRegion(region6);
        jugador3.setNacion(nacion3);

        Jugador jugador4 = new Jugador();
        jugador4.setNombre("Jugador 4");
        jugador4.setRol(Jugador.Roles.SATRAPA);
        jugador4.setImperio(imperio2);
        Nacion nacion4 = new Nacion("Nacion 4");
        nacion4.setJugador(jugador4);
        Region region7 = new Region("Region 7",null);
        Region region8 = new Region("Region 8",null);
        nacion4.addRegion(region7);
        nacion4.addRegion(region8);
        jugador4.setNacion(nacion4);

        imperio2.addJugador(jugador3);
        imperio2.addJugador(jugador4);

        /* Tribu */
        Imperio tribu1 = new Imperio("Tribu 1");
        tribu1.setEsTribu(true);
        Jugador jugador5 = new Jugador();
        jugador5.setNombre("Jugador 5");
        jugador5.setRol(Jugador.Roles.JEFE_DE_TRIBU);
        jugador5.setImperio(tribu1);
        Nacion nacion5 = new Nacion("Nacion 5");
        nacion5.setJugador(jugador5);
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
                System.out.println("jugador id imperio = " + j.getImperio().getId());
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

        Object lock= new Object();
        synchronized(lock){
            Dispatcher.inicializa();
            Dispatcher.ejecuta();
            // write your code here. You may use wait() or notify() as per your requirement.
            System.out.println("Sincronizando");
            lock.wait();
            //lock.notify();
            System.out.println("deSincronizando");
        }
    }
}
