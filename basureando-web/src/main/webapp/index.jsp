<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:url value='/js/jquery-1.9.1.js' var="url_jquery" />
<spring:url value='/js/jquery-ui.js' var="url_jquery_ui" />
<spring:url value='/js/usuario.js' var="url_usuario_js" />
<spring:url value='/css/principal.css' var="url_principal_css" />
<spring:url value='/css/jquery-ui.css' var="url_jqueryUi_css" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
        <a href="#" onclick="getSysinfo('consulta/json/usuario/javadabadoo')">Carga Informacion</a>


        <ul id="menu">
            <li class="ui-state-disabled"><a href="#">Aberdeen</a></li>
            <li><a href="#">Ada</a></li>
            <li><a href="#">Adamsville</a></li>
            <li><a href="#">Addyston</a></li>
            <li>
                <a href="#">Delphi</a>
                <ul>
                    <li class="ui-state-disabled"><a href="#">Ada</a></li>
                    <li><a href="#">Saarland</a></li>
                    <li><a href="#">Salzburg</a></li>
                </ul>
            </li>
            <li><a href="#">Saarland</a></li>
            <li>
                <a href="#">Salzburg</a>
                <ul>
                    <li>
                        <a href="#">Delphi</a>
                        <ul>
                            <li><a href="#">Ada</a></li>
                            <li><a href="#">Saarland</a></li>
                            <li><a href="#">Salzburg</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Delphi</a>
                        <ul>
                            <li><a href="#">Ada</a></li>
                            <li><a href="#">Saarland</a></li>
                            <li><a href="#">Salzburg</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Perch</a></li>
                </ul>
            </li>
            <li class="ui-state-disabled"><a href="#">Amesville</a></li>
        </ul>
    </body>
</html>