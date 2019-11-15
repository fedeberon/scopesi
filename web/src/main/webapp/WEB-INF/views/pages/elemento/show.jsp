<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Empresa</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="display" style="width:100%">
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


                            <tr>
                                <td>${elemento.id}</td>
                                <td>${elemento.descripcion}</td>
                                <td>${elemento.panos}</td>
                                <td>${elemento.mapMedio.descripcion}</td>
                                <td>${elemento.mapFormato.descripcion}</td>
                                <td>${elemento.acumulaDatos}</td>
                                <td>${elemento.evalua}</td>
                                <td>${elemento.metrosContacto}</td>
                                <td>${elemento.coeficiente}</td>
                            </tr>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
