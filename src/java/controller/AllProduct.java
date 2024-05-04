package controller;

import entity.Product;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.ProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.transaction.UserTransaction;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllProduct extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ProductService productService = new ProductService();
            utx.begin();
            List<Product> productList = productService.getAllProduct();
            utx.commit();
            request.setAttribute("productList", productList); // Set customerList in request scope
            HttpSession session = request.getSession();
            String role = (String) session.getAttribute("role");
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("productpage.jsp");
            dispatcher.forward(request, response);
            
            
        } catch (Exception ex) {
            Logger.getLogger(loadAllCustomer.class.getName()).log(Level.SEVERE, null, ex);
            // Set the error message in request attribute
            request.setAttribute("errorMessage", "An unexpected error occurred while retrieving product data: " + ex.getMessage());
            // Redirect to the error page
            RequestDispatcher errorDispatcher = request.getRequestDispatcher("error.jsp");
            errorDispatcher.forward(request, response);
        } 
    }

}
