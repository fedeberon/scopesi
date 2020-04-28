<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Modal -->
<div class="modal fade" id="optionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Datos a Cambiar</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
                <input type="hidden" name="page" value="${ubicacionRequest.page}"/>
                <div class="modal-body row">

                    <div class="form-group col-6">
                        <label for="idEmpresa">Empresas</label>
                        <select name="request.idEmpresa" class="form-control" title="Seleccione una empresa">
                            <c:forEach items="${empresas}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idElemento">Elementos</label>
                        <select name="request.idElemento" class="form-control" title="Seleccione un elemento">
                            <c:forEach items="${elementos}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idFormato">Formatos</label>
                        <select name="request.idFormato" items="${formatos}" class="form-control" title="Seleccione un formato">
                            <c:forEach items="${formatos}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idMedio">Medios</label>
                        <select name="request.idMedio" class="form-control" title="Seleccione un medio   ">
                            <c:forEach items="${medios}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idLocalidad">Localidadades</label>
                        <select name="request.idLocalidad" items="${localidades}" class="form-control" title="Seleccione una localidad">
                            <c:forEach items="${localidades}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idProvincia">Provincias</label>
                        <select name="request.idProvincia" items="${provincias}" class="form-control" title="Seleccione una provincia">
                            <c:forEach items="${provincias}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idAltura">Alturas</label>
                        <select name="request.idAltura" items="${alturas}" class="form-control" title="Seleccione una altura">
                            <c:forEach items="${alturas}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="idVisibilidades">Visibilidades</label>
                        <select name="request.idVisibilidades" items="${visibilidades}" class="form-control" title="Seleccione una visibilidad">
                            <c:forEach items="${visibilidades}" var="bo">
                                <option value="${bo.id}">${bo.descripcion}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group col-6">
                        <label for="metrosContactoRequest">Metros Contact</label>
                        <input type="number" name="request.metrosContactoRequest" class="form-control" title="Metros Contacto" placeholder="Ingrese metros de contacto">
                    </div>

                    <div class="form-group col-6">
                        <label for="coeficienteRequest">Metros Contact</label>
                        <input type="number" name="request.coeficienteRequest" class="form-control" title="Coeficiente" placeholder="Ingrese coeficiente">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>

                    <button name="saveList" type="submit" class="btn btn-primary"><i class="nc-icon nc-map-big"></i>&nbsp;Guardar resultados</button>
                </div>

        </div>
    </div>
</div>