<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.load==null}">

<c:set var="load" value="1" scope="session"/>
<c:set var="distrito" value="${requestScope.distrito }"></c:set>
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
<body style="padding:25px;">
<p>Mantenimiento Distrito</p>
<main>
<form class="main__mantenimiento" action="ServletDistrito" method="post">
<input type="hidden" name="distrito_id" value="${distrito.getDistrito_id() }">
<label>nombre del distrito</label>
<input type="text" name="nombre" placeholder="ingrese el nombre del distrito" value="${distrito.getNombre() }">
<input type="submit" name="accion" value="actualizar">
</form>
</main>
</body>
</html>