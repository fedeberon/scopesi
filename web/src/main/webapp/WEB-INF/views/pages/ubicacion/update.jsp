<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="addEmpresa" modelAttribute="empresa" method="post">
    <form:hidden path="id" value='${empresa.id}'/>

    <div class="form-group"> <!-- Street 1 -->
        <label for="street1_id" class="control-label">DESCRIPCION</label>
        <form:input value='${empresa.descripcion}' path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Guardar</button>
    </div>

</form:form>