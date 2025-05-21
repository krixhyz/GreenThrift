<%@ page import="Model.User" %>
<%
    // Fetch current user and path
    String currentPage = request.getServletPath();
    User user = (User) session.getAttribute("user");

    // Role-based flag
    boolean isAdmin = user != null && "admin".equalsIgnoreCase(user.getRole());

    // Logo redirects to the appropriate homepage
    String logoLink = isAdmin ? "productsPageAdmin.jsp" : "homepage.jsp";

    // Show search bar only on these pages
    boolean showSearch = currentPage.endsWith("productPageUser.jsp") || 
                         currentPage.endsWith("productsPageAdmin.jsp") || 
                         currentPage.endsWith("homepage.jsp");
%>

<header style="position: relative; z-index: 1000; background-color: #fff; padding: 1em 0; box-shadow: 0 2px 5px rgba(0,0,0,0.1);">
    <div class="header-container" style="display: flex; justify-content: space-between; align-items: center; max-width: 1200px; margin: 0 auto; padding: 0 1em;">

        <!-- Logo -->
        <a href="<%= logoLink %>" class="logo" style="font-size: 1.5em; font-weight: bold; text-decoration: none; color: #333;">Green Thrifts</a>

        <!-- Navigation Links -->
        <nav>
            <ul style="list-style: none; display: flex; gap: 1em; margin: 0; padding: 0;">
                <% if (isAdmin) { %>
                    <!-- Admin Navigation -->
                    <li><a href="adminDashboard.jsp">Dashboard</a></li>
                    <li><a href="productsPageAdmin.jsp">Manage Products</a></li>
                    <li><a href="manageUser.jsp">Manage Users</a></li>
                <% } else { %>
                    <!-- User/Guest Navigation -->
                    <li><a href="homepage.jsp#shop">Shop</a></li>
                    <li><a href="#">Brands</a></li>
                    <li><a href="about.jsp">About</a></li>
                    <li><a href="contact.jsp">Contact</a></li>
                <% } %>
            </ul>
        </nav>

        <!-- Search Bar -->
        <% if (showSearch) { %>
            <form action="search" method="get" class="search-form" style="margin-left: 1em;">
                <input type="text" name="query" placeholder="Search products..." required style="padding: 0.3em;" />
                <button type="submit" style="padding: 0.3em 0.6em;">Search</button>
            </form>
        <% } %>

        <!-- Header Actions -->
        <div class="header-actions" style="margin-left: auto; display: flex; gap: 0.5em;">
            <% if (user == null) { %>
                <!-- Not Logged In -->
                <a href="login.jsp" class="btn login" style="text-decoration: none;">Login</a>
                <a href="register.jsp" class="btn register" style="text-decoration: none;">Register</a>
            <% } else { %>
                <% if (!isAdmin) { %>
                    <!-- Logged in User -->
                    <a href="cart.jsp" class="btn cart" style="text-decoration: none;">Cart</a>
                    <a href="userDashboard.jsp" class="btn profile" style="text-decoration: none;">Profile</a>
                <% } %>
                <!-- Common Logout for both admin and user -->
                <a href="logout" class="btn logout" style="text-decoration: none;">Logout</a>
            <% } %>
        </div>
    </div>
</header>
