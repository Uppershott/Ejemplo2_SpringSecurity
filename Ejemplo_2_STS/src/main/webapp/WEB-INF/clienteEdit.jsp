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
    <title>Editar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
     <div class="container-fluid">
	    <form:form method="POST" action="/cliente/editarCliente" modelAttribute="cliente">
	    	<input type="hidden" name="_method" value="put">
	    	<form:input type="hidden" path="id"/>
	    	
	    	<form:label path="rut" >RUT: </form:label>
	    	<form:input type="text" path="rut" />
	    	<br>
	    	<form:label path="nombre" >Nombre: </form:label>
	    	<form:input type="text" path="nombre" />
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
	    	<form:select path="proveedores">
    		<c:forEach items="${listaProveedores}" var="proveedor">
    			<%-- <c:if test="${proveedor.id == cliente.proveedores.id}">
					<form:option value="${proveedor.getId()}" selected="true">
						${proveedor.getNombre()} ${proveedor.getApellido()}
					</form:option>
				</c:if> --%>
	    		<form:option value="${proveedor.getId()}">${proveedor.getNombre()}</form:option>
	    		</c:forEach>
	    	</form:select>
	    	
	    	<br>
	    	<input type="button" onClick="window.history.back()" value="Cancelar">
	    	<input type="submit" value="Confirmar">
	    </form:form>
    </div>
</body>

</html>