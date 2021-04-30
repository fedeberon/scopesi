<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form:form autocomplete="off" action="save" modelAttribute="appUbicacionRelevamiento" method="post">

                <div class="row ml-3">
                    <div class="col-md-11">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label class="control-label pt-2">Relevamiento</label>
                                    <select id="select-empresas" name="idRelevamiento.id" class="form-control selectStyle" data-live-search="true" title="Seleccione un relevamiento">
                                        <c:forEach items="${relevamientos}"  var="bo" varStatus="status">
                                            <option value="${bo.id}">${bo.nombreRelevamiento}</option>
                                        </c:forEach>
                                    </select>
                                    <form:errors path="idRelevamiento" cssStyle="color: red;"/>
                                </div>

                                <div class="col-6">
                                    <label for="newAddress" class="control-label pt-2">Direccion</label>
                                    <label style="font-size: 11px;" class="pt-2 col-6 float-right text-right">(Formato: direccion, localidad , provincia, pa&iacute;s)</label>
                                    <form:input path="direccion" cssClass="form-control" id="newAddress" placeholder="Ej: Av. Independencia 100, Buenos Aires, Argentina"/>
                                    <form:errors path="direccion" cssStyle="color: red;"/>
                                </div>

                                <div class="col-6">
                                    <label class="control-label pt-2">Latitud</label>
                                    <form:input path="latitud" value='${appUbicacionRelevamiento.latitud}' cssClass="form-control" onchange="setLat(event)"/>
                                </div>
                                <div class="col-6">
                                    <label class="control-label pt-2">Longitud</label>
                                    <form:input path="longitud" value='${appUbicacionRelevamiento.longitud}' cssClass="form-control" onchange="setLong(event)"/>
                                </div>
                            </div>
                        </div>

                        <a href="list" class="btn btn-light pull-left"><i class="fas fa-angle-double-left pr-2"></i>Volver</a>


                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-secondary btn-fill pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                            Guardar
                        </button>

                        <!-- Modal -->
                        <div class="modal fade modal-confirm" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel1"></h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <h5>&iquest;Desea guardar una nueva ubicacion?</h5>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="#" class="btn btn-light" data-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-secondary btn-fill">Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <a href="#" class="btn btn-info btn-fill pull-right mr-1" onclick="showMap(lat, lng , 'mapApp','searchInputCreate')"><i class=""></i>Mapa</a>

                    </div>
                </div>
                <div class="modal fade" id="mapModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div style="max-width: 650px;" class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Selecci&oacute;n de la geolocalizaci&oacute;n</h5>
                                <button type="button" onclick="reCreateInputSearch('mapApp','searchInputCreate')" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>

                            <div class="modal-body row">
                                <input id="searchInputCreate" class="form-control col-sm-6" type="text" style="margin-top: 10px" placeholder="Ingrese una lugar ..">
                                <div id="mapApp">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script>
    var element = document.getElementById("auditapp");
    element.classList.add("active");

    var lat;
    var lng;

    function setLat(event) {
        console.log(event.target.value);
        lat = event.target.value;
    }

    function setLong(event) {
        console.log(event.target.value);
        lng = event.target.value;
    }

    $(document).ready(function() {
        $(window).keydown(function(event){
            if(event.keyCode == 13) {
                event.preventDefault();
                return false;
            }
        });
    });
</script>
