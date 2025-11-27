package es.etg.dam;

import java.util.concurrent.Exchanger;

public class App {

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();

        Thread hilo1 = new Thread(new HiloIntercambio(exchanger, "Hola!"), "Hilo1");
        Thread hilo2 = new Thread(new HiloIntercambio(exchanger, "Adios"), "Hilo2");

        hilo1.start();
        hilo2.start();
    }
}
