<%-- 
    Document   : custRegister
    Created on : 17 Apr 2024, 1:44:02 PM
    Author     : shika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="UTF-8">
    <title>Responsive Registration Form | CodingLab</title>
    <link rel="stylesheet" href="css/custstyle.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <div class="container">
        <div class="title">Registration</div>
        <div class="content">
            <c:if test="${not empty errorMessage}">
    <div style="color: red;">${errorMessage}</div>
</c:if>
            <form method="post" action="custRegister" name="register-form" id="register-form" enctype="multipart/form-data">

                <div class="user-details">
                    <div class="input-box">
                        <span class="details">First Name</span>
                        <input type="text" name="fname" id="fname" placeholder="Enter your first name" required minlength="3" maxlength="50">
                    </div>
                    <div class="input-box">
                        <span class="details">Last Name</span>
                        <input type="text" name="lname" id="lname" placeholder="Enter your last name" minlength="3" required maxlength="50">
                    </div>
                    <div class="input-box">
                        <span class="details">IC Number</span>
                        <input type="text" name="ic" id="ic" placeholder="Enter your IC Number" required pattern="[0-9]{6}-[0-9]{2}-[0-9]{4}" maxlength="15">
                    </div>
                    <div class="input-box">
                        <span class="details">Address</span>
                        <input type="text" name="address" id="address" placeholder="Enter your address" required minlength="3" maxlength="255">
                    </div>
                    <div class="input-box">
                        <span class="details">Email</span>
                        <input type="email" name="email" id="email" placeholder="Enter your email" required maxlength="100">
                    </div>
                    <div class="input-box">
                        <span class="details">Phone Number</span>
                        <input type="tel" name="phone" id="phone" placeholder="XXX-XXXXXXX" required pattern="[0-9]{3}-[0-9]{7}" maxlength="11">
                    </div>
                  <div class="input-box">
                        <span class="details">Password</span>
                        <input type="password" name="pass" id="pass" placeholder="Enter your password" required minlength="6" maxlength="100">
                    </div>
                    <div class="input-box">
                        <span class="details">Confirm Password</span>
                        <input type="password" name="re_pass" id="re_pass" placeholder="Confirm your password" required maxlength="100">
                    </div>
                </div>

                <div class="button">
                    <input type="submit" value="Register">
                </div>
            </form>
        </div>
    </div>

    <c:if test="${not empty status}">
        <p style="color: red">${status}</p>
    </c:if>
    <c:if test="${not empty success}">
        <p style="color: green">${success}</p>
    </c:if>
</body>
</html>