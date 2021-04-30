<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<style>
    #mapApp {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
    }
    .card form [class*="col-"]:first-child {
        padding-left: 6px;
    }
    .card form [class*="col-"]:last-child {
        padding-right: 6px;
    }
</style>

<div class="content">
    <div class="col-12">
        <div class="card">
            <form:form action="saveUpdate" modelAttribute="updateAppUbicacion" method="post">
            <form:hidden path="id" value='${appUbicacionRelevamiento.id}'/>

            <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <label class="control-label pt-2">Relevamiento</label>
                                <select class="form-control" name="idRelevamiento.id">
                                    <c:forEach items="${relevamientos}" var="bo" varStatus="status">
                                        <option ${bo.nombreRelevamiento == updateAppUbicacion.idRelevamiento.nombreRelevamiento ? 'selected' : ''} value="${bo.id}">${bo.nombreRelevamiento}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2 pr-2 col-4">Direccion</label>
                                <label style="font-size: 11px;" class="pt-2 col-6 float-right text-right">(Formato: direccion, localidad , provincia, pa&iacute;s)</label>
                                <form:input path="direccion" cssClass="form-control" id="newAddress" placeholder="Ej: Av. Independencia 100, Buenos Aires, Argentina"/>
                            </div>

                            <div class="col-6">
                                <label class="control-label pt-2">Latitud</label>
                                <form:input path="latitud" cssClass="form-control" id="latitud" onchange="setLatApp(event)" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Longitud</label>
                                <form:input path="longitud" cssClass="form-control" id="longitud"  onchange="setLngApp(event)" placeholder=""/>
                            </div>

                        </div>
                    </div>
                    <a href="list" class="btn btn-light pull-left ml-3"><i class="fas fa-angle-double-left pr-2"></i>Volver</a>


                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-secondary btn-fill pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                        Guardar
                    </button>

                    <!-- Modal -->
                    <div class="modal fade modal-confirm" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"></h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h5>&iquest;Desea confirmar los cambios?</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="#" class="btn btn-light" data-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-secondary btn-fill">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <a href="#" class="btn btn-info btn-fill pull-right mr-1" onclick="showMap(lat, lng, 'mapApp', 'searchInputApp')">Mapa</a>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="mapModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div style="max-width: 650px;" class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Edici&oacute;n de coordenadas</h5>
                            <button type="button" onclick="reCreateInputSearch('mapApp','searchInputApp')" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body row">
                            <input id="searchInputApp" class="form-control col-sm-6" type="text" style="margin-top: 10px" placeholder="Ingrese una lugar ..">
                            <div id="mapApp">

                            </div>
                        </div>
                        </form:form>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    <c:choose>
    <c:when test="${updateAppUbicacion.latitud == null}">
    var lat = "";
    </c:when>
    <c:otherwise>
    var lat = ${updateAppUbicacion.latitud}
    </c:otherwise>
    </c:choose>
    <c:choose>
    <c:when test="${updateAppUbicacion.longitud == null}">
    var lng = "";
    </c:when>
    <c:otherwise>
    var lng = ${updateAppUbicacion.longitud};
    </c:otherwise>
    </c:choose>

    function setLatApp(event) {
        lat = event.target.value;
    }

    function setLngApp(event) {
        lng = event.target.value;
    }
</script>
