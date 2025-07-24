import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CsvFileReader {
    public static void main(String[] args) {
        String fileName = "funcionarios.csv"; // Nome do arquivo fixo para leitura

        try ( BufferedReader buffRead = new BufferedReader(new FileReader(fileName));) {
            String linha = "";
            while ((linha = buffRead.readLine()) != null) {
                String[] valor = linha.split(",");

                System.out.println("Funcionário: " + valor[0].trim());
                System.out.println("Idade: " + valor[1].trim());
                System.out.println("Departamento: " + valor[2].trim());
                System.out.println("Salarial: " + valor[3].trim());
                System.out.println("------------------------");

            }
            System.out.println("Leitura do arquivo concluída.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }

    }

}