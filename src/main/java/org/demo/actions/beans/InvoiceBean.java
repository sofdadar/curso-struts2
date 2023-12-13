package org.demo.actions.beans;

import java.util.Date;
import java.text.DecimalFormat;


public class InvoiceBean {

    private String subject;
    private boolean tipoIva;
    private Date dateFrom;
    private Date dateTo;
    private double amount;
    private double ivaAmount;
    private String tipoDeIva;
    private double amountConIva;

    public InvoiceBean() {
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public boolean isTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(boolean tipoIva) {
        this.tipoIva = tipoIva;

        if (tipoIva) {
            this.amountConIva = this.amount;
            this.ivaAmount = this.amount - (this.amount /(1+0.21));
            this.tipoDeIva = "Con IVA";
        } else {
            this.tipoDeIva = "Sin IVA";
            this.ivaAmount = this.amount * 0.21;
            this.amountConIva = this.amount * 1.21;
        }

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTipoDeIva() {
        return tipoDeIva;
    }

    public double getAmountConIva() {
        return amountConIva;
    }

    public double getIvaAmount() {
        return ivaAmount;
    }

    public String getFormattedIvaAmount() {
        DecimalFormat formato = new DecimalFormat("#.##");
        return formato.format(ivaAmount);
    }
}
