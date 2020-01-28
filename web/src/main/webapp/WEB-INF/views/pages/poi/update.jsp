<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<style>
    #mapa {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
    }
</style>

<div class="content">
<div class="col-12">
<div class="card">
<form:form action="addPoi" modelAttribute="poi" method="post">
    <form:hidden path="id" value='${poi.id}'/>

    <div class="row ml-3">
        <div class="col-md-11">
            <div class="form-group">
                <div class="row">
                    <div class="col-6">
                        <label  class="control-label">POI Entidad</label>
                        <select class="form-control" id="street1_id1" name="mapPoiEntidad.id">
                            <c:forEach items="${poiEntidades}" var="bo" varStatus="status">
                                <option ${bo.descripcion == poi.mapPoiEntidad.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
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
                        <select class="form-control" id="street2_id" name="mapProvincia.id">
                            <c:forEach items="${provincias}" var="bo" varStatus="status">
                                <option ${bo.descripcion == poi.mapProvincia.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-6">
                        <label class="control-label pt-2">Latitud</label>
                        <form:input path="geoLatitud" cssClass="form-control" id="latitud" placeholder=""/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-6">
                        <label class="control-label pt-2">Icono</label>
                        <form:input path="icono" cssClass="form-control" id="street5_id" name="street1" placeholder=""/>
                    </div>
                    <div class="col-6">
                        <label class="control-label pt-2">Longitud</label>
                        <form:input path="geoLongitud" cssClass="form-control" id="longitud"  placeholder=""/>
                    </div>

                </div>
            </div>
            <a href="list" class="btn btn-light btn-fill pull-left ml-3"><i class=""></i>Volver</a>


            <!-- Button trigger modal -->
            <button type="button" class="btn btn-success pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                Guardar
            </button>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel"></h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <h5>Confirmar cambios.</h5>
                        </div>
                        <div class="modal-footer">
                            <button type="#" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>
                    </div>
                </div>
            </div>

            <a href="#" class="btn btn-info btn-fill pull-right" onclick="showMap('${poi.geoLatitud}', '${poi.geoLongitud}')">Mapa</a>
        </div>
    </div>


    <!-- Modal -->
    <div class="modal fade" id="mapModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Filtros</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                    <div class="modal-body row">
                        <div id="mapa">

                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>


</div>
</div>
</div>
