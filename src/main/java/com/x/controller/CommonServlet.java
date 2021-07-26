/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.x.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author X
 */
public class CommonServlet extends HttpServlet{
    protected void validate(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        if (request.getSession().getAttribute("CURRENT_USER") == null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
}
