<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
    <div class="col-12">
        <div class="card">
        <form:form action="addPoi" modelAttribute="poi" method="post">
            <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <label  class="control-label">POI Entidad</label>
                                <select class="form-control" id="street1_id" name="mapPoiEntidad.id">
                                    <c:forEach items="${poiEntidades}" var="bo" varStatus="status">
                                        <option value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Descripcion</label>
                                <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label class="control-label pt-2">Provincia</label>
                                <select class="form-control" id="street1_id" name="mapProvincia.id">
                                    <c:forEach items="${provincias}" var="bo" varStatus="status">
                                        <option value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Latitud</label>
                                <form:input path="geoLatitud" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label class="control-label pt-2">Longitud</label>
                                <form:input path="geoLongitud" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Icono</label>
                                <form:input path="icono" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-info btn-fill pull-left ">Guardar</button>
                </div>
            </div>
        </form:form>
        </div>
    </div>
</div>
