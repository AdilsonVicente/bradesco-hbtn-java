import java.util.Random;

public class Produtor extends Thread {

    public Fila fila;

    public Produtor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {

        try {
            Random random = new Random();
            int numero = random.nextInt(100) + 1;
            fila.adicionar(numero);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}