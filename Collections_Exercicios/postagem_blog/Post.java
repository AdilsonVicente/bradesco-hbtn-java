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
}