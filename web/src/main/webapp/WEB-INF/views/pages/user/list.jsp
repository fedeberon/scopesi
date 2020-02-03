<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<script>
    var element = document.getElementById("users");
    element.classList.add("active");
</script>

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
                        <table id="dataTable" class="display" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Nombre Completo</th>
                            <th>Email</th>
                            <th>Telefono</th>
                            <th>Enviar crendeciales</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${users}" var="bo">

                                <tr>
                                    <td><a href="/user/${bo.id}">${bo.id}</a></td>
                                    <td>${bo.username}</td>
                                    <td>${bo.nombreCompleto}</td>
                                    <td>${bo.eMail}</td>
                                    <td>${bo.telefono}</td>
                                    <td class="text-center">
                                        <i onclick="sendMailCredentialsTo(${bo.id})"  class="far fa-envelope"></i>
                                    </td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                        <div class="row pt-4 px-2">
                            <div class="col-6">

                                <form name="search" action="list" method="get">
                                    <input type="hidden" name="page" value="${page}"/>

                                    <tags:paginador page="${page}" formName="search"/>

                                </form>

                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>