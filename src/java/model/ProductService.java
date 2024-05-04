/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import entity.Product;
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

public class ProductService {


@PersistenceContext
private EntityManager entityManager;
@Resource
private EntityManagerFactory emf;

public ProductService() {
    emf = Persistence.createEntityManagerFactory("groceryPU");
}

public List<Product> getAllProduct() {
    EntityManager em = emf.createEntityManager();
    try {
        // Execute JPQL query to select all customers
        Query query = em.createQuery("SELECT c FROM Product c");
        return query.getResultList(); // Return the list of customers
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Error get product: " + e.getMessage());
    } finally {
        em.close();
    }
}


public void close() {
    emf.close();
}



}