<%--
  Created by IntelliJ IDEA.
  User: erwin
  Date: 15/03/21
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header">
                        <h4 class="card-title">Encuestas</h4>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="dataTableToCompleteList" class="display" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th class="text-center">Editar</th>
                            <th>Nombre</th>
                            <th>Link publicacion</th>
                            <th>Link edicion</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${encuestas}" var="bo">

                            <tr>
                                <td><a href="/encuesta/${bo.id}">${bo.id}</a></td>
                                <td class="text-center">
                                    <a href="<c:url value='/encuesta/update?id=${bo.id}'/>"/>
                                    <img src="/resources/assets/img/icons/edit2.png" alt="">
                                </td>
                                <td>${bo.nombreEncuesta}</td>
                                <td>${bo.linkPublicacion}</td>
                                <td>${bo.linkEdicion}</td>
                            </tr>

                            </c:forEach>
                        </table>

                        <div class="row pt-4 px-2">
                            <div class="col-6">
                                <tags:paginador page="${mapPoiRequest.page}" formName="myWrapper"/>

                                <a href="create" class="btn btn-primary btn-fill"><i class="fas fa-plus"></i>&nbsp;Nuevo</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script>
    var element = document.getElementById("auditapp");
    element.classList.add("active");

    $(document).ready(function(){

        var valueOfSearchingDataTable = sessionStorage['encuestaSearchDataTable'] || '';
        $('.dataTables_filter input[type="search"]').val(valueOfSearchingDataTable).keyup();

        $('.dataTables_filter input').unbind().keyup(function(e) {

            var valueSearchDataTable = $(this).val();
            if (valueSearchDataTable.length>=1) {
                dataTableToCompleteList.search(valueSearchDataTable).draw();
                sessionStorage['encuestaSearchDataTable'] = valueSearchDataTable;

            } else {
                dataTableToCompleteList.search('').draw();
                sessionStorage['encuestaSearchDataTable'] = "";
            }
        });

    });
</script>