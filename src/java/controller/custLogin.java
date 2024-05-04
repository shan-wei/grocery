/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.UserTransaction;
import model.CustomerService;

public class custLogin extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerService customerService = new CustomerService();       
       
        try {
            String CUSTEMAIL = request.getParameter("email");
            String CUSTPASSWORD = request.getParameter("pass");
            
            utx.begin();
            boolean isLoggedIn = customerService.loginCustomer(CUSTEMAIL, CUSTPASSWORD);
            String custID = customerService.getCustomerIdByEmail(CUSTEMAIL);
            utx.commit();
            if(isLoggedIn) {
                HttpSession session = request.getSession();
                session.setAttribute("custID", custID);
                session.setAttribute("role", "customer");
                session.setAttribute("email", CUSTEMAIL);
                response.sendRedirect("mainpage.jsp");
            } else {
                // Handle incorrect login credentials
                request.setAttribute("errorMessage", "Incorrect email or password.");
                request.getRequestDispatcher("loginpage.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Error: " + ex.getMessage());
            request.getRequestDispatcher("loginpage.jsp").forward(request, response);
        }
    }

    
}