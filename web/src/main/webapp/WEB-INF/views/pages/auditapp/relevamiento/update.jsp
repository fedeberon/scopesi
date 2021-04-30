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
            <form:form action="saveUpdate" modelAttribute="updateRelevamiento"  method="post">
                <form:hidden path="id" value='${relevamiento.id}'/>
                <div class="row ml-3">
                    <div class="col-md-11">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label class="control-label pt-2">Nombre del relevamiento:</label>
                                    <form:input path="nombreRelevamiento" onkeypress="preventSpaceBar(event)" cssClass="form-control" required="true"/>
                                    <form:errors path="nombreRelevamiento" cssStyle="color: red;"/>
                                </div>

                                <div class="col-6">
                                    <label for="inspector" class="control-label pt-2">Inspector:</label>
                                    <select class="form-control" id="inspector" name="usuario.id">
                                        <c:forEach items="${inspectores}" var="bo" varStatus="status">
                                            <option ${bo.username == updateRelevamiento.usuario.username ? 'selected' : ''} value="${bo.id}">${bo.username}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="col-6">
                                    <label for="encuesta" class="control-label pt-2">Encuesta:</label>
                                    <select class="form-control" id="encuesta" name="encuesta.id">
                                        <c:forEach items="${encuestas}" var="bo" varStatus="status">
                                            <option ${bo.nombreEncuesta == updateRelevamiento.encuesta.nombreEncuesta ? 'selected' : ''} value="${bo.id}">${bo.nombreEncuesta}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <a href="list" class="btn btn-light pull-left ml-3"><i class="fas fa-angle-double-left pr-2"></i>Volver</a>


                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-secondary btn-fill pull-right mr-3" data-toggle="modal" data-target="#exampleModal">
                            Guardar
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="top:180px; text-align: center;">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel"></h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <h5>&iquest;Desea guardar los cambios?</h5>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="#" class="btn btn-light " data-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-secondary btn-fill">Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="clearfix"></div>
            </form:form>
        </div>
    </div>
</div>
<script>
    var element = document.getElementById("auditapp");
    element.classList.add("active");

</script>