package Classes_Objetos.personagem;

public class PersonagemGame {
    private int saldoAtual = 100;
    private String nome;

    public void tomarDano(int quantidadeDeDano) {
        saldoAtual -= quantidadeDeDano;
        if(saldoAtual < 0) {
            saldoAtual = 0;
        }
    }

    public void receberCura(int quantidadeDeCura) {
        saldoAtual += quantidadeDeCura;
        if(saldoAtual > 100) {
            saldoAtual = 100;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(int saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
}
