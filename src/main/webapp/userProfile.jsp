<%@ page import="Model.User" %>
<%@ page session="true" %>

<%
    User user = (User) session.getAttribute("user");
    String message = (String) request.getAttribute("message");

    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
        * {
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: #d1f7d1;  /* Pastel Green Background */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .card {
            background-color: #ffffff;
            padding: 40px;
            width: 450px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 128, 0, 0.1);
            border-top: 5px solid #4CAF50;
        }

        h2 {
            text-align: center;
            color: #2e7d32;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: 600;
            color: #333;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            transition: border-color 0.3s ease;
        }

        input:focus {
            border-color: #4CAF50;
            outline: none;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #388e3c;
        }

        .message {
            text-align: center;
            margin-top: 15px;
            color: #2e7d32;
            font-weight: 600;
        }

    </style>
</head>
<body>
<div class="card">
    <h2>User Profile</h2>
    <form method="post" action="UserProfileServlet">
        <label>Username</label>
        <input type="text" name="username" value="<%= user.getUsername() %>" readonly />

        <label>Email</label>
        <input type="email" name="email" value="<%= user.getEmail() %>" required />

        <label>New Password </label>
        <input type="password" name="password" placeholder="Leave blank to keep current" />

        <label>Role</label>
        <input type="text" name="role" value="<%= user.getRole() %>" readonly />

        <button type="submit">Update Profile</button>
    </form>

    <% if (message != null) { %>
        <div class="message"><%= message %></div>
    <% } %>
</div>
</body>
</html>
