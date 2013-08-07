<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<html>
    <head>
        <script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.min.js"></script>
    </head>
    <body>
        <h2>Message : ${mensajito}</h2>	(con seguridad)

        <a href="j_spring_security_logout">Salir</a>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            Administrador
        </sec:authorize>

        <script type="text/javascript">
            $(function() {
            });
        </script>
    </body>
</html>