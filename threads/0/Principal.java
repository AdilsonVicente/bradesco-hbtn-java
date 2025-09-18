
public class Principal {
    public static void main(String[] args) throws InterruptedException {

        Contador contador = new Contador();

        ThreadContador threads = new ThreadContador(contador);
        threads.start();

        ThreadContador threads1 = new ThreadContador(contador);
        threads1.start();

        threads.join();
        threads1.join();

        System.out.println("Valor final do contador: " + contador.getContagem());

    }

}