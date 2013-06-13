<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/js/jquery-1.9.1.js" var="url_jquery"/>
<spring:url value="/js/principal.js" var="url_principal_js" />
<spring:url value="/js/mailFormDescriptor.js" var="url_mailFormDescriptor_js" />
<spring:url value="/js/livevalidation_standalone.js" var="url_liveValidation"/>
<spring:url value="/css/forms.css" var="url_forms_css" />

<html>
<head>
    <script type="text/javascript" src="${url_jquery}"></script>
    <script type="text/javascript" src="${url_principal_js}"></script>
    <script type="text/javascript" src="${url_liveValidation}"></script>
    <script type="text/javascript" src="${url_mailFormDescriptor_js}"></script>

    <style type="text/css" title="currentStyle">
        @import "${url_forms_css}";
    </style>

    <title>Prueba de Validación</title>
</head>
<body>

<h2>Validacion de form</h2>
<br/>
<form:form method="post" commandName="sendMailBean" action="send" id="formulario">
    <table>
        <tr>
            <td>
                <form:input type="text" id="sentFrom" path="sentFrom" required="required"/>
            </td>
            <td id="formulario_sentFrom_message">
                <form:errors path="sentFrom" cssClass="LV_validation_message LV_invalid"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:input type="text" id="title" path="title"/>
            </td>
            <td id="formulario_title_message">
                <form:errors path="title" cssClass="LV_validation_message LV_invalid"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
            <td>&nbsp;</td>
        </tr>
    </table>
</form:form>

</body>
</html>