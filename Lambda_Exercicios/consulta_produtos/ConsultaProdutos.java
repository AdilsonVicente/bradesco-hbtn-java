import java.util.List;

public class ConsultaProdutos {

    public static List<Produto> filtrar(List<Produto> lista, CriterioFiltro criterioFiltro) {
        return lista.stream().filter(criterioFiltro::testar).toList();
    }
}