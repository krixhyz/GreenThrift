<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <link rel="stylesheet" href="styles/contact.css">
    <link rel="stylesheet" href="styles/mainCss.css">
    <style>
        .error {
            color: #c0392b;
            background-color: #fdecea;
            padding: 10px;
            border-radius: 5px;
            margin-top: 15px;
            text-align: center;
        }

        .message {
            color: #27ae60;
            background-color: #eafaf1;
            padding: 10px;
            border-radius: 5px;
            margin-top: 15px;
            text-align: center;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>

<main>
    <div class="contact-container">
        <h1>Contact Us</h1>
        <form action="contact" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required
                       value="${name != null ? name : ''}">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required
                       value="${email != null ? email : ''}">
            </div>
            <div class="form-group">
                <label for="message">Message:</label>
                <textarea id="message" name="message" required>${messageContent != null ? messageContent : ''}</textarea>
            </div>
            <button type="submit">Send</button>
        </form>

        <!-- Error Message -->
        <c:if test="${not empty error}">
            <p class="error">${error}</p>
        </c:if>

        <!-- Success Message -->
        <c:if test="${not empty successMessage}">
            <p class="message">${successMessage}</p>
        </c:if>

        <a href="homepage.jsp">Back to Home</a>
    </div>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>
