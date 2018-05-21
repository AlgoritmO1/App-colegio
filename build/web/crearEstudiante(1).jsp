<%@ include file="header.jsp" %>
<br>
<br>
<div class="container center_div" style="width:30%;">
    <form style="color:#FDF3E7" method="GET" action="./servletEstudiante">
        <center><h2>Crear estudiante</h2></center>
        <hr>
        <br>
        <div class="form-group-row">
            <label for="Nombre">Nombre :</label>
            <input class="form-control" type="text" name="nombre" id="example-text-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Apellido">Apellido :</label>
            <input class="form-control" type="text" name="apellido" id="example-search-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Email">Email :</label>
            <input class="form-control" type="email" name="email" id="example-email-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Cedula">Cedula :</label>
            <input class="form-control" type="number" name="cedula" id="example-url-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="celular" >Celular :</label>
            <input class="form-control" type="number" name="celular" id="example-tel-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="usuario" >Usuario :</label>
            <input class="form-control" type="text" name="usuario" id="example-tel-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="contraseña" >Contraseña :</label>
            <input class="form-control" type="text" name="clave" id="example-tel-input" required>
        </div>
        <br>
        <br>
        <br>
        <center><input class="btn btn-primary btn-lg" style="width:50%" value="Guardar" name="accion" type="submit"></center>
    </form>
</div>
<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>