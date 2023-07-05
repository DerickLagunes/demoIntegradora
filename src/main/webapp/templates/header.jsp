<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zazil</title>
    <meta name="">
    <meta name="keywords" content="Tienda en linea de Zazil - insumos cosmeticos">
    <meta name="description" content="Ejemplo de integradora">
    <meta name="author" content="Derick Lagunes">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/icon/font/bootstrap-icons.css" />
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
                Zazil
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/index.jsp">Home</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/tienda.jsp">Productos</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/contacto">Contacto</a>
                    <a class="nav-link" href="${pageContext.request.contextPath}/zazil.jsp">¿Quienes somos?</a>
                </div>
            </div>
        </div>
    </nav>
</header>
