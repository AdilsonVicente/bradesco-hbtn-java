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

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {

        List<Pedido> pedido3 = new ArrayList<>();
        boolean pedido2 = false;
        for (Pedido pedido : pedidos) {
            pedido2 = pedido.getProdutos().stream()
                    .anyMatch(cat -> cat.getCategoria().name() == CategoriaProduto.ELETRONICO.toString());
            if (pedido2) {
                pedido3.add(pedido);
            }

        }

        return pedido3;
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {

        List<Produto> produtosAtualizados = produtos.stream()
                .map(produto -> {
                    if (produto.getCategoria().equals(CategoriaProduto.ELETRONICO)) {
                        produto.setPreco(produto.getPreco() - (produto.getPreco() * 0.15));
                    }
                    return produto;
                })
                .collect(Collectors.toList());

        return produtosAtualizados;
    }
}