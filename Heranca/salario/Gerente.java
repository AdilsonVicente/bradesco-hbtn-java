public class Gerente extends Empregado {
    public Gerente(double salarioFixo) {
        super(salarioFixo);
    }

    @Override
    public double calcularBonus(Departamento departamento) {
        if (departamento.alcancouMeta()) {
            return (super.getSalarioFixo() * 0.20 + ((departamento.getValorAtingidoMeta() - departamento.getValorMeta()) * 0.01));
        }

        return (0.0);
    }
}
