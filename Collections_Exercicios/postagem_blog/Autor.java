public class Autor implements Comparable<Autor> {
    private String nome, sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Autor o) {
        return (this.nome+this.sobrenome).compareTo(o.nome+o.sobrenome);
    }
}