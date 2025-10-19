<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pagina" value="Menu-Pedido.jsp" scope="session"/>
<c:if test="${ requestScope.loadDetalle==null }">
<c:set var="loadDetalle" value="1" scope="request"/>
<jsp:forward page="ServletMenuPedido?accion=leer&pedido_idDetalle=${requestScope.pedido.pedido_id }"/>
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
<main style="padding:20px;">
<p>Detalle del Pedido</p>
<c:if test="${requestScope.pedido.estado== 'en preparacion' }">

<form class="main__mantenimiento" action="ServletMenuPedido" method="post">

<label>Pedido ID:</label>

<input type="text" name="pedido_id" value="${requestScope.pedido.pedido_id }" readonly>
<label>Menu pedido:</label>
<select name="menu_id">
<c:forEach items="${sessionScope.menus }" var="menu">
<option value="${menu.menu_id }">${menu.nombre }</option>
</c:forEach>
</select>
<label>Cantidad:</label>
<input type="text" name="cantidad" placeholder="ingrese la cantidad">
<input type="submit" name="accion" value="crear">
</form>
<br>
</c:if>

<table class="table table-striped table-hover">
<tr>
<td class="table-dark">Pedido ID</td>
<td class="table-dark">Menu ID</td>
<td class="table-dark">Nombre Menu</td>
<td class="table-dark">Cantidad</td>
<c:if test="${requestScope.pedido.estado== 'en preparacion' }">
<td class="table-dark">Acciones</td>
</c:if>
</tr>

<c:forEach items="${requestScope.menupedidos }" var="item">
<tr>
<td>${item.pedido_id }</td>
<td>${item.menu_id }</td>
<td>${item.nombre }</td>
<td>${item.cantidad }</td>
<c:if test="${requestScope.pedido.estado== 'en preparacion' }">
<td>
<a href="ServletMenuPedido?accion=editar&pedido_idEditar=${item.pedido_id}&menu_idEditar=${item.menu_id}" class="btn btn-primary">Editar</a>
<a href="ServletMenuPedido?accion=eliminar&pedido_idEliminar=${item.pedido_id}&menu_idEliminar=${item.menu_id}" class="btn btn-danger">Eliminar</a></td>
</c:if>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>
