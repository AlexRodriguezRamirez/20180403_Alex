<%-- 
    Document   : contadorCookies
    Created on : 12-abr-2018, 16:21:37
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
        <title>Contador de visitas</title>
    </head>
    <body class="contenido">
        
        <% 
            Cookie[] Cookies = request.getCookies();
            Cookie contador = null;
            for (Cookie miCookie : Cookies) {
                if (miCookie.getName().equals("CONTADOR")) {
                    contador = new Cookie (miCookie.getName(), miCookie.getValue());
                    break;
                }
            }
            
            if (contador == null) {
               contador = new Cookie("CONTADOR", "0");
            }
            else {
                if (request.getParameter("Eliminar") != null) {
                    contador.setValue("0");
                }    
            }
            
            
            int cont = Integer.parseInt(contador.getValue());
            contador.setValue(Integer.toString(cont + 1));
            contador.setMaxAge(86400);
            contador.setSecure(false);
            contador.setVersion(1);
                
            response.addCookie(contador);
            
            
        %>
        
        <h1><b>Has visitado la página <%=contador.getValue() %> veces.</b></h1>
        <% 
            if(Integer.parseInt(contador.getValue()) < 2) {
        %>
        
        <h2><b>Información de la cookie:</b></h2>
        <p>Caducidad: <%=contador.getMaxAge()%></p>
        <p>Nombre: <%=contador.getName()%></p>
        <p>Segura: <%=contador.getSecure()%></p>
        <p>Versión: <%=contador.getVersion()%></p>
        
        <%
        }
        %>
        
        <form action="contadorCookies.jsp" method="POST">
            <a href="contadorCookies.jsp"><input type="button" name="Recargar" value="Recargar"></a>
            <input type="submit" value="Eliminar" name="Eliminar"/>
            <a href="<%=request.getContextPath()%>"><input type="button" name="Menu" value="Men&uacute; principal"></a>
        </form>
    </body>
</html>
