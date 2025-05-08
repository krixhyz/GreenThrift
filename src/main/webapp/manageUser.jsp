 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, Model.User" %> 
<%@ include file="sidebar.jsp" %>



 <!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: #f4f7fa;
            margin: 0;
        }

        .main-content {
            margin-left: 250px;
            padding: 20px;
        }

        .dashboard-container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 3px 8px rgba(0,0,0,0.1);
        }

        h2 {
            color: black;
            margin-bottom: 20px;
        }

        .user-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        .user-table th, .user-table td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        .user-table th {
            background-color: #2ecc71;
            color: white;
        }

        .user-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .user-table tr:hover {
            background-color: #eafaf1;
        }
    </style>
</head>
<body>

<div class="main-content">
    <div class="dashboard-container">
        <h2>Manage Users</h2>

        <%
            List<User> userList = (List<User>) request.getAttribute("userList");
            if (userList != null && !userList.isEmpty()) {
        %>
            <table class="user-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Role</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (User user : userList) {
                    %>
                        <tr>
                            <td><%= user.getId() %></td>
                            <td><%= user.getUsername() %></td>
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getRole() %></td>
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p>No users found.</p>
        <%
            }
        %>
    </div>
</div>

</body>
</html>
