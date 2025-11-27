package es.etg.dam;

import java.util.concurrent.Exchanger;

class Hilo implements Runnable {

    private Exchanger<String> exchanger;
    private String mensajeEnviado;
    private String mensajeRecibido;
    private static final String RECIBIR = "Ha recibido: ";

    public Hilo(Exchanger<String> exchanger, String mensaje) {
        this.exchanger = exchanger;
        this.mensajeEnviado = mensaje;

    }

    @Override
    public void run() {
        try {
            mensajeRecibido = exchanger.exchange(mensajeEnviado);
            System.out.println(RECIBIR + mensajeRecibido);

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
