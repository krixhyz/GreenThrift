<%@ page import="java.util.List" %>
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
</html>
