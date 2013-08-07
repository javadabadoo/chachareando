<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/js/principal.js" var="url_principal_js" />
<spring:url value="/js/usuario.js" var="url_usuario_js" />
<spring:url value="/js/entrada.js" var="url_entrada_js" />
<spring:url value="/js/jquery.dataTables.js" var="url_dataTables_js" />
<spring:url value="/css/principal.css" var="url_principal_css" />
<spring:url value="/css/jquery-ui.css" var="url_jqueryUi_css" />
<spring:url value="/css/demo_table.css" var="url_table_css" />
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style type="text/css" title="currentStyle">
        @import "${url_principal_css}";
        @import "${url_jqueryUi_css}";
        @import "${url_table_css}";
    </style>
    <script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.22/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${url_principal_js}"></script>
    <script type="text/javascript" src="${url_usuario_js}"></script>
    <script type="text/javascript" src="${url_entrada_js}"></script>
    <script type="text/javascript" src="${url_dataTables_js}"></script>
    <title>Inicio Basureando</title>
</head>
<body>
<div id="divBanned">
    <h2>Inicio</h2> (sin seguridad)<br />
</div>
<div id="menuSuperior">
    <a href="#">Inicio</a><span class="pipeSeparadorMenu">|</span>
    <a href="#">Entradas Recientes</a><span class="pipeSeparadorMenu">|</span>
    <a href="#">Blogs</a><span class="pipeSeparadorMenu">|</span>
    <a href="#">Configuraci&oacute;n</a>
</div>
<br />
<div id="principal">
    <h1>java.daba.doo</h1>
    <div id="fila">
        <div id="divMenuPrincipal"></div>
        <div id="contenidoPrincipal"></div>
    </div>
</div>
<div id="dialog" />

</body>
</html>