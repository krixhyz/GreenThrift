<%--  
 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, Model.User" %>
<%@ include file="sidebar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" href="styles/manageUser.css">
</head>
<body>

<div class="main-content">
    <div class="dashboard-container">
        <h2>Manage Users</h2>

        <!-- Add User Button -->
        <a href="register.jsp" class="add-user-btn">+ Add User</a>

        <%
            List<User> userList = (List<User>) request.getAttribute("userList");
        %>

        <%
            if (userList != null && !userList.isEmpty()) {
        %>
        <div class="table-wrapper">
            <table class="user-table">
                <thead>
                    <tr>
                         <th>ID</th>
					    <th>Username</th>
					    <th>Email</th>
					    <th>Gender</th>
					    <th>Address</th>	
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (User user : userList) { %>
                    <tr>
                       <td><%= user.getId() %></td>
						    <td><%= user.getUsername() %></td>
						    <td><%= user.getEmail() %></td>
						    <td><%= user.getGender() %></td>
						    <td><%= user.getAddress() %></td>	
                        <td>
                            <a href="ManageUserServlet?action=edit&id=<%= user.getId() %>" class="edit-btn">Edit</a>
                            
                            <form action="ManageUserServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="id" value="<%= user.getId() %>" />
                                <button type="submit" class="delete-btn" onclick="return confirm('Are you sure you want to delete this user?');">
                                    Delete
                                </button>
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <% } else { %>
        <p class="no-users">No users found.</p>
        <% } %>
    </div>
</div>

</body>
</html>
  --%>
  
  
  
  
  
  
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, Model.User" %>
<%@ include file="sidebar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" href="styles/manageUser.css">
</head>
<body>

<div class="main-content">
    <div class="dashboard-container">
        <h2>Manage Users</h2>

        <!-- Add User Button -->
        <a href="register.jsp" class="add-user-btn">+ Add User</a>

        <%
            List<User> userList = (List<User>) request.getAttribute("userList");
            if (userList == null) {
                response.sendRedirect("ManageUserServlet");
                return;
            }
        %>

        <% if (!userList.isEmpty()) { %>
            <div class="table-wrapper">
                <table class="user-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Gender</th>
                            <th>Address</th>	
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (User user : userList) { %>
                            <tr>
                                <td><%= user.getId() %></td>
                                <td><%= user.getUsername() %></td>
                                <td><%= user.getEmail() %></td>
                                <td><%= user.getGender() %></td>
                                <td><%= user.getAddress() %></td>	
                                <td>
                                    <a href="ManageUserServlet?action=edit&id=<%= user.getId() %>" class="edit-btn">Edit</a>
                                    <form action="ManageUserServlet" method="post" style="display:inline;">
                                        <input type="hidden" name="action" value="delete" />
                                        <input type="hidden" name="id" value="<%= user.getId() %>" />
                                        <button type="submit" class="delete-btn" onclick="return confirm('Are you sure you want to delete this user?');">
                                            Delete
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        <% } else { %>
            <p class="no-users">No users found.</p>
        <% } %>
    </div>
</div>

</body>
</html>
  