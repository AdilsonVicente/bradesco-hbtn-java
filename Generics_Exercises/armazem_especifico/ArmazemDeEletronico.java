public class ArmazemDeEletronico<T extends Eletronico> extends Armazem<T> {
    @Override
    public void adicionarAoInventario(String nome, T valor) {
        super.adicionarAoInventario(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return super.obterDoInventario(nome);
    }
}