<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                                <form:input  path="mapMedio.id" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                <label for="street1_id" class="control-label pt-2">Formato</label>
                                <form:input  path="mapFormato.id" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                <label for="street1_id" class="control-label pt-2">Acumula datos</label>
                                <form:input  path="acumulaDatos" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                <label for="street1_id" class="control-label pt-2">Evalua</label>
                                <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                                <label for="street1_id" class="control-label pt-2">Metros contacto</label>
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
</div>