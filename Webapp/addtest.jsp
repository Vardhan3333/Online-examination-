<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Test and Question Type Input</title>
</head>
<body>
    <h1>Test and Question Type Input</h1>
    <form action="/savetest" method="post">
        <label for="testId">Test ID:</label>
        <input type="number" id="Id" name="Id">
        <br><br>
        
        <label for="questionType">Question Type:</label>
        <input type="text" id="type" name="type">
        <br><br>
        
        <label for="testDate">Test Date:</label>
    <input type="date" id="testDate" name="testDate" required>
    <br><br>
    
    <label for="testTime">Test Time:</label>
    <input type="time" id="testTime" name="testTime" required>
    <br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
