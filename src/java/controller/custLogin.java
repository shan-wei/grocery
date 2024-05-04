/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import jakarta.servlet.RequestDispatcher;
import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.CustomerService;

public class custLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        CustomerService customerService = new CustomerService();       
//       
//        try {
//            String CUSTEMAIL = request.getParameter("email");
//            String CUSTPASSWORD = request.getParameter("pass");
//            
//            boolean isLoggedIn = customerService.loginCustomer(CUSTEMAIL, CUSTPASSWORD);
//            String custID = customerService.getCustomerIdByEmail(CUSTEMAIL);
//            if(isLoggedIn) {
//                HttpSession session = request.getSession();
//                session.setAttribute("custID", custID);
//                session.setAttribute("role", "customer");
//                session.setAttribute("email", CUSTEMAIL);
//                response.sendRedirect("custHomepage.jsp");
//            } else {
//                // Handle incorrect login credentials
//                request.setAttribute("errorMessage", "Incorrect email or password.");
//                request.getRequestDispatcher("custLogin.jsp").forward(request, response);
//            }
//        } catch (SQLException ex) {
//            request.setAttribute("errorMessage", "Error: " + ex.getMessage());
//            request.getRequestDispatcher("custLogin.jsp").forward(request, response);
//        }
    }

    
}