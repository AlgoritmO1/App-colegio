<%@ include file="header.jsp" %>
<br>
<br>

<c:if test="${not empty matriculaConProfe}">
    <div class="container">
        <center><h2 style="color:#FDF3E7">Lista de estudiantes</h2></center>
        <hr>
        <br>
        <div class="divTable" style="width: 100%;border: 1px solid #000;" >
            <div class="divTableBody">
                <div class="divTableRow">
                    <div class="divTableCell"><b>Codigo Matricula</b></div>
                    <div class="divTableCell"><b>Nombre</b></div>
                    <div class="divTableCell"><b>Apellido</b></div>
                    <div class="divTableCell"><b>Cedula</b></div>
                    <div class="divTableCell"><b>Nota</b></div>
                    <div class="divTableCell"><b>Asignar nota</b></div>
                </div>
                <c:forEach items="${matriculaConProfe}" var="matr">
                    <form class="divTableRow" method="GET" action="./servletMatricula">
                        <div class="divTableCell"><input type="text" name="codigo" class="noEstilo" value=${matr.getCodigo()} /></div>
                        <div class="divTableCell">${matr.getEstudiante().getNombre()}</div>
                        <div class="divTableCell">${matr.getEstudiante().getApellido()}</div>
                        <div class="divTableCell">${matr.getEstudiante().getCedula()}</div>
                        <div class="divTableCell"><input type="text" name="nota" id="example-text-input" value=${matr.getNota()}/></div>
                        <div class="divTableCell"> <center>        <button type="submit" value="Editar nota" name="accion" class="btn btn-info">
                                   <span class="glyphicon glyphicon-pencil"></span>
                                </button></center></div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>

<br>
<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>