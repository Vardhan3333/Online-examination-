<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add New User</title>
</head>
<body>
    <h1>Add New User</h1>
    <form action="registeration" method="post">
        <label>User Name:</label>
        <input type="text" name="userName">
        <br><br>

        <label>Password:</label>
        <input type="password" name="password">
        <br><br>

        <label>Email:</label>
        <input type="text" name="emailId">
        <br><br>

        <label>Address:</label>
        <input type="text" name="address">
        <br><br>

        <label>Phone Number:</label>
        <input type="text" name="phoneNum">
        <br><br>

        

        

        <label>Class:</label>
        <input type="text" name="group">
        <br><br>

        <input type="submit" value="Add User">
    </form>
</body>
</html>
