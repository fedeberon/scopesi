<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Ubicaciones</h4>
                        <p class="card-category">lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="table table-hover table-striped" >
                            <thead>
                            <th>Empresa</th>
                            <th>Elemento</th>
                            <th>Formato</th>
                            <th>Medio</th>
                            <th>Direccion</th>
                            <th>Nro Agip</th>

                            </thead>

                            <tbody>
                                <tr>
                                    <td>${ubicaciones.mapEmpresa.descripcion}</td>
                                    <td>${ubicaciones.mapElemento.descripcion}</td>
                                    <td>${ubicaciones.mapFormato.descripcion}</td>
                                    <td>${ubicaciones.mapMedio.descripcion}</td>
                                    <td>${ubicaciones.direccion}</td>
                                    <td>${ubicaciones.nroAgip}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example1" class="table table-hover table-striped" >
                            <thead>
                            <th>Referencia</th>
                            <th>Nro_Anuncio</th>
                            <th>Provincia</th>
                            <th>Localidad</th>
                            <th>Anunciante</th>
                            </thead>

                            <tbody>
                            <tr>
                                <td>${ubicaciones.anunciante}</td>
                                <td>${ubicaciones.referencia}</td>
                                <td>${ubicaciones.nroAnuncio}</td>
                                <td>${ubicaciones.mapProvincia.descripcion}</td>
                                <td>${ubicaciones.audLocalidad.descripcion}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example2" class="table table-hover table-striped" >
                            <thead>

                            <th>Cantidad</th>
                            <th>Transito</th>
                            <th>Iluminacion</th>
                            <th>Medidas</th>
                            <th>Metros Cuadrados</th>
                            <th>Direccion Normalizada</th>
                            <th>Latitud</th>
                            <th>Longitud</th>
                            <th>Metros Contacto</th>
                            </thead>

                            <tbody>
                            <tr>

                                <td>${ubicaciones.cantidad}</td>
                                <td>${ubicaciones.transito}</td>
                                <td>${ubicaciones.iluminacion}</td>
                                <td>${ubicaciones.medidas}</td>
                                <td>${ubicaciones.m2}</td>
                                <td>${ubicaciones.direccionNormalizada}</td>
                                <td>${ubicaciones.latitud}</td>
                                <td>${ubicaciones.longitud}</td>
                                <td>${ubicaciones.metrosContacto}</td>

                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example3" class="table table-hover table-striped" >
                            <thead>
                            <th>Coeficiente</th>
                            <th>Zona</th>
                            <th>Saturacion</th>
                            <th>Visibilidad</th>
                            <th>Circulacion Peatonal</th>
                            <th>Circulacion Vehicular</th>
                            <th>Referencia</th>
                            <th>Buses</th>
                            <th>Baja Logica</th>
                           </thead>

                            <tbody>
                            <tr>
                                <td>${ubicaciones.coeficiente}</td>
                                <td>${ubicaciones.zona}</td>
                                <td>${ubicaciones.saturacion}</td>
                                <td>${ubicaciones.visibilidad}</td>
                                <td>${ubicaciones.circulacionPeatonal}</td>
                                <td>${ubicaciones.circulacionVehicular}</td>
                                <td>${ubicaciones.idReferencia}</td>
                                <td>${ubicaciones.mapBuses.descripcion}</td>
                                <td>${ubicaciones.bajaLogica}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example4" class="table table-hover table-striped" >
                            <thead>
                            <th>Fecha Transf</th>
                            <th>Fecha Alta</th>
                            <th>Ubicacion Altura</th>
                            <th>Ubicacion visibilidad</th>
                            </thead>

                            <tbody>
                            <tr>
                                <td>${ubicaciones.fechaTransf}</td>
                                <td>${ubicaciones.fechaAlta}</td>
                                <td>${ubicaciones.mapUbicacionAltura.descripcion}</td>
                                <td>${ubicaciones.mapUbicacionVisibilidad.descripcion}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
