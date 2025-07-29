import java.util.Objects;

public class Post implements Comparable<Post> {
    private String titulo, corpo;
    private Autor autor;
    private Categorias categoria;
    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post o) {
        return this.titulo.compareTo(o.titulo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Post other = (Post) obj;
        return this.autor.equals(other.autor) && this.titulo.equals(other.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, titulo);
    }
}