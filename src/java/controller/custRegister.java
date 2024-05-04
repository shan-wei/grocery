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
import jakarta.servlet.http.Part;
import model.CustomerService;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.transaction.UserTransaction;

@MultipartConfig
public class custRegister extends HttpServlet {
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        CustomerService customerService = new CustomerService();       
        try {
            String custID = customerService.getLatestCustId();
            String custFName = request.getParameter("fname");
            String custLName = request.getParameter("lname");
            String custIC = request.getParameter("ic");
            String custAddress = request.getParameter("address");
            String custEmail = request.getParameter("email");
            String custContactNumber = request.getParameter("phone");
            String custPassword = request.getParameter("pass");
            Part imagePart = request.getPart("image");
//            String custJoinDate = request.getParameter("custjoindate");
            utx.begin();           
            customerService.regCustomer(custIC, custFName, custLName, custEmail, custContactNumber, custAddress, custPassword, custID,imagePart);
            String registerID = customerService.getCustomerIdByEmail(custEmail);
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("custID", registerID);
            session.setAttribute("role", "customer");
            session.setAttribute("email", custEmail);
            response.sendRedirect("mainpage.jsp");
        } catch (Exception ex) {
            request.setAttribute("errorMessage", "Error: " + ex);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    
}