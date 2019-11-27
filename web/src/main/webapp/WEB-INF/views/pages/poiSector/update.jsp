<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="addPoiSector" modelAttribute="poiSector" method="post">
    <form:hidden path="id" value='${poiSector.id}'/>

    <div class="form-group"> <!-- Street 1 -->
        <label  class="control-label pt-2">Descripcion</label>
        <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Guardar</button>
    </div>

</form:form>