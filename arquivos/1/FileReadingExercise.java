import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura

        try ( BufferedReader buffRead = new BufferedReader(new FileReader(fileName));) {
            String linha = "";
            while ((linha = buffRead.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }

    }

}