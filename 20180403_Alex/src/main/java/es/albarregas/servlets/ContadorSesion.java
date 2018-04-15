/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alex
 */
@WebServlet(name = "ContadorSesion", urlPatterns = {"/contador"})
public class ContadorSesion extends HttpServlet {

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
            out.println("<title>Contador de visitas</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS/estilos.css\"/>");
            out.println("</head>");
            out.println("<body class=\"contenido\">");
            
            int contador = 0;
            HttpSession sesion = request.getSession();
            
            
            
            if (request.getParameter("Eliminar") != null) {
                sesion.removeAttribute("CONTADOR");
                sesion.setAttribute("CONTADOR", 1);
            
            }
            
            else {
                contador = (int) sesion.getAttribute("CONTADOR");
                
                sesion.setAttribute("CONTADOR", contador + 1);
            }
            
            
            
            out.println("<h2>Se ha visitado la página " + sesion.getAttribute("CONTADOR") + " veces.</h2>");
            
            out.println("<form action=\"contador\" method=\"POST\">");
            out.println("<input type=\"checkbox\" value=\"Eliminar\" name=\"Eliminar\"/><label for=\"Eliminar\">Eliminar sesi&oacute;n</label><br><br>");
            out.println("<a href=\"contador\"><input type=\"submit\" name=\"Recargar\" value=\"Recargar\"></a>");
            out.println("<a href=\"" + request.getContextPath() + "\"><input type=\"button\" name=\"Menu\" value=\"Men&uacute; principal\"></a>");
            out.println("</form>");
            
            
            
            
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
