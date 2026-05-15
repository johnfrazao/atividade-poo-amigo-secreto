package ufpb.dcx.br.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo() {
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(emailAmigo)) {
                throw new AmigoJaExisteException("Esse amigo de email: " + emailAmigo + " já está cadastrado.");
            }
        }
        amigos.add(new Amigo(nomeAmigo, emailAmigo));
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a;
            }
        }
        throw new AmigoInexistenteException("Amigo de email: " + email + " não cadastrado.");
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        mensagens.add(new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima));
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        mensagens.add(new MensagemParaTodos(texto, emailRemetente, ehAnonima));
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> msgsAnonimas = new ArrayList<>();
        if (mensagens.isEmpty()) {
            return null;
        }
        for (Mensagem msg : mensagens) {
            if (msg.ehAnonima()) {
                msgsAnonimas.add(msg);
            }
        }
        return msgsAnonimas;

    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        pessoa.setEmailAmigoSecreto(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException,
            AmigoNaoSorteadoException {
        for (Amigo a : amigos) {
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                if (a.getEmailAmigoSecreto().isEmpty()) {
                    throw new AmigoNaoSorteadoException("Nenhum amigo secreto sorteado para o email: " + emailDaPessoa);
                } else {
                    return a.getEmailAmigoSecreto();
                }
            }}
        throw new AmigoInexistenteException("Nenhum amigo com email: " + emailDaPessoa + " encontrado.");

    }


}
