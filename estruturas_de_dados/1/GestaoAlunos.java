import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestaoAlunos {
    private List<Aluno> lista = new ArrayList<>();

    public void adicionarAluno(String nome, int idade) {
        Aluno aluno = new Aluno(nome, idade);
        lista.add(aluno);
        System.out.println("Adicionando aluno: " + aluno.toString());
    }

    public void excluirAluno(String nome) {
        boolean b = lista.removeIf(aluno -> {
            if (aluno.getNome().equals(nome)) {
                System.out.println("Removendo aluno: " + aluno.toString());
                return true;
            } else {
                return false;
            }
        });
        if (!b)
            System.out.println("aluno não existe "+nome);
    }

    public void buscarAluno(String nome) {
        Aluno aluno1 = lista.stream()
                .filter(aluno -> {
                    if (aluno.getNome().equals(nome)) {
                        System.out.println("aluno encontrado " + aluno.toString());
                        return true;
                    } else
                        return false;
                })
                .findAny()
                .orElse(null);
        if (Objects.isNull(aluno1)) {
            System.out.println("aluno não existe "+nome);
        }
    }

    public void listarAlunos() {
        lista.forEach(System.out::println);
    }
}