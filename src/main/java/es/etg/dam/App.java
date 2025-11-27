package es.etg.dam;

import java.util.concurrent.Exchanger;

public class App {

    private static final String MENSAJE_HOLA = "Hola!";
    private static final String MENSAJE_ADIOS = "Adios.";
    private static final String HILO1 = "Hilo1";
    private static final String HILO2 = "Hilo2";

    public static void main(String[] args) {

        Exchanger<String> exchanger = new Exchanger<>();

        Thread hilo1 = new Thread(new Hilo(exchanger, MENSAJE_HOLA), HILO1);
        Thread hilo2 = new Thread(new Hilo(exchanger, MENSAJE_ADIOS), HILO2);

        hilo1.start();
        hilo2.start();
    }
}
