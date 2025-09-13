import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> pessoas) {

        TreeMap<String, TreeSet<Pessoa>> ordemReversa = pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.toCollection(TreeSet::new)));

        return ordemReversa;

    }

    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {

        Map<String, Long> contagem = pessoas.stream()
                .collect(Collectors.groupingBy(
                        Pessoa::getCargo, Collectors.counting()));

        return contagem;

    }
}