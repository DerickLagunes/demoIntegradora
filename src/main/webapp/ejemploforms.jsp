<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="assets/icon/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>Registro de examen</h1>
<br>
  <form>
      <div id="principal"></div>
      <br>
      <input id="registro" hidden="" class="btn btn-primary" type="submit" value="Registrar examen">
  </form>
    <div class="form-group">
        <p>Utilize los siguientes botones para agregar preguntas al examen</p>
        <button class="btn btn-info" type="button" onclick="agregarAbierta()"><i class="bi-plus-circle"></i> Abierta</button>
        <button class="btn btn-info" type="button" onclick="agregarMultiple()"><i class="bi-ui-radios-grid"></i> Opción_multiple</button>
    </div>
<script>
    var formulario = document.getElementById('principal');
    var count = 0;

    function agregarAbierta(){
        count++;
        var group = document.createElement('div');
        group.setAttribute('class','form-group');
        var lab = document.createElement('label');
        lab.setAttribute('for', 'pregunta'+count)
        lab.innerText = "Pregunta Abierta "+count+":";
        var pregunta = document.createElement('input');
        pregunta.setAttribute('type','text');
        pregunta.setAttribute('id','pregunta'+count);
        pregunta.setAttribute('name','pregunta'+count);
        pregunta.setAttribute('class','form-control');
        pregunta.setAttribute('placeholder','Escriba la pregunta abierta aqui');
        var eliminar = document.createElement('button');
        eliminar.setAttribute('onclick','eliminarPregunta(\"'+pregunta.getAttribute('id')+'\")');
        eliminar.setAttribute('class', 'btn btn-danger')
        eliminar.innerHTML = "<i class='bi-trash3-fill'></i>";
        group.appendChild(lab);
        group.appendChild(pregunta);
        group.appendChild(eliminar);
        formulario.appendChild(group);
        var salto = document.createElement('br');
        formulario.appendChild(salto);

        document.getElementById('registro').removeAttribute('hidden');
    }

    function agregarMultiple(){
        count++;
        var group = document.createElement('div');
        group.setAttribute('class','form-group');
        var lab = document.createElement('label');
        lab.setAttribute('for', 'pregunta'+count)
        lab.innerText = "Pregunta Op. Multiple "+count+":";
        var pregunta = document.createElement('input');
        pregunta.setAttribute('type','text');
        pregunta.setAttribute('id','pregunta'+count);
        pregunta.setAttribute('name','pregunta'+count);
        pregunta.setAttribute('class','form-control');
        pregunta.setAttribute('placeholder','Escriba la pregunta de opción multiple aqui');
        var op1 = document.createElement('input');
        op1.setAttribute('type','text');
        op1.setAttribute('id','pregunta'+count+'op1');
        op1.setAttribute('name','pregunta'+count+'op1');
        op1.setAttribute('class','form-control');
        op1.setAttribute('placeholder','Escriba una opción aqui');
        var op2 = document.createElement('input');
        op2.setAttribute('type','text');
        op2.setAttribute('id','pregunta'+count+'op2');
        op2.setAttribute('name','pregunta'+count+'op2');
        op2.setAttribute('class','form-control');
        op2.setAttribute('placeholder','Escriba una opción aqui');
        var eliminar = document.createElement('button');
        eliminar.setAttribute('onclick','eliminarPregunta(\"'+pregunta.getAttribute('id')+'\")');
        eliminar.setAttribute('class', 'btn btn-danger')
        eliminar.innerHTML = "<i class='bi-trash3-fill'></i>";
        group.appendChild(lab);
        group.appendChild(pregunta);
        group.appendChild(op1);
        group.appendChild(op2);
        group.appendChild(eliminar);
        formulario.appendChild(group);
        var salto = document.createElement('br');
        formulario.appendChild(salto);

        document.getElementById('registro').removeAttribute('hidden');
    }

    function eliminarPregunta(id){
        formulario.removeChild(document.getElementById(id).parentElement);
    }

</script>
</body>
</html>
