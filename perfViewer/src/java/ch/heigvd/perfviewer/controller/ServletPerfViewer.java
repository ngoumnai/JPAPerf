/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.perfviewer.controller;

import ch.heigvd.perfviewer.model.Bean.JPQLRequestBean;
import ch.heigvd.perfviewer.service.JpaQueryMangerLocal;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gauss
 */
public class ServletPerfViewer extends HttpServlet {
    @EJB
    JpaQueryMangerLocal jpaQueryManager;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<JPQLRequestBean> requestList = new ArrayList<JPQLRequestBean>();
        for (Object jpqlR : jpaQueryManager.getHashMapOfJPQLRequest().values()){
            requestList.add((JPQLRequestBean)jpqlR);
        }
        request.setAttribute("jpqlRequest", requestList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/JspPerfViewer.jsp").forward(request, response);
    }
}
