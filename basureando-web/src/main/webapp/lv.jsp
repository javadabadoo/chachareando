<%--
  Created by IntelliJ IDEA.
  User: XM060EF
  Date: 24/05/13
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/js/jquery-1.9.1.js" var="url_jquery" />
<spring:url value="/js/livevalidation_standalone.js" var="url_liveValidation" />
<html>
<head>
    <script type="text/javascript" src="${url_jquery}"></script>
    <script type="text/javascript" src="${url_liveValidation}"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var nombre = new LiveValidation( "nombre", { validMessage: "Correcto!", wait: 100 } );
            var apellidoPaterno = new LiveValidation( "apellidoPaterno", { validMessage: "Este si es válido", wait: 100 } );

            nombre.add(
                    Validate.Presence,
                    {
                        failureMessage: 'Campo requerido'
                    } );

            nombre.add(Validate.Email);

            apellidoPaterno.add(
                    Validate.Numericality, { is: 2000 }
            );
        });
    </script>
    <style type="text/css">

        .LV_validation_message{
            font-weight:bold;
            margin:0 0 0 5px;
            float: left;
        }

        .LV_valid {
            color:#8DC262;
        }

        .LV_invalid {
            color:#CC0000;
        }

        .LV_valid_field,
        input.LV_valid_field:hover,
        input.LV_valid_field:active,
        textarea.LV_valid_field:hover,
        textarea.LV_valid_field:active {
            border: 1px solid #8DC262;
        }

        .LV_invalid_field,
        input.LV_invalid_field:hover,
        input.LV_invalid_field:active,
        textarea.LV_invalid_field:hover,
        textarea.LV_invalid_field:active {
            border: 1px solid #CC0000;
        }

        .ko_validation_image {
            height: 16px;
            width: 16px;
            float: left;
            background-image: url(css/images/ui-icons_cd0a0a_256x240.png);
            background-position: 224px 48px;
        }

        .ok_validation_image {
            height: 16px;
            width: 16px;
            float: left;
            background-image: url(css/images/ui-icons_8DC262_256x240.png);
            background-position: 192px 96px;
        }
    </style>
    <title></title>
</head>
<body>

<h2>Validacion de form</h2>
<br />

<form id="formulario" method="get" action="#submited">
    <table>
        <tr>
            <td><input type="text" id="nombre" required="required" /></td>
            <td id="formulario_nombre_message">&nbsp;Texto <span class="LV_valid LV_validation_message">Inicial</span></td>
        </tr>
        <tr>
            <td><input type="text" id="apellidoPaterno" required="required" /></td>
            <td id="formulario_apellidoPaterno_message"></td>
        </tr>
        <tr>
            <td><input type="text" id="apellidoMaterno"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><input type="text" id="edad" required="required"/></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td><input type="submit" /></td>
            <td>&nbsp;</td>
        </tr>
    </table>
</form>

</body>
</html>