package controller;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.UserTransaction;
import model.CustomerService;

public class DeleteCustomerServlet extends HttpServlet {
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CustomerService customerService = new CustomerService();
    
        String custID = request.getParameter("custID");
        try {
            utx.begin(); 
            customerService.deleteCustomer(custID);
            utx.commit();
            response.sendRedirect("loadAllCustomer");          
        } catch (Exception ex) {
            response.sendRedirect("loadAllCustomer");
        }

    }

 
}
