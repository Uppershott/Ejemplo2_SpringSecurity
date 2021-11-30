<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/usuario/loginJsp" method="POST">
		<label for="email">Correo: </label>
		<input type="text" name="email">
		<br>
		<label for="password">Contrasena: </label>
		<input type="text" name="password">
		<br>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="submit" value="Ingresar">
	</form>
	<br>
	<a href="/registro">Registrarse</a>
</body>
</html>