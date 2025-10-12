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
<body>
<nav>
<div><img alt="" src="https://pbs.twimg.com/profile_images/1904526155765481472/TcKKw0k9_400x400.jpg" width="150px"></div>   
<div><a href="Mantenimiento.jsp" class="nav_item">🛠 Mantenimiento</a></div>
<div><a href="Consultas.jsp" class="nav_item" >🔎 Consultas</a></div>
<div><a href="Reportes.jsp" class="nav_item" >📊 Reportes</a></div>
<div><a href="Pedidos.jsp" class="nav_item" >📩 Pedidos</a></div>
<div><a href="Detalle-Cuenta.jsp" class="nav_item" >👤 Cuenta</a></div>
</nav>
<main style="padding:25px;" >
<form class="main__mantenimiento" action="ServletDistrito" method="post">
<p>Mantenimiento Distrito</p>
<label>nombre del distrito</label>
<input type="text" 
<c:if test="${sessionScope.distritos.size() == null}">
value="DIS001"</c:if>
<c:if test="${sessionScope.distritos.size() != null}">
value="DIS00${sessionScope.distritos.size()+1}"
</c:if>
 name="distrito_id" placeholder="ingrese el nombre del distrito" readonly>

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