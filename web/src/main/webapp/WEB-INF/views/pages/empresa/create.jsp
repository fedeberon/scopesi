<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="content">
    <div class="col-6">
    <div class="card">
        <form:form action="addEmpresa" modelAttribute="empresa" method="post">
                <div class="row ml-3">
                    <div class="col-md-11">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Descripcion</label>
                                    <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese una nueva empresa"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Telefono</label>
                                    <form:input  path="telefono" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo telefono"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">E-mail</label>
                                    <form:input  path="mail" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo e-mail"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Logo</label>
                                    <form:input  path="logo" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo logo"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Orden</label>
                                    <form:input  path="orden" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo orden"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">Html</label>
                                    <form:input  path="html" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo html"/>
                                </div>
                                <div class="col-6">
                                    <label for="street1_id" class="control-label">GP+</label>
                                    <form:input  path="gpmas" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo cliente"/>
                                </div>

                            </div>
                        </div>
                        <button type="submit" class="btn btn-info btn-fill pull-left ">Guardar</button>
                    </div>
                </div>
            <div class="clearfix"></div>
        </form:form>
    </div>
    </div>
    </div>

