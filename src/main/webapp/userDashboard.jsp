<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="dashboard-container">
        <h1>User Dashboard</h1>
        <p>Welcome, ${user.username} (${user.role})</p>
        <a href="logout">Logout</a>
        
        <h2>Your Profile</h2>
        <div class="profile-info">
            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <p><strong>Role:</strong> ${user.role}</p>
        </div>
        
        <h2>Actions</h2>
        <ul>
            <li><a href="editProfile">Edit Profile</a></li>
            <li><a href="changePassword">Change Password</a></li>
        </ul>
    </div>
</body>
</html> --%>


<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<jsp:useBean id="user" class="Model.User" scope="session" />
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="dashboard-container">
        <h1>User Dashboard</h1>
        <p>Welcome, ${user.username} (${user.role})</p>
        <a href="logout">Logout</a>

        <h2>Your Profile</h2>
        <div class="profile-info">
            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <p><strong>Role:</strong> ${user.role}</p>
        </div>

        <h2>Actions</h2>
        <ul>
            <li><a href="editProfile">Edit Profile</a></li>
            <li><a href="changePassword">Change Password</a></li>
        </ul>
    </div>
</body>
</html> --%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<jsp:useBean id="user" class="Model.User" scope="session" />
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="dashboard-container">
        <h1>User Dashboard</h1>
        <p>Welcome, ${user.username} (${user.role})</p>
        <a href="logout">Logout</a>

        <h2>Your Profile</h2>
        <div class="profile-info">
            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <p><strong>Role:</strong> ${user.role}</p>
        </div>

        <h2>Actions</h2>
        <ul>
            <li><a href="userProfile.jsp">Edit Profile</a></li>
            <li><a href="changePassword">Change Password</a></li>
        </ul>
    </div>
</body>
</html>

