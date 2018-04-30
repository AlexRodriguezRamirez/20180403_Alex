<%-- 
    Document   : tags
    Created on : 29-abr-2018, 22:05:42
    Author     : Alex
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/tlds/AlexRodriguezTags" prefix="ar" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etiquetas personalizadas</title>
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
    </head>
    <body class="etiquetas">
        <c:set var="texto" value="Hola Mundo"/>
        <table class="arriba">
            <tr>
                <th>Librer&iacute;a</th>
                <th>Prefijo</th>
                <th>Uri</th>
            </tr>
            
            <tr>
                <td>Personalizada</td>
                <td>ar</td>
                <td>/WEB-INF/tlds/AlexRodriguezTags</td>
            </tr>          
        </table>
        
        
        <table class="abajo">
            <tr>
                <th>Etiqueta</th>
                <th>Significado</th>
                <th>Atributos</th>
                <th>Requerido</th>
                <th>Ejemplo</th>
                <th>Salida</th>
            </tr>
            
            <tr>
                <td>login</td>
                <td>Muestra un div con dos cajas de texto para introducir usuario y contraseña.</td>
                <td>Ninguno</td>
                <td>Ninguno</td>
                <td>&lt;ar:login/&gt;</td>
                <td><ar:login/></td>
            </tr>
            
            <tr>
                <td>potencia</td>
                <td>Dados una base y un exponente, calcula la potencia.</td>
                <td>base<br>exponente</td>
                <td>S&iacute;<br>S&iacute;</td>
                <td>&lt;ar:potencia base="2" exponente="3"/&gt;</td>
                <td><ar:potencia base="2" exponente="3"/></td>
            </tr>
            
            <tr>
                <td>repetir</td>
                <td>Escribe el valor de una variable el número de veces que se indique.</td>
                <td>numero<br>mensaje</td>
                <td>S&iacute;<br>S&iacute;</td>
                <td>&lt;ar:repetir numero="4" mensaje="&#36;{texto}"/&gt;</td>
                <td><ar:repetir numero="4" mensaje="${texto}"/></td>
            </tr>
            
            <tr>
                <td>aleatorio</td>
                <td>Genera un entero aleatorio comprendido entre los valores introducidos.</td>
                <td>minimo<br>maximo</td>
                <td>S&iacute;<br>S&iacute;</td>
                <td>&lt;ar:aleatorio minimo="1" maximo="100"/&gt;</td>
                <td><ar:aleatorio minimo="1" maximo="100"/></td>
            </tr>
            
            <tr>
                <td>colorear</td>
                <td>Colorea cada letra de la palabra introducida de un color diferente</td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            
            
        </table>
    </body>
</html>
