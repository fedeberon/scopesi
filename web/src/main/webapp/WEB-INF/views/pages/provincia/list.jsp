<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

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
                        <table id="dataTable" class="display" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Descripcion</th>
                            <th>Evalua</th>
                            <th class="text-center">Editar</th>
                            <th class="text-center">Estado Baja Logica</th>

                            </thead>

                            <tbody>

                            <c:forEach items="${provincias}" var="bo">

                                <tr>
                                    <td><a href="/provincia/${bo.id}">${bo.id}</a></td>
                                    <td>${bo.descripcion}</td>
                                    <td>${bo.evalua}</td>
                                    <td class="text-center">
                                        <a href="<c:url value='/provincia/update?id=${bo.id}'/>"/>
                                        <img src="\resources\assets\img\icons\edit2.png" alt="">
                                    </td>
                                    <td class="text-center">
                                        <a ${bo.bajaLogica == true ? 'class="d-none"' : ''} href="<c:url value='/provincia/dropBajaLogica?id=${bo.id}'/>"/>
                                        <img ${bo.bajaLogica == true ? 'class="d-none"' : ''} src="\resources\assets\img\icons\delete.png" alt="">
                                        <a ${bo.bajaLogica == false ? 'class="d-none"' : ''} href="<c:url value='/provincia/upBajaLogica?id=${bo.id}'/>"/>
                                        <img ${bo.bajaLogica == false ? 'class="d-none"' : ''} src="" alt="">
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

                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>