<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pagina" value="Mantenimiento-Empleado.jsp" scope="session"/>
<c:if test="${sessionScope.load==null}">
<c:set var="load" value="1" scope="session"/>
<jsp:forward page="ServletDistrito"/>
</c:if>
<c:if test="${sessionScope.loadEmpleado==null }">
<c:set var="loadEmpleado" value="1" scope="session"/>
<jsp:forward page="ServletEmpleado"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="Mantenimiento-Menu.css">
</head>
<body>
<main style="padding:20px;">
<form class="main__mantenimiento" action="ServletEmpleado" method="post" >
<p>Informacion personal</p>
<label>nombre</label>
<input type="text" placeholder="nombre completo" name="nombre" >
<label>apellido</label>
<input type="text" placeholder="apellido completo" name="apellido" >
<label>distrito:</label>
<select name="distrito_id">
<c:forEach items="${sessionScope.distritos}" var="item">
<option value="${item.distrito_id }">${item.nombre }</option>
</c:forEach>
</select>
<label>rol:</label>
<select name="rol">
<option value="administrador" >Administrador</option>
<option value="cajero" >Cajero</option>
<option value="cocinero" >Cocinero</option>
<option value="mesero" >Mesero</option>
<option value="portero" >Portero</option>
</select>
<p>Informacion de usuario</p>
<label>correo</label>
<input type="email" placeholder="ingrese su correo" name="correo" >
<label>contraseña</label>
<input type="password" placeholder="ingrese su nueva contraseña" name="clave" >
<input type="submit" name="accion" value="crear" >
</form>
<br>
<table class="table table-striped table-hover">
<tr>
<td class="table-dark">rol</td>
<td class="table-dark">nombre</td>
<td class="table-dark">apellido</td>
<td class="table-dark">direccion</td>
<td class="table-dark">correo</td>
<td class="table-dark">clave</td>
<td class="table-dark">Acciones </td>
</tr>
<c:forEach items="${sessionScope.empleados}" var="empleado" >
<tr>
<td>${empleado.rol}</td>
<td>${empleado.nombre}</td>
<td>${empleado.apellido}</td>
<td>${empleado.distrito_id}</td>
<td>${empleado.correo}</td>
<td>****</td>
<td><a class="btn btn-primary" href="ServletEmpleado?accion=editar&idEditar=${empleado.empleado_id}">Editar</a><a class="btn btn-danger" href="ServletEmpleado?accion=eliminar&idEliminar=${empleado.empleado_id }">Eliminar</a></td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>