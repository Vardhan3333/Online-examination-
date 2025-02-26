<%@page import="com.example.Online.Examination.System.Model.Test"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upcoming Tests</title>
</head>
<body>
    <h1>Upcoming Tests</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Test ID</th>
                <th>Test Date</th>
                <th>Test Time</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Test> tests = (List<Test>) request.getAttribute("tests");
                java.time.LocalDate currentDate = java.time.LocalDate.now();
                java.time.LocalTime currentTime = java.time.LocalTime.now();
                for (Test test : tests) {
                    java.time.LocalDate testDate = test.getDate();
                    java.time.LocalTime testTime = test.getTime();
                    boolean isTestDateEqual = currentDate.isEqual(testDate);
                    boolean isTestTimeBefore = currentTime.isBefore(testTime.plusMinutes(30));


                    boolean isTestAvailable = isTestDateEqual && isTestTimeBefore;
            %>
                <tr>
                    <td><%= test.getTestId() %></td>
                    <td><%= test.getDate() %></td>
                    <td><%= test.getTime() %></td>
                    <td>
                        <%
                            if (isTestAvailable) {
                        %>
                                <form action="/takeTest" >
                                    <input type="hidden" name="testId" value="<%= test.getTestId() %>">
                                    <button type="submit">Take Test</button>
                                </form>
                        <%
                            } else {
                        %>
                                <button type="button" disabled>Not Available</button>
                        <%
                            }
                        %>
                    </td>
                </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
