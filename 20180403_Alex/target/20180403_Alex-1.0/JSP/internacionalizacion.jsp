<%-- 
    Document   : internacionalizacion
    Created on : 19-abr-2018, 16:19:46
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internacionalizaci&oacute;n</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
        <%-- script encontrado en internet que utiliza jquery para ordenar los datos del select alfabéticamente--%>
        <script>
            function ordenarSelect(id_select) {
                var selectToSort = jQuery('#' + id_select);
                var optionActual = selectToSort.val();
                selectToSort.html(selectToSort.children('option').sort(function (a, b) {
                    return a.text === b.text ? 0 : a.text < b.text ? -1 : 1;
                })).val(optionActual);
            }
            $(document).ready(function () {
                ordenarSelect('selectPaises');
            });
        </script>
    </head>
    <body class="contenido">
        <form action="controlPais" method="POST">
            <table>
                <tr>
                    <td><label for="Pais">Seleccione un pa&iacute;s y su idioma: </label></td>
                    <td>
                        <select name="Pais" id="selectPaises">
                            <c:forEach var="select" items="${idiomas}">
                                <%--Quitamos aquellos paises que aparezcan en blanco y aquellos cuyo codigo contenga #, ya que estan duplicados --%>
                                <c:if test="${select.getDisplayCountry()!=\"\" && !select.toString().contains(\"#\")}" >
                                    <option value="${select}"
                                        <%-- Si el país es Albania (el primero por orden alfabético) lo dejamos seleccionado por defecto--%>
                                        <c:if test="${select.getDisplayCountry() ==\"Albania\" }">
                                            selected="selected"
                                        </c:if>
                                    >${select.getDisplayCountry()}, ${select.getDisplayLanguage()}</option>
                                </c:if>
                            </c:forEach>
                                    
                                    <input type="hidden" name="oculto" value="${select.getDisplayCountry()}"/>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" name="Enviar" value="Enviar">
            <br><br>
            <a href="${pageContext.request.contextPath}">Volver al men&uacute; principal</a>
        </form>
    </body>
</html>
