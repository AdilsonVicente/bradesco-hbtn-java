import java.util.LinkedList;

public class SistemaFilas {

    public static void main(String[] args)  throws InterruptedException{

        LinkedList<Integer> lista = new LinkedList<>();
        Fila fila;
        Thread.sleep(2000);
        for (int i = 0; lista.size() < 10; i++) {

            lista.add(i);
            fila = new Fila(lista);

            Produtor produtor = new Produtor(fila);
            Produtor produtor1 = new Produtor(fila);
            produtor.start();
            produtor1.start();
            Consumidor consumidor = new Consumidor(fila);
            Consumidor consumidor1 = new Consumidor(fila);
            consumidor.start();
            consumidor1.start();



        }
        Thread.sleep(20000);
        System.exit(0);

    }
}