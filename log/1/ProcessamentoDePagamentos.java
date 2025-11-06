import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Random;


public class ProcessamentoDePagamentos {


    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);


    public static void main(String[] args) {


        // implemente o codigo necessario para resolucao do problema


        processar(1);
        processar(2);
        processar(3);
        processar(4);
        processar(5);
        logger.info("Processamento de pagamentos concluído.");

    }

    public void processar(int pagamento) {
        Thread.sleep(1000);
        logger.info("Iniciando o processamento do pagamento " + pagamento);
        switch (pagamento) {
            case 1:
                logger.error("Erro ao processar o pagamento " + pagamento);
                break;
            case 2, 3:
                logger.info("Pagamento " + pagamento + "processado com sucesso.");
                break;

            case 4:
                logger.error("Erro ao processar o pagamento " + pagamento + ": Falha na transação.");
                break;
            case 5:
                logger.warn("Pagamento " + pagamento + " está pendente. Aguardando confirmação.");

                break;
            default:
                break;
        }


    }
}
