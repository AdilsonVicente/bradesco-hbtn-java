import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T extends Midia> {
    private List<T> lista = new ArrayList<>();

    public void adicionarMidia(T valor) {
        this.lista.add(valor);
    }

    public List<T> obterListaMidias() {
        return this.lista;
    }
}