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
	    <form:form method="POST" action="/cliente/crear" modelAttribute="cliente">
	    	<form:label path="rut" >RUT: </form:label>
	    	<form:input type="text" path="rut" /> 
	    	<br>
	    	<form:label path="nombre">Nombre: </form:label>
	    	<form:input type="text" path="nombre"/>
	    	<br>
	    	<form:label path="edad">Edad: </form:label>
	    	<form:input type="number" path="edad"/> 
	    	<br>
	    	<form:label path="sexo">Sexo: </form:label>
	    	<form:input type="text" path="sexo"/> 
	    	<br>
	    	<form:label path="plan">Plan: </form:label>
	    	<form:select path="plan">
	    		<form:option value="true">Si</form:option>
	    		<form:option value="false">No</form:option>
	    	</form:select>
	    	<br>
	    	<form:label path="celular">Celular: </form:label>
	    	<form:input type="text" path="celular"/> 
	    	<br>
	    	<form:label path="proveedores">Proveedores: </form:label>
	    	<form:select path="proveedores" multiple="true" >
				<option selected disabled>Seleccione Proveedor</option>
				<c:forEach items="${listaProveedores}" var="proveedor">
					<form:option value="${proveedor.getId()}">
						${proveedor.getNombre()} ${proveedor.getApellido()}
					</form:option>
				</c:forEach>
			</form:select>
	    	<br>
	    	<input type="button" value="Limpiar">
	    	<input type="submit" value="Submit">
	    </form:form>
	    <br>
	    <table class="table">
    	<thead>
    		<tr>
    			<th scope="col">#</th>
    			<th scope="col">Nombre</th>
    			<th scope="col">Edad</th>
    			<th scope="col">Sexo</th>
    			<th scope="col">Plan</th>
    			<th scope="col">Celular</th>
    			<th scope="col">Cantidad de proyectos</th>
    			<th scope="col">Editar</th>
    			<th scope="col">Eliminar</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${listaClientes}" var="cliente">
    			<tr>
    				<th scope="row">${cliente.getId()}</th>
    				<td>${cliente.getNombre()}</td>
    				<td>${cliente.getEdad()}</td>
    				<td>${cliente.getSexo()}</td>
    				<c:if test="${cliente.getPlan()=='true' }"><td>Si</td></c:if>
    				<c:if test="${cliente.getPlan()=='false'}"><td>No</td></c:if>
    				<td>${cliente.getCelular()}</td>
    				<td>${cliente.getProveedores().size()}</td>
    				<td>
    					<form action="/cliente/editar" method="POST">
    						<input type="Hidden" name="id" value="${cliente.getId()}">
    						<input type="submit" value="Editar">
    					</form>
    				</td>
    				<td>
    					<form action="/cliente/eliminar" method="POST">
    						<input type="Hidden" name="id" value="${cliente.getId()}">
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