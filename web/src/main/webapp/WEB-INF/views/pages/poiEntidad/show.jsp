<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">POI Entidad</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Sector</th>
                            <th>Descripcion</th>
                            <th>Baja Logica</th>
                            </thead>

                            <tbody>


                            <tr>
                                <td>${poiEntidades.id}</td>
                                <td>${poiEntidades.mapPoiSector.descripcion}</td>
                                <td>${poiEntidades.descripcion}</td>
                                <td>${poiEntidades.bajaLogica}</td>
                            </tr>


                            </tbody>
                        </table>

                        <a href="<c:url value='/poiEntidad/updateBajaLogica?id=${poiEntidades.id}'/>"
                           class="btn btn-primary"><i class="nc-icon nc-simple-remove"></i>&nbsp;Baja Logica</a>

                        <a href="list" class="btn btn-primary"><i class="nc-icon nc-map-big"></i>Volver a la lista</a>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
