<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header">
                        <h4 class="card-title">Relevamiento Ubicacion</h4>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <form:form action="search" modelAttribute="myWrapper" name="myWrapper" id="myWrapper" method="post">
                        <table id="dataTableToCompleteList" class="display" style="width:100%">
                            <thead>
                                <th>
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input type="checkbox" value=""  id="checkbox-all" onclick="selectAll()">
                                            <span class="form-check-sign"></span>
                                        </label>
                                    </div>
                                </th>
                                <th>ID</th>
                                <th class="text-center">Editar</th>
                                <th>Relevamiento</th>
                                <th>Direccion</th>
                                <th>Latitud</th>
                                <th>Longitud</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${ubicaciones}" var="bo" varStatus="status">

                            <tr>
                                <td>
                                    <div class="form-check">
                                        <label class="form-check-label">
                                            <input class="form-check-input" type="checkbox" id="form-check-input-${bo.id}" name="list[${status.index}].checked">
                                            <span class="form-check-sign" id="${bo.id}"></span>
                                        </label>
                                    </div>
                                </td>
                                <td>
                                    <a href="/appUbicacion/${bo.id}">${bo.id}</a>
                                    <input type="hidden" value="${bo.id}" name="list[${status.index}].id"/>
                                </td>
                                <td class="text-center">
                                    <a href="<c:url value='/appUbicacion/update?id=${bo.id}'/>"/>
                                    <img src="/resources/assets/img/icons/edit2.png" alt="">
                                </td>
                                <td>
                                    ${bo.idRelevamiento.nombreRelevamiento}
                                    <input type="hidden" value="${bo.idRelevamiento.nombreRelevamiento}" name="list[${status.index}].description"/>
                                </td>
                                <td>
                                    ${bo.direccion}
                                    <input type="hidden" value="${bo.direccion}" name="list[${status.index}].address"/>
                                </td>
                                <td>
                                    ${bo.latitud}
                                    <input type="hidden" value="${bo.latitud}" name="list[${status.index}].latitud"/>
                                </td>
                                <td>
                                    ${bo.longitud}
                                    <input type="hidden" value="${bo.longitud}" name="list[${status.index}].longitud"/>
                                </td>
                            </tr>

                            </c:forEach>
                        </table>

                        <div class="col-8">

                            <a href="create" class="btn btn-primary btn-fill"><i class="fas fa-plus"></i>&nbsp;Nuevo</a>

                            <button type="submit" name="maps" class="btn btn-info btn-fill"><i class="fas fa-map-marker-alt"></i>&nbsp;Mapa</button>

                        </div>
                        </form:form>
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

        var valueOfSearchingDataTable = sessionStorage['appUbicacionSearchDataTable'] || '';
        $('.dataTables_filter input[type="search"]').val(valueOfSearchingDataTable).keyup();

        $('.dataTables_filter input').unbind().keyup(function(e) {

            var valueSearchDataTable = $(this).val();
            if (valueSearchDataTable.length>=1) {
                dataTableToCompleteList.search(valueSearchDataTable).draw();
                sessionStorage['appUbicacionSearchDataTable'] = valueSearchDataTable;

            } else {
                dataTableToCompleteList.search('').draw();
                sessionStorage['appUbicacionSearchDataTable'] = "";
            }
        });

    });
</script>