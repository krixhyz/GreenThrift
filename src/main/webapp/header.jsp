<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String currentPage = request.getServletPath();
    boolean showSearch = currentPage.endsWith("productPageUser.jsp") || currentPage.endsWith("productsPageAdmin.jsp")  || currentPage.endsWith("homepage.jsp");
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
