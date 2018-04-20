/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "ControladorPaises", urlPatterns = {"/controlPais"})
public class ControladorPaises extends HttpServlet {
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
        
        Locale paises[] = SimpleDateFormat.getAvailableLocales();
    
        /*for (int i=0; i<paises.length; i++) {
            System.out.println(paises[i]);
            System.out.println(paises[i].getDisplayCountry());
            System.out.println(paises[i].getDisplayLanguage());
        }*/
        
        request.setAttribute("idiomas", paises);
        
        request.getRequestDispatcher("JSP/internacionalizacion.jsp").forward(request, response);
        
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
        
        String codigo;
        Date fecha = new Date();
        
        if (request.getParameter("Pais") != null) {
            codigo = request.getParameter("Pais");
            request.setAttribute("codigo", codigo);
            request.setAttribute("fecha", fecha);
        }
        
        
        request.getRequestDispatcher("JSP/salidaInternacionalizacion.jsp").forward(request, response);
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
