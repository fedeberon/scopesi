<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="col-6">
        <div class="card">
            <form:form action="addPoiSector" modelAttribute="poiSector" method="post">
                <div class="row ml-3">
                        <div class="col-md-11">
                            <div class="form-group">
                                <label  class="control-label pt-2"><strong>Descripcion</strong></label>
                                <form:input path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <button type="submit" class="btn btn-info btn-fill pull-left ">Guardar</button>
                        </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
