<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Elemento</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="dataTable" class="display" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Descripcion</th>
                            <th>Panos</th>
                            <th>IdMedio</th>
                            <th>IdFormato</th>
                            <th>AcumulaDatos</th>
                            <th>Evalua</th>
                            <th>MetrosContacto</th>
                            <th>Coeficiente</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${elementos}" var="bo">

                                <tr>
                                    <td><a href="/elemento/${bo.id}">${bo.id}</a></td>
                                    <td>${bo.descripcion}</td>
                                    <td>${bo.panos}</td>
                                    <td>${bo.mapMedio.descripcion}</td>
                                    <td>${bo.mapFormato.descripcion}</td>
                                    <td>${bo.acumulaDatos}</td>
                                    <td>${bo.evalua}</td>
                                    <td>${bo.metrosContacto}</td>
                                    <td>${bo.coeficiente}</td>

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
