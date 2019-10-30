<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<style>
    .form-check{
        margin-top: 10px;
    }


</style>

<div class="content">
    <td class="container-fluid">

        <div class="row">

            <div class="col-12">

                <div class="card strpied-tabled-with-hover">

                    <div class="card-header">
                        <h4 class="card-title">Ubicaciones</h4>
                    </div>

                    <div class="card-body table-full-width table-responsive">

                        <form:form action="map" modelAttribute="wrapper">

                             <table id="dataTable" class="display" style="width:100%">
                            <thead>
                                <td>
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" value="">
                                            <span class="form-check-sign"></span>
                                        </label>
                                    </div>
                                </td>
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
                                    <td>${bo.audEmpresa.descripcion}</td>
                                    <td>
                                            ${bo.mapElemento.descripcion}
                                                <input type="hidden" value="${bo.id}" name="list[${status.index}].name"/>
                                    </td>
                                    <td>${bo.mapFormato.descripcion}</td>
                                    <td>${bo.mapMedio.descripcion}</td>
                                    <td>${bo.direccion}</td>
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
                                                <input type="hidden" value="${bo.id}" name="list[${status.index}].lat"/>

                                    </td>
                                    <td>
                                            ${bo.longitud}
                                                <input type="hidden" value="${bo.id}" name="list[${status.index}].lon"/>
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


                            <button type="submit" class="btn btn-primary"><i class="nc-icon nc-map-big"></i>&nbsp;Mapa</button>

                        </form:form>

                        <form:form name="search" action="list" modelAttribute="mapUbicacionRequest">
                            <form:hidden path="audEmpresa"/>
                            <form:hidden path="mapElemento"/>
                            <form:hidden path="mapMedio"/>
                            <form:hidden path="mapMedio"/>
                            <form:hidden path="audLocalidad"/>
                            <form:hidden path="mapProvincia"/>
                            <input type="hidden" name="page" value="${page}"/>

                            <div class="col-6">
                                <tags:paginador page="${page}" formName="search"/>
                            </div>

                        </form:form>

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
            <form:form action="search"  modelAttribute="mapUbicacionRequest">
                <div class="modal-body row">

                        <div class="form-group col-6">
                            <label for="audEmpresa">Empresas</label>
                            <form:select path="audEmpresa" items="${empresas}" itemLabel="descripcion" itemValue="descripcion" cssClass="form-control"/>
                        </div>
                        <div class="form-group col-6">
                            <label for="mapElemento">Elementos</label>
                            <form:select path="mapElemento" items="${elementos}" itemLabel="descripcion" itemValue="descripcion" cssClass="form-control"/>
                        </div>
                        <div class="form-group col-6">
                            <label for="mapElemento">Formatos</label>
                            <form:select path="mapFormato" items="${formatos}" itemLabel="descripcion" itemValue="descripcion" cssClass="form-control"/>
                        </div>

                        <div class="form-group col-6">
                            <label for="mapMedio">Medios</label>
                            <form:select path="mapMedio" items="${medios}" itemLabel="descripcion" itemValue="descripcion" cssClass="form-control"/>
                        </div>

                        <div class="form-group col-6">
                            <label for="audLocalidad">Localidadades</label>
                            <form:select path="audLocalidad" items="${localidades}" itemLabel="descripcion" itemValue="descripcion" cssClass="form-control"/>
                        </div>

                        <div class="form-group col-6">
                            <label for="mapProvincia">Provincias</label>
                            <form:select path="mapProvincia" items="${medios}" itemLabel="descripcion" itemValue="descripcion" cssClass="form-control"/>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
