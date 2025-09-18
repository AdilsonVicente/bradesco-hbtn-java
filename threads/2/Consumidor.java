public class Consumidor extends Thread {

    public Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            fila.retirar();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}