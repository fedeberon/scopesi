<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="addLocalidad" modelAttribute="localidad" method="post">

    <div class="form-group"> <!-- Street 1 -->
        <label  class="control-label">DESCRIPCION</label>
        <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label class="control-label">PROVINCIA</label>
        <form:input path="audProvincia.id" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Nueva Localidad</button>
    </div>

</form:form>