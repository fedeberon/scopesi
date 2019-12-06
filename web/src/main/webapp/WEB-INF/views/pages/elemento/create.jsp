<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
<div class="col-12">
<div class="card">
<form:form action="addElemento" modelAttribute="elemento" method="post">
                            <div class="form-group ml-3 mr-3"> <!-- Street 1 -->
                                <div class="row">
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Descripcion</strong></label>
                                        <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                    </div>
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Pano</strong></label>
                                        <form:input  path="panos" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <label for="street2_id" class="control-label pt-2"><strong>Medio</strong></label>
                                        <select class="form-control" id="street2_id" name="mapMedio.id">
                                            <c:forEach items="${medios}" var="bo" varStatus="status">
                                                <option value="${bo.id}">${bo.descripcion}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Formato</strong></label>
                                        <select class="form-control" id="street1_id" name="mapFormato.id">
                                            <c:forEach items="${formatos}" var="bo" varStatus="status">
                                                <option value="${bo.id}">${bo.descripcion}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Acumula Datos</strong></label>
                                        <form:input  path="acumulaDatos" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                    </div>
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Evalua</strong></label>
                                        <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Metros de contacto</strong></label>
                                        <form:input  path="metrosContacto" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                    </div>
                                    <div class="col-6">
                                        <label for="street1_id" class="control-label pt-2"><strong>Coeficiente</strong></label>
                                        <form:input  path="coeficiente" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-left ml-3"><strong>Guardar</strong></button>






</form:form>
</div>
</div>
</div>