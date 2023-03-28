
package model.bo;


public class ItensCompra {
    private int id;
    private float qtdProduto;
    private float vlrUnitProd;
    private char status;
    
    private Produto produto; 
    
    private HistoricoMovimentacao historicoMovimentacao;
    
    public ItensCompra() {
    }

    public ItensCompra(int id, float qtdProduto, float vlrUnitProd, char status, Produto produto, HistoricoMovimentacao historicoMovimentacao) {
        this.id = id;
        this.qtdProduto = qtdProduto;
        this.vlrUnitProd = vlrUnitProd;
        this.status = status;
        this.produto = produto;
        this.historicoMovimentacao = historicoMovimentacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(float qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public float getVlrUnitProd() {
        return vlrUnitProd;
    }

    public void setVlrUnitProd(float vlrUnitProd) {
        this.vlrUnitProd = vlrUnitProd;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public HistoricoMovimentacao getHistoricoMovimentacao() {
        return historicoMovimentacao;
    }

    public void setHistoricoMovimentacao(HistoricoMovimentacao historicoMovimentacao) {
        this.historicoMovimentacao = historicoMovimentacao;
    }

   

    @Override
    public String toString() {
        return this.getId() + ";" + this.getQtdProduto() + ";" + this.getVlrUnitProd() + ";" + this.getStatus() + ";" + historicoMovimentacao.toString() + ";" + produto.toString();
    }
    
    
}
