package ufpb.dcx.br.amigosecreto;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente,
                              String emailDestinatario, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;

    }
    public String getEmailDestinatario(){
        return this.emailDestinatario;
    }
    public void setEmailDestinatario(String novoEmDestinatario){
        this.emailDestinatario = novoEmDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (ehAnonima()) {
            return "Mensagem para: " + this.emailDestinatario + ". Texto: " + getTexto();
        } else {
            return "Mensagem de: " + getEmailRemetente() + " para: " + emailDestinatario + ". Texto: " + getTexto();
        }

    }
}
