package ufpb.dcx.br.amigosecreto;

import java.util.Objects;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSecreto;

    public Amigo(String nomeAmigo, String emailAmigo){
        this.nome = nomeAmigo;
        this.email = emailAmigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAmigoSecreto() {
        return emailAmigoSecreto;
    }

    public void setEmailAmigoSecreto(String emailAmigoSecreto) {
        this.emailAmigoSecreto = emailAmigoSecreto;
    }

}
