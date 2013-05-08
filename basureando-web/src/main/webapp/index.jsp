<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<spring:url value='/js/jquery-1.9.1.js' var="url_jquery" />
<spring:url value='/js/usuario.js' var="url_usuario_js" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script type="text/javascript" src="${url_jquery}"></script>
        <script type="text/javascript" src="${url_usuario_js}"></script>
        <title>Insert title here</title>

        <script type="text/javascript">
            $(function () {
                getSysinfo('consulta/json/usuario/javadabadoo');
            });
        </script>
    </head>
    <body>
        <h2>Inicio</h2> (sin seguridad)
        <a href="#" onclick="getSysinfo('consulta/json/usuario/javadabadoo')">Carga Informacion</a>
    </body>
</html>