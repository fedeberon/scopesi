<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title" style="text-align: center">Relevamiento Ubicacion ID: ${appUbicacion.id}</h4>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" >

                            <tbody>
                                <tr>
                                    <th>Nombre del relevamiento:</th>
                                    <td>${appUbicacion.idRelevamiento.nombreRelevamiento}</td>
                                </tr>
                                <tr>
                                    <th>Direccion:</th>
                                    <td>${appUbicacion.direccion}</td>
                                </tr>
                                <tr>
                                    <th>Latitud:</th>
                                    <td>${appUbicacion.latitud}</td>
                                </tr>
                                <tr>
                                    <th>Longitud:</th>
                                    <td>${appUbicacion.longitud}</td>
                                </tr>

                            </tbody>
                        </table>
                    </div>

                    <div class="py-2" style="text-align: center;">
                        <a class="btn btn-light" href="list"><i class="fas fa-angle-double-left pr-2"></i>Volver a la lista</a>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
<script>
    var element = document.getElementById("auditapp");
    element.classList.add("active");
</script>