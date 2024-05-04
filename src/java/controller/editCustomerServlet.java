/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;
import model.CustomerService;

public class editCustomerServlet extends HttpServlet {
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        try {
            String custID = request.getParameter("custID");
            String custIC = request.getParameter("custIC");
            String custFName = request.getParameter("custFName");
            String custLName = request.getParameter("custLName");
            String custEmail = request.getParameter("custEmail");
            String custContactNumber = request.getParameter("custContactNumber");
            String custAddress = request.getParameter("custAddress");
            String custPassword = request.getParameter("custPassword");
            utx.begin(); 
            customerService.updateCustomer(custID, custIC, custFName, custLName, custEmail, custContactNumber, custAddress, custPassword);
            utx.commit();
            response.sendRedirect("loadAllCustomer");
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Error: " + ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}