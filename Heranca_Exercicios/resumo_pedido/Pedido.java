import java.util.Arrays;

public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularValorDesconto() {
        return (Arrays.stream(itens)
                .mapToDouble(item -> item.getQuantidade() * item.getProduto().obterPrecoLiquido())
                .sum()) * (percentualDesconto / 100.00);
    }

    public double calcularTotal() {
        double total = 0.0;

        for (ItemPedido item : itens) {
            total += item.getProduto().obterPrecoLiquido() * item.getQuantidade();
        }

        return total;
    }

    public void apresentarResumoPedido() {
        double valorTotalPedido = calcularTotal();
        double valorDesconto = calcularValorDesconto();

        System.out.println("------- RESUMO PEDIDO -------");
        for (ItemPedido item : itens ) {
            System.out.println(String.format("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f", item.getProduto().getClass().getSimpleName(), item.getProduto().getTitulo(), item.getProduto().obterPrecoLiquido(), item.getQuantidade(), item.getQuantidade() * item.getProduto().obterPrecoLiquido()));
        }
        System.out.println("----------------------------");
        System.out.println(String.format("DESCONTO: %.2f", valorDesconto));
        System.out.println(String.format("TOTAL PRODUTOS: %.2f", valorTotalPedido));
        System.out.println("----------------------------");
        System.out.println(String.format("TOTAL PEDIDO: %.2f", valorTotalPedido - valorDesconto));
        System.out.println("----------------------------");
    }

}