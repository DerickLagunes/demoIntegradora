<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp" />

<form method="post" action="CambiaServlet">
  <label>Ingresa tu nueva contraseña:</label>
  <input type="password" name="pass" required="">
  <input type="hidden" name="id" value="${infoContra.id}">
  <br>
  <input type="submit" value="Cambiar mi contraseña">
</form>

<jsp:include page="templates/footer.jsp" />
