<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<input type="hidden"  name="empleado_id" value="${requestScope.menu.empleado_id }">
<input type="hidden" name="menu_id" value="${requestScope.menu.menu_id }">
<label>nombre del menu</label>
<input type="text" name="nombre" placeholder="ingrese el nombre del plato" value="${requestScope.menu.nombre }">
<label>costo</label>
<input type="text" name="costo" placeholder="ingrese el costo" value="${requestScope.menu.costo }">
<input type="submit" name="accion" value="actualizar">
</form>
</main>
</body>
</html>