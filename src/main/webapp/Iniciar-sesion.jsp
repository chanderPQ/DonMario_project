<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="iniciar-sesion.css">
</head>
<body>
   <main class="iniciar__main">
   <img alt="" src="https://pbs.twimg.com/profile_images/1904526155765481472/TcKKw0k9_400x400.jpg" size="500">
      <form class="mantenimiento-sign" action="ServletEmpleado" method="post" style="margin:50px" > <p style="font-size:20px;" >Iniciar sesion</p>
            <input type="email" placeholder="enter your email" name="correo" >
            <input type="password" placeholder="enter your password" name="clave">
            <input type="submit" value="acceder" name="accion">
      </form>
   </main>
</body>
</html>