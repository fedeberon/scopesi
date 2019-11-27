<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Empresa</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Empresa</th>
                            </thead>

                            <tbody>


                                <tr>
                                    <td>${empresa.id}</td>
                                    <td>${empresa.descripcion}</td>
                                </tr>


                            </tbody>
                        </table>
                        <a href="<c:url value='/empresa/updateBajaLogica?id=${empresa.id}'/>"
                        class="btn btn-primary"><i class="nc-icon nc-simple-remove"></i>&nbsp;Baja Logica</a>

                    </div>
                </div>
            </div>

        </div>
    </div>


</div>
