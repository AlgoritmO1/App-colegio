<%@ include file="header.jsp" %>
<h1 style="text-align: center; color: white" > <%
    String b = "bienvenida";
    %>


    <c:out value="<%=msj.mensajes.get(b)%>" /></h1>


<center> <img src="http://www.stec-laborales.com/images/articulos/examen.jpg">  </center>
<br><br>
<%

    if (registrado.getNombre().equals("Admin")) {
        String df="datosFic";
%>
<center><a href="servletLogin?accion=DatosFicticios"><c:out value="<%=msj.mensajes.get(df)%>" /></a></center>
<%     }
%>
<br><br>
<%@ include file="footer.jsp" %>