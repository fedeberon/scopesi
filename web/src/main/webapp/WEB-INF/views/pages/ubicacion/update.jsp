<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #mapUpdate {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
    }
</style>
<script>
    var lat = ${updateUbicacion.latitud};
    var lng = ${updateUbicacion.longitud};

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
<div class="content">
<div class="col-12">
<div class="card">
        <form:form action="search" modelAttribute="updateUbicacion" method="post">
            <form:hidden path="id" value='${empresa.id}'/>
            <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <label class="control-label pt-2">Empresa</label>
                                <select id="select-empresas" name="mapEmpresa.id" class="form-control selectStyle" data-live-search="true" title="Seleccione una empresa">
                                    <c:forEach items="${empresas}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapEmpresa.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Elemento</label>
                                <select class="form-control selectStyle" id="select-elementos" name="mapElemento.id" data-live-search="true" title="Seleccione un elemento">
                                    <c:forEach items="${elementos}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapElemento.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Formato</label>
                                <select class="form-control selectStyle" id="select-formatos" name="mapFormato.id">
                                    <c:forEach items="${formatos}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapFormato.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Medio</label>
                                <select class="form-control selectStyle" id="select-medios" name="mapMedio.id">
                                    <c:forEach items="${medios}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapMedio.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Direccion</label>
                                <form:input  path="direccion" cssClass="form-control" id="newAddress" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Numero Agip</label>
                                <form:input  path="nroAgip" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Referencia</label>
                                <form:input  path="referencia" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Cantidad</label>
                                <form:input  path="cantidad" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Provincia</label>
                                <select class="form-control selectStyle" data-live-search="true" id="select-provincias" name="mapProvincia.id">
                                    <c:forEach items="${provincias}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapProvincia.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion == "" ? "-Dejar vacio-" : bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label class="control-label pt-2">Localidad</label>
                                <select class="form-control selectStyle" data-live-search="true" id="select-localidades" name="mapLocalidad.id">
                                    <c:forEach items="${localidades}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapLocalidad.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Transito</label>
                                <form:input  path="transito" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Iluminacion</label>
                                <form:input  path="iluminacion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Medida</label>
                                <form:input  path="medidas" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Metros Contacto</label>
                                <form:input  path="metrosContacto" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Latitud</label>
                                <form:input  path="latitud" cssClass="form-control" id="latitud" name="street1" onchange="setLat(event)" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Longitud</label>
                                <form:input  path="longitud" cssClass="form-control" id="longitud" name="street1" onchange="setLong(event)" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Coeficiente</label>
                                <form:input  path="coeficiente" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Referencia</label>
                                <form:input  path="idReferencia" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Buses</label>
                                <select class="form-control" id="street1_id" name="mapBuses.id">
                                    <c:forEach items="${buses}" var="bo" varStatus="status">
                                        <option ${bo.id == updateUbicacion.mapBuses.id ? 'selected' : ''} value="${bo.id}">${bo.id}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Baja Logica</label>
                                <form:select path="bajaLogica" cssClass="form-control" name="">
                                    <form:option value="false"> Activo </form:option>
                                    <form:option value="true"> Inactivo</form:option>
                                </form:select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Fecha Transf</label>
                                <form:input  path="fechaTransf" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Ubicacion Altura</label>
                                <select class="form-control" id="street1_id" name="mapUbicacionAltura.id">
                                    <c:forEach items="${alturas}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapUbicacionAltura.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Ubicacion visibilidad</label>
                                <select class="form-control" id="street1_id" name="mapUbicacionVisibilidad.id">
                                    <c:forEach items="${visibilidades}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == updateUbicacion.mapUbicacionVisibilidad.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <form:input  type="hidden" path="fechaAlta" value='${ubicacion.fechaAlta}' cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                    </div>

                        <%-- Filter--%>
                    <form:form action="/ubicacion/search" modelAttribute="myWrapper">
                        <form:hidden path="request.id"/>
                        <form:hidden path="request.idsSearch"/>
                        <form:hidden path="request.mapEmpresa"/>
                        <form:hidden path="request.mapElemento"/>
                        <form:hidden path="request.mapFormato"/>
                        <form:hidden path="request.mapMedio"/>
                        <form:hidden path="request.mapLocalidad"/>
                        <form:hidden path="request.mapProvincia"/>
                        <form:hidden path="request.bajaLogica"/>
                        <form:hidden path="request.latLngEmpty"/>
                        <form:hidden path="request.fechaAlta"/>
                        <form:hidden path="request.searchValue"/>
                        <form:hidden path="request.maxResults"/>

                        <button type="submit" name="paginate" class="btn btn-info btn-fill"><i class="fas fa-angle-double-left pr-2"></i> Volver</button>
                    </form:form>

                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-secondary btn-fill pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                        Guardar
                    </button>

                    <a href="#" class="btn btn-info btn-fill pull-right mr-1" onclick="showMap(lat, lng, 'mapUpdate', 'searchInputUpdate')">Mapa</a>

                    <!-- Modal -->
                    <div class="modal fade modal-confirm" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel1"></h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h5>&iquest;Desea confirmar los cambios?</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="#" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    <button type="submit" name="editUbicacion" class="btn btn-secondary btn-fill">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="modal fade" id="mapModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div style="max-width: 650px;" class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Edici&oacute;n de coordenadas</h5>
                            <button type="button" onclick="reCreateInputSearch('mapUpdate','searchInputUpdate')" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body row">
                            <input id="searchInputUpdate" class="form-control col-sm-6" type="text" style="margin-top: 10px" placeholder="Ingrese una lugar ..">
                            <div id="mapUpdate">

                            </div>
                        </div>
                     </form:form>
                    </div>
                </div>
            </div>


</div>
</div>
</div>