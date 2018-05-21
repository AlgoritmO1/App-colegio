<%-- 
    Document   : Error
    Created on : 15/05/2017, 12:40:53 PM
    Author     : Salo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Mensajes"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje de error</title>
    </head>
    <body>
        <h1> <%Mensajes msj = new Mensajes();
        String m = "error";
            %>
        
        <c:out value="<%=msj.mensajes.get(m)%>" />
            
        </h1>
    </body>
</html>
