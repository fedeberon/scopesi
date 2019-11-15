<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-6 pt-3">

    <form:form action="addEmpresa" modelAttribute="empresa" method="post">


        <div class="form-group"> <!-- Street 1 -->
            <label for="street1_id" class="control-label">Descripcion</label>
            <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese una nueva empresa"/>
        </div>

        <div class="form-group"> <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Nueva Empresa</button>
        </div>

    </form:form>

</div>