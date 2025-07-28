import java.io.*;
import java.nio.file.*;

public class Estoque {

    private String arquivo;

    public Estoque(String arquivo) {
        this.arquivo = arquivo;
    }

    private int proximoId = 1;

    public void adicionarProduto(String nome, int quantidade, double preco) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write("ID: " + proximoId + ", Nome: " + nome + ", Quantidade: " + quantidade + ", Preço: " + preco);
            writer.newLine();
            proximoId++;
        } catch (IOException e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());
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
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(arquivo));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp.csv"))
        ) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                linha = linha.trim();

                // Ignora linhas vazias ou mal formatadas
                if (linha.isEmpty() || !linha.startsWith("ID:")) {
                    continue;
                }

                String[] valor = linha.split(",");

                if (valor.length < 4) {
                    System.out.println("Linha ignorada (formato inválido): " + linha);
                    continue;
                }

                String idStr = valor[0].replace("ID:", "").trim();
                if (idStr.isEmpty()) {
                    System.out.println("ID vazio na linha: " + linha);
                    continue;
                }

                int id = Integer.parseInt(idStr);

                if (id == idAtualizar) {
                    String nome = valor[1].replace("Nome:", "").trim();
                    double preco = Double.parseDouble(valor[3].replace("Preço:", "").trim());

                    bufferedWriter.write("ID: " + id + ", Nome: " + nome + ", Quantidade: " + novaQuantidade + ", Preço: " + preco);
                } else {
                    bufferedWriter.write(linha);
                }
                bufferedWriter.newLine();
            }

            Path caminhoOriginal = Paths.get(arquivo);
            File arquivoTemp = new File("temp.csv");

            Files.delete(caminhoOriginal);
            arquivoTemp.renameTo(new File(arquivo));

        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }
    }
}