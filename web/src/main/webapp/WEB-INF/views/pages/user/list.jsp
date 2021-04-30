<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<script>
    var element = document.getElementById("users");
    element.classList.add("active");

    $(document).ready(function(){

        var valueOfSearchingDataTable = sessionStorage['usuarioSearchDataTable'] || '';
        $('.dataTables_filter input[type="search"]').val(valueOfSearchingDataTable).keyup();

        $('.dataTables_filter input').unbind().keyup(function(e) {

            var valueSearchDataTable = $(this).val();
            if (valueSearchDataTable.length>=1) {
                dataTableToCompleteList.search(valueSearchDataTable).draw();
                sessionStorage['usuarioSearchDataTable'] = valueSearchDataTable;

            } else {
                dataTableToCompleteList.search('').draw();
                sessionStorage['usuarioSearchDataTable'] = "";
            }
        });

    });
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
                                <th>Fotos</th>
                                <th class="text-center">Editar</th>
                                <th class="text-center">Baja/Alta</th>
                                <th>Usuario</th>
                                <th>Contrase&ntilde;a</th>
                                <th>Nombre Completo</th>
                                <th>Email</th>
                                <th>Telefono</th>
                                <th>Estado</th>
                                <th>Tipo de usuario</th>
                                <th>Empresa</th>
                                <th>C.Inversion</th>
                                <th>C.Auditoria</th>
                                <th>C.Mapping</th>
                                <th>Fecha Vencimiento</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${usuarios}" var="bo">

                                <tr>
                                    <td><a href="/usuario/${bo.id}">${bo.id}</a></td>
                                    <td class="text-center">
                                        <a href="<c:url value='/usuario/update?id=${bo.id}'/>"/>
                                        <img src="/resources/assets/img/icons/edit2.png" alt="">
                                    </td>
                                    <td>
                                        <div ${bo.tipoUsuario.id == 5 ? 'class="text-center cursorPointer"' : 'class="d-none"'} onclick="createCarouselUser('${bo.id}' )">
                                            <i class="fas fa-camera"></i>
                                        </div>
                                        <span ${bo.tipoUsuario.id == 5 ? 'class="d-none"' : ''}> - </span>
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
                                    <td>${bo.fechaVencimiento}</td>
                                </tr>

                            </c:forEach>

                            </tbody>
                        </table>
                        <div class="row pt-4 px-2">
                            <div class="col-8">
                                <a href="create" class="btn btn-primary btn-fill"><i class="fas fa-plus"></i>&nbsp;Nuevo</a>

                            </div>
                        </div>
                        <div class="data-auditapp"></div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>