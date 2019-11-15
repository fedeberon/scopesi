<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="addPoi" modelAttribute="poi" method="post">

    <div class="form-group"> <!-- Street 1 -->
        <label  class="control-label">POI Entidad</label>
        <form:input path="mapPoiEntidad.id" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label  class="control-label">DESCRIPCION</label>
        <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label class="control-label">PROVINCIA</label>
        <form:input path="mapProvincia.id" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label class="control-label">LATITUD</label>
        <form:input path="geoLatitud" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label class="control-label">LONGTITUD</label>
        <form:input path="geoLongitud" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label class="control-label">ICONO</label>
        <form:input path="icono" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
    </div>
    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Nuevo Punto de interes</button>
    </div>

</form:form>