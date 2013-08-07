<%--
  Created by IntelliJ IDEA.
  User: Gerardo Aquino
  Date: 07/08/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="is-recent-comments">
    <header>
        <h2>Recent Comments</h2>
    </header>
    <ul>
        <c:forEach items="${recentComments}" var="comment">
            <li>${comment.user.userAlias} <a href="${pageContext.request.contextPath}/post/show/${comment.user.userAlias}/${comment.id}/${comment.encodedTitle}">${comment.title}</a></li>
        </c:forEach>
    </ul>
</section>