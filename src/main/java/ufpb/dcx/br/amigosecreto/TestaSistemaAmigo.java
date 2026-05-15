package ufpb.dcx.br.amigosecreto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        try {
            sistema.cadastraAmigo("José", "jose@gmail.com");
            sistema.cadastraAmigo("Maria", "maria@gmail.com");
            sistema.configuraAmigoSecretoDe("jose@gmail.com","maria@gmail.com");
            sistema.configuraAmigoSecretoDe("maria@gmail.com","jose@gmail.com");
            sistema.enviarMensagemParaAlguem("Oi, tudo bem?","maria@gmail.com","jose@gmail.com", true );
            sistema.enviarMensagemParaTodos("Vocês já fizeram a atividade?","maria@gmail.com", true );
            List<Mensagem> msgAnonimas = sistema.pesquisaMensagensAnonimas();
            for(Mensagem msg: msgAnonimas){
                System.out.println(msg.getTextoCompletoAExibir());
            }
            if ((sistema.pesquisaAmigoSecretoDe("jose@gmail.com").equalsIgnoreCase("maria@gmail.com"))){
                System.out.println("ok");
            }
        } catch (AmigoJaExisteException | AmigoInexistenteException | AmigoNaoSorteadoException e) {
            System.out.println(e.getMessage());;
        }
    }
}
