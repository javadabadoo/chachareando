<%--
  Created by IntelliJ IDEA.
  User: Gerardo Aquino
  Date: 12/08/13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a href="${twitterAuthenticationURL}" target="twitter.authenticate">Login</a>
<form action="${pageContext.request.contextPath}/json/twitter/confirmation" method="post">
    <input type="text" name="pin" />
    <input type="submit" />
</form>