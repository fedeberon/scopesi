<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Usuarios</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table class="table table-hover table-striped">
                            <thead>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Nombre Completo</th>
                            <th>Email</th>
                            <th>Telefono</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${users}" var="bo">

                                <tr>
                                    <td>1</td>
                                    <td>${bo.username}</td>
                                    <td>${bo.nombreCompleto}</td>
                                    <td>${bo.eMail}</td>
                                    <td>${bo.telefono}</td>
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