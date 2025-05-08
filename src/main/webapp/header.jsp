<%-- <%@ page language="java" pageEncoding="UTF-8" %>
<%
    String currentPage = request.getServletPath();
    boolean showSearch = currentPage.endsWith("productsPageUser.jsp") || currentPage.endsWith("productsPageAdmin.jsp") ;
%>
<header>
    <div class="header-container">
        <a href="homepage.jsp" class="logo">Green Thrifts</a>
        <nav>
            <ul>
                <li><a href="#shop">Shop</a></li>
                <li><a href="#">Brands</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </nav>

        <% if (showSearch) { %>
        <form action="search" method="get" class="search-form">
            <input type="text" name="query" placeholder="Search products..." required />
            <button type="submit">Search</button>
        </form>
        <% } %>

        <div class="header-actions">
            <a href="login.jsp" class="btn login">Login</a>
            <a href="register.jsp" class="btn register">Register</a>
        </div>
    </div>
</header>
 --%>
<%--  
 
 <%@ page language="java" pageEncoding="UTF-8" %>
<%
    String currentPage = request.getServletPath();
    boolean showSearch = currentPage.endsWith("productsPageUser.jsp") || currentPage.endsWith("productsPageAdmin.jsp");
%>

<header>
    <div class="header-container">
        <!-- Logo and Navigation -->
        <a href="homepage.jsp" class="logo">Green Thrifts</a>
        <nav>
            <ul>
                <li><a href="#shop">Shop</a></li>
                <li><a href="#">Brands</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </nav>

        <!-- Search Bar: Only visible on product pages -->
        <% if (showSearch) { %>
        <form action="productsPageUser.jsp" method="get" class="search-form">
            <input type="text" name="query" placeholder="Search products..." required />
            <button type="submit">Search</button>
        </form>
        <% } %>

        <!-- User Actions (Login/Register) -->
        <div class="header-actions">
            <a href="login.jsp" class="btn login">Login</a>
            <a href="register.jsp" class="btn register">Register</a>
        </div>
    </div>
</header>
  --%>
  
  
  <%@ page language="java" pageEncoding="UTF-8" %>
<%
    String currentPage = request.getServletPath();
    boolean showSearch = currentPage.endsWith("productsPageUser.jsp") || currentPage.endsWith("productsPageAdmin.jsp");
    boolean isAdmin = currentPage.endsWith("productsPageAdmin.jsp");
%>

<header>
    <div class="header-container">
        <a href="homepage.jsp" class="logo">Green Thrifts</a>
        <nav>
            <ul>
                <li><a href="#shop">Shop</a></li>
                <li><a href="#">Brands</a></li>
                <li><a href="#">About</a></li>
            </ul>
        </nav>

        <% if (showSearch) { %>
        <form action="search" method="get" class="search-form">
            <input type="text" name="query" placeholder="Search products..." required />
            <input type="hidden" name="role" value="<%= isAdmin ? "admin" : "user" %>" />
            <button type="submit">Search</button>
        </form>
        <% } %>

        <div class="header-actions">
            <a href="login.jsp" class="btn login">Login</a>
            <a href="register.jsp" class="btn register">Register</a>
        </div>
    </div>
</header>
  