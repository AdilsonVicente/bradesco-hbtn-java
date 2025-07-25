import java.util.*;
import java.util.stream.Collectors;

public class Blog {
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPostagem(Post post) {
        postagens.add(post);
    }

    public Set<String> obterTodosAutores() {
        List<String> list = this.postagens.stream().map(Post::getAutor).sorted(Comparator.comparing(s -> s.compareTo(s))).collect(Collectors.toList());
        return new HashSet<>(list);
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