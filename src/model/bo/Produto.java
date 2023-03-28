
package model.bo;

import java.util.Date;

public class Produto {
    private int id;
    private String descricao;
    private float vlrCompra;
    private float vlrVenda;
    private String undCompra;
    private String undVenda;
    private int fatorConversao;
    private char status;
    private Date dtCadastro;
    private String barraEntrada;
    private String barraSaida;
    private float estoqueMin;
    private float estoqueMax;
    
    private Classe classe;
    private Marca marca;
    
    public Produto() {
    }

    public Produto(int id, String descricao, float vlrCompra, float vlrVenda, String undCompra, String undVenda, int fatorConversao, char status, Date dtCadastro, String barraEntrada, String barraSaida, float estoqueMin, float estoqueMax, Classe classe, Marca marca) {
        this.id = id;
        this.descricao = descricao;
        this.vlrCompra = vlrCompra;
        this.vlrVenda = vlrVenda;
        this.undCompra = undCompra;
        this.undVenda = undVenda;
        this.fatorConversao = fatorConversao;
        this.status = status;
        this.dtCadastro = dtCadastro;
        this.barraEntrada = barraEntrada;
        this.barraSaida = barraSaida;
        this.estoqueMin = estoqueMin;
        this.estoqueMax = estoqueMax;
        this.classe = classe;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getVlrCompra() {
        return vlrCompra;
    }

    public void setVlrCompra(float vlrCompra) {
        this.vlrCompra = vlrCompra;
    }

    public float getVlrVenda() {
        return vlrVenda;
    }

    public void setVlrVenda(float vlrVenda) {
        this.vlrVenda = vlrVenda;
    }

    public String getUndCompra() {
        return undCompra;
    }

    public void setUndCompra(String undCompra) {
        this.undCompra = undCompra;
    }

    public String getUndVenda() {
        return undVenda;
    }

    public void setUndVenda(String undVenda) {
        this.undVenda = undVenda;
    }

    public int getFatorConversao() {
        return fatorConversao;
    }

    public void setFatorConversao(int fatorConversao) {
        this.fatorConversao = fatorConversao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getBarraEntrada() {
        return barraEntrada;
    }

    public void setBarraEntrada(String barraEntrada) {
        this.barraEntrada = barraEntrada;
    }

    public String getBarraSaida() {
        return barraSaida;
    }

    public void setBarraSaida(String barraSaida) {
        this.barraSaida = barraSaida;
    }

    public float getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(float estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public float getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(float estoqueMax) {
        this.estoqueMax = estoqueMax;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    
    
    
    @Override
    public String toString() {
        return this.getId() + ";" + this.getDescricao() + ";" + this.getVlrCompra() + ";" + this.getVlrVenda() + ";" + this.getUndCompra() + ";" + this.getUndVenda() + ";" + this.getFatorConversao() + ";" + this.getStatus() + ";" + this.getDtCadastro() + ";" + this.getBarraEntrada() + ";" + this.getBarraSaida() + ";" + this.getEstoqueMin() + ";" + this.getEstoqueMax() + ";" + classe.toString() + ";" + marca.toString();
    }
    
    
    
    
}

