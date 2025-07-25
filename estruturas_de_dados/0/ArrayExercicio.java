import java.util.Scanner;
import java.util.Arrays;


public class ArrayExercicio {


    public static void main(String[] args) {
        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);


        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;


        // Preenchendo o array com números fornecidos pelo usuário
        // Utilize scanner.nextInt(); para receber o numero digitado
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite o número %d: ", i+1);
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
        }
        maiorNumero = Arrays.stream(numeros).max().orElse(maiorNumero);

        // Exibindo os resultados
        System.out.println("\n");
        System.out.println("Conteúdo do array:");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tamanhoArray; i++) {
            stringBuilder.append(numeros[i]);
            if ((i+1) < tamanhoArray)
                stringBuilder.append(" ");
        }
        System.out.println(stringBuilder.toString());
        System.out.printf("Soma de todos os números: %d\n", soma);
        System.out.printf("Maior número no array: %d\n", maiorNumero);
        // Fechando o scanner
        scanner.close();
    }
}