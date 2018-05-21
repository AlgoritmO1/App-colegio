<%@ include file="header.jsp" %>
<br>
<br>
<c:if test="${not empty materia}">
<div class="container center_div" style="width:30%;">
    <form style="color:#FDF3E7" method="GET" action="./servletMateria">
        <center><h2>Editar materia</h2></center>
        <hr>
        <br>
        <c:forEach items="${materia}" var="mat">
        <div class="form-group-row">
            <label for="Codigo">Codigo :</label>
            <input class="form-control" type="text" value="${mat.getCodigo()}" name="codigo" id="example-text-input" required>
            <br>
            <label for="Nombre">Nombre :</label>
            <input class="form-control" type="text" value="${mat.getNombre()}" name="nombre" id="example-text-input" required>
        </div>
        </c:forEach>
        <br>        
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