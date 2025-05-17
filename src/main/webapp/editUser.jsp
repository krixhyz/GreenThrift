<%@ page import="Model.User" %>
<%@ page session="true" %>

<%
    User user = (User) request.getAttribute("user");
    if (user == null) {
        response.sendRedirect("ManageUserServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/editUser.css">
</head>
<body>

    <div class="dashboard-container">
        <h2>Edit User</h2>

        <form method="post" action="ManageUserServlet" class="editUserForm">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="<%= user.getId() %>" />

            <label>Username (cannot be changed)</label>
            <input type="text" name="username" value="<%= user.getUsername() %>" readonly />

            <label>Email</label>
            <input type="email" name="email" value="<%= user.getEmail() %>" required />

            <label>New Password</label>
            <input type="password" name="password" placeholder="Leave blank to keep current password" />

            <label>Role</label>
            <input type="text" name="role" value="<%= user.getRole() %>" required />

            <label>First Name</label>
            <input type="text" name="firstname" value="<%= user.getFirstname() %>" required />

            <label>Last Name</label>
            <input type="text" name="lastname" value="<%= user.getLastname() %>" required />

            <label>Phone</label>
            <input type="text" name="phone" value="<%= user.getPhone() != null ? user.getPhone() : "" %>" />

            <button type="submit">Update User</button>
        </form>

        <%
            String message = (String) request.getAttribute("message");
            if (message != null) {
        %>
            <div class="message"><%= message %></div>
        <%
            }
        %>
    </div>

</body>
</html>
