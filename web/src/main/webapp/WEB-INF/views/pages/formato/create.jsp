<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="col-6 pt-3">
    <form:form action="addFormato" modelAttribute="formato" method="post">
    
    
        <div class="form-group"> <!-- Street 1 -->
            <label for="street1_id" class="control-label pt-2">Descripcion</label>
            <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
            <label for="street1_id" class="control-label pt-2">Evalua</label>
            <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
        </div>
    
        <div class="form-group"> <!-- Submit Button -->
            <button type="submit" class="btn btn-primary">Nuevo Formato</button>
        </div>
    
    </form:form>
</div>