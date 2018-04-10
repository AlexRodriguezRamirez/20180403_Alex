<%-- 
    Document   : saludo
    Created on : 10-abr-2018, 16:39:35
    Author     : Alex
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
        <title>Saludo JSP</title>
    </head>
    <body class="contenido">
        <%
            String sexo;
            if (request.getParameter("Sexo").equals("Hombre")) {
                sexo = "señor";
            }
            else {
                sexo = "señora";
            }
            
            Calendar time = Calendar.getInstance();
            int hora = time.get(Calendar.HOUR_OF_DAY);

            String saludo;
            
            if (hora >= 8 && hora <= 12) {
                saludo = "Buenos días";
            }
            else {
                if (hora > 12 && hora < 21) {
                    saludo = "Buenas tardes";
                }
                else {
                    saludo = "Buenas noches";
                }
            }
            
        %>
        
        <h2><%=saludo%> <%=sexo%> <%=request.getParameter("Nombre")%></h2>
        
        
        <a href="<%=request.getContextPath()%>">Volver al men&uacute; principal</a>
    </body>
</html>
<%-- 8-12: buenos dias
12:01-21:00: buentas tardes
21-8: buenas noches --%>