<%@page import="modelos.Usuario"%>
<%@page import="modelos.Mensajes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <title>Sistema de notas</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/forFooter.css">
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/algunos.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/npm.js"></script>
        <link href="fonts/glyphicons-halflings-regular.eot">
        <link href="fonts/glyphicons-halflings-regular.svg">
        <link href="fonts/glyphicons-halflings-regular.ttf">
        <link href="fonts/glyphicons-halflings-regular.woff">
        <link href="fonts/glyphicons-halflings-regular.woff2">
        <link href="https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%        List<Usuario> usuarioConSesion = new ArrayList<>();
              Mensajes msj = new Mensajes();
              String est = "crearEst";
              String prof = "crearProf";
              String mat = "crearMat";
              String datos = "datos";
              String matmm = "matmm";
              String matmp = "matmp";
              String matmn = "matmn";
              String matms = "matms";
              String mejorp = "mejorp";
              String estpm = "estpm";
              String notma = "notma";
              String notmb = "notmb";
              String listest = "listest";
              String listprof = "listprof";
              String asign = "asign";
              String verest = "verest";
              String verprof = "verprof";
              String vermat = "vermat";
              String matm = "matm";
              String cerrc = "cerrc";
              
        if (null != session.getAttribute("SUsuario")) {

            usuarioConSesion = (ArrayList<Usuario>) session.getAttribute("SUsuario");

        }
        Usuario registrado = usuarioConSesion.get(0);
    %>
    <body style="background-color: #3B3738">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><% out.print(msj.mensajes.get("bien") + registrado.getNombre()); %></a>
            </div>
            <ul class="nav navbar-nav">
                <li class="bottom"><a href="index.jsp">Inicio</a></li>
                    <% switch (registrado.getTipo()) {
                            case "admin":
                    %>

                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Estudiante<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletEstudiante?accion=RutaCrearEstudiante"><c:out value="<%=msj.mensajes.get(est)%>" /></a></li>
                        <li><a href="servletEstudiante?accion=Ver+todos+los+estudiantes"><c:out value="<%=msj.mensajes.get(datos)%>" /></a></li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Profesor<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletProfesor?accion=RutaCrearProfesor"><c:out value="<%=msj.mensajes.get(prof)%>" /></a></li>
                        <li><a href="servletProfesor?accion=VerProfesores"><c:out value="<%=msj.mensajes.get(datos)%>" /></a></li>
                    </ul>                    
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Materia<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletMateria?accion=RutaCrearMateria"><c:out value="<%=msj.mensajes.get(mat)%>" /></a></li>
                        <li><a href="servletMateria?accion=VerMaterias"><c:out value="<%=msj.mensajes.get(datos)%>" /></a></li>
                        <li><a href="servletMateria?accion=MateriaMasMatriculas"><c:out value="<%=msj.mensajes.get(matmm)%>" /></a></li>
                        <li><a href="servletMateria?accion=MateriaMasProfesores"><c:out value="<%=msj.mensajes.get(matmp)%>" /></a></li>
                        <li><a href="servletMateria?accion=MateriaMejorNota"><c:out value="<%=msj.mensajes.get(matmn)%>" /></a></li>
                    </ul>                        
                </li>    
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Matricula<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletMatricula?accion=VerMatriculas"><c:out value="<%=msj.mensajes.get(datos)%>" /></a></li>
                        <li><a href="servletMatricula?accion=mejorPromediopormateria"><c:out value="<%=msj.mensajes.get(mejorp)%>" /></a></li>
                        <li><a href="servletMatricula?accion=estudiantePormateria"><c:out value="<%=msj.mensajes.get(estpm)%>" /></a></li>
                        <li><a href="servletMatricula?accion=notaMasAlta"><c:out value="<%=msj.mensajes.get(notma)%>" /></a></li>
                        <li><a href="servletMatricula?accion=notaMasBaja"><c:out value="<%=msj.mensajes.get(notmb)%>" /></a></li>
                    </ul>                    
                </li>
                <%
                        break;
                    case "estudiante":
                %>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Estudiante<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletEstudiante?accion=Ver+todos+los+estudiantes"><c:out value="<%=msj.mensajes.get(verest)%>" /></a></li>
                    </ul>
                </li>                    
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Profesor<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletProfesor?accion=VerProfesores"><c:out value="<%=msj.mensajes.get(verprof)%>" /></a></li>
                    </ul>                    
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Materia<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletMateria?accion=VerMaterias"><c:out value="<%=msj.mensajes.get(vermat)%>" /></a></li>
                    </ul>                        
                </li>    
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Matricula<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletMatricula?accion=RutaCrearMatricula"><c:out value="<%=msj.mensajes.get(matm)%>" /></a></li>
                    </ul>                    
                </li>
                <%
                        break;
                    case "profesor":
                %>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Estudiante<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletEstudiante?accion=Ver+todos+los+estudiantes"><c:out value="<%=msj.mensajes.get(listest)%>" /></a></li>
                    </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Profesor<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletProfesor?accion=VerProfesores"><c:out value="<%=msj.mensajes.get(listprof)%>" /></a></li>
                    </ul>                    
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Materia<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletMateria?accion=VerMaterias"><c:out value="<%=msj.mensajes.get(matmm)%>" /></a></li>
                    </ul>                        
                </li>    
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Matricula<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="servletMatricula?accion=asignarNota"><c:out value="<%=msj.mensajes.get(asign)%>" /></a></li>
                    </ul>                    
                </li>
                <%break;
                    }%>
                <li class="bottom"><a href="servletLogin?accion=RutaLogin"><c:out value="<%=msj.mensajes.get(cerrc)%>" /></a></li>
            </ul>
        </div>
    </nav>
