<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="templates/header.jsp" />

<div class="container">
    <div class="row">
        <div class="col">
            <form id="form" method="post" action="login">
                <div class="form-control">
                    <label for="e">Ingresa tu email:</label>
                    <input type="email"
                           name="email"
                           id="e"
                           required=""
                           placeholder="Tu email" />
                </div>
                <div class="form-control">
                    <label for="p">Ingresa tu contraseña:</label>
                    <input type="password"
                           name="pass"
                           id="p"
                           required=""
                           placeholder="Tu contraseña" />
                </div>
                <div class="form-control">
                    <label for="p2">Reingresa tu contraseña:</label>
                    <input type="password"
                           name="passConfirm"
                           id="p2"
                           required=""
                           placeholder="Repite contraseña" />
                </div>
                <input type="hidden" name="registro" value="true" />
                <button class="btn btn-primary"
                        type="button" onclick="compara()">Registrarme</button>
            </form>
        </div>
    </div>
</div>

<script>
    function compara(){
        var p1 = document.getElementById('p').value;
        var p2 = document.getElementById('p2').value;
        if(p1 == p2 && p1 != "" && p2 != ""){
            //Mandar el formulario
            document.getElementById('form').submit();
        }else{
            //Deberia advertirle y no mandar el formulario
            alert("Tus contraseñas no coinciden");
        }
    }
</script>

<jsp:include page="templates/footer.jsp" />