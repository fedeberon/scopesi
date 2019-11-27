<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form:form action="addPoiEntidad" modelAttribute="poiEntidad" method="post">
    <form:hidden path="id" value='${poiEntidad.id}'/>

    <div class="form-group"> <!-- Street 1 -->
        <select class="form-control" id="street1_id" name="mapPoiSector.id">

        <c:forEach items="${poiSectores}" var="bo" varStatus="status">
            <option value="${bo.id}">${bo.descripcion}</option>
        </c:forEach>
        </select>

        <label class="control-label pt-2">Descripcion</label>
        <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Guardar</button>
    </div>

</form:form>