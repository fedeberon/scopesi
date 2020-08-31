<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<script>
    var element = document.getElementById("usuarios");
    element.classList.add("active");
</script>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header">
                        <h4 class="card-title">Usuarios</h4>
                        <a class="" href="listComplete"><i class="fas fa-sort-amount-up"></i> Usuarios activos/inactivos</a>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="dataTableToCompleteList" class="display" style="width:100%">
                            <thead>
                                <th>ID</th>
                                <th class="text-center">Editar</th>
                                <th class="text-center">Baja/Alta</th>
                                <th>Usuario</th>
                                <th>Contrase&ntilde;a</th>
                                <th>Nombre Completo</th>
                                <th>Email</th>
                                <th>Telefono</th>
                                <th>Estado</th>
                                <th>Tipo de usuario</th>
                                <th>Cargo</th>
                                <th>C.Inversion</th>
                                <th>C.Auditoria</th>
                                <th>C.Mapping</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${usuarios}" var="bo">

                                <tr>
                                    <td><a href="/usuario/${bo.id}">${bo.id}</a></td>
                                    <td class="text-center">
                                        <a href="<c:url value='/usuario/update?id=${bo.id}'/>"/>
                                        <img src="/resources/assets/img/icons/edit2.png" alt="">
                                    </td>
                                    <td class="text-center">
                                        <a ${bo.estado == "B" ? 'class="d-none"' : ''} href="<c:url value='/usuario/dropState?id=${bo.id}'/>"/>
                                        <img ${bo.estado == "B" ? 'class="d-none"' : ''} src="/resources/assets/img/icons/delete.png" alt="">
                                        <a ${bo.estado == "A" || bo.estado == "M" ? 'class="d-none"' : ''} href="<c:url value='/usuario/upState?id=${bo.id}'/>"/>
                                        <img ${bo.estado == "A" || bo.estado == "M" ? 'class="d-none"' : ''} src="/resources/assets/img/icons/arrowUp2.png" alt="">
                                    </td>
                                    <td>${bo.username}</td>
                                    <td>${bo.password}</td>
                                    <td>${bo.nombreCompleto}</td>
                                    <td>${bo.eMail}</td>
                                    <td>${bo.telefono}</td>
                                    <td>${bo.estado}</td>
                                    <td>${bo.tipoUsuario.descripcion}</td>
                                    <td>${bo.cargo}</td>
                                    <td>${bo.contratoInv.descripcion}</td>
                                    <td>${bo.contratoAud.descripcion}</td>
                                    <td>${bo.contratoMap.descripcion}</td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                        <div class="row pt-4 px-2">
                            <div class="col-8">
                                <a href="create" class="btn btn-primary btn-fill"><i class="fas fa-plus"></i></i>&nbsp;Nuevo</a>

                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>
    </div>
</div>