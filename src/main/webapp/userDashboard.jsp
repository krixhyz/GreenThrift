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
    <link rel="stylesheet" href="styles/userDashboard.css">
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <link rel="stylesheet" href="styles/userSidebar.css" />
    <style>
    * {
        box-sizing: border-box;
    }

    html, body {
        margin: 0;
        padding: 0;
        overflow-x: hidden;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    }

    .main-content {
        margin-left: 220px;
        padding: 20px;
        width: calc(100% - 220px);
        background-color: #e9f8ef;
        min-height: 100vh;
        position: relative;
    }

    .main-content h2 {
        text-align: center;
        margin-top: 0;
        margin-bottom: 20px;
        font-weight: 700;
        color: #2c3e50;
    }

    .edit-profile-button {
        position: absolute;
        top: 20px;
        right: 30px;
        background-color: #ffffff;
        border-radius: 50%;
        padding: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.15);
        border: none;
        cursor: pointer;
        transition: all 0.3s ease;
        text-decoration: none;
        color: inherit;
    }

    .edit-profile-button:hover {
        background-color: #f0f0f0;
        transform: scale(1.05);
    }

    .edit-profile-button i {
        font-size: 1.3rem;
        /* No color override here */
    }

    /* Custom tooltip using data-tooltip attribute */
    .edit-profile-button[data-tooltip]:hover::after {
        content: attr(data-tooltip);
        position: absolute;
        top: 48px; /* below the button (20px top + 24px button height + 4px margin) */
        right: 0;
        background: #333;
        color: #fff;
        padding: 4px 8px;
        border-radius: 4px;
        font-size: 12px;
        white-space: nowrap;
        z-index: 10;
        pointer-events: none;
    }

    .welcome-box {
        background-color: #ffffff;
        padding: 25px 30px;
        border-radius: 10px;
        box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        margin-bottom: 30px;
        text-align: center;
    }

    .welcome-box h1 {
        font-size: 2.4rem;
        margin: 0 0 10px 0;
        color: #2c3e50;
    }

    .welcome-box p {
        font-size: 1rem;
        color: #555;
    }

    .cards {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
        gap: 20px;
        margin-top: 20px;
        width: 100%;
    }

    .card {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        text-align: center;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .card i {
        margin-bottom: 10px;
    }

    .card h3 {
        margin: 10px 0 5px 0;
        color: #2c3e50;
    }

    .card p {
        font-size: 1.2rem;
        margin: 0;
        color: #34495e;
        word-break: break-word;
    }
    </style>
</head>
<body>

<jsp:include page="userSidebar.jsp" />

<div class="main-content">
    <div class="dashboard-header">
        <h2>User Dashboard</h2>
        <!-- Removed title, added data-tooltip for custom tooltip -->
        <a href="userProfile.jsp" class="edit-profile-button" data-tooltip="Edit Profile">
            <i class="fas fa-user-edit"></i>
        </a>
    </div>

    <div class="welcome-box">
        <h1>Welcome, ${user.username}!</h1>
        <p>You can view your account details and manage your profile here.</p>
    </div>

    <section class="cards">
        <div class="card">
            <i class="fas fa-user fa-2x"></i>
            <h3>Username</h3>
            <p>${user.username}</p>
        </div>
        <div class="card">
            <i class="fas fa-envelope fa-2x"></i>
            <h3>Email</h3>
            <p>${user.email}</p>
        </div>
    </section>
</div>

</body>
</html>




















