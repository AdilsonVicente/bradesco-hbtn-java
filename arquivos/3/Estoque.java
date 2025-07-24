import java.io.*;
import java.nio.file.*;

public class Estoque {

    private String nomeArquivo;

    public Estoque(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {

        try {
            FileWriter fileWriter = new FileWriter(this.nomeArquivo);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(1 + "," + nome + "," + quantidade + "," + preco);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void excluirProduto(int idExcluir) {

    }

    public void exibirEstoque() {
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public void atualizarQuantidade(int idAtualizar, int novaQuantidade) {
        String nome;
        double preco;
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("estoque.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] valor = linha.split(",");

                if (Integer.parseInt(valor[0].trim()) == idAtualizar) {
                    nome = valor[1];
                    preco = Double.parseDouble(valor[3]);
                    bufferedWriter.write(idAtualizar + "," + nome + ", " + novaQuantidade + "," + preco);
                    bufferedWriter.newLine();
                } else {
                    bufferedWriter.write(linha);
                    bufferedWriter.newLine();
                }

            }
            bufferedWriter.close();
            bufferedReader.close();

            Path nomeArquivoOriginal = Paths.get(nomeArquivo);
            File novoArquivo = new File("estoque.csv");

            Files.delete(nomeArquivoOriginal);
            novoArquivo.renameTo(new File(nomeArquivo));


        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}