<%--
  Created by IntelliJ IDEA.
  User: XM060EF
  Date: 4/07/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${userEntryPage.items}" var="post" varStatus="status">
    <article class="is-post is-post-excerpt">
        <header>
            <h2><a href="${pageContext.request.contextPath}/post/show/${post.user.userAlias}/${post.id}/${post.encodedTitle}">${post.title}</a></h2>
            <div style="float: left"><img src="${pageContext.request.contextPath}/image/resizer/60/60/${post.user.id}" alt="" /></div>
            <span class="byline">${post.title}</span>
            <a href="#PerfilDeUsuario">${post.user.userAlias}</a>: <span class="date">${post.publicationDate}</span>
        </header>
        <p>${post.content}</p>
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


<!-- Pager -->
<jsp:include page="paginator.jsp" />