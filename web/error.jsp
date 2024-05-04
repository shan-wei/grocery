<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h1>An unexpected error occurred</h1>
    <p>We're sorry, but something went wrong while processing your request. Please try again later.</p>
    <p>Error details: <%= request.getAttribute("errorMessage") %></p>
</body>
</html>
