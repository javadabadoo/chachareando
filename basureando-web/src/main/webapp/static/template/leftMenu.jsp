<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/inicio" var="url_inicio" />
<script type="text/javascript">
$(function() {
	$('#menu').menu();
});
</script>
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