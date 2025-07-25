public class ArmazemDeComida<T extends Comida> extends Armazem<T> {
    @Override
    public void adicionarAoInventario(String nome, T valor) {
        super.adicionarAoInventario(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return super.obterDoInventario(nome);
    }
}