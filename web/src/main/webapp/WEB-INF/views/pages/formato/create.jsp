<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="content">
    <div class="col-12">
        <div class="card">
        <form:form action="addFormato" modelAttribute="formato" method="post">
            <div class="row ml-3">
                <div class="col-md-11">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2"><strong>Descripcion</strong></label>
                                <form:input  path="descripcion" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
                            </div>
                            <div class="col-6">
                                <label for="street1_id" class="control-label pt-2"><strong>Evalua</strong></label>
                                <form:input  path="evalua" cssClass="form-control" id="street1_id" name="street1" placeholder=""/>
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

