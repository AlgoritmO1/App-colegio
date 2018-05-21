<%@ include file="header.jsp" %>
<br>
<br>

<c:if test="${not empty profesor}">
    <div class="container">
        <center><h2 style="color:#FDF3E7">Lista de profesores</h2></center>
        <hr>
        <br>
        <div class="divTable" style="width: 100%;border: 1px solid #000;" >
            <div class="divTableBody">
                <div class="divTableRow">
                    <div class="divTableCell"><b>Nombre</b></div>
                    <div class="divTableCell"><b>Apellido</b></div>
                    <div class="divTableCell"><b>Email</b></div>
                    <div class="divTableCell"><b>Cedula</b></div>
                    <div class="divTableCell"><b>Materia</b></div>
                    <div class="divTableCell"><b>Usuario</b></div>
                    <div class="divTableCell"><b>Contraseña</b></div>                    
                    <div class="divTableCell"><b>Ver detalles</b></div>
                    <div class="divTableCell"><b>Modificar</b></div>
                    <div class="divTableCell"><b>Eliminar</b></div>
                </div>
                <c:forEach items="${profesor}" var="prof">
                    <form class="divTableRow" method="GET" action="./servletProfesor">
                        <div class="divTableCell">${prof.getNombre()}</div>
                        <div class="divTableCell">${prof.getApellido()}</div>
                        <div class="divTableCell">${prof.getEmail()}</div>
                        <div class="divTableCell"><input type="text" name="cedula" class="noEstilo" value=${prof.getCedula()} /></div>
                         <div class="divTableCell">${prof.getMateria().getNombre()}</div>
                         <div class="divTableCell">${prof.getUsuario()}</div>
                         <div class="divTableCell">${prof.getClave()}</div>
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
    <form method="GET" action="./servletProfesor">
        <center><input type="submit" class="btn btn-primary btn-lg" style="width:50%" name="accion" value="VerProfesores" /></center>

    </form>
</div>
<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>