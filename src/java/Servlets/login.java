package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Juan Carlos
 */
@WebServlet(name = "login", urlPatterns = {"/login"}, initParams = {
    @WebInitParam(name = "parametro1", value = "Valor1")
    ,@WebInitParam(name = "parametro2", value = "Valor2")})
public class login extends HttpServlet {

    private Map<String, String> mapaDeParametrosDeConfiguracion = new ConcurrentHashMap<String, String>();

    @Override
    public void init(ServletConfig config) {
        Enumeration<String> nombresParametros = config.getInitParameterNames();
        while (nombresParametros.hasMoreElements()) {
            String nombreParametro = nombresParametros.nextElement();
            mapaDeParametrosDeConfiguracion.put(nombreParametro, config.getInitParameter(nombreParametro));
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nuevoAtributo = request.getParameter("parametro");
        String valor = request.getParameter("valor");
        String action = request.getParameter("accion");

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("<ul>");
            Enumeration<String> nombresDeCabeceras = request.getHeaderNames();
            while (nombresDeCabeceras.hasMoreElements()) {
                String cabecera = nombresDeCabeceras.nextElement();
                out.println("<li><b>" + cabecera + ": </b>" + request.getHeader(cabecera) + "</li>");
            }

            Set<String> param = mapaDeParametrosDeConfiguracion.keySet();
            for (String h : param) {
                out.println("<li>" + h + ": " + mapaDeParametrosDeConfiguracion.get(h) + "</li>");
            }

            out.println("</ul>");
            HttpSession s = request.getSession();
            if (action.equals("invalidar")) {
                s.invalidate();
                out.println("<h1>Sesion invalidada:</h1>");
            } else {
                s.setAttribute(nuevoAtributo, valor);
                out.println("<ul>");
                Enumeration<String> nombresDeAtributos = s.getAttributeNames();
                while (nombresDeAtributos.hasMoreElements()) {
                    String atributo = nombresDeAtributos.nextElement();
                    out.println("<li><b>" + atributo + ": </b>" + s.getAttribute(atributo) + "</li>");
                }
            }
            out.println(request.getQueryString());
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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