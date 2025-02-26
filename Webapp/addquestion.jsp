<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Question</title>
</head>
<body>
    <h1>Add Question</h1>
    <form action="/savequestion" method="post">
        <label>Question Description:</label>
        <input type="text" name="qDesc">
        <br><br>

        <label>Option 1:</label>
        <input type="text" name="op1">
        <br><br>

        <label>Option 2:</label>
        <input type="text" name="op2">
        <br><br>

        <label>Option 3:</label>
        <input type="text" name="op3">
        <br><br>

        <label>Correct Answer:</label>
        <input type="text" name="correctAns">
        <br><br>

        <label>Type:</label>
        <input type="text" name="type">
        <br><br>

        <input type="submit" value="Add Question">
    </form>
</body>
</html>
