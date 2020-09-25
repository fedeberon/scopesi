<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<style>
    .form-check{
        margin-top: 10px;
    }

    .hidden{
        display: none;
    }

    .dt-buttons{
        display: none;
    }

    .fancybox-button--fb {
        padding: 10px;
        margin-right: 5px;
    }

    .fancybox-button--fb svg path{
        stroke-width: 0;
    }

    .confirm-modal{
        margin-top: 124px;
        z-index: 100000;
    }

</style>

<div class="content">
    <div class="container-fluid">

        <div class="col load mt-5" style="display: none; position:absolute; z-index: 1000; top: 123px;">
            <div class="col-md-12">
                <div class="loader">
                    <div class="loader-inner box1"></div>
                    <div class="loader-inner box2"></div>
                    <div class="loader-inner box3"></div>
                </div>
            </div>
            <div class="col-md-12"><h5 id="info-loader" style="text-align: center"></h5></div>
        </div>

        <div class="row">

            <div class="col-12">

                <div class="card strpied-tabled-with-hover">

                    <div class="card-header">
                        <h4 class="card-title">Ubicaciones</h4>
                    </div>

                    <div class="card-body table-full-width table-responsive">

                        <form:form action="search" modelAttribute="myWrapper" name="myWrapper" id="myWrapper" method="post">
                            <input type="hidden" name="page" value="${ubicacionRequest.page}"/>
                            <table id="dataTable" class="display" style="width:100%">
                                <thead>
                                <th>
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input type="checkbox" value=""  id="checkbox-all" onclick="selectAll()">
                                            <span class="form-check-sign"></span>
                                        </label>
                                    </div>
                                </th>
                                <th>Fotos</th>
                                <th>Editar</th>
                                <th>ID</th>
                                <th>Empresa</th>
                                <th>Elemento</th>
                                <th>Formato</th>
                                <th>Medio</th>
                                <th>Direccion</th>
                                <th>Nro.Agip</th>
                                <th>Referencia</th>
                                <th>Localidad</th>
                                <th>Provincia</th>
                                <th>Cantidad</th>
                                <th>Transito</th>
                                <th>Iluminacion</th>
                                <th>Medidas</th>
                                <th>Latitud</th>
                                <th>Longitud</th>
                                <th>Metros Contacto</th>
                                <th>Coeficiente</th>
                                <th>Id.Referencia</th>
                                <th>Id.Buses</th>
                                <th>Baja Logica</th>
                                <th>Fecha de Tranferencia</th>
                                <th>Fecha de Alta</th>
                                <th>Altura</th>
                                <th>Visibilidad</th>
                                <th>Poligono</th>
                            </thead>
                                <tbody>
                                    <c:forEach items="${ubicaciones}" var="bo" varStatus="status">

                                    <tr>
                                        <td>
                                            <div class="form-check">
                                                <label class="form-check-label">
                                                    <input class="form-check-input" type="checkbox" id="form-check-input-${bo.id}" name="list[${status.index}].checked">
                                                    <span class="form-check-sign" id="${bo.id}"></span>
                                                </label>
                                            </div>
                                        </td>

                                        <td>
                                            <div class="text-center cursorPointer" onclick="createCarrusel('${bo.id}')">
                                                <i class="fas fa-camera"></i>
                                            </div>
                                        </td>

                                        <td class="text-center">
                                            <input type="hidden" id="wrapperId" value="${bo.id}" name="id"/>
                                            <button type="submit" id="sudmit-${bo.id}" name="editar" style="display: none;"></button>
                                            <a href="#" onclick="submitEdit(${bo.id})"><img src="/resources/assets/img/icons/edit2.png" alt=""></a>
                                        </td>
                                        <td>
                                            <a href="/ubicacion/${bo.id}">${bo.id}</a>
                                                 <input type="hidden" value="${bo.id}" name="list[${status.index}].id"/>
                                        </td>
                                        <td>
                                                ${bo.mapEmpresa.descripcion}
                                                    <input type="hidden" value="${bo.mapEmpresa.descripcion}" name="list[${status.index}].name"/>
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
                                        <td>
                                                ${bo.mapLocalidad.descripcion}
                                                    <input type="hidden" value="${bo.mapLocalidad.descripcion}" name="list[${status.index}].localidad"/>
                                        </td>
                                        <td>
                                                ${bo.mapProvincia.descripcion}
                                                    <input type="hidden" value="${bo.mapProvincia.descripcion}" name="list[${status.index}].provincia"/>
                                        </td>
                                        <td>${bo.cantidad}</td>
                                        <td>${bo.transito}</td>
                                        <td>${bo.iluminacion}</td>
                                        <td>${bo.medidas}</td>
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
                                        <td>${bo.idReferencia}</td>
                                        <td>${bo.mapBuses.id}</td>
                                        <td>${bo.bajaLogica}</td>
                                        <td>${bo.fechaTransf}</td>
                                        <td>${bo.fechaAlta}</td>
                                        <td>${bo.mapUbicacionAltura.descripcion}</td>
                                        <td>${bo.mapUbicacionVisibilidad.descripcion}</td>
                                        <td>${bo.polygonLatLong} <input type="hidden" value='${bo.polygonLatLong}' name="list[${status.index}].polygonCoordinates"/></td>
                                    </tr>

                                </c:forEach>
                                </tbody>
                            </table>

                        <!-- Modal Editar campos -->
                    <%--    <div class="modal fade" id="optionModalEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Datos a Cambiar</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <input type="hidden" name="page" value="${ubicacionRequest.page}"/>
                                    <div class="modal-body row">

                                        <div class="form-group col-6">
                                            <label for="idEmpresa">Empresas</label>
                                            <select name="request.idEmpresa" class="form-control" title="Seleccione una empresa">
                                                <option  value="-1">Seleccione una Empresa</option>
                                                <c:forEach items="${empresas}" var="bo">
                                                    <option  value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idElemento">Elementos</label>
                                            <select name="request.idElemento" class="form-control">
                                                <option  value="-1">Seleccione un Elemento</option>
                                                <c:forEach items="${elementos}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idFormato">Formatos</label>
                                            <select name="request.idFormato" items="${formatos}" class="form-control" title="Seleccione un formato">
                                                <option  value="-1">Seleccione un Formato</option>
                                                <c:forEach items="${formatos}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idMedio">Medios</label>
                                            <select name="request.idMedio" items="${medios}" class="form-control" title="Seleccione un Medio   ">
                                                <option  value="-1">Seleccione una Medio</option>
                                                <c:forEach items="${medios}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idLocalidad">Localidades</label>
                                            <select name="request.idLocalidad" items="${localidades}" class="form-control" title="Seleccione una Localidad">
                                                <option  value="-1">Seleccione una Localidad</option>
                                                <c:forEach items="${localidades}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idProvincia">Provincias</label>
                                            <select name="request.idProvincia" items="${provincias}" class="form-control" title="Seleccione una Provincia">
                                                <option  value="-1">Seleccione una Provincia</option>
                                                <c:forEach items="${provincias}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idAltura">Alturas</label>
                                            <select name="request.idAltura" class="form-control" title="Seleccione una Altura">
                                                <option  value="-1">Seleccione una altura</option>
                                                <c:forEach items="${alturas}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="idVisibilidad">Visibilidades</label>
                                            <select name="request.idVisibilidad" class="form-control" title="Seleccione una Visibilidad">
                                                <option  value="-1">Seleccione una visibilidad</option>
                                                <c:forEach items="${visibilidades}" var="bo">
                                                    <option value="${bo.id}">${bo.descripcion}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="metrosContactoRequest">Metros Contacto</label>
                                            <input  type="number" name="request.metrosContactoRequest" class="form-control" title="Metros Contacto" placeholder="Ingrese metros de contacto">
                                        </div>

                                        <div class="form-group col-6">
                                            <label for="coeficienteRequest">Coeficiente</label>
                                            <input  type="number" step="any" name="request.coeficienteRequest" class="form-control" title="Coeficiente" placeholder="Ingrese coeficiente">
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                                        <button name="saveList" type="submit" class="btn btn-primary"><i class="far fa-save"></i>&nbsp;Guardar resultados</button>
                                    </div>

                                </div>
                            </div>
                        </div>

                  --%>

                        <div class="col-8">
