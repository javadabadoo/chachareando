<%--
  Created by IntelliJ IDEA.
  User: java_daba_doo
  Date: 7/28/13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form  action="${pageContext.request.contextPath}" method="POST" commandName="userPost" name="user-post-editor" id="user-post-editor">
    <form:input type="text" name="title" placeholder="Post title" path="title" />
    <input type="text" name="tags" id="user-post-editor-tags" class="text" placeholder="Post tags" />
    <form:textarea name="content" id="user-post-editor-content" class="text" placeholder="Post content" path="content" />
    <input type="submit" />
</form:form>

<script type="text/javascript">
    $('#user-post-editor-tags').tagsInput({
        width: 'auto',
        autocomplete_url:'${pageContext.request.contextPath}/tags/list'
    });
</script>