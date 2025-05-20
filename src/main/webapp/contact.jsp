<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <link rel="stylesheet" href="styles/mainCss.css">
</head>
<body>
    <%@ include file="header.jsp" %>
    <div class="dashboard-container">
        <h1>Contact Us</h1>
        <form action="contact" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="message">Message:</label>
                <textarea id="message" name="message" required></textarea>
            </div>
            <button type="submit">Send</button>
        </form>
        <% if (request.getAttribute("message") != null) { %>
            <p class="message">${request.getAttribute("message")}</p>
        <% } %>
        <a href="homepage.jsp">Back to Home</a>
    </div>
    <%@ include file="footer.jsp" %>
</body>
</html>
