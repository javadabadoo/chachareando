<%--
  Created by IntelliJ IDEA.
  User: Gerardo Aquino
  Date: 15/07/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="is-recent-posts">
    <header>
        <h2>Recent Posts</h2>
    </header>
    <ul>
        <c:forEach items="${recentEntries}" var="entry">
            <li><a href="${pageContext.request.contextPath}/post/show/${entry.user.userAlias}/${entry.id}/${entry.encodedTitle}">${entry.title}</a></li>
        </c:forEach>
    </ul>
</section>