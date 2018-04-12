/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "Registro", urlPatterns = {"/registro"})
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro</title>");            
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\"/>");
            out.println("</head>");
            out.println("<body class=\"contenido\">");
            
            boolean hayErrores = false;
            int[] errores = {0,0,0,0,0,0};
            
            String nombre = request.getParameter("Nombre");            
            
            if (nombre.equals("") || nombre == null) {
                hayErrores = true;
                errores[0] = 1;
            }
            
            //fecha valiada con pattern por falta de tiempo, queda pendiente de modificación
            String fecha = request.getParameter("Fecha de nacimiento");
            if (fecha.equals("") || fecha == null || !fecha.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                hayErrores = true;
                errores[1] = 1;
            }
            
            //dividimos la fecha para posteriormente mostrarla en el formato adecuado
            String[] separar = fecha.split("/");
            String dia = separar[0];
            String mesAux = separar [1];
            String anio = separar[2];
            
            //pasamos el mes a texto
            String mes;
            switch (mesAux) {
                case "1":
                case "01":
                    mes = "Enero";
                    break;
                    
                case "2":
                case "02":
                    mes = "Febrero";
                    break;
                    
                case "3":
                case "03":
                    mes = "Marzo";
                    break;
                    
                case "4":
                case "04":
                    mes = "Abril";
                    break;
                
                case "5":
                case "05":
                    mes = "Mayo";
                    break;
                    
                case "6":
                case "06":
                    mes = "Junio";
                    break;
                    
                case "7":
                case "07":
                    mes = "Julio";
                    break;
                    
                case "8":
                case "08":
                    mes = "Agosto";
                    break;
                    
                case "9":
                case "09":
                    mes = "Septiembre";
                    break;
                
                case "10":
                    mes = "Octubre";
                    break;
                    
                case "11":
                    mes = "Noviembre";
                    break;
                    
                case "12":
                    mes = "Diciembre";
                    break;
                    
                default:
                    mes = "?";
                    break;
                    
                
            }
            
            
            String documento = request.getParameter("Tipo de documento");
            String numero = request.getParameter("Documento");
            
            switch (documento) {
                case "NIF":
                case "NIE":
                    if (numero.equals("") || numero == null || !isNifNie(numero)) {
                        hayErrores = true;
                        errores[2] = 1;
                    }
                    break;
                    
                case "Pasaporte":
                    
                    break;    
                
            }
            
            
            String usuario = request.getParameter("Usuario");
            
            if (usuario.equals("") || usuario == null) {
                hayErrores = true;
                errores[3] = 1;
            }
            
            String password = request.getParameter("Password");
            
            if (password.equals("") || password == null) {
                hayErrores = true;
                errores[4] = 1;
            }
            
            String telefono = request.getParameter("Telefono");
            
            if (telefono.equals("") || telefono == null || (!telefono.startsWith("6") && !telefono.startsWith("7") && !telefono.startsWith("9")) || telefono.length() != 9) {
                hayErrores = true;
                errores[5] = 1;
            }

            
            
            Map<String, String[]> datos = request.getParameterMap();
            Set s = datos.keySet();
            Iterator it = s.iterator();
            String[] preferencias = datos.get("Preferencias");
            
            if (!hayErrores) {
                out.println("<h3>Datos introducidos en el formulario:</h3>");
                while (it.hasNext()) {
                String clave = (String) it.next();
                
                    
                    if (clave.startsWith("Pref")) {
                        out.print("<p>" + clave + ": ");
                        for (String preferencia : preferencias) {
                            out.print("<b>" + preferencia + "</b>&nbsp;");
                        }
                        out.println("</p>");
                    
                    }
                    
                    else {
                        if (clave.startsWith("Fech")) {
                            out.println("<p>" + clave + ": <b>" + dia + " de " + mes + " de " + anio + "</b></p>");
                        }
                        
                        else {
                            if (!clave.startsWith("Env")) {
                                out.println("<p>" + clave + ": <b>" + request.getParameter(clave) + "</b></p>");
                            }
                        }
                    }
                
                }
                
                out.println("<br/>");
                out.println("<a href=" + request.getContextPath() + ">Volver al men&uacute; principal</a>");
            }
            
            else {
                out.println("<form method=\"POST\" action=\"registro\">");
                out.println("<table>");
                out.println("<caption><b>Registro</b></caption>");
                out.println("<tr>");
                out.println("<td>*Nombre:</td>");
                out.print("<td><input type=\"text\" name=\"Nombre\" value=\"" + nombre + "\"></td>");
                out.println("<td>");
                    if (errores[0] == 1) {
                        out.print("<p class=\"mal\">X</p>");
                    }
                    else {
                        out.print("<p class=\"bien\">V</p>");
                    }
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Apellidos:</td>");
                out.println("<td><input type=\"text\" name=\"Apellidos\" value=\"" + request.getParameter("Apellidos") + "\"></td>");
                out.println("</tr>");
                    
                out.println("<tr>");
                out.println("<td>Sexo:</td>");
                out.println("<td>");
                out.print("<input type=\"radio\" name=\"Sexo\" value=\"Hombre\" "); 
                    if (request.getParameter("Sexo").equals("Hombre")) {
                        out.print("checked=\"checked\"");
                    }
                out.println("><label>Hombre</label>");
                out.print("<input type=\"radio\" name=\"Sexo\" value=\"Mujer\" ");
                    if (request.getParameter("Sexo").equals("Mujer")) {
                        out.print("checked=\"checked\"");
                    }
                out.println("><label>Mujer</label>");
                out.println("</td>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td>*Fecha de nacimiento:</td>");
                out.println("<td><input type=\"text\" name=\"Fecha de nacimiento\" value=\"" + fecha + "\"></td>");
                out.println("<td>");
                    if (errores[1] == 1) {
                        out.print("<p class=\"mal\">X</p>");
                    }
                    else {
                        out.print("<p class=\"bien\">V</p>");
                    }
                out.println("</td>");
                out.println("</tr>");
                                
                out.println("<tr>");
                out.println("<td>Documento:</td>");
                out.println("<td>");
                out.println("<select name=\"Tipo de documento\" size=\"1\">");
                out.print("<option value=\"NIF\" ");
                    if (request.getParameter("Tipo de documento").equals("NIF")) {
                        out.print("selected=\"selected\"");
                    }
                out.println(">NIF</option>");
                out.print("<option value=\"NIE\" ");
                    if (request.getParameter("Tipo de documento").equals("NIE")) {
                        out.print("selected=\"selected\"");
                    }
                out.println(">NIE</option>");
                out.print("<option value=\"Pasaporte\" ");
                    if (request.getParameter("Tipo de documento").equals("Pasaporte")) {
                        out.print("selected=\"selected\"");
                    }
                out.println(">Pasaporte</option>");
                out.println("</select>");
                out.println("</td>");
                out.println("</tr>");
                                        
                out.println("<tr>");
                out.println("<td>*Número de documento:</td>");
                out.println("<td><input type=\"text\" name=\"Documento\" value=\"" + numero + "\"></td>");
                out.println("<td>");
                    if (errores[2] == 1) {
                        out.print("<p class=\"mal\">X</p>");
                    }
                    else {
                        out.print("<p class=\"bien\">V</p>");
                    }
                out.println("</td>");
                out.println("</tr>");
                                
                out.println("<tr>");
                out.println("<td>*Usuario:</td>");
                out.println("<td><input type=\"text\" name=\"Usuario\" value=\"" + usuario + "\"></td>");
                out.println("<td>");
                    if (errores[3] == 1) {
                        out.print("<p class=\"mal\">X</p>");
                    }
                    else {
                        out.print("<p class=\"bien\">V</p>");
                    }
                out.println("</td>");
                out.println("</tr>");
                                
                out.println("<tr>");
                out.println("<td>*Password:</td>");
                out.println("<td><input type=\"password\" name=\"Password\" value=\"" + password + "\"></td>");
                out.println("<td>");
                    if (errores[4] == 1) {
                        out.print("<p class=\"mal\">X</p>");
                    }
                    else {
                        out.print("<p class=\"bien\">V</p>");
                    }
                out.println("</td>");
                out.println("</tr>");
                                
                out.println("<tr>");
                out.println("<td>*Teléfono:</td>");
                out.println("<td><input type=\"text\" name=\"Telefono\" value=\"" + telefono + "\"></td>");
                out.println("<td>");
                    if (errores[5] == 1) {
                        out.print("<p class=\"mal\">X</p>");
                    }
                    else {
                        out.print("<p class=\"bien\">V</p>");
                    }
                out.println("</td>");
                out.println("</tr>");
                                
                out.println("<tr>");
                out.println("<td>Preferencias:</td>");
                out.println("<td class=\"check\">");
                out.print("<input type=\"checkbox\" name=\"Preferencias\" value=\"Deporte\" ");
                    if (preferencias[0].equals("Deporte")) {
                        out.print("checked=\"checked\"");
                    }
                out.println("><label>Deporte</label><br>");
                out.print("<input type=\"checkbox\" name=\"Preferencias\" value=\"Lectura\" ");
                    if (preferencias[0].equals("Lectura") || preferencias[1].equals("Lectura")) {
                        out.print("checked=\"checked\"");
                    }
                out.println("><label>Lectura</label><br>");
                out.print("<input type=\"checkbox\" name=\"Preferencias\" value=\"Cine\" ");
                    if (preferencias[0].equals("Cine") || preferencias[1].equals("Cine") || preferencias[2].equals("Cine")) {
                        out.print("checked=\"checked\"");
                    }
                out.println("><label>Cine</label><br>");
                out.print("<input type=\"checkbox\" name=\"Preferencias\" value=\"Viajes\" ");
                    if (preferencias[0].equals("Viajes") || preferencias[1].equals("Viajes") || preferencias[2].equals("Viajes") || preferencias[3].equals("Viajes")) {
                        out.print("checked=\"checked\"");
                    }
                out.println("><label>Viajes</label><br>");
                out.println("</td>");
                out.println("</tr>");
                                    
                out.println("<tr>");
                out.println("<td></td>");
                out.println("<td><input type=\"submit\" name=\"Enviar\" value=\"Enviar\"> <input type=\"reset\" name=\"Limpiar\" value=\"Limpiar\"></td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</form>");
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    
    
    
    //método para validar NIF o NIE copiado de internet
    public static boolean isNifNie(String nif){
        //si es NIE, eliminar la x,y,z inicial para tratarlo como nif
        if (nif.toUpperCase().startsWith("X")||nif.toUpperCase().startsWith("Y")||nif.toUpperCase().startsWith("Z")){
            nif = nif.substring(1);
        } 
        
        Pattern nifPattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher m = nifPattern.matcher(nif);
        
        if(m.matches()){
            String letra = m.group(2);
            //Extraer letra del NIF
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int dni = Integer.parseInt(m.group(1));
            dni = dni % 23;
            String reference = letras.substring(dni,dni+1);
 
            if (reference.equalsIgnoreCase(letra)){
                return true;
            }
            
            else {
                return false;
            }
        }
    
        else {
            return false;
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
