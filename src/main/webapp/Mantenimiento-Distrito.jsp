<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="pagina" value="Mantenimiento-Distrito.jsp" scope="session"/>
<c:if test="${sessionScope.load==null}">
<c:set var="load" value="1" scope="session"/>
<jsp:forward page="ServletDistrito"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="Mantenimiento-Menu.css">
</head>
<body style="padding:25px;">
<p>Mantenimiento Distrito</p>

<main>
<form class="main__mantenimiento" action="ServletDistrito" method="post">
<label>nombre del distrito</label>
<input type="text" name="nombre" placeholder="ingrese el nombre del distrito">
<input type="submit" name="accion" value="crear">
</form>
<br>
<table class="table table-striped table-hover">
<td class="table-dark">Distrito_id</td>
<td class="table-dark">nombre</td>
<td class="table-dark">acciones</td>
<c:forEach items="${sessionScope.distritos}" var="item">
<tr>
<td>${item.distrito_id }</td>
<td>${item.nombre }</td>
<td>
<a class="btn btn-primary" href="ServletDistrito?accion=editar&idEditar=${item.distrito_id}">Editar</a><a class="btn btn-danger" href="ServletDistrito?accion=eliminar&idEliminar=${item.distrito_id}">Eliminar</a></td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>