
package model.bo;

import java.util.Date;


public class Pagamento {
    private int id;
    private Date dtPgto;
    private Date hrPgto;
    private float vlrDesc;
    private float vlrAcresc;
    private float vlrPago;
    private char Status;

    public Pagamento() {
    }

    public Pagamento(int id, Date dtPgto, Date hrPgto, float vlrDesc, float vlrAcresc, float vlrPago, char Status) {
        this.id = id;
        this.dtPgto = dtPgto;
        this.hrPgto = hrPgto;
        this.vlrDesc = vlrDesc;
        this.vlrAcresc = vlrAcresc;
        this.vlrPago = vlrPago;
        this.Status = Status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDtPgto() {
        return dtPgto;
    }

    public void setDtPgto(Date dtPgto) {
        this.dtPgto = dtPgto;
    }

    public Date getHrPgto() {
        return hrPgto;
    }

    public void setHrPgto(Date hrPgto) {
        this.hrPgto = hrPgto;
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

    public float getVlrPago() {
        return vlrPago;
    }

    public void setVlrPago(float vlrPago) {
        this.vlrPago = vlrPago;
    }

    public char getStatus() {
        return Status;
    }

    public void setStatus(char Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return this.getId() + ";" + this.getDtPgto() + ";" + this.getHrPgto() + ";" +this.getVlrDesc() + ";" + this.getVlrAcresc() + ";" +this.getVlrPago() + ";" +this.getStatus();
    }
    
    
    
}
