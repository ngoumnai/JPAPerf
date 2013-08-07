/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package ch.heigvd.perfviewer.controller;

import ch.heigvd.perfviewer.model.bean.JPQLRequestDetailsBean;
import ch.heigvd.perfviewer.model.query.JPAQuery;
import ch.heigvd.perfviewer.service.JPAQueryManagerLocal;
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
public class ServletPerfViewerDetail extends HttpServlet {
    @EJB
    JPAQueryManagerLocal jpaQueryManager;
    ArrayList<JPQLRequestDetailsBean> requestListDetails;

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
        requestListDetails = new ArrayList<JPQLRequestDetailsBean>();
        for (Object jpaQuery: jpaQueryManager.findByQueryname(request.getParameter("queryName"))){
            requestListDetails.add(new JPQLRequestDetailsBean((JPAQuery)jpaQuery));
        }
        
        request.setAttribute("requestListDetails", requestListDetails);
        this.getServletContext().getRequestDispatcher("/WEB-INF/JSPPerfViewerDetails.jsp").forward(request, response);
    }
}