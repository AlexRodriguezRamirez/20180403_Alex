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
@WebServlet(name = "FormularioComplejo", urlPatterns = {"/fcomplejo"})
public class FormularioComplejo extends HttpServlet {

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
            out.println("<title>Formulario Complejo</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\"/>");
            out.println("</head>");
            out.println("<body class=\"contenido\">");
            out.println("<h3>Datos introducidos en el formulario:</h3>");

            Map<String, String[]> datos = request.getParameterMap();
            Set s = datos.keySet();
            Iterator it = s.iterator();

            while (it.hasNext()) {
                String clave = (String) it.next();
                String[] vehiculos = datos.get("Vehiculo");
                String[] bebidas = datos.get("Bebidas");

                if (clave.startsWith("Veh")) {
                    out.print(clave + ": ");
                    for (int i = 0; i < vehiculos.length; i++) {
                        out.print(vehiculos[i] + "&nbsp;");
                    }
                    out.println("<br/>");
                    
                } else {
                    if (clave.startsWith("Beb")) {
                        out.print(clave + ": ");
                        for (int i = 0; i < bebidas.length; i++) {
                            out.print(bebidas[i] + "&nbsp;");
                        }
                        out.println("<br/>");
                        
                    } else {
                        if (!clave.startsWith("Env")) {
                            out.println(clave + ": " + request.getParameter(clave) + "<br/>");
                        }
                    }

                }

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
