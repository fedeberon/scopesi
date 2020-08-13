<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .card form [class*="col-"]:first-child {
        padding-left: 6px;
    }
    .card form [class*="col-"]:last-child {
        padding-right: 6px;
    }
</style>
<div class="content">
    <div class="col-12">
        <div class="card">
            <form:form action="update" modelAttribute="usuario" method="post">
                <form:hidden path="id" value='${username.id}'/>
                <div class="row ml-3">
                    <div class="col-md-11">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Usuario</label>
                                    <form:input  path="username" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Password</label>
                                    <form:input  path="password" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Nombre completo</label>
                                    <form:input  path="nombreCompleto" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">E-mail</label>
                                    <form:input  path="eMail" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Telefono</label>
                                    <form:input  path="telefono" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                </div>

                                <div class="col-6">
                                    <label for="street1_id" class="control-label pt-2">Tipo de Usuario</label>
                                    <select class="form-control" id="street1_id" name="tipoUsuario.id">
                                        <c:forEach items="${tiposUsuarios}" var="bo" varStatus="status">
                                            <option ${bo.descripcion == usuario.tipoUsuario.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Cargo</label>
                                    <form:input  path="cargo" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un cargo"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label pt-2">Contrato Inversion</label>
                                    <select class="form-control" id="street1_id" name="contratoInv.id">
                                        <c:forEach items="${contratos}" var="bo" varStatus="status">
                                            <option ${bo.descripcion == usuario.contratoInv.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label pt-2">Contrato Auditoria</label>
                                    <select class="form-control" id="street1_id" name="contratoAud.id">
                                        <c:forEach items="${contratos}" var="bo" varStatus="status">
                                            <option ${bo.descripcion == usuario.contratoAud.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label pt-2">Contrato Mapping</label>
                                    <select class="form-control" id="street1_id" name="contratoMap.id">
                                        <c:forEach items="${contratos}" var="bo" varStatus="status">
                                            <option ${bo.descripcion == usuario.contratoMap.descripcion ? 'selected' : ''} value="${bo.id}">${bo.descripcion}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <input type="hidden" name="estado" value="M"/>
                                <input type="hidden" name="mapAnunciante.id" value="0">
                                <input type="hidden" name="producto.id" value="0">
                            </div>
                        </div>
                        <a href="list" class="btn btn-light pull-left ml-3"><i class="fas fa-angle-double-left pr-2"></i>Volver</a>


                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-secondary btn-fill pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                            Guardar
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="top:180px; text-align: center;">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <h5>&iquest;Desea guardar los cambios?</h5>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="#" class="btn btn-light " data-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-secondary btn-fill">Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="clearfix"></div>
            </form:form>
        </div>
    </div>
</div>