public class Email implements CanalNotificacao {
    @Override
    public void notificar(Mensagem mensagem) {
        System.out.println(String.format("[EMAIL] {%s} - %s", mensagem.getTipoMensagem(), mensagem.getTexto()));
    }
}