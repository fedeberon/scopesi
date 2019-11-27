<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="addFormato" modelAttribute="formato" method="post">
    <form:hidden path="id" value='${formato.id}'/>

    <div class="form-group"> <!-- Street 1 -->
        <label for="street1_id" class="control-label pt-2">Descripcion</label>
        <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
        <label for="street1_id" class="control-label pt-2">Evalua</label>
        <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Guardar</button>
    </div>

</form:form>