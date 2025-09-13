import java.util.List;

public class Pedido {
    private int codigo;
    private List<Produto> produtoV1s;
    private Cliente clienteV1;

    public Pedido(int codigo, List<Produto> produtoV1s, Cliente clienteV1) {
        this.codigo = codigo;
        this.produtoV1s = produtoV1s;
        this.clienteV1 = clienteV1;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public List<Produto> getProdutos() {
        return produtoV1s;
    }

    public void setProdutos(List<Produto> produtoV1s) {
        this.produtoV1s = produtoV1s;
    }

    public Cliente getCliente() {
        return clienteV1;
    }

    public void setCliente(Cliente clienteV1) {
        this.clienteV1 = clienteV1;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s", this.codigo, this.clienteV1.getNome());
    }
}
