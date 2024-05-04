package controller;

import entity.Customer;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.CustomerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.transaction.UserTransaction;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loadAllCustomer extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CustomerService customerService = new CustomerService();
            utx.begin();
            List<Customer> customerList = customerService.getAllCustomers();
            utx.commit();
            request.setAttribute("customerList", customerList); // Set customerList in request scope
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("role");
            if(role == "customer"){
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminCustManagement.jsp");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("adminCustManagement.jsp");
                dispatcher.forward(request, response);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(loadAllCustomer.class.getName()).log(Level.SEVERE, null, ex);
            // Set the error message in request attribute
            request.setAttribute("errorMessage", "An unexpected error occurred while retrieving customer data: " + ex.getMessage());
            // Redirect to the error page
            RequestDispatcher errorDispatcher = request.getRequestDispatcher("error.jsp");
            errorDispatcher.forward(request, response);
        } 
    }

}
