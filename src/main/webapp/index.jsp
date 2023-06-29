<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Porfavor inicia sesión en el sistema</h1>
<br/>
<form action="login" method="post">
    <label>Correo:</label><input type="email" name="email">
    <br/>
    <label>Contraseña:</label><input type="password" name="pass">
    <input type="submit" value="iniciar sesión">
</form>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>