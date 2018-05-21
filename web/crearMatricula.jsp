<%@page import="modelos.Profesor"%>
<%@page import="modelos.Estudiante"%>
<%@page import="java.util.List"%>
<%@page import="modelos.Materia"%>
<%@page import="modelos.Materia"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="header.jsp" %>
<br>
<br>
<div class="container">
    <center><h2 style="color:#FDF3E7">Lista de matriculas</h2></center>
    <hr>
    <br>
    <div class="divTable" style="width: 100%;border: 1px solid #000;" >
        <div class="divTableBody">
            <div class="divTableRow">
                <div class="divTableCell"><b>Codigo materia</b></div>
                <div class="divTableCell"><b>Materia</b></div>
                <div class="divTableCell"><b>Profesor</b></div>
                <div class="divTableCell"><b>Inscribir</b></div>
            </div>
            <%
                List<Materia> materia = new ArrayList<>();
                if (null != session.getAttribute("SMateria")) {
                    materia = (ArrayList<Materia>) session.getAttribute("SMateria");
                }
                for (Materia mate : materia) {
            %>

            <form class="divTableRow" method="GET" action="./servletMatricula">
                <div class="divTableCell"><input name='materia' class='noEstilo' value="<%=mate.getCodigo()%>" ></div>
                <div class="divTableCell"><%=mate.getNombre()%></div>
                <div class="divTableCell"><select name="profesor" required>
                        <option value="">Elija una opcion</option>
                        <%
                            for (Profesor profesor : mate.getProfesores()) {
                        %>
                        <option value="<%=profesor.getCedula()%>"> <%=profesor.getNombre()%> </option>
                        <%
                            }
                        %>
                    </select></div>
                <div class="divTableCell"> <center><button type="submit" value="Inscribir" name="accion" class="btn btn-info">
                            <span class="glyphicon glyphicon-pushpin"></span>
                        </button></center></div>

            </form>
            <% }%>
        </div>
    </div>
</div>


<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>
