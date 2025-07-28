import java.io.*;
import java.nio.file.*;

public class Estoque {

    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
    }

    private int proximoId = 1;

    public void adicionarProduto(String nome, int quantidade, double preco) {
        try {
            FileWriter fileWriter = new FileWriter(arquivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("ID: " + proximoId + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: " + preco);
            bufferedWriter.newLine();
            bufferedWriter.close();

            proximoId++;

        } catch (IOException e) {
            System.out.println("Erro ao salvar o produto: " + e.getMessage());
        }
    }

    public void excluirProduto(int idExcluir) {

    }

    public void exibirEstoque() {
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }

    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        String nome;
        double preco;
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("temp.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");

                String idLimpo = valor[0].replace("ID:", "").trim();
                if (Integer.parseInt(idLimpo) == idAtualizar) {
                    nome = valor[1];
                    String precoLimpo = valor[3].replace("Preço:", "").trim();
                    preco = Double.parseDouble(precoLimpo);
                    bufferedWriter.write("ID: " + idAtualizar + ", Nome: " + nome + ", Quantidade: " + novaQuantidade + ", Preço: " + preco);
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();
                }

            }
            bufferedWriter.close();
            bufferedReader.close();

            Path arquivoOriginal = Paths.get(arquivo);
            File novoArquivo = new File("temp.csv");

            Files.delete(arquivoOriginal);
            novoArquivo.renameTo(new File(arquivo));


        } catch (IOException e) {

            System.out.println("Erro ao ler o arquivo" + e.getMessage());
        }

    }
}