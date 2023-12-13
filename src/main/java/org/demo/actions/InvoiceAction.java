package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.demo.actions.beans.InvoiceBean;

public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }
    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {
            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }

        if (invoiceBean.getDateFrom() == null) {
            addFieldError("invoiceBean.dateFrom", "La fecha de inicio es obligatoria.");
        }

        if (invoiceBean.getDateTo() == null) {
            addFieldError("invoiceBean.dateTo", "La fecha de fin es obligatoria.");
        }

        if (invoiceBean.getAmount() <= 0) {
            addFieldError("invoiceBean.amount", "El monto debe ser mayor que cero.");
        }
    }
}
