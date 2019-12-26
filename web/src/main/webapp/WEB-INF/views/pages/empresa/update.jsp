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
        <form:form action="addEmpresa" modelAttribute="empresa" method="post">
            <form:hidden path="id" value='${empresa.id}'/>
                <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label">Descripcion</label>
                                <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label">Telefono</label>
                                <form:input  path="telefono" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label">E-mail</label>
                                <form:input  path="mail" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label">Logo</label>
                                <form:input  path="logo" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label">Orden</label>
                                <form:input  path="orden" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label">Html</label>
                                <form:input  path="html" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label">GP+</label>
                                <form:input  path="GPMas" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-info btn-fill pull-left ">Editar</button>
                </div>
                </div>
            <div class="clearfix"></div>
        </form:form>
</div>
</div>
</div>