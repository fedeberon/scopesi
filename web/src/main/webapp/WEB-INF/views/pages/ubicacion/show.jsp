<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title" style="text-align: center">Ubicacion: ${ubicacion.id}</h4>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" >

                            <tbody>
                                <tr>
                                    <th>Empresa:</th>
                                    <td>${ubicacion.mapEmpresa.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Elemento:</th>
                                    <td>${ubicacion.mapElemento.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Formato:</th>
                                    <td>${ubicacion.mapFormato.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Medio:</th>
                                    <td>${ubicacion.mapMedio.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Direccion:</th>
                                    <td>${ubicacion.direccion}</td>
                                </tr>
                                <tr>
                                    <th>Nro Agip:</th>
                                    <td>${ubicacion.nroAgip}</td>
                                </tr>
                                <tr>
                                    <th>Referencia:</th>
                                    <td>${ubicacion.referencia}</td>
                                </tr>
                                <tr>
                                    <th>Provincia:</th>
                                    <td>${ubicacion.mapProvincia.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Localidad:</th>
                                    <td>${ubicacion.mapLocalidad.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Cantidad:</th>
                                    <td>${ubicacion.cantidad}</td>
                                </tr>
                                <tr>
                                    <th>Transito:</th>
                                    <td>${ubicacion.transito}</td>
                                </tr>
                                <tr>
                                    <th>Iluminacion:</th>
                                    <td>${ubicacion.iluminacion}</td>
                                </tr>
                                <tr>
                                    <th>Medidas:</th>
                                    <td>${ubicacion.medidas}</td>
                                </tr>
                                <tr>
                                    <th>Direccion normalizada:</th>
                                    <td>${ubicacion.direccionNormalizada}</td>
                                </tr>
                                <tr>
                                    <th>Latitud:</th>
                                    <td>${ubicacion.latitud}</td>
                                </tr>
                                <tr>
                                    <th>Longitud:</th>
                                    <td>${ubicacion.longitud}</td>
                                </tr>
                                <tr>
                                    <th>Metros contacto:</th>
                                    <td>${ubicacion.metrosContacto}</td>
                                </tr>
                                <tr>
                                    <th>Coeficiente:</th>
                                    <td>${ubicacion.coeficiente}</td>
                                </tr>
                                <tr>
                                    <th>ID.Referencia:</th>
                                    <td>${ubicacion.idReferencia}</td>
                                </tr>
                                <tr>
                                    <th>Bus:</th>
                                    <td>${ubicacion.mapBuses.linea}</td>
                                </tr>
                                <tr>
                                    <th>Baja logica:</th>
                                    <td>${ubicacion.bajaLogica}</td>
                                </tr>
                                <tr>
                                    <th>Fecha transf:</th>
                                    <td>${ubicacion.fechaTransf}</td>
                                </tr>
                                <tr>
                                    <th>Fecha alta:</th>
                                    <td>${ubicacion.fechaAlta}</td>
                                </tr>
                                <tr>
                                    <th>Ubicacion altura:</th>
                                    <td>${ubicacion.mapUbicacionAltura.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Ubicacion visibilidad:</th>
                                    <td>${ubicacion.mapUbicacionVisibilidad.descripcion}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <form:form action="/ubicacion/search" modelAttribute="myWrapper">
                        <form:hidden path="request.id"/>
                        <form:hidden path="request.idsSearch"/>
                        <form:hidden path="request.mapEmpresa"/>
                        <form:hidden path="request.mapElemento"/>
                        <form:hidden path="request.mapFormato"/>
                        <form:hidden path="request.mapMedio"/>
                        <form:hidden path="request.mapLocalidad"/>
                        <form:hidden path="request.mapProvincia"/>
                        <form:hidden path="request.bajaLogica"/>
                        <form:hidden path="request.latLngEmpty"/>
                        <form:hidden path="request.fechaAlta"/>
                        <form:hidden path="request.searchValue"/>
                        <form:hidden path="request.maxResults"/>

                    <div class="py-2" style="text-align: center;">
                        <button type="submit" name="paginate" class="btn btn-info btn-fill"><i class="fas fa-angle-double-left pr-2"></i>Volver a la lista</button>
                    </div>

                    </form:form>
                </div>
            </div>

        </div>

    </div>
</div>
