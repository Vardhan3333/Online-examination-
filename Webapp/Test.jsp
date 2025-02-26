<%@page import="com.example.Online.Examination.System.Model.QuestionBank"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Take Test</title>
</head>
<body>
<form action="submitTest">
    <c:forEach items="${questions}" var="q">
     
<h2 id="question">Question ${q.qId}: <br>${q.qDesc}</h2>
<div class="answer">
<label>
A.<br><input type="radio"  name="${q.qId }" value="1" required >${q.op1}<br>
</label>
<label>
B.<br><input type="radio"  name="${q.qId}" value="2" required>${q.op2}<br>
</label>
<label>
C.<br><input type="radio"  name="${q.qId}" value="3" required>${q.op3}<br>
</label>
</div>
 

    </c:forEach>
    <button id="submit">Submit</button>
</form>
</body>
</html>
