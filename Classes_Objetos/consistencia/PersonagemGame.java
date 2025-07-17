public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    PersonagemGame(int saudeAtual, String nome) {
        this.setSaudeAtual(saudeAtual);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) return;
        this.nome = nome;
    }

    public String getStatus() {
        return this.status;
    }


    public void tomarDano(int quantidadeDeDano) {
        int saudeAtual = this.saudeAtual - quantidadeDeDano;
        this.setSaudeAtual(saudeAtual< 0 ? 0 : saudeAtual);
    }

    public void receberCura(int quantidadeDeCura) {
        int saudeAtual =  this.saudeAtual + quantidadeDeCura;
        this.setSaudeAtual(saudeAtual > 100 ? 100 : saudeAtual);

    }
}
