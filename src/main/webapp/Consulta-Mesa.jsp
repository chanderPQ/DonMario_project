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

<nav>
<div><img alt="" src="https://pbs.twimg.com/profile_images/1904526155765481472/TcKKw0k9_400x400.jpg" width="150px"></div>   
<div><a href="Mantenimiento.jsp" class="nav_item">🛠 Mantenimiento</a></div>
<div><a href="Consultas.jsp" class="nav_item" >🔎 Consultas</a></div>
<div><a href="Reportes.jsp" class="nav_item" >📊 Reportes</a></div>
<div><a href="Pedidos.jsp" class="nav_item" >📩 Pedidos</a></div>
<div><a href="Detalle-Cuenta.jsp" class="nav_item" >👤 Cuenta</a></div>
</nav>
<main style="padding:20px">
<h1>Consultar Mesas</h1>
<br>
<table class="table table-striped table-hover">
<tr>
<td class="table-dark">Mesa ID</td>
<td class="table-dark">Capacidad</td>
<td class="table-dark">Estado</td>
<td class="table-dark">Actualizado por:</td>
</tr>
<c:forEach items="${sessionScope.mesas }" var="mesa">
<tr>
<td>${mesa.mesa_id }</td>
<td>${mesa.capacidad }</td>
<td>${mesa.estado }</td>
<td>${mesa.empleado_id }</td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>