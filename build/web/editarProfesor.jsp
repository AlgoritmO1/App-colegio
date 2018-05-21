<%@ include file="header.jsp" %>
<br>
<br>
<c:if test="${not empty profesor}">
<div class="container center_div" style="width:30%;">
    <form style="color:#FDF3E7" method="GET" action="./servletProfesor">
        <center><h2>Editar profesor</h2></center>
        <hr>
        <br>
        <c:forEach items="${profesor}" var="prof">
        <div class="form-group-row">
            <label for="Nombre">Nombre :</label>
            <input class="form-control" type="text" value="${prof.getNombre()}" name="nombre" id="example-text-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Apellido">Apellido :</label>
            <input class="form-control" type="text" value="${prof.getApellido()}" name="apellido" id="example-search-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Email">Email :</label>
            <input class="form-control" type="email" value="${prof.getEmail()}" name="email" id="example-email-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Cedula">Cedula :</label>
            <input class="form-control" type="text" value="${prof.getCedula()}" name="cedula" id="example-url-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Oficina" >Oficina :</label>
            <input class="form-control" type="text" value="${prof.getOficina()}" name="oficina" id="example-tel-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Telefono" >Telefono :</label>
            <input class="form-control" type="text" value="${prof.getTelefono()}" name="telefono" id="example-tel-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Codigo">Materia :</label>

            <select name="materia" class="form-control" required>
                <option>Elija una opcion</option>
                <c:forEach items="${materias}" var="mat">
                <option value="${mat.getCodigo()}"> ${mat.getNombre()} </option>
                </c:forEach>
            </select> 
        </div>
        <br>
        <div class="form-group-row">
            <label for="usuario" >Usuario :</label>
            <input class="form-control" type="text" value="${prof.getUsuario()}" name="usuario" id="example-tel-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="contraseña" >Contraseña :</label>
            <input class="form-control" type="text" value="${prof.getClave()}" name="clave" id="example-tel-input" required>
        </div>
        <br>
        </c:forEach>
        <br>
        <center><input class="btn btn-primary btn-lg" style="width:50%" value="Guardar edicion" name="accion" type="submit"></center>
    </form>
</div>
</c:if>
<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>