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
    <title>Celular</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
	<div class="container">
	    <form:form method="POST" action="/celular/crear" modelAttribute="celular">
    	<form:label path="numero" class="col-sm-2 col-form-label">Numero: </form:label>
    	<form:input type="text" path="numero" class="form-control"/>
    	<br>
    	<form:label path="marca" class="col-sm-2 col-form-label">Marca: </form:label>
    	<form:input type="text" path="marca" class="form-control"/>
    	<br>
    	<form:select path="usuario">
    		<c:forEach items="${listaUsuarios}" var="usuario">
    			<form:option value="${usuario.getId()}">${usuario.getNombre()} ${usuario.getApellido()}</form:option>
    		</c:forEach>
    	</form:select>
    	<br>
    	<input type="submit" value="Submit" class="btn btn-primary">
    </form:form>
    
    <table class="table">
    	<thead>
    		<tr>
    			<th scope="col">#</th>
    			<th scope="col">Numero</th>
    			<th scope="col">Marca</th>
    			<th scope="col">Nombre dueño</th>
    			<th scope="col">Editar</th>
    			<th scope="col">Eliminar</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${listaCelulares}" var="celular">
    			<tr>
    				<th scope="row">${celular.getId()}</th>
    				<td>${celular.getNumero()}</td>
    				<td>${celular.getMarca()}</td>
    				<td>${celular.getUsuario().getNombre()} ${celular.getUsuario().getApellido()}</td>
    				<td>
    					<form action="/celular/editar" method="POST">
    						<input type="Hidden" name="id" value="${celular.getId()}">
    						<input type="submit" value="Editar">
    					</form>
    				</td>
    				<td>
    					<form action="/celular/eliminar" method="POST">
    						<input type="Hidden" name="id" value="${celular.getId()}">
    						<input type="submit" value="Eliminar">
    					</form>
    				</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    </div>
</body>

</html>