<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, Model.User" %>
<%@ include file="sidebar.jsp" %>

<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" href="styles/manageUser.css">
</head>
<body>
<div class="main-content">
    <div class="dashboard-container">
        <h2>Manage Users</h2>
        <a href="register.jsp" class="add-user-btn">+ Add User</a>

        <%
            List<User> userList = (List<User>) request.getAttribute("userList");
        %>

        <% if (userList != null && !userList.isEmpty()) { %>
            <table class="user-table">
                <thead>
                <tr><th>ID</th><th>Username</th><th>Email</th><th>Gender</th><th>Address</th><th>Actions</th></tr>
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
                            <a href="ManageUserServlet?action=edit&id=<%= user.getId() %>">Edit</a>
                            <form action="ManageUserServlet" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete" />
                                <input type="hidden" name="id" value="<%= user.getId() %>" />
                                <button type="submit" onclick="return confirm('Are you sure?')">Delete</button>
                            </form>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        <% } else { %>
            <p>No users found.</p>
        <% } %>
    </div>
</div>
</body>
</html>
 --%>
 
 
 <%-- 
 
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, Model.User" %>

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
  --%>
  
  
  
 
<%--  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, Model.User" %>
<%@ include file="header.jsp" %> <!-- Optional: header/sidebar -->
<!DOCTYPE html>
<html>
<head>
    <title>Manage Users</title>
    <link rel="stylesheet" href="styles/mainCss.css">
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
                response.sendRedirect("manageUser"); // Match your servlet URL
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
                        <% for (User u : userList) { %>
                            <tr>
                                <td><%= u.getId() %></td>
                                <td><%= u.getUsername() %></td>
                                <td><%= u.getEmail() %></td>
                                <td><%= u.getGender() %></td>
                                <td><%= u.getAddress() %></td>    
                                <td>
                                    <a href="manageUser?action=edit&id=<%= user.getId() %>" class="edit-btn">Edit</a>
                                    <form action="manageUser" method="post" style="display:inline;">
                                        <input type="hidden" name="action" value="delete" />
                                        <input type="hidden" name="id" value="<%= user.getId() %>" />
                                        <button type="submit" class="delete-btn"
                                                onclick="return confirm('Are you sure you want to delete this user?');">
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

<%@ include file="footer.jsp" %> <!-- Optional: footer -->
</body>
</html> --%>
 
 <%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, Model.User" %>
<link rel="stylesheet" href="styles/manageUser.css">
<div class="dashboard-container">
    <h2>Manage Users</h2>
    
    <a href="register.jsp" class="add-user-btn">+ Add User</a>

    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        if (userList == null) {
            response.sendRedirect("manageUser");
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
                                <a href="manageUser?action=edit&id=<%= user.getId() %>" class="edit-btn">Edit</a>
                                <form action="manageUser" method="post" style="display:inline;">
                                    <input type="hidden" name="action" value="delete" />
                                    <input type="hidden" name="id" value="<%= user.getId() %>" />
                                    <button type="submit" class="delete-btn" onclick="return confirm('Are you sure?');">
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
   --%>
   
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, Model.User" %>
<link rel="stylesheet" href="styles/manageUser.css">
<div class="dashboard-container">
    <h2>Manage Users</h2>
    
    <a href="register.jsp" class="add-user-btn">+ Add User</a>

    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        if (userList == null) {
            response.sendRedirect("manageUser");
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
                                <a href="manageUser?action=edit&id=<%= user.getId() %>" class="edit-btn">Edit</a>
                                
                                <form action="manageUser" method="post" style="display:inline;">
                                    <input type="hidden" name="action" value="delete" />
                                    <input type="hidden" name="id" value="<%= user.getId() %>" />
                                    <button type="submit" class="delete-btn" onclick="return confirm('Are you sure?');">
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