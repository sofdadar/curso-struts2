<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><s:text name="resumen.titulo"/></title>
    <s:head/>
    <sx:head/>
</head>

<body>

    <h1><s:text name="resumen.titulo"/> </h1>
    <table>
        <tr>
            <td class="title"><s:text name="resumen.concepto"/></td>
            <td colspan="3"><s:text name="invoiceBean.subject"/></td>
        </tr>
        <tr>
            <td class="title"><s:text name="resumen.desde"/></td>
            <td><s:text name="invoiceBean.dateFrom"/></td>
            <td class="title"><s:text name="resumen.hasta"/></td>
            <td><s:text name="invoiceBean.dateTo"/></td>
        </tr>
        <tr>
            <td class="title"><s:text name="resumen.tipoIVA"/></td>
            <td colspan="3"><s:property value="invoiceBean.tipoDeIva"/></td>
        </tr>

        <!-- Mostrar solo si tipoIva es falso -->
        <s:if test="%{!#invoiceBean.tipoIva}">
            <tr>
                <td colspan="3" class="title"><s:text name="resumen.subtotal"/></td>
                <td><s:text name="invoiceBean.amount"/></td>
            </tr>
            <tr>
                <td colspan="3" class="title"><s:text name="resumen.IVA"/></td>
                <td><s:text name="invoiceBean.elIva"/></td>
            </tr>
            <tr>
                <td colspan="3" class="title"><s:text name="resumen.total"/></td>
                <td><s:text name="invoiceBean.amountConIva"/></td>
            </tr>
        </s:if>
        <s:else>
            <tr>
                <td colspan="3" class="title"><s:text name="resumen.subtotal"/></td>
                <td><s:text name="invoiceBean.amount"/></td>
            </tr>
            <tr>
                <td colspan="3" class="title"><s:text name="resumen.IVA"/></td>
                <td><s:text name="invoiceBean.formattedIvaAmount"/></td>
            </tr>
            <tr>
                <td colspan="3" class="title"><s:text name="resumen.total"/></td>
                <td><s:text name="invoiceBean.amountConIva"/></td>
            </tr>
        </s:else>
    </table>

</body>
</html>
<style>
    .title {
        font-weight: 800;
        text-align: left;
    }
    td {
        text-align: end;
    }
    table, td, tr {
        border: 1px solid black;
        width: 500px;
        border-spacing: 0;
        padding: 0.2rem;
    }
</style>