<%--                            <tags:paginador page="${ubicacionRequest.page}"  formName="myWrapper" noMorePages="${Integer.valueOf(ubicaciones.size() / 10) + Integer.valueOf(ubicaciones.size() % 10 >= 1 ? 1 : 0)}"/>--%>
                            <tags:paginador page="${ubicacionRequest.page}"  formName="myWrapper"/>

                            <button type="submit" name="maps" class="btn btn-info btn-fill"><i class="fas fa-map-marker-alt"></i>&nbsp;Mapa</button>

                            <a href="create" class="btn btn-primary btn-fill"><i class="fas fa-plus"></i></i>&nbsp;Nuevo</a>

                        </div>

                            <%--Modal editar campos--%>
                            <jsp:include page="../modals/editUbicacionesModal.jsp"/>

                            <%--Modal filtrar campos--%>
                            <jsp:include page="../modals/filterUbicacion.jsp"/>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="modal-info-marker" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content" style="margin-top: 0px;">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Datos de la ubicaci&oacute;n</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body data-ubicacion"></div>
            <div class="modal-footer">
                <button onclick="showImages()" class="btn btn-primary">Ver Imagenes</button>

                <a data-toggle="modal" href="#myModal2" class="btn btn-primary">Subir Imagenes</a>

                <button type="submit" class="btn btn-primary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="myModal2">
    <div class="modal-dialog  modal-md">
        <div class="modal-content mt-0">
            <div style="text-align: center;">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h3>Selecci&oacute;n de imagenes</h3>
            </div>

            <div class="upload-container" style="margin: 15px;">
                <div class="upload-content">
                    <div class="single-upload">
                        <h5>Subir una imagen</h5>
                        <form id="singleUploadForm" name="singleUploadForm">
                            <input id="singleFileUploadInput" type="file" name="file" class="file-input" required />
                            <button type="submit" class="btn btn-sm btn-primary btn-fill confirmUpload-button">Confirmar</button>
                        </form>
                        <div class="upload-response">
                            <div id="singleFileUploadError"></div>
                            <div id="singleFileUploadSuccess"></div>
                        </div>
                    </div>
                    <div class="multiple-upload">
                        <h5>Subir varias imagenes</h5>
                        <form id="multipleUploadForm" name="multipleUploadForm">
                            <input id="multipleFileUploadInput" type="file" name="files" class="file-input" multiple required />
                            <button type="submit" class="btn btn-sm btn-primary btn-fill confirmUpload-button">Confirmar</button>
                        </form>
                        <div class="upload-response">
                            <div id="multipleFileUploadError"></div>
                            <div id="multipleFileUploadSuccess"></div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<li class="nav-item more-options" style="display: none">
    <a href="#" class="nav-link" onclick="openModal('searchModal')">
        <i class="nc-icon nc-zoom-split"></i>
        <span class="d-lg-block">&nbsp;Buscar</span>
    </a>
