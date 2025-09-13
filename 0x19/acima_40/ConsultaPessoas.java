import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {

        Map<String, List<Pessoa>> agrupados = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getCargo));
        return agrupados;
    }

    public static Map<String, List<Integer>> obterIdadePorCargo(List<Pessoa> pessoas) {
        Map<String, List<Integer>> agrupados = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getCargo, Collectors.mapping(Pessoa::getIdade, Collectors.toList())));
        return agrupados;
    }

    public static Map<String, List<Pessoa>> obterPessoasPorCargoAcimaDe40anos(List<Pessoa> pessoas) {
        Map<String, List<Pessoa>> agrupados = pessoas.stream()
                .collect(Collectors.groupingBy(Pessoa::getCargo,
                        Collectors.filtering(
                                pessoa -> pessoa.getIdade() > 40,
                                Collectors.toList()
                        )));
        return agrupados;
    }

}