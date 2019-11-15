<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-6 pt-3">
<form:form action="addElemento" modelAttribute="elemento" method="post">

    <div class="content">
        <div class="container-fluid">
            <div class="row">
                        <div class="col-md-6">
                            <div class="form-group"> <!-- Street 1 -->
                                <label for="street1_id" class="control-label pt-2">Descripcion</label>
                                <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

                                <label for="street1_id" class="control-label pt-2">Pano</label>
                                <form:input  path="panos" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

                                <label for="street1_id" class="control-label pt-2">Medio</label>
                                <select class="form-control" id="street1_id" name="mapMedio.id">
                                    <c:forEach items="${medios}" var="bo" varStatus="status">
                                        <option value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>

                                <label for="street1_id" class="control-label pt-2">Formato</label>
                                <select class="form-control" id="street1_id" name="mapFormato.id">
                                    <c:forEach items="${formatos}" var="bo" varStatus="status">
                                        <option value="${bo.id}">${bo.descripcion}</option>
                                    </c:forEach>
                                </select>

                                <label for="street1_id" class="control-label pt-2">Acumula Datos</label>
                                <form:input  path="acumulaDatos" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

                                <label for="street1_id" class="control-label pt-2">Evalua</label>
                                <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

                                <label for="street1_id" class="control-label pt-2">Metros de contacto</label>
                                <form:input  path="metrosContacto" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

                                <label for="street1_id" class="control-label pt-2">Coeficiente</label>
                                <form:input  path="coeficiente" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>

                            </div>

                            <div class="form-group"> <!-- Submit Button -->
                                <button type="submit" class="btn btn-primary">Nuevo Formato</button>
                            </div>
                        </div>

            </div>
        </div>
    </div>

</form:form>