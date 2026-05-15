package ufpb.dcx.br.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Amigo> amigosMap;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap() {
        this.amigosMap = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo)
            throws AmigoJaExisteException {
        if (amigosMap.containsKey(emailAmigo)) {
            throw new AmigoJaExisteException("Esse amigo já existe.");
        }
        amigosMap.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo));
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        Amigo a = amigosMap.get(email);
        if (a == null) {
            throw new AmigoInexistenteException("Amigo não encontrado.");
        }
        return a;
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
        Amigo a = pesquisaAmigo(emailDaPessoa);

        if (a.getEmailAmigoSecreto().isEmpty()) {
            throw new AmigoNaoSorteadoException("Nenhum amigo secreto sorteado para o email: " + emailDaPessoa);
        }
        return a.getEmailAmigoSecreto();
    }
}

