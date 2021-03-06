/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.upiicsa.practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mx.upiicsa.practica1.Disco;
import com.mx.upiicsa.practica1.base.BaseDisco;
import java.util.List;
/**
 *
 * @author David
 */
@WebServlet(name = "Index", urlPatterns = {"/Index"})
public class Index extends HttpServlet {

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
            int res = 0;
            String nombre=request.getParameter("nombre");
            String autor=request.getParameter("autor");
            String numero=request.getParameter("numero");
            out.print("<!DOCTYPE HTML>");
            out.print("<html>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Consulta de discos</h1>");
            List<Disco> listaDiscos;
            BaseDisco discoDB=new BaseDisco();
            listaDiscos=discoDB.consultaDiscos();

            for(Disco disco:listaDiscos) {
                out.print("<p>" + disco.getNumero()+" / " +disco.getAutor()+" / " + disco.getNombre() + "</p>" );
            }
            out.print("<h1>Registro de discos</h1>");
            out.println("<form action='Registro' method='get'>");
            out.println("<p>Numero de disco: <input type='text' name='numero' id='numero'></input></p>");
            out.println("<p>Nombre de disco: <input type='text' name='nombre' id='nombre'></input></p>");
            out.println("<p>Autor del disco: <input type='text' name='autor' id='autor'></input></p>");
            out.println("<input type='submit' value='Registrar'></input> </form>");

            out.print("<h1>Modificacion de discos</h1>");
            out.println("<form action='Modificar' method='get'>");
            out.println("<p>Numero de disco a modificar: <input type='text' name='numero' id='numero'></input></p>");
            out.println("<p>Nuevo Nombre de disco: <input type='text' name='nombre' id='nombre'></input></p>");
            out.println("<p>Nuevo Autor del disco: <input type='text' name='autor' id='autor'></input></p>");
            out.println("<input type='submit' value='Modificar'></input> </form>");

            out.print("</body>");
            out.print("</html>");
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
