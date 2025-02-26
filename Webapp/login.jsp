<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Login or Register</title>
    <script>
        function changeFormAction(action) {
            document.getElementById("loginOrRegisterForm").action = action;
        }
    </script>
</head>
<body>
    <h1>Login or Register</h1>
    <p>${logout}</p>
    <form id="loginOrRegisterForm" >
        <label>Email:</label>
        <input type="text" name="emailId">
        <br><br>
        
        <label>Password:</label>
        <input type="password" name="password">
        <br><br>
        
        <button type="submit" onclick="changeFormAction('/login')" name="login">Login</button>
        <button type="submit" onclick="changeFormAction('/Register')" name="Register">Register</button>
        <button type="submit" onclick="changeFormAction('/adminreg')" name="Admin registration">Admin registration</button>
    </form>
</body>
</html>
