import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.LinkedHashSet;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPostagem(Post post) {
        boolean existe = postagens.stream()
                .anyMatch(p -> p.getAutor().equals(post.getAutor()) &&
                        p.getTitulo().equals(post.getTitulo()));

        if (existe) {
            throw new IllegalArgumentException("Postagem jah existente");
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
        return postagens.stream()
                .collect(Collectors.groupingBy(
                        Post::getCategoria,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }
    public Set<Post> obterPostsPorAutor(Autor autor) {
        return postagens.stream()
                .filter(p -> p.getAutor().equals(autor))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        return postagens.stream()
                .filter(p -> p.getCategoria().equals(categoria))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        return postagens.stream()
                .collect(Collectors.groupingBy(
                        Post::getCategoria,
                        LinkedHashMap::new,
                        Collectors.toCollection(TreeSet::new)
                ));
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        return postagens.stream()
                .sorted(Comparator.comparing(p -> p.getAutor().toString()))
                .collect(Collectors.groupingBy(
                        Post::getAutor,
                        LinkedHashMap::new,
                        Collectors.toCollection(TreeSet::new)
                ));
    }
}