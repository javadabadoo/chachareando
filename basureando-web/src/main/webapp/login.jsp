<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form name='f' action='j_spring_security_check' method='POST'>
    <table>
        <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password'/></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Login"/></td>
        </tr>
    </table>

    <a href="/">Inicio</a>
</form>
</body>
</html>