<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <style>
        /* Sidebar Styling */
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2ecc71; /* Green background */
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            transition: left 0.3s;
            overflow-y: auto; /* Ensures sidebar content doesn't overflow vertically */
        }

        .sidebar h2 {
            color: white;
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
        }

        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #27ae60; /* Darker green on hover */
        }

        .sidebar .logout {
            margin-top: auto;
            background-color: #2ecc71; /* Green background */
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }

        .sidebar .logout:hover {
            background-color: #27ae60; /* Darker green on hover */
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>green thrift</h2>
    <a href="#">Home</a>
    <a href="#">Categories</a>
    <a href="#">Add Categories</a>
    <a href="#">View Products</a>
    <a href="#">Users</a>
    <a href="#">Orders</a>
    <button class="logout">Logout</button>
</div>



</body>
</html>
 --%>
 

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <style>
        /* Sidebar Styling */
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2ecc71;
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            transition: left 0.3s;
            overflow-y: auto;
        }

        .sidebar h2 {
            color: white;
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
        }

        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #27ae60;
        }

        .sidebar .logout {
            margin-top: auto;
            background-color: #2ecc71;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }

        .sidebar .logout:hover {
            background-color: #27ae60;
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>green thrift</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Home</a>
    <a href="#">Categories</a>
    <a href="#">Add Categories</a>
    <a href="#">View Products</a>
    <a href="#">Users</a>
    <a href="#">Orders</a>
    <button class="logout">Logout</button>
</div>

</body>
</html> --%>

<%-- 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
    <style>
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2ecc71;
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            overflow-y: auto;
        }
        .main-content {
            margin-left: 270px;
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="sidebar">
    <h2>green thrift</h2>
    <a href="sidebar.jsp?page=dashboard">Home</a>
    <a href="sidebar.jsp?page=categories">Categories</a>
    <a href="sidebar.jsp?page=addCategories">Add Categories</a>
    <a href="sidebar.jsp?page=viewProducts">View Products</a>
    <a href="sidebar.jsp?page=users">Users</a>
    <a href="sidebar.jsp?page=orders">Orders</a>
    <form action="${pageContext.request.contextPath}/logout" method="post" style="margin-top: 20px;">
        <button type="submit" class="logout">Logout</button>
    </form>
</div>

<div class="main-content">
    <c:choose>
        <c:when test="${param.page == 'categories'}">
            <h1>Categories Page</h1>
        </c:when>
        <c:when test="${param.page == 'addCategories'}">
            <h1>Add Categories Page</h1>
        </c:when>
        <c:when test="${param.page == 'viewProducts'}">
            <h1>View Products Page</h1>
        </c:when>
        <c:when test="${param.page == 'users'}">
            <h1>Users Page</h1>
        </c:when>
        <c:when test="${param.page == 'orders'}">
            <h1>Orders Page</h1>
        </c:when>
        <c:otherwise>
            <h1>Dashboard</h1>
            <%
                request.setAttribute("userCount", 100);
                request.setAttribute("productCount", 50);
                request.setAttribute("categoryCount", 10);
                request.setAttribute("orderCount", 30);
            %>
            <jsp:include page="/adminDashboard.jsp" />
        </c:otherwise>
    </c:choose>
</div>

</body>
</html> --%>


<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            font-family: Arial, sans-serif;
        }

        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2ecc71;
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            overflow-y: auto;
        }

        .sidebar h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #27ae60;
        }

        .main-content {
            margin-left: 250px;
            padding: 20px;
            width: calc(100% - 250px);
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>green thrift</h2>
<!--     <a href="sidebar.jsp?page=/admin/dashboard">Home</a> -->
	<a href="${pageContext.request.contextPath}/admin/dashboard">Home</a>
    <a href="sidebar.jsp?page=categories">Categories</a>
    <a href="sidebar.jsp?page=addCategories">Add Categories</a>
    <a href="sidebar.jsp?page=viewProducts">View Products</a>
    <a href="sidebar.jsp?page=users">Users</a>
    <a href="sidebar.jsp?page=orders">Orders</a>
    <a href="#">Logout</a>
</div>

<!-- Main Content -->
<div class="main-content">
    <c:choose>
        <c:when test="${param.page == 'categories'}">
            <jsp:include page="categories.jsp"/>
        </c:when>
        <c:when test="${param.page == 'addCategories'}">
            <jsp:include page="addCategories.jsp"/>
        </c:when>
        <c:when test="${param.page == 'viewProducts'}">
            <jsp:include page="viewProducts.jsp"/>
        </c:when>
        <c:when test="${param.page == 'users'}">
            <jsp:include page="users.jsp"/>
        </c:when>
        <c:when test="${param.page == 'orders'}">
            <jsp:include page="orders.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="/adminDashboard.jsp"/>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>



 --%>
 
 

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String pageParam = request.getParameter("page");
    if (pageParam == null) {
        response.sendRedirect(request.getContextPath() + "/admin/dashboard");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            font-family: Arial, sans-serif;
        }

        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2ecc71;
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            overflow-y: auto;
        }

        .sidebar h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #27ae60;
        }

        .main-content {
            margin-left: 250px;
            padding: 20px;
            width: calc(100% - 250px);
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>green thrift</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Home</a>
    <a href="sidebar.jsp?page=categories">Categories</a>
    <a href="sidebar.jsp?page=addCategories">Add Categories</a>
    <a href="sidebar.jsp?page=viewProducts">View Products</a>
    <a href="sidebar.jsp?page=users">Users</a>
    <a href="sidebar.jsp?page=orders">Orders</a>
    <a href="#">Logout</a>
</div>

<!-- Main Content -->
<div class="main-content">
    <c:choose>
        <c:when test="${param.page == 'dashboard'}">
            <jsp:include page="adminDashboard.jsp"/>
        </c:when>
        <c:when test="${param.page == 'categories'}">
            <jsp:include page="categories.jsp"/>
        </c:when>
        <c:when test="${param.page == 'addCategories'}">
            <jsp:include page="addCategories.jsp"/>
        </c:when>
        <c:when test="${param.page == 'viewProducts'}">
            <jsp:include page="viewProducts.jsp"/>
        </c:when>
        <c:when test="${param.page == 'users'}">
            <jsp:include page="users.jsp"/>
        </c:when>
        <c:when test="${param.page == 'orders'}">
            <jsp:include page="orders.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="adminDashboard.jsp"/>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
