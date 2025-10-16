<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="pagina" value="Menu-Pedido.jsp" scope="session"/>
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
<form class="main__mantenimiento" action="ServletMenuPedido" method="post">

<label>Pedido ID:</label>

<input type="text" name="pedido_id" value="${sessionScope.menupedido.pedido_id }" readonly>
<label>Menu pedido:</label>

<input type="text" value="${sessionScope.menupedido.menu_id }" name="menu_id" readonly/>


<label>Cantidad:</label>
<input type="text" name="cantidad" value="${sessionScope.menupedido.cantidad }" placeholder="ingrese la cantidad">
<input type="submit" name="accion" value="actualizar">
</form>
</main>
</body>
</html>
