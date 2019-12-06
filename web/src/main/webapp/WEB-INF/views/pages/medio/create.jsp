<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="col-6">
        <div class="card">
            <form:form action="addMedio" modelAttribute="medio" method="post">

                <div class="row ml-3">
                    <div class="col-md-11">
                        <div class="form-group"> <!-- Street 1 -->
                            <label for="street1_id" class="control-label"><strong>Descripcion</strong></label>
                            <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder="Ingrese un nuevo medio"/>

                        </div>
                        <button type="submit" class="btn btn-info btn-fill pull-left ">Guardar</button>
                    </div>
                </div>
            </form:form>
            </div>
        </div>
    </div>
