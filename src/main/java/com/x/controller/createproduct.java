/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.controller;

import com.google.protobuf.TextFormat.ParseException;
import com.sun.istack.logging.Logger;
import com.x.dao.GenericDao;
import com.x.model.Product;
import com.x.types.Measure;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author X
 */
@WebServlet(name = "createproduct", urlPatterns = {"/create"})
public class createproduct extends HttpServlet {

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
        String productName = request.getParameter("name");
        String description = request.getParameter("desc");
        String company = request.getParameter("company");
        String country = request.getParameter("country");
//        String date = request.getParameter("expiry");
//        DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
//        Date expiry = new Date();
//        expiry = format.parse(date);
        Long sellingQty = Long.parseLong(request.getParameter("amount"));
        Measure measure = Measure.valueOf(request.getParameter("measure"));
        
        Product product = new Product(productName,sellingQty,measure,description,company,country);
        GenericDao dao = new GenericDao(Product.class);
        dao.create(product);
        response.sendRedirect(request.getContextPath() + "/products.jsp");
      
        
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
