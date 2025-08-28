public class FolhaPagamento {
    public static double calcularLiquido(Funcionario f, CalculadorDeSalario c) {
        return c.calcular(f.getSalario());
    }
}