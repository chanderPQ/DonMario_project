<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pagina" value="Mantenimiento-Menu.jsp" scope="session"/>
<c:if test="${sessionScope.loadMenu==null }">
<c:set var="loadMenu" value="1" scope="session"/>
<jsp:forward page="ServletMenu"/>
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
<p>Mantenimiento Menu</p>
<form class="main__mantenimiento" action="ServletMenu" method="post">
<input type="hidden" name="empleado_id" value="1">
<label>nombre del menu</label>
<input type="text" name="nombre" placeholder="ingrese el nombre del plato">
<label>costo</label>
<input type="text" name="costo" placeholder="ingrese el costo">
<input type="submit" name="accion" value="crear">
</form>
<br>
<table class="table table-striped table-hover">
<tr>
<td class="table-dark">Menu ID</td>
<td class="table-dark">Nombre del menu</td>
<td class="table-dark">Costo</td>
<td class="table-dark">Empleado ID</td>
<td class="table-dark">Acciones</td>
</tr>

<c:forEach items="${sessionScope.menus }" var="item">
<tr>
<td>${item.menu_id }</td>
<td>${item.nombre }</td>
<td>${item.costo }</td>
<td>${item.empleado_id }</td>
<td><a href="ServletMenu?accion=editar&idEditar=${item.menu_id }" class="btn btn-primary">Editar</a><a href="ServletMenu?accion=eliminar&idEliminar=${item.menu_id }" class="btn btn-danger">Eliminar</a></td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>