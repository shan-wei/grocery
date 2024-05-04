/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import entity.Customer;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.io.*;
import java.sql.Blob;
import java.util.Base64;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CustomerService {


@PersistenceContext
private EntityManager entityManager;
@Resource
private EntityManagerFactory emf;

public CustomerService() {
    emf = Persistence.createEntityManagerFactory("groceryPU");
}

public String getLatestCustId() {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to get the latest custID
        Query query = em.createQuery("SELECT c.custid FROM Customer c ORDER BY c.custid DESC");
        query.setMaxResults(1); // Limit the result to one row
        List<String> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            
            String latestId = resultList.get(0);
            int num = Integer.parseInt(latestId.substring(1)); // extract the numeric part
            num++; // increment the number
            return "C" + String.format("%04d", num); // format the next ID
            
            
        } else {
            return "C0001"; // No customers found
        }
    } finally {
        em.close();
    }
}

public String getCustomerIdByEmail(String email) {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to get the custID by email
        Query query = em.createQuery("SELECT c.custid FROM Customer c WHERE c.custemail = :email");
        query.setParameter("email", email);
        String customerId = (String) query.getSingleResult();
        return customerId;
    } catch (Exception e) {
        // Handle any exceptions (e.g., NoResultException)
        e.printStackTrace();
        return null;
    } finally {
        em.close();
    }
}

public void regCustomer(String custIC, String custFName, String custLName, String custEmail,
                        String custContactNumber, String custAddress, String custPassword, String custID, Part imagePart)
        throws IOException {

    try {
        EntityManager em = emf.createEntityManager();

        Customer customer = new Customer();
        customer.setCustic(custIC);
        customer.setCustfname(custFName);
        customer.setCustlname(custLName);
        customer.setCustemail(custEmail);
        customer.setCustcontactnumber(custContactNumber);
        customer.setCustaddress(custAddress);
        customer.setCustpassword(custPassword);
        customer.setCustid(custID);
        customer.setCustjoindate(java.sql.Date.valueOf(java.time.LocalDate.now()));

        // Read image data from Part
        InputStream inputStream = imagePart.getInputStream();
        byte[] imageData = new byte[inputStream.available()];
        inputStream.read(imageData);
        inputStream.close();

        // Set image data and name
        customer.setCustimage(imageData);
        customer.setCustimagename(imagePart.getSubmittedFileName());

        em.persist(customer);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error registering customer: " + e.getMessage());
    }
}

   

public void close() {
    emf.close();
}



}