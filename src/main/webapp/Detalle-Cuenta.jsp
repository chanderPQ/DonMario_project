<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cuenta" value="${sessionScope.cuenta }"/>
<c:set var="pagina" value="Detalle-Cuenta.jsp" scope="session"/>
<c:if test="${sessionScope.load==null }">
<c:set var="load" value="1" scope="session"/>
<% response.sendRedirect("ServletDistrito"); %>
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
<main style="padding:20px">
<form class="main__mantenimiento" action="ServletEmpleado" method="post" >
<p>Informacion personal</p>
<label>Empleado ID</label>
<input type="text" name="empleado_id" value="${cuenta.empleado_id }" readonly> 
<label>nombre</label>
<input type="text" placeholder="nombre completo" name="nombre" value="${cuenta.nombre }" >
<label>apellido</label>
<input type="text" placeholder="apellido completo" name="apellido" value="${cuenta.apellido }" >
<label>distrito:</label>
<select name="distrito_id" >
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
<input type="email" placeholder="ingrese su correo" name="correo" value="${cuenta.correo }" >
<label>contraseña</label>
<input type="password" placeholder="ingrese su nueva contraseña" name="clave" value="${cuenta.clave }" >
<input type="submit" name="accion" value="actualizar" class="btn btn-primary">
<input type="submit" name="accion" value="cerrar session" class="btn btn-secondary" > 
</form>
</main>
</body>
</html>