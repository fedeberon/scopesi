<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form action="addElemento" modelAttribute="elemento" method="post">


    <div class="form-group"> <!-- Street 1 -->
        <label for="street1_id" class="control-label">DESCRIPCION</label>
        <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">PANOS</label>
        <form:input  path="panos" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">ID MEDIO</label>
        <form:input  path="mapMedio.id" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">ID FORMATO</label>
        <form:input  path="mapFormato.id" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">ACUMULA DATOS</label>
        <form:input  path="acumulaDatos" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">EVALUA</label>
        <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">METROS CONTACTO</label>
        <form:input  path="metrosContacto" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label for="street1_id" class="control-label">COEFICIENTE</label>
        <form:input  path="coeficiente" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>

    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Nuevo Formato</button>
    </div>

</form:form>