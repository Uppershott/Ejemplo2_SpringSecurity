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
    <title>Proyectos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
	<%@ include file="../WEB-INF/templates/navigation.jsp" %>
    <div class="container-fluid">
    <form:form method="POST" action="/proyecto/crear" modelAttribute="proyecto">
    	<form:label path="nombre" >Nombre: </form:label>
    	<form:input type="text" path="nombre" /> <br>
    	<form:label path="descripcion">Descripcion: </form:label>
    	<form:input type="text" path="descripcion"/> <br>
    	<input type="button" value="Limpiar">
    	<input type="submit" value="Submit">
    </form:form>
    <br>
     <form:form method="POST" action="/proyecto/buscar" modelAttribute="proyecto">
    	<form:select path="nombre">
    		<c:forEach items="${listaProyectos}" var="proyecto">
    			<form:option value="${proyecto.getId()}"> ${proyecto.getNombre()}</form:option>
    		</c:forEach>
    	</form:select>
    	<br>
    	<input type="button" value="Limpiar">
    	<input type="submit" value="Submit">
    </form:form>
    </div>
</body>

</html>