<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">POI</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <form:form action="search" modelAttribute="myWrapper" name="myWrapper" method="post">                        <table id="dataTable" class="display" style="width:100%">
                            <thead>
                            <th>
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input class="form-check-input" type="checkbox" value="">
                                        <span class="form-check-sign"></span>
                                    </label>
                                </div>
                            </th>
                            <th>ID</th>
                            <th>Descripcion</th>
                            <th>Entidad</th>
                            <th>Provincia</th>
                            <th>Latitud</th>
                            <th>Longitud</th>
                            <th>Icono</th>
                            <th class="text-center">Editar</th>
                            <th class="text-center">Estado Baja Logica</th>

                            </thead>

                            <tbody>

                            <c:forEach items="${pois}" var="bo" varStatus="status">

                                <tr>
                                    <td>
                                        <div class="form-check">
                                            <label class="form-check-label">
                                                <input class="form-check-input" type="checkbox" id="form-check-input-${bo.id}" name="list[${status.index}].checked">
                                                    <%--<form:checkbox cssClass="form-check-input"  path="list[${status.index}].checked"/>--%>
                                                <span class="form-check-sign" id="${bo.id}"></span>
                                            </label>
                                        </div>
                                    </td>
                                    <td>
                                        <a href="/poi/${bo.id}">${bo.id}</a>
                                        <input type="hidden" value="${bo.id}" name="list[${status.index}].id"/>

                                        <input type="hidden" value="${bo.descripcion}" name="list[${status.index}].name"/>

                                        <input type="hidden" value="" name="list[${status.index}].direccion"/>

                                        <input type="hidden" value="${bo.descripcion}" name="list[${status.index}].descripcion"/>
                                    </td>
                                    <td>${bo.descripcion}</td>


                                    <td>${bo.mapPoiEntidad.descripcion}</td>
                                    <td>${bo.mapProvincia.descripcion}</td>
                                    <td>
                                        ${bo.geoLatitud}
                                            <input type="hidden" value="${bo.geoLatitud}" name="list[${status.index}].lat"/>

                                    </td>
                                    <td>
                                        ${bo.geoLongitud}
                                            <input type="hidden" value="${bo.geoLongitud}" name="list[${status.index}].lon"/>
                                    </td>
                                    <td>${bo.icono}</td>
                                    <td class="text-center">
                                        <a href="<c:url value='/poi/update?id=${bo.id}'/>"/>
                                        <img src="\resources\assets\img\icons\edit2.png" alt="">
                                    </td>
                                    <td class="text-center">
                                        <a ${bo.bajaLogica == true ? 'class="d-none"' : ''} href="<c:url value='/poi/dropBajaLogica?id=${bo.id}'/>"/>
                                        <img ${bo.bajaLogica == true ? 'class="d-none"' : ''} src="/resources/assets/img/icons/delete.png" alt="">
                                        <a ${bo.bajaLogica == false ? 'class="d-none"' : ''} href="<c:url value='/poi/upBajaLogica?id=${bo.id}'/>"/>
                                        <img ${bo.bajaLogica == false ? 'class="d-none"' : ''} src="/resources/assets/img/icons/flechaUp.png" alt="">
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

                                        <a href="create" class="btn btn-info btn-fill"><i class=""></i>&nbsp;Nuevo</a>

                                    </form>
                                <button type="submit" name="maps" class="btn btn-primary"><i class="nc-icon nc-map-big"></i>&nbsp;Mapa</button>


                            </div>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>