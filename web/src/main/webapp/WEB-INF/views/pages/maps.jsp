<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>

    .modal-content {
        margin-top: 0px;
    }

    .marker-touched{
        background-color: yellow;
        border: 0.1px solid #cabdbd;
        padding: 2px;
    }


    .table-ubicaciones{
        position: absolute;
        margin-top: -150px;
        background-color: white;
        opacity: 0.8;
        min-width: 99%;
    }

    .hidden{
        display: none;
    }


    .fancybox-button--fb {
        padding: 10px;
        margin-right: 5px;
    }

    .fancybox-button--fb svg path{
        stroke-width: 0;
    }

    .dropdown-toggle::after{
        display: none !important;
    }
</style>

<script>
    var element = document.getElementById("maps-show");
    element.classList.add("active");
</script>

<div class="container">

    <div class="map-container">
        <%--<input id="pac-input"/>--%>
        <input id="searchInput" class="form-control col-sm-6" type="text" style="margin-top: 10px" placeholder="Ingrese una lugar ..">

        <div id="map"></div>

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

    </div>


    <div class="table-ubicaciones" id="table-ubicaciones">

                <img id="arrowUp" src="/resources/assets/img/icons/arrowUp.png" style="margin-top: -30px;z-index: 500;">
                <img id="arrowDown" src="/resources/assets/img/icons/arrowDown.png" style="margin-top: -30px; display: none">

                <table class="table" id="table-markers">
                    <thead>
                        <th>opciones</th>
                        <th>id</th>
                        <th>empresa</th>
                        <th>direccion</th>
                        <th>localidad</th>
                        <th>provincia</th>
                        <th>description</th>
                        <th>lat</th>
                        <th>long</th>

                    </thead>
                    <tbody>

                        <c:forEach items="${registros}" var="bo">

                            <tr>
                                <td>
                                    <a class="nav-link dropdown-toggle cursorPointer" id="dropdownMenuOffset" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="fas fa-bars" id="icon-${bo.id}"></i>
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuOffset">

                                        <i class="fas fa-sync dropdown-item cursorPointer" id="${bo.id}-update" onclick="actualizarCoordenadas('${bo.address}', '${bo.id}')"><a>&nbsp;&nbsp;GeoReferenciar</a></i>
                                        <button style="margin-left: 30px; margin-top: 8px;" id="${bo.id}-save" onclick="guardarCoordenadas('${bo.id}');" class="btn btn-danger hidden btn-fill">Guardar</button>

                                        <div class="dropdown-divider"></div>

                                        <div class="dropdown-item cursorPointer" id="icon-view-marker-${bo.id}" onclick="displayMarkers(this, '${bo.id}')">
                                            <i class="far fa-eye-slash"></i><a>&nbsp;&nbsp;Ocultar pin</a>
                                        </div>

                                        <div class="dropdown-divider"></div>

                                        <div class="dropdown-item cursorPointer" id="marker-touch-${bo.id}" onclick="toggleBounce('${bo.id}')">
                                            <i class="nc-icon nc-tap-01 pr-0" style="font-size: 16px"></i><a>&nbsp;&nbsp;Resaltar pin</a>
                                        </div>

                                        <div class="dropdown-divider"></div>

                                        <div class="dropdown-item cursorPointer" onclick="centerFromMarker('${bo.id}')">
                                            <i class="fas fa-location-arrow"></i><a>&nbsp;&nbsp;Ir</a>
                                        </div>

                                        <div class="dropdown-divider"></div>

                                        <div class="dropdown-item cursorPointer" onclick="createCarrusel('${bo.id}')">
                                            <i class="fas fa-camera"></i><a>&nbsp;&nbsp;Fotos</a>
                                        </div>
                                    </div>

                                </td>
                                <td>${bo.id}</td>
                                <td>${bo.name}</td>
                                <td id="${bo.id}-address">${bo.address}</td>
                                <td>${bo.localidad}</td>
                                <td>${bo.provincia}</td>
                                <td>${bo.description}</td>
                                <td id="${bo.id}-lat">${bo.lat}</td>
                                <td id="${bo.id}-lon">${bo.lon}</td>

                            </tr>

                        </c:forEach>

                    </tbody>

                </table>
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="modal-info-marker" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
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


<li class="nav-item more-options" style="display: none">
    <a class="nav-link" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        <i id="icon-close-menu" class="nc-icon nc-stre-left"></i>
        <span id="span-close-option" class="d-lg-block">&nbsp;Ocultar Menu</span>
    </a>
</li>

<form:form  action="search" modelAttribute="myWrapper">

    <input type="text" name="request.mapEmpresa" value="${ubicacionRequest.mapEmpresa}">

    <input name="request.mapElemento" type="text" value="${ubicacionRequest.mapElemento}">
    <input type="text" value="${ubicacionRequest.mapFormato}">
    <input type="text" value="${ubicacionRequest.mapMedio}">
    <input type="text" value="${ubicacionRequest.mapLocalidad}">
    <input type="text" value="${ubicacionRequest.mapProvincia}">
    <input type="text" value="${ubicacionRequest.bajaLogica}">
    <input type="text" value="${ubicacionRequest.langLongEmpty}">
    <input type="text" value="${ubicacionRequest.maxResults}">


    <button type="submit" class="nav-link" name="paginate">Volver</button>

</form:form>

<table class="table table-bordered table-data-ubicaciones hidden">
    <thead>
        <tr>
            <th>Empresa</th>
            <th>Direcci&oacute;n</th>
            <th>Elemento</th>
            <th>Formato</th>
        </tr>
    </thead>
</table>



<div class="modal" id="myModal2">
    <div class="modal-dialog  modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Subir Imagenes</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div><div class="container"></div>

            <div class="upload-container">
                <div class="upload-content">
                    <div class="single-upload">
                        <h3>Upload Single File</h3>
                        <form id="singleUploadForm" name="singleUploadForm">
                            <input id="singleFileUploadInput" type="file" name="file" class="file-input" required />
                            <button type="submit" class="primary submit-btn">Submit</button>
                        </form>
                        <div class="upload-response">
                            <div id="singleFileUploadError"></div>
                            <div id="singleFileUploadSuccess"></div>
                        </div>
                    </div>
                    <div class="multiple-upload">
                        <h3>Upload Multiple Files</h3>
                        <form id="multipleUploadForm" name="multipleUploadForm">
                            <input id="multipleFileUploadInput" type="file" name="files" class="file-input" multiple required />
                            <button type="submit" class="primary submit-btn">Submit</button>
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


<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">Desea modificar la geolocalizaci&oacute;n</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="modal-btn-si">Si</button>
                <button type="button" class="btn btn-primary" id="modal-btn-no">No</button>
            </div>
        </div>
    </div>
</div>

