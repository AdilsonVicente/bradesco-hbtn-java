import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> pessoas) {
        Map<String, List<Pessoa>> agrupados = pessoas.stream().collect(Collectors.groupingBy(Pessoa::getCargo));
        return agrupados;
    }
}