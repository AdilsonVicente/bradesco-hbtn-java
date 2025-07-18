import exceptions.OperacaoInvalidaException;

public class ContaBancariaTarifada extends ContaBancariaBasica {
    private int quantidadeTransacoes;

    public ContaBancariaTarifada(String numeracao, double taxaJurosAnual) throws OperacaoInvalidaException {
        super(numeracao, taxaJurosAnual);
    }

    public int getQuantidadeTransacoes() {
        return quantidadeTransacoes;
    }

    @Override
    public void depositar(double valor) throws OperacaoInvalidaException {
        super.depositar(valor);
        super.setSaldo(super.getSaldo() - 0.10);
        this.quantidadeTransacoes += 1;
    }

    @Override
    public void sacar(double valor) throws OperacaoInvalidaException {
        super.sacar(valor);
        super.setSaldo(super.getSaldo() - 0.10);
        this.quantidadeTransacoes += 1;
    }
}