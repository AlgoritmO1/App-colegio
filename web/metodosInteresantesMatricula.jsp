<%@page import="modelos.Matricula"%>
<%@page import="modelos.Materia"%>
<%@ include file="header.jsp" %>
<br>
<br>

<% Object resultado = request.getAttribute("resultado");

    Materia materia = new Materia();
    Matricula matr = new Matricula();
    ArrayList<Matricula> matri = new ArrayList<>();
    ArrayList<Materia> mate = new ArrayList<>();
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

%>

<center><h2 style="color:#FDF3E7">Lista de estudiantes por materia</h2></center>
<hr>
<br>
<%    mate = (ArrayList<Materia>) resultado;
    for (Materia mate1 : mate) {

%>
<div class="container">
    <center><h3 style="color:#FDF3E7"><%out.print(mate1.getNombre());%></h3></center>
    <hr>
    <br>
    <div class="divTable" style="width: 100%;border: 1px solid #000;" >
        <div class="divTableBody">
            <div class="divTableRow">
                <div class="divTableCell"><b>Codigo matricula</b></div>
                <div class="divTableCell"><b>Estudiante</b></div>
                <div class="divTableCell"><b>Nota</b></div>
            </div>

<%
                for (Matricula matr1 : mate1.getMatriculas()) {
%>
             <div class="divTableRow">
                <div class="divTableCell"><input type="text" name="nota" class="noEstilo" value="<%out.print(matr1.getNota());%>" disabled></div>
                <div class="divTableCell"><input type="text" name="codigo" class="noEstilo" value="<%out.print(matr1.getCodigo());%>" disabled></div>
                <div class="divTableCell"><%out.print(matr1.getEstudiante().getNombre() + " " + matr1.getEstudiante().getApellido());%></div>
            </div>



<%
        }
%>
        </div>
    </div>
</div>
            <%
    }
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
