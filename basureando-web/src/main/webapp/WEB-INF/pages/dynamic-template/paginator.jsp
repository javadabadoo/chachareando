<%--
  Created by IntelliJ IDEA.
  User: java_daba_doo
  Date: 6/30/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pager">
    <c:if test="${userEntryPage.currentPage > 0}">
        <a href="${pageContext.request.contextPath}/consulta/entrada/${userEntryPage.currentPage -1}"
           class="button previous">Previous</a>
    </c:if>
    <div class="pages">
        <c:forEach
                var="userEntryIndex"
                begin="${userEntryPage.currentPage > 3 ? userEntryPage.currentPage - 3 : 0}"
                end="${(userEntryPage.currentPage + 3) > userEntryPage.totalPages ? userEntryPage.totalPages : userEntryPage.currentPage + 3}"
                step="1">
            <c:choose>
                <c:when test="${userEntryPage.currentPage == userEntryIndex}"><a
                        class="active">${userEntryIndex}</a></c:when>
                <c:otherwise><a
                        href="${pageContext.request.contextPath}/consulta/entrada/${userEntryIndex}">${userEntryIndex}</a></c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${(userEntryPage.currentPage + 4) < userEntryPage.totalPages}">
            <span>&hellip;</span>
            <a href="${pageContext.request.contextPath}/consulta/entrada/${userEntryPage.totalPages}">${userEntryPage.totalPages}</a>
        </c:if>
    </div>

    <c:if test="${userEntryPage.currentPage < userEntryPage.totalPages}">
        <a href="${pageContext.request.contextPath}/consulta/entrada/${userEntryPage.currentPage + 1}" class="button next">Next</a>
    </c:if>
</div>