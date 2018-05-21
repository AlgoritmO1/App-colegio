<%@page import="modelos.Matricula"%>
<%@page import="modelos.Materia"%>
<%@ include file="header.jsp" %>
<br>
<br>

<% Object resultado = request.getAttribute("resultado");

    Materia materia = new Materia();
    Matricula matr = new Matricula();
    ArrayList<Matricula> matri = new ArrayList<>();
    String consulta = (String) request.getAttribute("opcion");

    if (resultado != null) {
        if (consulta == "mejorPromediopormateria") {
            materia = (Materia) resultado;

%>
<div class="container">
    <center><h2 style="color:#FDF3E7">Mejor promedio por materia</h2></center>
    <hr>
    <br>
            <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("matmasmatr") + materia.getNombre() + msj.mensajes.get("con")
                        + materia.getMatriculas().size() + msj.mensajes.get("matricula"));%></b></h3>
</div>

<%

} else if (consulta == "estudiantePormateria") {
    matri = (ArrayList<Matricula>) resultado;
    
%>

<div class="container">
    <center><h2 style="color:#FDF3E7">Lista de estudiantes por materia</h2></center>
    <hr>
    <br>
    <% 
        for(int i = 1; i <= matri.size(); i++){ 
    %>
    <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("est") + matri.get(i).getEstudiante().toString());%></b></h3>
    <% } %>
</div>

<%

} else if (consulta == "notaMasAlta") {
    matr = (Matricula) resultado;

%>
<div class="container">
    <center><h2 style="color:#FDF3E7">Matricula con la nota mas alta</h2></center>
    <hr>
    <br>
    <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("estmayornota") + resultado.toString());%></b></h3>
</div>

<%

} else if (consulta == "notaMasBaja") {
    matr = (Matricula) resultado;

%>
<div class="container">
    <center><h2 style="color:#FDF3E7">Matricula con la nota mas baja</h2></center>
    <hr>
    <br>
    <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("estmenornota") + resultado.toString());%></b></h3>
</div>
                                    
<%    }
    }

%>
<br>
<br>

<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>
