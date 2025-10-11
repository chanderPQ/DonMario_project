<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="item" value="${requestScope.mesa }"/>
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
<label>Mesa ID: </label>
<input type="text" name="mesa_id" value="${mesa.mesa_id }" readonly >
<input type="hidden" name="empleado_id" value="${mesa.empleado_id }" >
<label>Capacidad: </label>
<input type="text" name="capacidad" value="${mesa.capacidad }">
<label>Estado: </label>
<div>
<label>Libre    <input type="radio" name="estado" value="libre"></label>
<label>Ocupado  <input type="radio" name="estado" value="ocupado"></label>
</div>
<input type="submit" name="accion" value="actualizar">
</form>
</main>
</body>
</html>