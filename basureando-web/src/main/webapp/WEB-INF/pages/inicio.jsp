<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value='/js/jquery-1.9.1.js' var="url_jquery" />
<html>
<head>
    <script type="text/javascript" src="${url_jquery}"></script>
</head>
<body>
	<h2>Message : ${mensajito}</h2>	(con seguridad)
	
	<a href="j_spring_security_logout">Salir</a>

<script type="text/javascript">
    $(function() {
    });
</script>
</body>
</html>