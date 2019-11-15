<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form action="addLocalidad" modelAttribute="localidad" method="post">

    <div class="form-group"> <!-- Street 1 -->
        <label  class="control-label">DESCRIPCION</label>
        <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
        <label class="control-label">PROVINCIA</label>
        <select class="form-control" id="street1_id" name="audProvincia.id">
            <c:forEach items="${provincias}" var="bo" varStatus="status">
                <option value="${bo.id}">${bo.descripcion}</option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Nueva Localidad</button>
    </div>

</form:form>