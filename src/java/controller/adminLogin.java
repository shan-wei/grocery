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
import model.AdminService;

public class adminLogin extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AdminService adminService = new AdminService();       
       
        try {
            String staffEMAIL = request.getParameter("email");
            String staffPASSWORD = request.getParameter("pass");
            
            utx.begin();
            boolean isLoggedIn = adminService.loginStaff(staffEMAIL, staffPASSWORD);
            String custID = adminService.getStaffIdByEmail(staffEMAIL);
            String staffRole = adminService.getStaffRoleByEmail(staffEMAIL);
            utx.commit();
            if(isLoggedIn) {
                HttpSession session = request.getSession();
                session.setAttribute("custID", custID);
                session.setAttribute("role", staffRole);
                session.setAttribute("email", staffEMAIL);
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