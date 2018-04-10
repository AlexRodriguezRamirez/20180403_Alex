<%-- 
    Document   : edad
    Created on : 10-abr-2018, 17:19:27
    Author     : Alex
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../CSS/estilos.css"/>
        <title>Calcular edad</title>
    </head>
    <body class="contenido">
        
        <%
            Date fecha = new Date();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           
            Date fechaNacimiento = dateFormat.parse(request.getParameter("Fecha"));
            String aux = dateFormat.format(fecha);
            Date fechaActual = dateFormat.parse(aux);
 
            long fechaInicial = fechaNacimiento.getTime();
            long fechaFinal = fechaActual.getTime();
            long diferencia = fechaFinal - fechaInicial;
            double diferenciaDias = diferencia / (1000 * 60 * 60 * 24);

            int dias = (int) diferenciaDias%30;
            double mesesAux = diferenciaDias / 30;
            int meses = (int) mesesAux%12;
            int anios = (int)mesesAux / 12;
            
            if (diferenciaDias < 0) {
                %>
                <h2>Hola <%=request.getParameter("Nombre")%>, nacerás dentro de <%=-anios%> años, <%=-meses%> meses y <%=-dias%> días.</h2>
        <%  }
            else {
                if (diferenciaDias == 0) {
                    %>
                        <h2>Hola <%=request.getParameter("Nombre")%>, has nacido hoy, bienvenido al mundo.</h2>
                    <%
                }
                else {
                    %>
                        <h2>Hola <%=request.getParameter("Nombre")%>, tienes <%=anios%> años, <%=meses%> meses y <%=dias%> días.</h2>
                    <%
                }
            }
        %>
        
        <a href="<%=request.getContextPath()%>">Volver al men&uacute; principal</a>

    </body>
</html>
