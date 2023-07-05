<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<c:if test="${not empty sesion}">
    <h1>Bienvenido al sistema ${sesion.email}</h1>
    <c:if test="${sesion.email == 'admin'}">
        <p>Eres administrador</p>
    </c:if>
    <a class="btn btn-danger" href="login">Logout</a>
</c:if>
<c:if test="${empty sesion}">
<h1>Porfavor inicia sesión en el sistema</h1>
<br/>
<form action="login" method="post">
    <label>Correo:</label>
    <input type="text" name="email" required="">
    <br/>
    <label>Contraseña:</label>
    <input type="password" name="pass" required="">
    <input type="submit" value="iniciar sesión">
</form>
<a href="hello-servlet">Hello Servlet</a>
</c:if>
<a href="productos">ver productos</a>
</body>
</html>