</li>

<li class="nav-item more-options" style="display: none">
    <a href="#" class="nav-link">
        <i id="icon-options" class="nc-icon nc-simple-add"></i>
        <span id="span-more-options" class="d-lg-block" onclick="showOptions()">&nbsp;Mas Opciones</span>
    </a>
</li>

<li class="nav-item more-options" style="display: none">
    <a href="#" class="nav-link" onclick="openModal('optionModal')">
        <i id="icon-options" class="nc-icon nc-simple-add"></i>
        <span class="d-lg-block">&nbsp;Editar Resultados</span>
    </a>
</li>

<!-- Modal -->
<div class="modal fade confirm-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" id="modal-confirmacion">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" style="margin-top: 0;" id="myModalLabel">&iquest;Desea eliminar esta imagen?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="modal-btn2-si">Si</button>
                <button type="button" class="btn btn-primary" id="modal-btn2-no">No</button>
            </div>
        </div>
    </div>
</div>
<script src="<c:url value='/resources/assets/js/filemanager.js'/>"></script>
<script>
    var element = document.getElementById("geoplanning");
    element.classList.add("active");

    function openModal(id){
        $('#' + id ).modal('show')
    }

    function closeModal(id){
        $('#' + id ).modal('hide')
    }

    $(document).ready(function(){

        var valueOfSearchingDataTable = sessionStorage['ubicacionSearchDataTable'] || '';
        $('.dataTables_filter input[type="search"]').val(valueOfSearchingDataTable).keyup();

        $('.dataTables_filter input').unbind().keyup(function(e) {

            var valueSearchDataTable = $(this).val();
            if (valueSearchDataTable.length>=1) {
                table.search(valueSearchDataTable).draw();
                sessionStorage['ubicacionSearchDataTable'] = valueSearchDataTable;

            } else {
                table.search('').draw();
                sessionStorage['ubicacionSearchDataTable'] = "";
            }
        });

    });

</script>