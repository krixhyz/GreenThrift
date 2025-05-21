<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Us</title>
    <link rel="stylesheet" href="styles/contact.css">
    <link rel="stylesheet" href="styles/mainCss.css">
    <style>
        /* styles/contact.css or you can place this inside your <style> tag */

		body {
		    background: #d0f0d9;
		    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
		    color: #000000;
		    margin: 0;
		    padding: 0;
		}
		
		.contact-container {
		    background: #ffffff;
		    max-width: 500px;
		    margin: 40px auto;
		    padding: 30px 40px;
		    border-radius: 12px;
		    box-shadow: 0 8px 15px rgba(34, 49, 32, 0.2);
		    color: #000000;
		    transition: box-shadow 0.3s ease;
		}
		
		.contact-container:hover {
		    box-shadow: 0 12px 25px rgba(50, 60, 40, 0.4);
		}
		
		h1 {
		    text-align: center;
		    font-weight: 700;
		    margin-bottom: 25px;
		}
		
		.form-group {
		    margin-bottom: 20px;
		    display: flex;
		    flex-direction: column;
		}
		
		label {
		    margin-bottom: 8px;
		    font-weight: 600;
		    font-size: 1.1em;
		}
		
		input[type="text"],
		input[type="email"],
		textarea {
		    padding: 12px 15px;
		    border: 2px solid #a3d9a5;
		    border-radius: 8px;
		    font-size: 1em;
		    transition: border-color 0.3s ease, box-shadow 0.3s ease, transform 0.2s ease;
		    resize: vertical;
		    background: #ffffff;
		    color: #000000;
		    box-sizing: border-box;
		}
		
		input[type="text"]:hover,
		input[type="email"]:hover,
		textarea:hover {
		    border-color: #6fcf97;
		    box-shadow: 0 0 8px #6fcf97;
		    transform: scale(1.03);
		}
		
		input[type="text"]:focus,
		input[type="email"]:focus,
		textarea:focus {
		    border-color: #55b87c;
		    outline: none;
		    box-shadow: 0 0 12px #55b87c;
		    transform: scale(1.05);
		}
		
		button {
		    width: 100%;
		    background-color: #2ecc71; 
		    color: #000000;
		    font-weight: 700;
		    font-size: 1.1em;
		    padding: 14px 0;
		    border: none;
		    border-radius: 10px;
		    cursor: pointer;
		    transition: background-color 0.3s ease, box-shadow 0.3s ease, transform 0.2s ease;
		    box-shadow: 0 4px 10px rgba(111, 207, 151, 0.5);
		}
		
		button:hover {
		    background-color:  #27ae60;
		    box-shadow: 0 6px 14px rgba(85, 184, 124, 0.7);
		    transform: scale(1.05);
		}
		
		.error, .message {
		    font-weight: 600;
		    border-radius: 5px;
		    margin-top: 15px;
		    text-align: center;
		    padding: 10px;
		    max-width: 100%;
		    box-sizing: border-box;
		}
		
		.error {
		    color: #c0392b;
		    background-color: #fdecea;
		}
		
		.message {
		    color: #27ae60;
		    background-color: #eafaf1;
		}
		
		a {
		    display: block;
		    margin: 25px auto 0;
		    text-align: center;
		    color: #3b6333;
		    font-weight: 600;
		    text-decoration: none;
		    transition: color 0.3s ease;
		}
		
		a:hover {
		    color: #6fcf97;
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
