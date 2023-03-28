
package model.bo;

import java.util.Date;



public class Compra {
    private int id;
    private Date dtCompra;
    private Date hrCompra;
    private String numNF;
    private String tipoNF;
    private float vlrDesc;
    private float vlrAcresc;
    private float totalNF;
    private char status;
   
    private CondicaoPgto condicaoPgto;
    private Pagar pagar;
    private ItensCompra itensCompra;
    private Fornecedor fornecedor;

    public Compra() {
    }

    public Compra(int id, Date dtCompra, Date hrCompra, String numNF, String tipoNF, float vlrDesc, float vlrAcresc, float totalNF, char status, CondicaoPgto condicaoPgto, Pagar pagar, ItensCompra itensCompra, Fornecedor fornecedor) {
        this.id = id;
        this.dtCompra = dtCompra;
        this.hrCompra = hrCompra;
        this.numNF = numNF;
        this.tipoNF = tipoNF;
        this.vlrDesc = vlrDesc;
        this.vlrAcresc = vlrAcresc;
        this.totalNF = totalNF;
        this.status = status;
        this.condicaoPgto = condicaoPgto;
        this.pagar = pagar;
        this.itensCompra = itensCompra;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtCompra() {
        return dtCompra;
    }

    public void setDtCompra(Date dtCompra) {
        this.dtCompra = dtCompra;
    }

    public Date getHrCompra() {
        return hrCompra;
    }

    public void setHrCompra(Date hrCompra) {
        this.hrCompra = hrCompra;
    }

    public String getNumNF() {
        return numNF;
    }

    public void setNumNF(String numNF) {
        this.numNF = numNF;
    }

    public String getTipoNF() {
        return tipoNF;
    }

    public void setTipoNF(String tipoNF) {
        this.tipoNF = tipoNF;
    }

    public float getVlrDesc() {
        return vlrDesc;
    }

    public void setVlrDesc(float vlrDesc) {
        this.vlrDesc = vlrDesc;
    }

    public float getVlrAcresc() {
        return vlrAcresc;
    }

    public void setVlrAcresc(float vlrAcresc) {
        this.vlrAcresc = vlrAcresc;
    }

    public float getTotalNF() {
        return totalNF;
    }

    public void setTotalNF(float totalNF) {
        this.totalNF = totalNF;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public CondicaoPgto getCondicaoPgto() {
        return condicaoPgto;
    }

    public void setCondicaoPgto(CondicaoPgto condicaoPgto) {
        this.condicaoPgto = condicaoPgto;
    }

    public Pagar getPagar() {
        return pagar;
    }

    public void setPagar(Pagar pagar) {
        this.pagar = pagar;
    }

    public ItensCompra getItensCompra() {
        return itensCompra;
    }

    public void setItensCompra(ItensCompra itensCompra) {
        this.itensCompra = itensCompra;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getDtCompra() + ";" + this.getHrCompra() + ";" + this.getNumNF() + ";" + this.getTipoNF() + ";" + this.getVlrDesc() + ";" + this.getVlrAcresc() + ";" + this.getTotalNF() + ";" + this.getStatus() + ";" + fornecedor.toString() + ";" + condicaoPgto.toString() + ";" + pagar.toString() + ";" + itensCompra.toString();
    }
    
    
}
