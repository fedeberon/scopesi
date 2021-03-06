<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    #mapa {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
    }
</style>
<div class="content">
<div class="col-12">
<div class="card">
        <form:form action="addUbicacion" modelAttribute="ubicacion" method="post">
            <form:hidden path="id" value='${empresa.id}'/>
            <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Empresa</label>
                                <select class="form-control" id="street1_id" name="mapEmpresa.id">
                                    <c:forEach items="${empresas}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == ubicacion.mapEmpresa.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Elemento</label>
                                <select class="form-control" id="street1_id" name="mapElemento.id" >
                                    <c:forEach items="${elementos}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == ubicacion.mapElemento.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Formato</label>
                                <select class="form-control" id="street1_id" name="mapFormato.id">
                                    <c:forEach items="${formatos}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == ubicacion.mapFormato.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Medio</label>
                                <select class="form-control" id="street1_id" name="mapMedio.id">
                                    <c:forEach items="${medios}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == ubicacion.mapMedio.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Direccion</label>
                                <form:input  path="direccion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
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
                                <select class="form-control" id="street1_id" name="mapProvincia.id">
                                    <c:forEach items="${provincias}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == ubicacion.mapProvincia.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Localidad</label>
                                <select class="form-control" id="street1_id" name="mapLocalidad.id">
                                    <c:forEach items="${localidades}" var="bo" varStatus="status">
                                        <option ${bo.descripcion == ubicacion.mapLocalidad.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
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
                                <form:input  path="latitud" cssClass="form-control" id="latitud" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Longitud</label>
                                <form:input  path="longitud" cssClass="form-control" id="longitud" name="street1" placeholder=""/>
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
                                        <option ${bo.descripcion == ubicacion.mapBuses.descripcion ? 'selected' : ''} value="${bo.id}">${bo.linea}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Baja Logica</label>
                                <form:input  path="bajaLogica" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Fecha Transf</label>
                                <form:input  path="fechaTransf" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Ubicacion Altura</label>
                                <form:input  path="mapUbicacionAltura" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2">Ubicacion visibilidad</label>
                                <form:input  path="mapUbicacionVisibilidad" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                    </div>
                    <a href="list" class="btn btn-light pull-left ml-3"><i class="fas fa-angle-double-left pr-2"></i>Volver</a>


                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-secondary btn-fill pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                        Guardar
                    </button>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel1" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel1"></h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <h5>¿Desea confirmar los cambios?</h5>
                                </div>
                                <div class="modal-footer">
                                    <button type="#" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                    <button type="submit" class="btn btn-secondaary btn-fill">Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <a href="#" class="btn btn-info btn-fill pull-right mr-1" onclick="showMap('${ubicacion.latitud}', '${ubicacion.longitud}')">Mapa</a>
                </div>
            </div>
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