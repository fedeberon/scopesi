<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Provincias</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Elemento</th>
                            <th>Evalua</th>
                            </thead>

                            <tbody>


                            <tr>
                                <td>${provincia.id}</td>
                                <td>${provincia.descripcion}</td>
                                <td>${provincia.evalua}</td>
                            </tr>


                            </tbody>
                        </table>
                        <a href="list" class="btn btn-primary"><i class="nc-icon nc-map-big"></i>&nbsp;Volver</a>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
