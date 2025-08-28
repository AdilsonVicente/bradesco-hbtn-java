import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {

    public static List<Produto> filtrar(List<Produto> lista, Predicate<Produto> criterioFiltro) {
        return lista.stream().filter(criterioFiltro).toList();
    }
}