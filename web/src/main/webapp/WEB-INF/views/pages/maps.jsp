<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    }

    .hidden{
        display: none;
    }

</style>

<script>


</script>

<div class="container">

<div class="map-container">
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

    <img id="arrowUp" src="/assets/img/icons/arrowUp.png" style="margin-top: -30px;z-index: 500;">
    <img id="arrowDown" src="/assets/img/icons/arrowDown.png" style="margin-top: -30px; display: none">

    <div class="container-fluid">
        <div class="row">
            <div class="col-12">
                <table class="table display" id="table-markers">
                    <thead>
                        <th>id</th>
                        <th>name</th>
                        <th>address</th>
                        <th>description</th>
                        <th>lat</th>
                        <th>long</th>
                        <th>show/hide</th>
                        <th>touch</th>
                        <th>go to</th>
                    </thead>
                    <tbody>

                    <c:forEach items="${ubicaciones}" var="bo">

                        <tr>
                            <td>${bo.id}</td>
                            <td>${bo.name}</td>
                            <td>${bo.address}</td>
                            <td>${bo.description}</td>
                            <td>${bo.lat}</td>
                            <td>${bo.lon}</td>
                            <td>
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="checkbox" value="">
                                        <span class="form-check-sign" onclick="displayMarkers(${bo.id})"></span>
                                    </label>
                                </div>
                            </td>

                            <td>
                                <i class="nc-icon nc-tap-01" id="marker-touch-${bo.id}" onclick="toggleBounce(${bo.id})"></i>
                            </td>


                            <td>
                                <i class="nc-icon nc-square-pin" onclick="centerFromMarker(${bo.id})"></i>
                            </td>


                            <td>
                                <button onclick="showImages()" class="btn btn-primary">Imagenes</button>
                            </td>
                        </tr>

                    </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
    </div>
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

                <div class="modal-body">




                </div>
                <div class="modal-footer">
                    <button onclick="showImages()" class="btn btn-primary">Imagenes</button>

                    <button type="file" class="btn btn-primary">Subir Imagen</button>

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



<table class="table table-bordered table-data-ubicaciones">
    <thead>
        <tr>
            <th>Empresa</th>
            <th>Direcci&oacute;n</th>
            <th>Elemento</th>
            <th>Formato</th>
        </tr>
    </thead>
</table>

