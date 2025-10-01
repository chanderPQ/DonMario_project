<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Mantenimiento-Menu.css">
</head>
<body>
<p>Mantenimiento Menu</p>
<main>
<form class="main__mantenimiento" action="ServletMenu" method="post">
<input type="hidden" name="empleado_id" value="1">
<label>nombre del menu</label>
<input type="text" name="nombre" placeholder="ingrese el nombre del plato">
<label>costo</label>
<input type="text" name="costo" placeholder="ingrese el costo">
<input type="submit" name="accion" value="crear">
</form>
</main>
<script type="text/javascript">
</script>
</body>
</html>