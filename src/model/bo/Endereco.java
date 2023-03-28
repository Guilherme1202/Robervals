
package model.bo;

public class Endereco {
        private int id;
        private String logradouro;
        private String cep;
        
        private Bairro bairro;
        private Cidade cidade;

    public Endereco() {
    }

    public Endereco(int id, String logradouro, String cep, Bairro bairro, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
        

    @Override
    public String toString() {
        return this.getId() + ";" + this.getLogradouro() + ";" + this.getCep() + ";" + this.getBairro().toString() + ";" + this.getCidade().toString();
    }
        
       
    
    
}
