<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:url value="/js/jquery-1.9.1.js" var="url_jquery" />
<spring:url value="/js/jquery-ui.js" var="url_jquery_ui" />
<spring:url value="/js/usuario.js" var="url_usuario_js" />
<spring:url value="/css/principal.css" var="url_principal_css" />
<spring:url value="/css/jquery-ui.css" var="url_jqueryUi_css" />
<spring:url value="/inicio" var="url_inicio" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${url_principal_css}" />
        <link rel="stylesheet" href="${url_jqueryUi_css}" />
        <script type="text/javascript" src="${url_jquery}"></script>
        <script type="text/javascript" src="${url_jquery_ui}"></script>
        <script type="text/javascript" src="${url_usuario_js}"></script>
        <title>Inicio Basureando</title>

        <script>
            $(function() {
                $( "#menu" ).menu();
            });
        </script>
    </head>
    <body>
        <h2>Inicio</h2> (sin seguridad)

        <ul id="menu">
            <li><a href="${url_inicio}">Inicio</a></li>
            <li><a href="#">Mi blog</a></li>
            <li><a href="#">Actualizaciones</a></li>
            <li><a href="#">Nueva entrada</a></li>
            <li>
                <a href="#">Perfil</a>
                <ul>
                    <li><a href="#" onclick="javascript:muestraVentana('dialog', 'Mi Perfil!')">Mi perfil</a></li>
                    <li class="ui-state-disabled"><a href="#">Cambiar password</a></li>
                    <li><a href="#">Bloquear cuenta</a></li>
                </ul>
            </li>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li>
                    <a href="#">Administracion</a>
                    <ul>
                        <li class="ui-state-disabled"><a href="#">Usuarios</a></li>
                        <li class="ui-state-disabled"><a href="#">Entradas</a></li>
                        <li class="ui-state-disabled"><a href="#">Foros</a></li>
                        <li><a href="#">Bloquear cuenta</a></li>
                    </ul>
                </li>
            </sec:authorize>
            <li><a href="j_spring_security_logout">Salir</a></li>
        </ul>

        <div id="dialog" />

    </body>
</html>