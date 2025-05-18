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



<%-- <%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/admin-dashboard.css">
</head>
<body>

<h2>Welcome, <c:out value="${sessionScope.adminName}" default="Admin" />!</h2>

<section class="cards">
    <div class="card">
        <h3>Total Users</h3>
        <p>${userCount}</p>
    </div>
    <div class="card">
        <h3>Total Products</h3>
        <p>${productCount}</p>
    </div>
    <div class="card">
        <h3>Total Categories</h3>
        <p>${categoryCount}</p>
    </div>
</section>

</body>
</html> --%>

<%-- 
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/styles/admin-dashboard.css' />">
</head>
<body>

<div class="sidebar">
    <h2>Dashboard</h2>
    <ul>
        <li><a href="<c:url value='/admin/users' />">Users</a></li>
        <li><a href="<c:url value='/admin/products' />">Products</a></li>
        <li><a href="<c:url value='/admin/categories' />">Categories</a></li>
        <li><a href="<c:url value='/admin/orders' />">Orders</a></li>
        <li><a href="<c:url value='/logout' />">Logout</a></li>
    </ul>
</div>

<div class="main-content">
    <h2>Welcome, <c:out value="${sessionScope.adminName}" default="Admin" />!</h2>

    <section class="cards">
        <div class="card">
            <h3>Total Users</h3>
            <p>${userCount}</p>
        </div>
        <div class="card">
            <h3>Total Products</h3>
            <p>${productCount}</p>
        </div>
        <div class="card">
            <h3>Total Categories</h3>
            <p>${categoryCount}</p>
        </div>
    </section>
</div>

</body>
</html>
 --%>
 
 
 
<%-- <%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/styles/admin-dashboard.css' />">
</head>
<body>

<div class="main-content">
    <h2>Dashboard</h2>

    <p>Welcome Admins! Here you can manage users, products, and categories all in one place.</p>

    <section class="cards">
        <div class="card">
            <h3>Total Users</h3>
            <p>${userCount}</p>
        </div>
        <div class="card">
            <h3>Total Products</h3>
            <p>${productCount}</p>
        </div>
        <div class="card">
            <h3>Total Categories</h3>
            <p>${categoryCount}</p>
        </div>
    </section>
</div>

</body>
</html>
  --%>
  
  
  
<%-- <%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/styles/admin-dashboard.css' />">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

<div class="main-content">
    <h2>Dashboard</h2>

    <!-- Welcome Container -->
    <div class="welcome-box">
        <h1>Welcome Admins!</h1>
        <p>Manage your platform efficiently by overseeing users, products, and categories all in one place.</p>
    </div>

    <!-- Cards Section -->
    <section class="cards">
        <div class="card">
            <i class="fas fa-users fa-2x"></i>
            <h3>Total Users</h3>
            <p>${userCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-box fa-2x"></i>
            <h3>Total Products</h3>
            <p>${productCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-th-list fa-2x"></i>
            <h3>Total Categories</h3>
            <p>${categoryCount}</p>
        </div>
    </section>
</div>

</body>
</html> --%>


<%-- 
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/styles/admin-dashboard.css' />">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

<div class="main-content">
    <h2>Dashboard</h2>

    <!-- Welcome Container -->
    <div class="welcome-box">
        <h1>Welcome Admins!</h1>
        <p>Manage your platform efficiently by overseeing users, products, orders, and categories all in one place.</p>
    </div>

    <!-- Cards Section -->
    <section class="cards">
        <div class="card">
            <i class="fas fa-users fa-2x"></i>
            <h3>Total Users</h3>
            <p>${userCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-box fa-2x"></i>
            <h3>Total Products</h3>
            <p>${productCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-th-list fa-2x"></i>
            <h3>Total Categories</h3>
            <p>${categoryCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-shopping-cart fa-2x"></i>
            <h3>Total Orders</h3>
            <p>${orderCount}</p>
        </div>
    </section>

    <!-- Recent Orders Table -->
    <section class="recent-orders">
        <h3>Recent Orders</h3>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${recentOrders}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.username}</td>
                        <td>${order.date}</td>
                        <td>${order.status}</td>
                        <td>$${order.total}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</div>

</body>
</html>


 --%>  
 
 
<%-- <%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/styles/admin-dashboard.css' />">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

<div class="main-content">
    <h2>Dashboard</h2>

    <!-- Welcome Container -->
    <div class="welcome-box">
        <h1>Welcome Admins!</h1>
        <p>Manage your platform efficiently by overseeing users, products, orders, and categories all in one place.</p>
    </div>

    <!-- Cards Section -->
    <section class="cards">
        <div class="card">
            <i class="fas fa-users fa-2x"></i>
            <h3>Total Users</h3>
            <p>${userCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-box fa-2x"></i>
            <h3>Total Products</h3>
            <p>${productCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-th-list fa-2x"></i>
            <h3>Total Categories</h3>
            <p>${categoryCount}</p>
        </div>
        <div class="card">
            <i class="fas fa-shopping-cart fa-2x"></i>
            <h3>Total Orders</h3>
            <p>${orderCount}</p>
        </div>
    </section>

    <!-- Recent Orders Table -->
    <section class="recent-orders">
        <h3>Recent Orders</h3>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${recentOrders}">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.userId}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.status}</td>
                        <td>$${order.totalAmount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</div>

</body>
</html>
  --%>
  
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Redirect to servlet if accessed directly (no attributes set)
    if (request.getAttribute("userCount") == null) {
        response.sendRedirect(request.getContextPath() + "/admin/dashboard");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="<c:url value='/styles/admin-dashboard.css' />">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

<div class="main-content">
    <h2>Dashboard</h2>

    <!-- Welcome Container -->
    <div class="welcome-box">
        <h1>Welcome Admins!</h1>
        <p>Manage your platform efficiently by overseeing users, products, orders, and categories all in one place.</p>
    </div>

    <!-- Cards Section -->
    <section class="cards">
        <div class="card">
            <i class="fas fa-users fa-2x"></i>
            <h3>Total Users</h3>
            <p><c:out value="${userCount}" default="0" /></p>
        </div>
        <div class="card">
            <i class="fas fa-box fa-2x"></i>
            <h3>Total Products</h3>
            <p><c:out value="${productCount}" default="0" /></p>
        </div>
        <div class="card">
            <i class="fas fa-th-list fa-2x"></i>
            <h3>Total Categories</h3>
            <p><c:out value="${categoryCount}" default="0" /></p>
        </div>
        <div class="card">
            <i class="fas fa-shopping-cart fa-2x"></i>
            <h3>Total Orders</h3>
            <p><c:out value="${orderCount}" default="0" /></p>
        </div>
    </section>

    <!-- Recent Orders Table -->
    <section class="recent-orders">
        <h3>Recent Orders</h3>
        <table>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>User ID</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="order" items="${recentOrders}">
                    <tr>
                        <td>${order.orderId}</td>
                        <td>${order.userId}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.status}</td>
                        <td>$${order.totalAmount}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
</div>

</body>
</html>
 