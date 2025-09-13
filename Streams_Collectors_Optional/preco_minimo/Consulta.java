import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        List<Produto> produtos = pedido.getProdutos().stream()
                .filter(produto -> produto.getCategoria().name() == CategoriaProduto.LIVRO.toString())
                .collect(Collectors.toList());

        return produtos;
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {

        Produto produto = produtos.get(0);

        Optional<Produto> produtos2 = produtos.stream()
                .max(Comparator.comparing(Produto::getPreco));

        if (produtos2.isPresent()) {
            produto = produtos2.get();
        }

        return produto;
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {

        List<Produto> produtos2 = produtos.stream()
                .filter(produto -> produto.getPreco() >= precoMinimo)
                .collect(Collectors.toList());

        return produtos2;

    }
}