package ufpb.dcx.br.amigosecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite a quantidade de amigos que irão participar: ");
        int quantAmigos = Integer.parseInt(leitor.nextLine());
        for (int i = 0; i < quantAmigos; i++) {
            System.out.println("Digite o nome do " + (i + 1) + "º participante.");
            String nome = leitor.nextLine();
            System.out.println("Digite o email do " + (i + 1) + "º participante.");
            String email = leitor.nextLine();
            try {
                sistema.cadastraAmigo(nome, email);
            } catch (AmigoJaExisteException e) {
                System.out.println(e.getMessage());
            }
        }

        for (int i = 0; i < quantAmigos; i++) {
            System.out.println("Cadastrar os Amigos Secretos");
            System.out.println("Digite o email da pessoa:");
            String emailPessoa = leitor.nextLine();
            System.out.println("Digite o email do amigo sorteado:");
            String emailSorteado = leitor.nextLine();
            try {
                sistema.configuraAmigoSecretoDe(emailPessoa, emailSorteado);
            } catch (AmigoInexistenteException e) {
                System.out.println(e.getMessage());
            }
        }
        for (int i = 0; i < quantAmigos/2; i++) {
            System.out.println("Enviar mensagem para todos os participantes.");
            System.out.println("Digite a mensagem que deseja enviar: ");
            String texto = leitor.nextLine();
            System.out.println("Email do Remetente: ");
            String remetente = leitor.nextLine();
            System.out.println("É anônima? [S/N]");
            String anonima = leitor.nextLine();
            boolean ehAnonima = false;
            if (anonima.equalsIgnoreCase("s")){
                 ehAnonima = true;
            }
            sistema.enviarMensagemParaTodos(texto, remetente, ehAnonima);
        }
        leitor.close();
    }
}

