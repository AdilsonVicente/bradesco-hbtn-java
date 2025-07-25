import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPostagem(Post post) {
        if (postagens.stream().anyMatch(p -> p.getAutor().compareTo(post.getAutor()) == 0 && p.toString().compareTo(post.toString()) == 0))
            throw new IllegalArgumentException("Postagem jah existente");
        postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        List<Autor> list = this.postagens.stream().map(Post::getAutor).sorted(Comparator.comparing(Autor::toString)).collect(Collectors.toList());
        return new HashSet<>(list);
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(Post::getCategoria, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue()
                ));
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return this.postagens.stream().filter(p -> p.getAutor().equals(autor))
                .sorted(Comparator.comparing(Post::toString))
                .collect(Collectors.toSet());
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return this.postagens.stream().filter(p -> p.getCategoria().equals(categoria))
                .sorted(Comparator.comparing(Post::toString))
                .collect(Collectors.toSet());
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(Post::getCategoria, Collectors.toSet()));
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(Post::getAutor, Collectors.toSet()));
    }
}