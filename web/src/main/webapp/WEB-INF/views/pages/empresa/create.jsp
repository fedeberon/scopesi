<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<form:form action="addEmpresa" modelAttribute="empresa" method="post">


    <div class="form-group"> <!-- Street 1 -->
        <label for="street1_id" class="control-label">DESCRIPCION</label>
        <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Nueva Empresa</button>
    </div>

</form:form>