<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.load==null}">
<c:set var="load" value="1" scope="session"/>
<c:set var="empleado" value="${requestScope.empleado }"/>
<jsp:forward page="ServletDistrito"/>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Mantenimiento-Menu.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<main style="padding:20px">
<form class="main__mantenimiento" action="ServletEmpleado" method="post" >
<p>Informacion personal</p>
<input type="text" name="empleado_id" value="${empleado.empleado_id }" > 
<label>nombre</label>
<input type="text" placeholder="nombre completo" name="nombre" value="${empleado.nombre }" >
<label>apellido</label>
<input type="text" placeholder="apellido completo" name="apellido" value="${empleado.apellido }" >
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
<input type="email" placeholder="ingrese su correo" name="correo" value="${empleado.correo }" >
<label>contraseña</label>
<input type="password" placeholder="ingrese su nueva contraseña" name="clave" value="${empleado.clave }" >
<input type="submit" name="accion" value="actualizar" >
</form>
</main>
</body>
</html>