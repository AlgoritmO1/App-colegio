<%@ include file="header.jsp" %>
<br>
<br>

<c:if test="${not empty materia}">
    <div class="container">
        <center><h2 style="color:#FDF3E7">Lista de materias</h2></center>
        <hr>
        <br>
        <div class="divTable" style="width: 100%;border: 1px solid #000;" >
            <div class="divTableBody">
                <div class="divTableRow">
                    <div class="divTableCell"><b>Codigo</b></div>
                    <div class="divTableCell"><b>Nombre</b></div>
                    <div class="divTableCell"><b>Ver detalles</b></div>
                    <div class="divTableCell"><b>Modificar</b></div>
                    <div class="divTableCell"><b>Eliminar</b></div>
                </div>
                <c:forEach items="${materia}" var="mat">
                    <form class="divTableRow" method="GET" action="./servletMateria">
                        <div class="divTableCell"><input type="text" name="codigo" class="noEstilo" value=${mat.getCodigo()} /></div>
                        <div class="divTableCell"><input type="text" name="nombre" class="noEstilo" value=${mat.getNombre()} /></div>
                        <div class="divTableCell"> <center>        <button type="submit" value="VerDetalles" name="accion" class="btn btn-info">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button></center></div>
                        <div class="divTableCell"><center>        <button type="submit" value="Modificar" name="accion" class="btn btn-info" style="background-color: #37E934;">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </button></center></div>
                        <div class="divTableCell"><center>        <button type="submit" value="Eliminar" name="accion" class="btn btn-info" style="background-color: #D51D20;">
                                    <span class="glyphicon glyphicon-trash"></span></button></center></div>
                    </form>
                </c:forEach>
            </div>
        </div>
    </div>
</c:if>

<br>
<br>
<br>
<div class="container center_div">
    <form method="GET" action="./servletMateria">
        <center><input type="submit" class="btn btn-primary btn-lg" style="width:50%" name="accion" value="VerMaterias" /></center>

    </form>
</div>
<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>
