<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-6 pt-3">
    <form:form action="addPoi" modelAttribute="poi" method="post">

        <div class="form-group"> <!-- Street 1 -->

            <label  class="control-label">POI Entidad</label>
            <select class="form-control" id="street1_id" name="mapPoiEntidad.id">
                <c:forEach items="${poiEntidades}" var="bo" varStatus="status">
                    <option value="${bo.id}">${bo.descripcion}</option>
                </c:forEach>
            </select>

            <label class="control-label pt-2">Descripcion</label>
            <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
            <label class="control-label pt-2">Provincia</label>
            <select class="form-control" id="street1_id" name="mapProvincia.id">
                <c:forEach items="${provincias}" var="bo" varStatus="status">
                    <option value="${bo.id}">${bo.descripcion}</option>
                </c:forEach>
            </select>

            <label class="control-label pt-2">Latitud</label>
            <form:input path="geoLatitud" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

            <label class="control-label pt-2">Longitud</label>
            <form:input path="geoLongitud" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

            <label class="control-label pt-2">Icono</label>
            <form:input path="icono" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
        </div>
        <div class="form-group"> <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Nuevo Punto de interes</button>
        </div>

    </form:form>
</div>