<%--
  Created by IntelliJ IDEA.
  User: java_daba_doo
  Date: 6/30/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${userEntries}" var="entries" varStatus="status">
    <article class="box-excerpt">
        <a href="#" class="image image-left"><img src="consulta/imagen/usuario/perfil/75/75/${entries.user.id}" alt="" /></a>
        <div>
            <header>
                <h3><a href="#">${entries.title}</a></h3>
                <a href="#PerfilDeUsuario">${entries.user.name}</a>: <span class="date">${entries.publicationDate}</span>
            </header>
            <p>${entries.content}</p>
        </div>
    </article>

</c:forEach>