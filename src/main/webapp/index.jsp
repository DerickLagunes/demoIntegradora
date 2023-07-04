<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="templates/header.jsp" />
<c:if test="${not empty login}">
    <h1>Bienvenido usuario ${login.email}</h1>
</c:if>
<c:if test="${empty login}">
    <main>
        <div class="container-fluid" style="padding-top:100px; text-align: center;">
            <div class="row">
                <div class="d-none d-sm-block offset-md-1 col-md-4 align-content-center">
                    <h1>Bienvenido a Zazil</h1><br/>
                    <img src="assets/img/logo.png" alt="logo">
                    <p class="lead">zazil es una empresa dedicada a la distribución y venta de insumos medicos y esteticos.</p>
                </div>
                <div class="col-sm-12 col-md-6 align-content-center">
                    <form class="form-signin" action="login" method="post">
                        <img class="mb-4" src="assets/img/login.png" alt="login" width="350" height="200">
                        <h1 class="h3 mb-3 font-weight-normal">Porfavor inicia sesión:</h1>
                        <label for="inputEmail" class="sr-only">Correo:</label>
                        <input type="text" id="inputEmail" class="form-control" placeholder="Correo electronico" required="" autofocus="" name="email">
                        <label for="inputPassword" class="sr-only">Password</label>
                        <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required="" name="pass">
                        <br/>
                        <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar sesión</button>
                        <a class="btn btn-lg btn-primary btn-block" href="registro.jsp">Registrarse</a>
                    </form>
                </div>
            </div>
            <p class="mt-5 mb-3 text-muted">©Aplicaciones Web</p>
        </div>
    </main>
</c:if>


<jsp:include page="templates/footer.jsp" />