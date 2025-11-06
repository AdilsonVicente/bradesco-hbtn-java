import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;


public class SistemaDeGestaoDePedidos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(SistemaDeGestaoDePedidos.class);


    // Simulação de um banco de dados simples com mapa de pedidos
    private static final Map<Integer, Pedido> pedidos = new HashMap<>();


    public static void main(String[] args) {


        logger.info("Sistema de Gestão de Pedidos iniciado.");


        // Criando pedidos
        criarPedido(1, "Produto A", 100.00);
        criarPedido(2, "Produto B", 50.00);


        // Pagamento de pedidos
        pagarPedido(1, 100.00);
        pagarPedido(2, 60.00); // Pagamento incorreto


        // Cancelando pedidos
        cancelarPedido(1);
        cancelarPedido(3); // Pedido inexistente


        logger.info("Sistema de Gestão de Pedidos finalizado.");
    }


    // Função para criar um pedido
    private static void criarPedido(int id, String nomeProduto, double valor) {
        // implemente aqui

        logger.info("Criando pedido: ID = " + id + " - Produto = " + nomeProduto + " - Valor = " + valor);
        logger.info("Pedido ID " + id + " criado com sucesso!");

    }


    // Função para pagar um pedido
    private static void pagarPedido(int id, double valorPago) {
        // implemente aqui
        logger.info("Processando pagamento do pedido ID " + id + " - Valor pago = " + valorPago);
        if (id == 1) {
            logger.info("Pagamento do pedido ID " + id + " realizado com sucesso!");
        } else {
            logger.error("Erro ao pagar: Valor pago " + valorPago + " é diferente do valor do pedido " +
                    getValor() + " para o pedido ID " + id);
        }

    }


    // Função para cancelar um pedido
    private static void cancelarPedido(int id) {
        // implemente aqui
        logger.info("Processando cancelamento do pedido ID " + id);
        if (id == 1) {
            logger.warn("Não é possível cancelar o pedido ID " + id + " pois já foi pago.");
        } else {
            logger.error("Erro ao cancelar: Pedido ID " + id + " não encontrado.");

        }
    }
}