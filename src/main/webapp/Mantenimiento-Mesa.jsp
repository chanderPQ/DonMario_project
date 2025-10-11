<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pagina" value="Mantenimiento-Mesa.jsp" scope="session"/>
<c:if test="${ sessionScope.loadMesa==null }">
<c:set var="loadMesa" value="1" scope="session"/>
<jsp:forward page="ServletMesa"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="Mantenimiento-Menu.css" >
</head>
<body>
<main style="padding:20px">
<form action="ServletMesa" method="post" class="main__mantenimiento" >
<p>Mantenimiento Mesa</p>
<input type="hidden" name="empleado_id" value="EMP00" >
<label>Mesa ID: </label>


<input type="text" 
<c:if test="${sessionScope.mesas.size() == null}">
value="MES001"</c:if>
<c:if test="${sessionScope.mesas.size() != null}">
value="MES00${sessionScope.mesas.size()+1}"
</c:if>
 name="mesa_id" placeholder="ingrese el nombre del mesa" readonly>



<label>Capacidad: </label>
<input type="text" name="capacidad">
<label>Estado: </label>
<div>
<label>Libre    <input type="radio" name="estado" value="libre"></label>
<label>Ocupado  <input type="radio" name="estado" value="ocupado"></label>
</div>
<input type="submit" name="accion" value="crear">
</form>
<br>
<table class="table table-striped table-hover">
<tr>
<td class="table-dark">Mesa ID</td>
<td class="table-dark">Capacidad</td>
<td class="table-dark">Estado</td>
<td class="table-dark">Actualizado por:</td>
<td class="table-dark">Acciones</td>
</tr>
<c:forEach items="${sessionScope.mesas }" var="mesa">
<tr>
<td>${mesa.mesa_id }</td>
<td>${mesa.capacidad }</td>
<td>${mesa.estado }</td>
<td>${mesa.empleado_id }</td>
<td><a href="ServletMesa?accion=editar&idEditar=${mesa.mesa_id }" class="btn btn-primary" >Editar</a>
<a href="ServletMesa?accion=eliminar&idEliminar=${mesa.mesa_id }" class="btn btn-danger" >Eliminar</a></td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>