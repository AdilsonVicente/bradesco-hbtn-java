import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FileWritingExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            System.out.println("Digite várias linhas de texto. Para finalizar digite 'sair':");
            while (true) {
                String linha = scanner.nextLine();
                if (linha.equals("sair")) {
                    break;
                }
                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo" + e.getMessage());
        }


        scanner.close();
    }
}