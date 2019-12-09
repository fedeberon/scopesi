<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<style>
    .form-check{
        margin-top: 10px;
    }

    .dt-buttons{
        display: none;
    }

    /*.modal-dialog.modal-lg {*/
    /*    margin-top: 20% !important;*/
    /*}*/



</style>

<div class="content">
    <div class="container-fluid">

        <div class="row">

            <div class="col-12">

                <div class="card strpied-tabled-with-hover">

                    <div class="card-header">
                        <h4 class="card-title">Ubicaciones</h4>
                    </div>

                    <div class="card-body table-full-width table-responsive">

                        <form:form action="map" modelAttribute="wrapper" name="ubicaciones">

                            <table id="dataTable" class="display" style="width:100%">

                            <thead>
                            <th>
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="checkbox" value="">
                                        <span class="form-check-sign"></span>
                                    </label>
                                </div>
                            </th>
                            <th>ID</th>
                            <th>Empresa</th>
                            <th>Elemento</th>
                            <th>Formato</th>
                            <th>Medio</th>
                            <th>Direccion</th>
                            <th>Nro.Agip</th>
                            <th>Referencia</th>
                            <th>Nro.Anuncio</th>
                            <th>Localidad</th>
                            <th>Provincia</th>
                            <th>Anunciante</th>
                            <th>Cantidad</th>
                            <th>Transito</th>
                            <th>Iluminacion</th>
                            <th>Medidas</th>
                            <th>Metros Cuadrados</th>
                            <th>Direccion Normalizada</th>
                            <th>Latitud</th>
                            <th>Longitud</th>
                            <th>Metros Contacto</th>
                            <th>Coeficiente</th>
                            <th>Zona</th>
                            <th>Saturacion</th>
                            <th>Visibilidad</th>
                            <th>Circulacion Peatonal</th>
                            <th>Circulacion Vehicular</th>
                            <th>Id.Referencia</th>
                            <th>Buses</th>
                            <th>Baja Logica</th>
                            <th>Fecha de Tranferencia</th>
                            <th>Fecha de Alta</th>
                            <th>Id.Altura</th>
                            <th>Id.Visibilidad</th>
                        </thead>

                            <tbody>

                                <c:forEach items="${ubicaciones}" var="bo" varStatus="status">

                                <tr>
                                    <td>
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <input class="form-check-input" type="checkbox" id="form-check-input-${bo.id}" name="list[${status.index}].checked">
                                                <%--<form:checkbox cssClass="form-check-input"  path="list[${status.index}].checked"/>--%>
                                                <span class="form-check-sign" id="${bo.id}"></span>
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        ${bo.id}
                                        <input type="hidden" value="${bo.id}" name="list[${status.index}].id"/>
                                    </td>
                                    <td>
                                            ${bo.audEmpresa.descripcion}
                                                <input type="hidden" value="${bo.audEmpresa.descripcion}" name="list[${status.index}].name"/>
                                    </td>

                                    <td>
                                            ${bo.mapElemento.descripcion}
                                                <input type="hidden" value="${bo.mapElemento.descripcion}" name="list[${status.index}].description"/>
                                    </td>

                                    <td>${bo.mapFormato.descripcion}</td>
                                    <td>${bo.mapMedio.descripcion}</td>
                                    <td>
                                            ${bo.direccion}
                                                <input type="hidden" value="${bo.direccion}" name="list[${status.index}].address"/>
                                    </td>
                                    <td>${bo.nroAgip}</td>
                                    <td>${bo.referencia}</td>
                                    <td>${bo.nroAnuncio}</td>
                                    <td>${bo.audLocalidad.descripcion}</td>
                                    <td>${bo.mapProvincia.descripcion}</td>
                                    <td>${bo.anunciante}</td>
                                    <td>${bo.cantidad}</td>
                                    <td>${bo.transito}</td>
                                    <td>${bo.iluminacion}</td>
                                    <td>${bo.medidas}</td>
                                    <td>${bo.m2}</td>
                                    <td>${bo.direccionNormalizada}</td>
                                    <td>
                                            ${bo.latitud}
                                                <input type="hidden" value="${bo.latitud}" name="list[${status.index}].lat"/>

                                    </td>
                                    <td>
                                            ${bo.longitud}
                                                <input type="hidden" value="${bo.longitud}" name="list[${status.index}].lon"/>
                                    </td>
                                    <td>${bo.metrosContacto}</td>
                                    <td>${bo.coeficiente}</td>
                                    <td>${bo.zona}</td>
                                    <td>${bo.saturacion}</td>
                                    <td>${bo.visibilidad}</td>
                                    <td>${bo.circulacionPeatonal}</td>
                                    <td>${bo.circulacionVehicular}</td>
                                    <td>${bo.idReferencia}</td>
                                    <td> - </td>
                                    <td>${bo.bajaLogica}</td>
                                    <td>${bo.fechaTransf}</td>
                                    <td>${bo.fechaAlta}</td>
                                    <td>${bo.mapUbicacionAltura.descripcion}</td>
                                    <td>${bo.mapUbicacionVisibilidad.descripcion}</td>
                                </tr>

                            </c:forEach>

                            </tbody>

                        </table>


                        </form:form>

                        <div class="col-6">
                            <tags:paginador page="${ubicacionRequest.page}" formName="searchModal"/>

                            <a href="#" onclick="onSubmit('ubicaciones')" class="btn btn-primary"><i class="nc-icon nc-map-big"></i>&nbsp;Mapa</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Filtros</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form:form action="list"  modelAttribute="mapUbicacionRequest" name="searchModal">
                <input type="hidden" name="page" value="${ubicacionRequest.page}"/>
                <div class="modal-body row">

                        <div class="form-group col-6">
                            <label for="empresa">Empresas</label>
                            <select id="select-empresas" name="audEmpresa" data-done-button="true" class="form-control" multiple data-live-search="true" data-actions-box="true" title="Seleccione una empresa">
                                <c:forEach items="${empresas}" var="bo">
                                    <<option value="${bo.descripcion}">${bo.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="elemento">Elementos</label>
                            <select id="select-elementos" name="mapElemento" data-done-button="true" class="form-control" multiple data-live-search="true" data-actions-box="true" title="Seleccione un Elemento">
                                <c:forEach items="${elementos}" var="bo">
                                    <option value="${bo.descripcion}">${bo.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="formato">Formatos</label>
                            <select id="select-formatos" name="mapFormato" data-done-button="true" class="form-control" multiple data-live-search="true" data-actions-box="true" title="Seleccione un formato">
                                <c:forEach items="${formatos}" var="bo">
                                    <option value="${bo.descripcion}">${bo.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="medio">Medios</label>
                            <select id="select-medios" name="mapMedio" data-done-button="true" class="form-control" multiple data-live-search="true" data-actions-box="true" title="Seleccione un Medio   ">
                                <c:forEach items="${medios}" var="bo">
                                    <option value="${bo.descripcion}">${bo.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="localidad">Localidadades</label>
                            <select id="select-localidades" name="audLocalidad" data-done-button="true" class="form-control" multiple data-live-search="true" data-actions-box="true" title="Seleccione una Localidad">
                                <c:forEach items="${localidades}" var="bo">
                                    <option value="${bo.descripcion}">${bo.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="provincia">Provincias</label>
                            <select id="select-provincias" name="mapProvincia" data-done-button="true" class="form-control" multiple data-live-search="true" data-actions-box="true" title="Seleccione una Provincia">
                                <c:forEach items="${provincias}" var="bo">
                                    <option value="${bo.descripcion}">${bo.descripcion}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="bajaLogica">Estado</label>
                            <select id="select-estados" name="bajaLogica" class="form-control" multiple data-live-search="true" title="Seleccione un estado">
                                <option value="true">Activo</option>
                                <option value="false">Inactivo</option>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="langLongEmpty">GeoLocalizacion</label>
                            <select id="select-geolocalizacion" name="langLongEmpty" class="form-control" multiple data-live-search="true" title="Seleccione una opci&oacute;n">
                                <option value="false">Con coordenadas</option>
                                <option value="true">Sin coordenadas</option>
                            </select>
                        </div>

                        <div class="form-group col-6">
                            <label for="fechaAlta">Fecha de alta</label>
                            <input name="fechaAlta" autocomplete="off"  class="form-control datepicker" title="Seleccione una fecha"/>
                        </div>

                        <div class="col load mt-5" style="display: none; position:absolute; top: 123px;">
                            <div class="col-md-12">
                                <div class="loader">
                                    <div class="loader-inner box1"></div>
                                    <div class="loader-inner box2"></div>
                                    <div class="loader-inner box3"></div>
                                </div>
                            </div>
                            <div class="col-md-12"><h5 id="info-loader" style="text-align: center"></h5></div>
                        </div>

                      <%--<div class="form-group col-6">
                             <label for="fechaAlta">Fecha de alta</label>
                             <br>
                             <input type="text" name="fechaAlta" class="datetimepicker"/>
                         </div>--%>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                    <button type="button" class="btn btn-secondary" id="btn-check-result" onclick="disabledOptionsNotFounds()">Chequear resultados</button>

                    <button onclick="onSubmit('searchModal')" class="btn btn-primary">Buscar</button>
                </div>
            </form:form>
        </div>
    </div>
</div>


<li class="nav-item more-options" style="display: none">
    <a href="#" class="nav-link">
        <i id="icon-options" class="nc-icon nc-simple-add"></i>
        <span id="span-more-options" class="d-lg-block" onclick="showOptions()">&nbsp;Mas Opciones</span>
    </a>
</li>


