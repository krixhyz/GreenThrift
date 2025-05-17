<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.User, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="dashboard-container">
        <h1>Admin Dashboard</h1>
        <p>Welcome, ${user.username} (${user.role})</p>
        <a href="logout">Logout</a>
        
        <h2>User Management</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <% 
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null) {
                    for (User user : users) { 
            %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getRole() %></td>
                    <td>
                        <a href="editUser?id=<%= user.getId() %>">Edit</a> | 
                        <a href="deleteUser?id=<%= user.getId() %>">Delete</a>
                    </td>
                </tr>
            <% 
                    }
                } 
            %>
        </table>
    </div>
</body>
</html> --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<jsp:useBean id="user" class="Model.User" scope="session" />
<%@ page import="Model.User, java.util.List" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="dashboard-container">
        <h1>Admin Dashboard</h1>
        <p>Welcome, ${user.username} (${user.role})</p>
        <a href="logout">Logout</a>

        <h2>User Management</h2>
        <table border="1" cellpadding="10">
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            <%
                List<User> users = (List<User>) request.getAttribute("users");
                if (users != null) {
                    for (User u : users) {
            %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getUsername() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getRole() %></td>
                <td>
                    <a href="editUser?id=<%= u.getId() %>">Edit</a> |
                    <a href="deleteUser?id=<%= u.getId() %>">Delete</a>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <h2>Manage Inquiries</h2>
        <a href="contactData.jsp">View Contact Submissions</a>
    </div>
</body>
</html>

