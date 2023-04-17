package br.com.helpdesk.domain.dtos;


// Essa classe é responsável em fazer a conversão do usuário e senha que vai vir na requisição de login.

import java.io.Serializable;

public class CredentialDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public String email;
    public String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
