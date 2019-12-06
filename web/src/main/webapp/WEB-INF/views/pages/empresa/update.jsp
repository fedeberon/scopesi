<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="content">
<div class="col-6">
<div class="card">
        <form:form action="addEmpresa" modelAttribute="empresa" method="post">
            <form:hidden path="id" value='${empresa.id}'/>
                <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <label for="street1_id" class="control-label">DESCRIPCION</label>
                        <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Street address, P.O. box, company name, c/o"/>
                    </div>
                    <button type="submit" class="btn btn-info btn-fill pull-left ">Editar</button>
                </div>
                </div>
            <div class="clearfix"></div>
        </form:form>
</div>
</div>
</div>