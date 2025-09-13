import java.util.Comparator;
import java.util.List;

public class Consulta {
    public static List<Produto> obterLivrosDoPedido(Pedido pedidoV1) {
        return pedidoV1.getProdutos().stream()
                .filter(produtoV1 -> produtoV1.getCategoria().equals(CategoriaProduto.LIVRO))
                .toList();
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos.stream()
                .sorted(Comparator.comparing(Produto::getPreco).reversed())
                .limit(1)
                .findFirst()
                .get();
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream()
                .filter(produto -> produto.getPreco() >= precoMinimo)
                .toList();
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
                .filter(pedido -> pedido.getProdutos().stream()
                        .anyMatch(produto -> produto.getCategoria().equals(CategoriaProduto.ELETRONICO))
                )
                .toList();
    }

    public static List<Produto> aplicar15PorcentoDescontoEletronicos(List<Produto> produtos) {
        return produtos.stream()
                .map(produto -> {
                    if(produto.getCategoria().equals(CategoriaProduto.ELETRONICO))
                        produto.setPreco(produto.getPreco() - (produto.getPreco() * 0.15D));
                    return produto;
                })
                .toList();
    }
}