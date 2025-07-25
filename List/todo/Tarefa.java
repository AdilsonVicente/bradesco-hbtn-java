import java.util.Objects;

public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        modificarDescricao(descricao);
        this.identificador = identificador;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }

    public void setEstahFeita(boolean estahFeita) {
        this.estahFeita = estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        String format = String.format("  Id: %d - Descricao: %s", this.identificador, this.descricao);
        return this.estahFeita ? "[X]" + format : "[ ]" + format;
    }

    public void modificarDescricao(String novaDescricao) {
        if (Objects.isNull(novaDescricao) || novaDescricao.isEmpty())
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        this.descricao = novaDescricao;
    }

}