<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Orders</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <link rel="stylesheet" href="styles/userSidebar.css" />
</head>
<body>

<jsp:include page="userSidebar.jsp" />

<div class="main-content">
    <h2>User Orders</h2>
    <p>Work in progress...</p>
</div>

</body>
</html>

