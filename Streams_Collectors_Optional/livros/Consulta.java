import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        List<Produto> produtos = pedido.getProdutos().stream()
                .filter(produto -> produto.getCategoria().name() == CategoriaProduto.LIVRO.toString())
                .collect(Collectors.toList());

        return produtos;

    }
}
