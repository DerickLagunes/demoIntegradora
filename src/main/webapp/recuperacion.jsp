<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp" />

<form method="post" action="RecuperaServlet">
  <input type="email" name="email" placeholder="Ingrese su correo electronico" />
  <input type="submit" value="Recuperar contraseña" />
</form>

<jsp:include page="templates/footer.jsp" />