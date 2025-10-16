<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pagina" value="Pedidos.jsp" scope="session" />
<c:if test="${sessionScope.loadPedido==null }">
<c:set var="loadPedido" value="1" scope="session"/>
<jsp:forward page="ServletPedido"/>
</c:if>
<c:if test="${sessionScope.loadMesa==null }">
<c:set var="loadMesa" value="1" scope="session"/>
<jsp:forward page="ServletMesa"/>
</c:if>
<c:if test="${sessionScope.loadMenu==null}">
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
<nav>
<div><img alt="" src="https://pbs.twimg.com/profile_images/1904526155765481472/TcKKw0k9_400x400.jpg" width="150px"></div>   
<div><a href="Mantenimiento.jsp" class="nav_item">🛠 Mantenimiento</a></div>
<div><a href="Consultas.jsp" class="nav_item" >🔎 Consultas</a></div>
<div><a href="Reportes.jsp" class="nav_item" >📊 Reportes</a></div>
<div><a href="Pedidos.jsp" class="nav_item" >📩 Pedidos</a></div>
<div><a href="Detalle-Cuenta.jsp" class="nav_item" >👤 Cuenta</a></div>
</nav>
<main style="padding:30px;" >
<form action="ServletPedido" method="POST" class="main__mantenimiento" >
<input type="hidden" name="empleado_id" value="${sessionScope.cuenta.empleado_id }">
<p>Generar pedido</p>
<label>Pedido ID:</label>

<input type="text" name="pedido_id"
<c:if test="${sessionScope.pedidos.size()==null }">
value="PED001"
</c:if> 
value="PED00${sessionScope.pedidos.size()+1 }"
readonly>
<label>Mesa ID:</label>
<select name="mesa_id">
<c:forEach items="${ sessionScope.mesas }" var="mesa" >
<option value="${mesa.mesa_id}" >${mesa.mesa_id}</option>
</c:forEach>
</select>
<label>Estado:</label>
<div>
<label>En Preparacion  <input type="radio" name="estado" value="en preparacion" ></label>
<label>Pedido Listo    <input type="radio" name="estado" value="pedido listo" ></label>
</div>
<input type="submit" value="crear" name="accion" >
</form>
<br>
<table class="table table-striped table-hover">
<tr>
<td class="table-dark">Pedido ID</td>
<td class="table-dark">Mesa ID</td>
<td class="table-dark">Generado por</td>
<td class="table-dark">Estado</td>
<td class="table-dark">Acciones</td>
</tr>
<c:forEach items="${sessionScope.pedidos }" var="pedido">
<tr>
<td>${pedido.pedido_id}</td>
<td>${pedido.mesa_id }</td>
<td>${pedido.empleado_id }</td>
<td>${pedido.estado }</td>
<td>
<a href="ServletPedido?accion=detalle&idDetalle=${pedido.pedido_id }" class="btn btn-warning" >Detalle</a>
<a href="ServletPedido?accion=editar&idEditar=${pedido.pedido_id }" class="btn btn-primary" >Editar</a>
<a href="ServletPedido?accion=eliminar&idEliminar=${pedido.pedido_id }" class="btn btn-danger" >Eliminar</a>
</td>
</tr>
</c:forEach>
</table>
</main>
</body>
</html>