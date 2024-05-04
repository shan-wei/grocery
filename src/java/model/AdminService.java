/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import entity.Staff;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.util.ArrayList;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.io.*;
import java.sql.Blob;
import java.util.Base64;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Date;

public class AdminService {


@PersistenceContext
private EntityManager entityManager;
@Resource
private EntityManagerFactory emf;

public AdminService() {
    emf = Persistence.createEntityManagerFactory("groceryPU");
}

public String getLatestStaffId() {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to get the latest custID
        Query query = em.createQuery("SELECT c.stfId FROM Staff c ORDER BY c.stfId DESC");
        query.setMaxResults(1); // Limit the result to one row
        List<String> resultList = query.getResultList();
        if (!resultList.isEmpty()) {
            
            String latestId = resultList.get(0);
            int num = Integer.parseInt(latestId.substring(1)); // extract the numeric part
            num++; // increment the number
            return "A" + String.format("%04d", num); // format the next ID
            
            
        } else {
            return "A0001"; // No customers found
        }
    } finally {
        em.close();
    }
}

public String getStaffIdByEmail(String email) {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to get the custID by email
        Query query = em.createQuery("SELECT c.stfId FROM Staff c WHERE c.stfEmail = :email");
        query.setParameter("email", email);
        String stfId = (String) query.getSingleResult();
        return stfId;
    } catch (Exception e) {
        // Handle any exceptions (e.g., NoResultException)
        e.printStackTrace();
        return null;
    } finally {
        em.close();
    }
}

public String getStaffRoleByEmail(String email) {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to get the custID by email
        Query query = em.createQuery("SELECT c.stfPosition FROM Staff c WHERE c.stfEmail = :email");
        query.setParameter("email", email);
        String stfPosition = (String) query.getSingleResult();
        return stfPosition;
    } catch (Exception e) {
        // Handle any exceptions (e.g., NoResultException)
        e.printStackTrace();
        return null;
    } finally {
        em.close();
    }
}

public void regStaff(String staffIC, String staffFName, String staffLName, String staffEmail, Character gender,
                        String staffContactNumber, String staffAddress, String staffPassword, String staffID, Part imagePart, Date Birthday)
        throws IOException {

    try {
        EntityManager em = emf.createEntityManager();

        Staff staff = new Staff();
        staff.setStfIc(staffIC);
        staff.setStfFname(staffFName);
        staff.setStfLname(staffLName);
        staff.setStfEmail(staffEmail);
        staff.setStfPhone(staffContactNumber);
        staff.setStfPosition("staff");
        staff.setStfGender(gender);
        staff.setStfPswd(staffPassword);
        staff.setStfId(staffID);
        staff.setStfBirthdate(Birthday);
        staff.setStfJoindate(java.sql.Date.valueOf(java.time.LocalDate.now()));

        // Read image data from Part
        InputStream inputStream = imagePart.getInputStream();
        byte[] imageData = new byte[inputStream.available()];
        inputStream.read(imageData);
        inputStream.close();

        // Set image data and name
        staff.setStfAvatar(imageData);
        staff.setStfAvatarname(imagePart.getSubmittedFileName());

        em.persist(staff);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error registering customer: " + e.getMessage());
    }
}

public boolean loginStaff(String email, String password) {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to check if the customer exists with the given email and password
        Query query = em.createQuery("SELECT c FROM Staff c WHERE c.stfEmail = :email AND c.stfPswd = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<Staff> resultList = query.getResultList();
        
        // Return true if any customer is found
        return !resultList.isEmpty();
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error login staff: " + e.getMessage());
    } finally {
        em.close();
    }
}

public void deleteStaff(String staffID) {
    EntityManager em = emf.createEntityManager();

    try {
 
        Staff staff = em.find(Staff.class, staffID);
        if (staff != null) {
            em.remove(staff);
        }

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error deleting staff: " + e.getMessage());
    }
}

public List<Staff> getAllStaffs() {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to select all customers
        Query query = em.createQuery("SELECT c FROM Staff c");
        return query.getResultList(); // Return the list of customers
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error get customer: " + e.getMessage());
    } finally {
        em.close();
    }
}

public void updateStaff(String staffID, String staffIC, String staffFName, String staffLName, String staffEmail,
                           String staffContactNumber, Character gender, String staffPassword) {
    EntityManager em = emf.createEntityManager();

    try {
        // Find the customer by ID
        Staff staff = em.find(Staff.class, staffID);
        if (staff != null) {
            // Update staff properties
                    
            staff.setStfIc(staffIC);
            staff.setStfFname(staffFName);
            staff.setStfLname(staffLName);
            staff.setStfEmail(staffEmail);
            staff.setStfPhone(staffContactNumber);
            staff.setStfGender(gender);
            staff.setStfPswd(staffPassword);
            staff.setStfId(staffID);
        
            em.merge(staff); // Merge the updated customer entity into the persistence context
        } else {
            // Handle case where customer with the given ID is not found
            throw new IllegalArgumentException("Staff with ID " + staffID + " not found");
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error updating customer: " + e.getMessage());
    } finally {
        em.close();
    }
}

public void addStaff(String staffIC, String staffFName, String staffLName, String staffEmail, Character gender,
                        String staffContactNumber, String staffAddress, String staffPassword, String staffID, Part imagePart, Date Birthday)
        throws IOException {

    try {
        EntityManager em = emf.createEntityManager();

        Staff staff = new Staff();
        staff.setStfIc(staffIC);
        staff.setStfFname(staffFName);
        staff.setStfLname(staffLName);
        staff.setStfEmail(staffEmail);
        staff.setStfPhone(staffContactNumber);
        staff.setStfPosition("staff");
        staff.setStfGender(gender);
        staff.setStfPswd(staffPassword);
        staff.setStfId(staffID);
        staff.setStfBirthdate(Birthday);
        staff.setStfJoindate(java.sql.Date.valueOf(java.time.LocalDate.now()));

        // Read image data from Part
        InputStream inputStream = imagePart.getInputStream();
        byte[] imageData = new byte[inputStream.available()];
        inputStream.read(imageData);
        inputStream.close();

        // Set image data and name
        staff.setStfAvatar(imageData);
        staff.setStfAvatarname(imagePart.getSubmittedFileName());

        em.persist(staff);
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error registering customer: " + e.getMessage());
    }
}

public void close() {
    emf.close();
}



}