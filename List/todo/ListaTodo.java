import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaTodo {
    private List<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) throws IllegalArgumentException {
        if (this.tarefas.stream().anyMatch(t -> t.getIdentificador() == tarefa.getIdentificador()))
            throw new IllegalArgumentException(String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador()));
        this.tarefas.add(tarefa);
    }

    private boolean alterarTarefa(int identificador, boolean valor) {
        Optional<Tarefa> first = this.tarefas.stream()
                .filter(tarefa -> tarefa.getIdentificador() == identificador)
                .findFirst();
        if (first.isPresent()) {
            first.get().setEstahFeita(valor);
            return true;
        } else
            return false;    }

    public boolean marcarTarefaFeita(int identificador) {
        return this.alterarTarefa(identificador, true);
    }

    public boolean desfazerTarefa(int identificador) {
        return this.alterarTarefa(identificador, false);
    }

    private void alterarTodas(boolean valor) {
        this.tarefas.forEach(tarefa -> tarefa.setEstahFeita(valor));
    }

    public void desfazerTodas() {
        this.alterarTodas(false);
    }

    public void fazerTodas() {
        this.alterarTodas(true);
    }

    public void listarTarefas() {
        this.tarefas.forEach(System.out::println);
    }
}