package br.com.helpdesk.domain.dtos;


// Essa classe é responsável em fazer a conversão do usuário e senha que vai vir na requisição de login.

public class CredentialDTO  {


    public String email;

    public String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

