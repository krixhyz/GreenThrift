<%--  <%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Products</title></head>
<body>
    <h1>Available Products</h1>
    <%
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();
        for (Product p : products) {
    %>
        <div style="border:1px solid black; margin:10px; padding:10px;">
            <h3><%= p.getName() %></h3>
            <p><%= p.getDescription() %></p>
            <p>Price: $<%= p.getPrice() %></p>
            <p>Stock: <%= p.getStock() %></p>
            <a href="productDetails.jsp?id=<%= p.getProductID() %>">View Details</a> |
            <a href="addToCart.jsp?id=<%= p.getProductID() %>">Add to Cart</a>
        </div>
    <% } %>
</body>
</html>>
 --%>
<%-- <%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<link rel="stylesheet" href="styles/mainCss.css">
<title>Products</title></head>
<body>
 <%@ include file="header.jsp" %>

    <h1>Available Products</h1>

    <%
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();
        if (products != null && !products.isEmpty()) {
            for (Product product : products) {
    %>
        <div style="border:1px solid gray; padding:10px; margin:10px;">
            <strong><%= product.getName() %></strong><br>
            Rs. <%= product.getPrice() %><br>
            <a href="productDetails?productId=<%= product.getProductID() %>">View Details</a>
        </div>
    <%
            }
        } else {
    %>
        <p>No products found.</p>
    <%
        }
    %>
    
    <%@ include file="footer.jsp" %>
</body>
</html>



 --%>
 
 
 
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<link rel="stylesheet" href="styles/mainCss.css">
<title>Products</title></head>
<body>
<%@ include file="header.jsp" %>

    <h1>Available Products</h1>

    <%
        String categoryIdParam = request.getParameter("categoryId");
        int categoryId = categoryIdParam != null ? Integer.parseInt(categoryIdParam) : 0;

        ProductDAO dao = new ProductDAO();
        List<Product> products;
        if (categoryId > 0) {
            products = dao.getProductsByCategory(categoryId);
        } else {
            products = dao.getAllProducts(); // fallback to show all
        }

        if (products != null && !products.isEmpty()) {
            for (Product product : products) {
    %>
        <div style="border:1px solid gray; padding:10px; margin:10px;">
            <strong><%= product.getName() %></strong><br>
            Rs. <%= product.getPrice() %><br>
            <a href="productDetails?productId=<%= product.getProductID() %>">View Details</a>
        </div>
    <%
            }
        } else {
    %>
        <p>No products found for this category.</p>
    <%
        }
    %>

<%@ include file="footer.jsp" %>
</body>
</html>
 