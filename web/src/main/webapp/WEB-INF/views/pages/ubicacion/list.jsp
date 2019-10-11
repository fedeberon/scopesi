<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>

    .active{

        background-color: yellow;

    }

</style>

<div class="content">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="card strpied-tabled-with-hover">
                    <div class="card-header ">
                        <h4 class="card-title">Ubicaciones</h4>
                        <p class="card-category">Lista</p>
                    </div>
                    <div class="card-body table-full-width table-responsive">
                        <table id="example" class="display" style="width:100%">
                            <thead>
                            <th>ID</th>
                            <th>Empresa</th>
                            <th>Elemento</th>
                            <th>Formato</th>
                            <th>Medio</th>
                            <th>Direccion</th>
                            <th>Nro.Agip</th>
                            <th>Referencia</th>
                            <th>Nro.Anuncio</th>
                            <th>Localidad</th>
                            <th>Provincia</th>
                            <th>Anunciante</th>
                            <th>Cantidad</th>
                            <th>Transito</th>
                            <th>Iluminacion</th>
                            <th>Medidas</th>
                            <th>Metros Cuadrados</th>
                            <th>Direccion Normalizada</th>
                            <th>Latitud</th>
                            <th>Longitud</th>
                            <th>Metros Contacto</th>
                            <th>Coeficiente</th>
                            <th>Zona</th>
                            <th>Saturacion</th>
                            <th>Visibilidad</th>
                            <th>Circulacion Peatonal</th>
                            <th>Circulacion Vehicular</th>
                            <th>Id.Referencia</th>
                            <th>Buses</th>
                            <th>Baja Logica</th>
                            <th>Fecha de Tranferencia</th>
                            <th>Fecha de Alta</th>
                            <th>Id.Altura</th>
                            <th>Id.Visibilidad</th>
                            </thead>

                            <tbody>

                            <c:forEach items="${ubicaciones}" var="bo">

                                <tr>
                                    <td>${bo.id}</td>
                                    <td>${bo.audEmpresa.descripcion}</td>
                                    <td>${bo.mapElemento.descripcion}</td>
                                    <td>${bo.mapFormato.descripcion}</td>
                                    <td>${bo.mapMedio.descripcion}</td>
                                    <td>${bo.direccion}</td>
                                    <td>${bo.nroAgip}</td>
                                    <td>${bo.referencia}</td>
                                    <td>${bo.nroAnuncio}</td>
                                    <td>${bo.audLocalidad.descripcion}</td>
                                    <td>${bo.mapProvincia.descripcion}</td>
                                    <td>${bo.anunciante}</td>
                                    <td>${bo.cantidad}</td>
                                    <td>${bo.transito}</td>
                                    <td>${bo.iluminacion}</td>
                                    <td>${bo.medidas}</td>
                                    <td>${bo.m2}</td>
                                    <td>${bo.direccionNormalizada}</td>
                                    <td>${bo.latitud}</td>
                                    <td>${bo.longitud}</td>
                                    <td>${bo.metrosContacto}</td>
                                    <td>${bo.coeficiente}</td>
                                    <td>${bo.zona}</td>
                                    <td>${bo.saturacion}</td>
                                    <td>${bo.visibilidad}</td>
                                    <td>${bo.circulacionPeatonal}</td>
                                    <td>${bo.circulacionVehicular}</td>
                                    <td>${bo.idReferencia}</td>
<%--                                    <td>${bo.mapBuses.linea}/{bo.mapBuses.color}</td>--%>
                                    <td> - </td>
                                    <td>${bo.bajaLogica}</td>
                                    <td>${bo.fechaTransf}</td>
                                    <td>${bo.fechaAlta}</td>
                                    <td>${bo.mapUbicacionAltura.descripcion}</td>
                                    <td>${bo.mapUbicacionVisibilidad.descripcion}</td>
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
