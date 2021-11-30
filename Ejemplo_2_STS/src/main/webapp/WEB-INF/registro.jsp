<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Clientes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
	<%@ include file="../WEB-INF/templates/navigation.jsp" %>
    <div class="container-fluid">
	    <form:form method="POST" action="/usuario/crear" modelAttribute="usuario">
	    
	    	<form:label path="nombre" >Nombre: </form:label>
	    	<form:input type="text" path="nombre" /> 
	    	<br>
	    	<form:label path="apellido">Apellido: </form:label>
	    	<form:input type="text" path="apellido"/> 
	    	<br>
	    	<form:label path="limite">Limite: </form:label>
	    	<form:input type="text" path="limite"/> 
	    	<br>
	    	<form:label path="codigoPostal">Codigo postal: </form:label>
	    	<form:input type="text" path="codigoPostal"/> <br>
	    	<br>
	    	<form:label path="rut">RUT: </form:label>
	    	<form:input type="text" path="rut"/> <br>
	    	<br>
	    	<form:label path="email">Correo: </form:label>
	    	<form:input type="text" path="email"/> <br>
	    	<br>
	    	<form:label path="password">Password: </form:label>
	    	<form:input type="text" path="password"/> <br>
	    	<br>
	    	<form:label path="passwordConfirmation">Confirmacion de password: </form:label>
	    	<form:input type="text" path="passwordConfirmation"/> <br>
	    	<br>
	    	<input type="button" onClick="window.history.back()" value="Cancelar">
	    	<input type="submit" value="Submit">
	    </form:form>
    </div>
</body>

</html>