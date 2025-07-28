import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPostagem(Post post) {
        if (postagens.stream().anyMatch(p -> p.equals(post))) {
            throw new IllegalArgumentException("Postagem já existente");
        }
        postagens.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        return this.postagens.stream()
                .map(Post::getAutor)
                .sorted(Comparator.comparing(Autor::toString))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(Post::getCategoria, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue(),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        return this.postagens.stream()
                .filter(p -> p.getAutor().equals(autor))
                .sorted(Comparator.comparing(Post::toString))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return this.postagens.stream().filter(p -> p.getCategoria().equals(categoria))
                .sorted(Comparator.comparing(Post::toString))
                .collect(Collectors.toSet());
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(
                        Post::getCategoria,
                        Collectors.toCollection(LinkedHashSet::new)
                ));
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(Post::getAutor, Collectors.toSet()));
    }
}