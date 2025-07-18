package provedores;

import provedores.ProvedorFrete;

public class Sedex implements ProvedorFrete {
    @Override
    public Frete calcularFrete(double peso, double valor) {
        double valorFrete = (peso > 1000.0 ? valor * 0.1 : valor * 0.05);
        return new Frete(valorFrete, obterTipoProvedorFrete());
    }

    @Override
    public TipoProvedorFrete obterTipoProvedorFrete() {
        return TipoProvedorFrete.SEDEX;
    }
}