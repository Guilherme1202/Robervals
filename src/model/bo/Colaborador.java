
package model.bo;

import java.util.Date;

public class Colaborador extends Pessoa {
    private String login;
    private String senha;

    public Colaborador() {
    }


    public Colaborador(String login, String senha, int id, String nome, String fone1, String fone2, String email, Date dtCadastro, String observacao, String status, String complementoEndereco) {
        super(id, nome, fone1, fone2, email, dtCadastro, observacao, status, complementoEndereco);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.getLogin() + ";" +this.getSenha() + ";" + super.toString();
    }
    
    
   
}
