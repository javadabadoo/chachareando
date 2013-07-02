<%--
  Created by IntelliJ IDEA.
  User: java_daba_doo
  Date: 6/30/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${userEntries}" var="entries" varStatus="status">

    <article class="is-post is-post-excerpt">
        <header>
            <h2><a href="#">${entries.title}</a></h2>
            <div style="float: left"><img src="consulta/imagen/usuario/perfil/60/60/${entries.user.id}" alt="" /></div>
            <span class="byline">${entries.title}</span>
            <a href="#PerfilDeUsuario">${entries.user.name}</a>: <span class="date">${entries.publicationDate}</span>
        </header>
        <p>${entries.content}</p>

        <div class="info">
            <span class="date"><span class="month">Jan<span>uary</span></span> <span class="day">8</span><span class="year">, 2013</span></span>
            <ul class="stats">
                <li><a href="#" class="link-icon24 link-icon24-1">12</a></li>
                <li><a href="#" class="link-icon24 link-icon24-2">24</a></li>
                <li><a href="#" class="link-icon24 link-icon24-3">48</a></li>
                <li><a href="#" class="link-icon24 link-icon24-4">96</a></li>
            </ul>
        </div>
    </article>

</c:forEach>