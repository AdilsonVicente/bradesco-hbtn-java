import java.util.List;

public class ManipularArrayNumeros {
    public static int buscarPosicaoNumero(List<Integer> lista, Integer numero) {
        return lista.indexOf(numero);
    }

    public static void adicionarNumero(List<Integer> lista, Integer numero) {
        if (buscarPosicaoNumero(lista,numero) == -1)
            lista.add(numero);
        else
            System.out.println("Numero jah contido na lista");
    }

    public static void removerNumero(List<Integer> lista, Integer numero) {
        if (buscarPosicaoNumero(lista,numero) == -1)
            System.out.println("Numero nao encontrado na lista");
        else
            lista.remove(numero);
    }

    public static void substituirNumero(List<Integer> lista, Integer numeroSubstituir, Integer numeroSubstituto) {
        int posicaoNumero = buscarPosicaoNumero(lista, numeroSubstituir);
        if (posicaoNumero == -1)
            lista.add(numeroSubstituto);
        else
            lista.set(posicaoNumero, numeroSubstituto);
    }
}