<%-- 
    Document   : salidaInternacionalizacion
    Created on : 20-abr-2018, 18:33:42
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internacionalizaci&oacute;n</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        
        <p>El c&oacute;digo de idioma del pa&iacute;s elegido es "<c:out value="${requestScope.codigo}"/>"</p>
        
        <fmt:bundle basename="${codigo}">
            <p>El saludo en ese pa&iacute;s es "<fmt:message key="hola"/>"</p>
            <p>La despedida en ese pa&iacute;s es "<fmt:message key="adios"/>"</p>   
        </fmt:bundle>
        
        <fmt:setLocale value="${codigo}"/>
        
        <p>Formato de moneda local: <fmt:formatNumber value="100.85" type="currency"/></p>
        
        <fmt:bundle basename="GMT">
            <p>La fecha actual es "<fmt:formatDate type="date" dateStyle="long" timeZone="${codigo}" value="${fecha}"/>"</p>
            <p>La hora actual es "<fmt:formatDate type="time" dateStyle="long" timeZone="${codigo}" value="${fecha}"/>"</p>
        </fmt:bundle>
        
        
        
        
        <a href="${pageContext.request.contextPath}">Volver al men&uacute; principal</a>
    </body>
</html>
