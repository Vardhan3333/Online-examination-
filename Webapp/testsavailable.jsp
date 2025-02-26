<%@page import="java.util.List"%>
<%@page import="com.example.Online.Examination.System.Model.Test"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
                <th>Register</th>
            </tr>
        </thead>
        <tbody>
            <% for (Test test : (List<Test>) request.getAttribute("tests")) { %>
                <tr>
                    <td><%= test.getTestId() %></td>
                    <td><%= test.getDate() %></td>
                    <td><%= test.getTime() %></td>
                    <td>
                        <form action="/registerForTest" method="post" onsubmit="return sendTestId(<%= test.getTestId() %>)">
                            <input type="hidden" name="testId" value="<%= test.getTestId() %>">
                            <button type="submit">Register</button>
                        </form>
                    </td>
                </tr>
            <% } %>
        </tbody>
    </table>

   <script>
    function sendTestId(testId) {
        // Show the testId when Register is clicked
        alert("Test ID: " + testId);

        // Create a form element
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = '/registerForTest';

        // Create an input element for the testId
        const input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'testId';
        input.value = testId;

        // Append the input element to the form
        form.appendChild(input);

        // Append the form to the document body
        document.body.appendChild(form);

        // Submit the form
        form.submit();

        return false; // Prevent the form submission
    }
</script>


</body>
</html>
