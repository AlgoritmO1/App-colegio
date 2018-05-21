<%@ include file="header.jsp" %>
<br>
<br>
<div class="container center_div" style="width:30%;">
    <form style="color:#FDF3E7" method="GET" action="./servletMateria">
        <center><h2>Crear materia</h2></center>
        <hr>
        <br>
        <div class="form-group-row">
            <label for="Codigo">Codigo :</label>
            <input class="form-control" type="number" name="codigo" id="example-text-input" required>
            <br>
            <label for="Nombre">Nombre :</label>
            <input class="form-control" type="text" name="nombre" id="example-text-input" required>
        </div>
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