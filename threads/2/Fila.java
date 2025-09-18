import java.util.LinkedList;

public class Fila {

    private LinkedList<Integer> lista;

    public Fila(LinkedList<Integer> lista) {
        this.lista = lista;
    }


    public synchronized void adicionar(int item) throws InterruptedException {

        while (this.lista.size() > 10) {
            System.out.println("Esperando a lista diminuir");
            wait();
        }
        this.lista.add(item);
        System.out.println("Produtor produziu: " + item);
        for (int listunit : lista) {
            System.out.println("Produtor item: " + listunit);
        }
        notify();

    }

    public synchronized void retirar() throws InterruptedException {
        while (this.lista.size() == 0) {
            System.out.println("Esperando a lista aumentar");
            wait();
        }
        this.lista.remove();

        for (int listunit : lista) {
            System.out.println("cosumiu o item: " + listunit);
        }
        notify();

    }
}