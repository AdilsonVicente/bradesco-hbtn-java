import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPostagem(Post post) {
        postagens.add(post);
    }

    public Set<String> obterTodosAutores() {
        return this.postagens.stream()
                .map(Post::getAutor)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        return this.postagens.stream()
                .collect(Collectors.groupingBy(Post::getCategoria, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue()
                ));
    }
}