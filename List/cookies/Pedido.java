import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        this.cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        return this.cookies.stream().mapToInt(PedidoCookie::getQuantidadeCaixas).sum();
    }

    public int removerSabor(String sabor) {
        List<PedidoCookie> remover = this.cookies.stream()
                .filter(pedidoCookie -> pedidoCookie.getSabor().equals(sabor))
                .toList();
        this.cookies.removeAll(remover);
        return remover.stream().mapToInt(PedidoCookie::getQuantidadeCaixas).sum();
    }
}