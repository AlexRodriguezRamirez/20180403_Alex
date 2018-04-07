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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "FormularioValidaciones", urlPatterns = {"/fvalid"})
public class FormularioValidaciones extends HttpServlet {

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
            out.println("<title>Formulario Validaciones</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\"/>");
            out.println("</head>");
            out.println("<body class=\"contenido\">");
            out.println("<h3>Datos introducidos en el formulario:</h3>");

            Map<String, String[]> datos = request.getParameterMap();
            Set s = datos.keySet();
            Iterator it = s.iterator();
            boolean seleccion = false; //controlar si hay algún vehículo seleccionado
            
            while (it.hasNext()) {
                String clave = (String) it.next();
                String[] valor = datos.get(clave);

                switch (clave) {
                    case "Nombre":
                        if (valor[0].equals("") || valor[0] == null) {
                            out.println("<p class=\"error\">Debe introducir un nombre.</p>");
                        }
                        
                        else {
                            if (valor[0].matches("^.*\\d.*$")) {
                                out.println("<p class=\"error\">El nombre no puede contener números.</p>");
                            }
                            
                            else {
                                out.println("<p>" + clave + ": " + request.getParameter(clave) + "</p>");
                            }
                        }
                        break;

                    case "Telefono":
                        if (valor[0].equals("") || valor[0] == null) {
                            out.println("<p class=\"error\">Debe introducir un teléfono.</p>");
                        }
                        
                        else {
                            if (!valor[0].matches("^[9|6|7][0-9]{8}$")) {
                                out.println("<p class=\"error\">Número de teléfono incorrecto.</p>");
                            }
                            
                            else {
                                out.println("<p>" + clave + ": " + request.getParameter(clave) + "</p>");
                            }
                        }
                        break;

                    case "Email":
                        if (valor[0].equals("") || valor[0] == null) {
                            out.println("<p class=\"error\">Debe introducir un email.</p>");
                        }
                        
                        else {
                            if (!valor[0].matches("^[A-Za-z0-9](([a-zA-Z0-9,=\\.!\\-#|\\$%\\^&\\*\\+/\\?_`\\{\\}~]+)*)@(?:[0-9a-zA-Z-]+\\.)+[a-zA-Z]{2,9}$$")) {
                                out.println("<p class=\"error\">Formato de email incorrecto.</p>");
                            }
                            
                            else {
                                out.println("<p>" + clave + ": " + request.getParameter(clave) + "</p>");
                            }
                        }
                        break;

                    case "Fecha de nacimiento":
                        out.println("<p>" + clave + ": " + request.getParameter(clave) + "</p>");
                        break;

                    case "Vehiculo":
                        out.print("<p>" + clave + ": ");
                            
                        for (String vehiculo : valor) {
                            out.print(vehiculo + "&nbsp;");
                        }
                            
                        out.println("</p>");
                        seleccion = true;
                        break;

                    case "Enviar":
                        break;
                }
            }
            
            if (seleccion == false) {
                out.println("<p class=\"error\">Debe seleccionar al menos un vehículo.</p>");
            }

            out.println("<br/>");
            out.println("<a href=" + request.getContextPath() + ">Volver al men&uacute; principal</a>");

            out.println("</body>");
            out.println("</html>");
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
