<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



    <form:form action="addMedio" modelAttribute="medio" method="post">
        <form:hidden path="id" value='${medio.id}'/>

        <div class="form-group"> <!-- Street 1 -->
            <label for="street1_id" class="control-label">Descripcion</label>
            <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo medio"/>

        </div>

        <div class="form-group"> <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Nuevo Formato</button>
        </div>

    </form:form>
