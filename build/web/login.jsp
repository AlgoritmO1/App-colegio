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
        <link rel="stylesheet" href="css/forLogin.css">
        <link href="https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
	<body style="background-color: #3B3738">
            <form action="./servletLogin" method="POST">
			<h2>Login de acceso</h2>
                        <br>
			<input class="form-control" type="text" placeholder="&#128272; Usuario" name="usuario" id="example-text-input" required>
                        <br>
			<input class="form-control" type="password" placeholder="&#128272; Contraseña" name="clave" id="example-text-input" required>
                        <br>
                        <center><input type="submit" class="btn btn-primary btn-lg" style="width:50%" name="accion" value="Ingresar"></center>
            </form>
	</body>
</html>
	
	