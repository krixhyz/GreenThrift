<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <style>
    .sidebar {
        width: 250px;
        height: 100vh;
        background-color: #4fd15c;
        color: white;
        padding: 20px;
        position: fixed;
        top: 0;
        left: 0;
        transition: left 0.3s;
        overflow-y: auto;
        box-shadow: 2px 0 10px rgba(0, 0, 0, 0.05);
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
        font-weight: 500;
    }

    .sidebar a:hover {
        background-color: #3bb64b;
    }

    .sidebar .logout {
        margin-top: auto;
        background-color: #4fd15c;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 5px;
        text-align: center;
        cursor: pointer;
        font-weight: 600;
    }

    .sidebar .logout:hover {
        background-color: #3bb64b;
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
 

 
    
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if (request.getAttribute("contentPage") == null) {
        request.setAttribute("contentPage", "/admin/dashboard");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            font-family: Arial, sans-serif;
        }
       /*  .sidebar {
            width: 250px;
            height: 100vh;
            background-color:  #2c3e50; 
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            overflow-y: auto;
        } */
        .sidebar {
    		position: fixed;
    		left: 0;
    		top: 0;
    		width: 220px;
    		height: 100%;
    		background-color: #2c3e50;
    		color: #ecf0f1;
    		padding-top: 20px;
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
            background-color: #0056b3; /* Darker blue on hover */
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
    <h2>Green Thrift</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard">Home</a>
    <a href="${pageContext.request.contextPath}/admin/categories">Categories</a>
    <a href="${pageContext.request.contextPath}/admin/addCategory">Add Categories</a>
    <a href="${pageContext.request.contextPath}/admin/products">View Products</a>
    <a href="${pageContext.request.contextPath}/admin/users">Users</a>
    <a href="${pageContext.request.contextPath}/admin/orders">Orders</a>
    <a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
</div>

<!-- Main Content -->
<div class="main-content">
    <c:if test="${not empty contentPage}">
        <jsp:include page="${contentPage}" />
    </c:if>
</div>

</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if (request.getAttribute("contentPage") == null) {
        request.setAttribute("contentPage", "/admin/dashboard");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
<style>
    body {
        margin: 0;
        padding: 0;
        display: flex;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #e6f3ea;
    }

    .sidebar {
        position: fixed;
        left: 0;
        top: 0;
        width: 220px;
        height: 100%;
        background-color: #a3d9a5;
        color: #1b3a1a;
        padding-top: 60px;
        box-sizing: border-box;
        box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
    }

    .sidebar h2 {
        text-align: center;
        margin-bottom: 30px;
        margin-top: 0;
        font-weight: bold;
        font-size: 1.5rem;
        color: #ffffff;
        text-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
    }

    .sidebar a {
        display: block;
        color: #1b3a1a;
        text-decoration: none;
        padding: 12px 20px;
        margin: 8px 15px;
        border-radius: 8px;
        background-color: #e6f3ea;
        transition: all 0.3s ease;
        font-weight: 600;
        font-size: 1rem;
        border-left: 3px solid transparent;
    }

    .sidebar a:hover {
        background-color: #cce9d6;
        transform: translateX(5px);
        border-left: 3px solid #2e7d32;
        box-shadow: 0 5px 15px rgba(46, 125, 50, 0.2);
        color: #1b3a1a;
    }

    .sidebar a i {
        margin-right: 10px;
        color: #2e7d32;
        transition: transform 0.3s ease;
    }

    .sidebar a:hover i {
        transform: scale(1.1);
        color: #1b3a1a;
    }

    .sidebar a.active {
        background-color: #d4f0dd !important;
        border-left: 3px solid #2e7d32;
    }

    .main-content {
        margin-left: 220px;
        padding: 20px;
        width: calc(100% - 220px);
        background-color: #e6f3ea;
        min-height: 100vh;
    }

    h1 {
        color: #1b3a1a;
    }
</style>

</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>Green Thrift</h2>
    <a href="${pageContext.request.contextPath}/admin/dashboard">
        <i class="fas fa-home"></i> Home
    </a>
    <a href="${pageContext.request.contextPath}/admin/categories">
        <i class="fas fa-th-list"></i> Categories
    </a>
    <a href="${pageContext.request.contextPath}/admin/categories?action=add">
        <i class="fas fa-plus-circle"></i> Add Category
    </a>
    <a href="${pageContext.request.contextPath}/productsPageAdmin.jsp">
        <i class="fas fa-box"></i> Products
    </a>
    <a href="${pageContext.request.contextPath}/manageUser">
        <i class="fas fa-users"></i> Users
    </a>
    <a href="${pageContext.request.contextPath}/admin/orders">
        <i class="fas fa-shopping-cart"></i> Orders
    </a>
    <a href="${pageContext.request.contextPath}/admin/dashboard?showContacts=true">
        <i class="fas fa-envelope"></i> Contact Inquiries
    </a>
	<a href="${pageContext.request.contextPath}/logout">
    <i class="fas fa-sign-out-alt"></i> Logout
</a>

</div>

<!-- Main Content -->
<div class="main-content">
    <c:if test="${not empty contentPage}">
        <jsp:include page="${contentPage}" />
    </c:if>
</div>

</body>
</html>
    