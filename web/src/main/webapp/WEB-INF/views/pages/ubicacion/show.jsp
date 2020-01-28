<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title" style="text-align: center">Ubicacion: ${ubicaciones.id}</h4>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" >

                            <tbody>
                                <tr>
                                    <th>Empresa:</th>
                                    <td>${ubicaciones.mapEmpresa.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Elemento:</th>
                                    <td>${ubicaciones.mapElemento.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Formato:</th>
                                    <td>${ubicaciones.mapFormato.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Medio:</th>
                                    <td>${ubicaciones.mapMedio.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Direccion:</th>
                                    <td>${ubicaciones.direccion}</td>
                                </tr>
                                <tr>
                                    <th>Nro Agip:</th>
                                    <td>${ubicaciones.nroAgip}</td>
                                </tr>
                                <tr>
                                    <th>Referencia:</th>
                                    <td>${ubicaciones.referencia}</td>
                                </tr>
                                <tr>
                                    <th>Provincia:</th>
                                    <td>${ubicaciones.mapProvincia.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Localidad:</th>
                                    <td>${ubicaciones.mapLocalidad.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Cantidad:</th>
                                    <td>${ubicaciones.cantidad}</td>
                                </tr>
                                <tr>
                                    <th>Transito:</th>
                                    <td>${ubicaciones.transito}</td>
                                </tr>
                                <tr>
                                    <th>Iluminacion:</th>
                                    <td>${ubicaciones.iluminacion}</td>
                                </tr>
                                <tr>
                                    <th>Medidas:</th>
                                    <td>${ubicaciones.medidas}</td>
                                </tr>
                                <tr>
                                    <th>Direccion normalizada:</th>
                                    <td>${ubicaciones.direccionNormalizada}</td>
                                </tr>
                                <tr>
                                    <th>Latitud:</th>
                                    <td>${ubicaciones.latitud}</td>
                                </tr>
                                <tr>
                                    <th>Longitud:</th>
                                    <td>${ubicaciones.longitud}</td>
                                </tr>
                                <tr>
                                    <th>Metros contacto:</th>
                                    <td>${ubicaciones.metrosContacto}</td>
                                </tr>
                                <tr>
                                    <th>Coeficiente:</th>
                                    <td>${ubicaciones.coeficiente}</td>
                                </tr>
                                <tr>
                                    <th>ID.Referencia:</th>
                                    <td>${ubicaciones.idReferencia}</td>
                                </tr>
                                <tr>
                                    <th>Bus:</th>
                                    <td>${ubicaciones.mapBuses.linea}</td>
                                </tr>
                                <tr>
                                    <th>Baja logica:</th>
                                    <td>${ubicaciones.bajaLogica}</td>
                                </tr>
                                <tr>
                                    <th>Fecha transf:</th>
                                    <td>${ubicaciones.fechaTransf}</td>
                                </tr>
                                <tr>
                                    <th>Fecha alta:</th>
                                    <td>${ubicaciones.fechaAlta}</td>
                                </tr>
                                <tr>
                                    <th>Ubicacion altura:</th>
                                    <td>${ubicaciones.mapUbicacionAltura.descripcion}</td>
                                </tr>
                                <tr>
                                    <th>Ubicacion visibilidad:</th>
                                    <td>${ubicaciones.mapUbicacionVisibilidad.descripcion}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="py-2" style="text-align: center;">
                        <a class="btn btn-primary" href="list">Volver a la lista</a>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
