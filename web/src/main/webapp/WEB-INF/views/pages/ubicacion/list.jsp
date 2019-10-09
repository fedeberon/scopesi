<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Ubicaciones</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                            <th>ID</th>
                            <th>Empresa</th>
                            <th>Elemento</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${ubicaciones}" var="bo">

                                <tr>
                                    <td>${bo.id}</td>
                                    <td>${bo.audEmpresa.descripcion}</td>
                                    <td>${bo.mapElemento.descripcion}</td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>