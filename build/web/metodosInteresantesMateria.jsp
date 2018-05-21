<%@page import="modelos.Matricula"%>
<%@page import="modelos.Materia"%>
<%@ include file="header.jsp" %>
<br>
<br>

<% Object resultado = request.getAttribute("resultado");

    Materia materia = new Materia();
    Matricula matr = new Matricula();

    String consulta = (String) request.getAttribute("opcion");

    if (resultado != null) {
        if (consulta == "masMatriculas") {
            materia = (Materia) resultado;

%>
<div class="container">
    <center><h2 style="color:#FDF3E7">Materia con mas matriculas</h2></center>
    <hr>
    <br>
            <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("matmasmatr") + materia.getNombre() + msj.mensajes.get("con")
                        + materia.getMatriculas().size() + msj.mensajes.get("matricula"));%></b></h3>
</div>

<%

} else if (consulta == "masProfesores") {
    materia = (Materia) resultado;

%>

<div class="container">
    <center><h2 style="color:#FDF3E7">Materia con mas profesores</h2></center>
    <hr>
    <br>
    <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("matmasprof") + materia.getNombre() + msj.mensajes.get("con") + materia.getProfesores().size()
                + msj.mensajes.get("profesor"));%></b></h3>
</div>

<%

} else if (consulta == "mejorNota") {
    matr = (Matricula) resultado;

%>
<div class="container">
    <center><h2 style="color:#FDF3E7">Materia con mejor nota</h2></center>
    <hr>
    <br>
    <h3 style="color:#FDF3E7"><b><%out.print(msj.mensajes.get("matmayornota") + matr.getMateria().getNombre() + msj.mensajes.get("con") + matr.getNota()
                                    + ","+msj.mensajes.get("estudiante") + matr.getEstudiante().getNombre() + " " + matr.getEstudiante().getApellido());%></b></h3>
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
