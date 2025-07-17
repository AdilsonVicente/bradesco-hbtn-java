public class PersonagemGame {
    private String nome;
    private int saudeAtual;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void tomarDano(int quantidadeDeDano) {
        int saudeAtual = this.saudeAtual - quantidadeDeDano;
        this.setSaudeAtual(saudeAtual< 0 ? 0 : saudeAtual);
    }

    public void receberCura(int quantidadeDeCura) {
        int saudeAtual =  this.saudeAtual + quantidadeDeCura;
        this.setSaudeAtual(saudeAtual > 100 ? 100 : saudeAtual);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        String status = saudeAtual <= 0 ? "morto" : "vivo";
        this.saudeAtual = saudeAtual;
        this.status = status;
    }
}
