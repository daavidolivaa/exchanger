package es.etg.dam;

import java.util.concurrent.Exchanger;

class HiloIntercambio implements Runnable {

    private Exchanger<String> exchanger;
    private String mensaje;

    public HiloIntercambio(Exchanger<String> exchanger, String mensaje) {
        this.exchanger = exchanger;
        this.mensaje = mensaje;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " envía: " + mensaje);

            String recibido = exchanger.exchange(mensaje);

            System.out.println(Thread.currentThread().getName()
                    + " recibe: " + recibido);

        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
