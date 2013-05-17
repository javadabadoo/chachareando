<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/js/jquery-1.9.1.js" var="url_jquery" />
<spring:url value="/js/jquery-ui.js" var="url_jquery_ui" />
<spring:url value="/js/principal.js" var="url_principal_js" />
<spring:url value="/js/usuario.js" var="url_usuario_js" />
<spring:url value="/css/principal.css" var="url_principal_css" />
<spring:url value="/css/jquery-ui.css" var="url_jqueryUi_css" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${url_principal_css}" />
        <link rel="stylesheet" href="${url_jqueryUi_css}" />
        <script type="text/javascript" src="${url_jquery}"></script>
        <script type="text/javascript" src="${url_jquery_ui}"></script>
        <script type="text/javascript" src="${url_principal_js}"></script>
        <script type="text/javascript" src="${url_usuario_js}"></script>
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
				<div id="contenidoPrincipal"><h2>Este es el titulo</h2><br />XXXX xxxx XX Xxxxx</div>
			</div>
        </div>
        <div id="dialog" />

    </body>
</html>