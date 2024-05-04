<%-- 
    Document   : pagenavbar
    Created on : May 4, 2024, 3:26:43 AM
    Author     : GENJI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <!-- Navbar Start -->
    <div class="container-fluid fixed-top px-0 wow fadeIn" data-wow-delay="0.1s">
        <div class="top-bar row gx-0 align-items-center d-none d-lg-flex">
            <div class="col-lg-6 px-5 text-start">
                <small><i class="fa fa-map-marker-alt me-2"></i>TARUMT MARKET, KL</small>
                <small class="ms-4"><i class="fa fa-envelope me-2"></i>info@example.com</small>
            </div>
        </div>

        <nav class="navbar navbar-expand-lg navbar-light py-lg-0 px-lg-5 wow fadeIn" data-wow-delay="0.1s">
            <a href="index.html" class="navbar-brand ms-4 ms-lg-0">
                <h1 class="fw-bold text-primary m-0">Fr<span class="text-secondary">e</span>sh</h1>
            </a>
            <button type="button" class="navbar-toggler me-4" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav ms-auto p-4 p-lg-0">
                    <a href="mainpage.jsp" class="nav-item nav-link active">Home</a>
                    <a href="productpage.jsp" class="nav-item nav-link">Products</a>
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                        <div class="dropdown-menu m-0">
                            <a href="blog.html" class="dropdown-item">Blog Grid</a>
                            <a href="feature.html" class="dropdown-item">Our Features</a>
                            <a href="testimonial.html" class="dropdown-item">Testimonial</a>
                            <a href="404.html" class="dropdown-item">404 Page</a>
                        </div>
                    </div>

                    <a href="contact.html" class="nav-item nav-link">Contact Us</a>
                    <% String email = (String) session.getAttribute("email"); %>
                    <% if (email != null) { %>
                        <a href="logout" class="nav-item nav-link">Logout</a>
                    <% } %>

                </div>
                <div class="d-none d-lg-flex ms-2">
                    <form action="/search" method="GET" class="d-flex  ms-3">
                        <input type="text" name="query" placeholder="Search..." class="form-control">
                        <button type="submit" class="btn btn-primary ms-3">
                            <i class="fa fa-search"></i>
                        </button>
                    </form>
                    <a class="btn-sm-square bg-white rounded-circle ms-3" href="">
                        <small class="fa fa-shopping-bag text-body"></small>
                    </a>
                </div>
                <div class="navbar-nav">
                    <div href="mainpage.jsp" class="nav-item nav-link active">Welcome, ALI</div>
                </div>
            </div>
        </nav>
    </div>
    <!-- Navbar End -->
