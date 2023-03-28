
package model.bo;

import java.util.Date;

public class CupomFiscal {
    private int id;
    private Date dtVenda;
    private Date hrVenda;
    private float vlrDesc;
    private float vlrAcresc;
    private float totalCupom;
    private char status;
    
    private Cliente cliente;
    private Colaborador colaborador;
    

    public CupomFiscal() {
    }

    public CupomFiscal(int id, Date dtVenda, Date hrVenda, float vlrDesc, float vlrAcresc, float totalCupom, char status, Cliente cliente, Colaborador colaborador) {
        this.id = id;
        this.dtVenda = dtVenda;
        this.hrVenda = hrVenda;
        this.vlrDesc = vlrDesc;
        this.vlrAcresc = vlrAcresc;
        this.totalCupom = totalCupom;
        this.status = status;
        this.cliente = cliente;
        this.colaborador = colaborador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public Date getHrVenda() {
        return hrVenda;
    }

    public void setHrVenda(Date hrVenda) {
        this.hrVenda = hrVenda;
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

    public float getTotalCupom() {
        return totalCupom;
    }

    public void setTotalCupom(float totalCupom) {
        this.totalCupom = totalCupom;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getDtVenda() + ";" + this.getHrVenda() + ";" + this.getVlrDesc() + ";" + this.getVlrAcresc() + ";" + this.getTotalCupom() + ";" + this.getStatus() + ";" + colaborador.toString() + ";" + cliente.toString();
    }
    
}
