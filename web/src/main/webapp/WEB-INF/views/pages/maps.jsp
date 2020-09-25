<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>

    .modal-content {
        margin-top: 0px;
    }

    .marker-touched{
        background-color: #6dfea9;
        border: 0.1px solid #cabdbd;
        text-align: center;
    }


    .table-ubicaciones{
        position: absolute;
        margin-top: -150px;
        background-color: white;
        opacity: 0.8;
        min-width: 98%;
        width: 98%;
        height: 52%;
        overflow: scroll;
        border-radius: 3px;
        margin-left: 1vh;
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

    .confirm-modal{
        margin-top: 124px;
        z-index: 100000;
    }
</style>

<div class="">

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
        <img id="arrowUp" src="/resources/assets/img/icons/arrowUp.png" style="width:3%; z-index: 500;">
        <img id="arrowDown" src="/resources/assets/img/icons/arrowDown.png" style="width:4%; display: none">

        <table class="table" id="table-markers">
            <thead>
                <th>opciones</th>
                <th>Resaltar pin</th>
                <th>GeoReferenciar</th>
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

                                <div class="dropdown-item cursorPointer" onclick="modificarCoordenadas('${bo.id}')">
                                <i class="fas fa-map-marker-alt"></i><a>&nbsp;&nbsp;Ubicar punto</a>
                                </div>

                                <div class="dropdown-divider"></div>

                                <div class="dropdown-item cursorPointer" id="icon-view-marker-${bo.id}" onclick="displayMarkers(this, '${bo.id}')">
                                    <i class="far fa-eye-slash"></i><a>&nbsp;&nbsp;Ocultar pin</a>
                                </div>

                                <div class="dropdown-divider"></div>

                                <div class="dropdown-item cursorPointer" onclick="centerFromMarker('${bo.id}')">
                                    <i class="fas fa-location-arrow"></i><a>&nbsp;&nbsp;Ir</a>
                                </div>

                                <div class="dropdown-divider"></div>

                                <div class="dropdown-item cursorPointer" onclick="createCarrusel('${bo.id}')">
                                    <i class="fas fa-camera"></i><a>&nbsp;&nbsp;Fotos</a>
                                </div>

                                <div class="dropdown-divider"></div>

                                <div class="dropdown-item cursorPointer" onclick="initPolygon(this,'${bo.id}')">
                                    <i class="fas fa-eye"></i><a>&nbsp;&nbsp;Ver poligono</a>
                                    <input type="hidden" id="pol-${bo.id}" value='${bo.polygonCoordinates}'>
                                </div>

                                <div class="dropdown-divider"></div>

                                <div class="dropdown-item cursorPointer" onclick="initDrawingControl(this, '${bo.id}')">
                                    <i class="fas fa-draw-polygon"></i><a>&nbsp;&nbsp;Asignar poligono</a>
                                </div>
                            </div>

                        </td>
                        <td>
                            <div class="dropdown-item cursorPointer" style="text-align: center;" id="marker-touch-${bo.id}" onclick="toggleBounce('${bo.id}')">
                                <i class="nc-icon nc-tap-01 pr-0" style="font-size: 24px"></i>
                            </div>
                        </td>
                        <td>
                            <i class="fas fa-sync dropdown-item cursorPointer" style="text-align: center; font-weight: 900;" id="${bo.id}-update" onclick="actualizarCoordenadas('${bo.address}','${bo.localidad}','${bo.provincia}', '${bo.id}')"></i>
                            <button id="${bo.id}-save" onclick="guardarCoordenadas('${bo.id}');" class="btn btn-danger hidden btn-fill">Guardar</button>
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

            <div style="text-align: center">
                <button type="submit" name="paginate" class="btn btn-secondary btn-fill"><i class="fas fa-angle-double-left pr-2"></i> Volver</button>
            </div>
        </form:form>
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
                        <form id="singleUploadFormMap" name="singleUploadFormMap">
                            <input id="singleFileUploadInputMap" type="file" name="file" class="file-input" required />
                            <button type="submit" class="primary submit-btn">Submit</button>
                        </form>
                        <div class="upload-response">
                            <div id="singleFileUploadErrorMap"></div>
                            <div id="singleFileUploadSuccessMap"></div>
                        </div>
                    </div>
                    <div class="multiple-upload">
                        <h3>Upload Multiple Files</h3>
                        <form id="multipleUploadFormMap" name="multipleUploadFormMap">
                            <input id="multipleFileUploadInputMap" type="file" name="files" class="file-input" multiple required />
                            <button type="submit" class="primary submit-btn">Submit</button>
                        </form>
                        <div class="upload-response">
                            <div id="multipleFileUploadErrorMap"></div>
                            <div id="multipleFileUploadSuccessMap"></div>
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
                <h4 class="modal-title" id="myModalLabel">&iquest;Desea modificar la geolocalizaci&oacute;n?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="modal-btn-si">Si</button>
                <button type="button" class="btn btn-primary" id="modal-btn-no">No</button>
            </div>
        </div>
    </div>
</div>

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

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modal-confirm-polyg">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" style="margin-top: 0px;" id="myModalLabel">&iquest;Desea guardar los datos del pol&iacute;gono?</h4>
            </div>
            <div class="modal-body" style="text-align: center" id="info"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="modal-btn3-si">Si</button>
                <button type="button" class="btn btn-primary" id="modal-btn3-no">No</button>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value='/resources/assets/js/filemanager.js'/>"></script>
<script>
    var element = document.getElementById("geoplanning");
    element.classList.add("active");
</script>