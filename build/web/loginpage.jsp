<%-- 
    Document   : loginpage
    Created on : May 4, 2024, 3:29:02 AM
    Author     : GENJI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/custlogin.css">
    <style>
        /* The modal container */
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4);
        }

        /* Modal content */
        .modal-content {
            background-color: #fefefe;
            margin: 10% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        /* Close button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        /* Input and button styles */
        input[type="email"] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    
    <div class="wrapper">
        <header>Login Form</header>
       
        <form action="custLogin" method="post">
            <div class="field email">
                <div class="input-area">
                    <input type="email" name="email" placeholder="Email Address" required>
                    <i class="icon fas fa-envelope"></i>
                    <i class="error error-icon fas fa-exclamation-circle"></i>
                </div>
                <div class="error error-txt">Email can't be blank</div>
            </div>
            <div class="field password">
                <div class="input-area">
                    <input type="password" name="pass" placeholder="Password" required>
                    <i class="icon fas fa-lock"></i>
                    <i class="error error-icon fas fa-exclamation-circle"></i>
                </div>
                <div class="error error-txt">Password can't be blank</div>
            </div>
            <div class="pass-txt"><a href="#" onclick="showForgotPasswordModal()">Forgot password?</a></div>
            <input type="submit" value="Login">
        </form>
        <div class="sign-txt">Not yet member? <a href="#">Signup now</a></div>
    </div>
            
    <!-- Modal for entering email -->
    <div id="forgotPasswordModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeForgotPasswordModal()">&times;</span>
            <h2>Forgot Password</h2>
            <input type="email" id="forgotPasswordEmail" placeholder="Enter your email" required>
            <button onclick="sendForgotPasswordEmail()">Submit</button>
        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
    <script>
        // Display success message if login is successful
        <%
        if (request.getAttribute("success") != null) {
        %>
        alert("Login successful!");
        <%
        }
        %>
        
        function showForgotPasswordModal() {
            document.getElementById('forgotPasswordModal').style.display = 'block';
        }

        function closeForgotPasswordModal() {
            document.getElementById('forgotPasswordModal').style.display = 'none';
        }

        function sendForgotPasswordEmail() {
            var email = $('#forgotPasswordEmail').val();
            $.ajax({
                url: 'EmailSendingServlet',
                method: 'POST',
                data: {email: email},
                success: function (resultText) {
                    alert(resultText);
                    closeForgotPasswordModal(); // Close the modal after success
                },
                error: function (jqXHR, exception) {
                    console.log('Error occurred!');
                }
            });
        }
    </script>
</body>
</html>

