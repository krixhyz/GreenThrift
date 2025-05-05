<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head><title>Admin Product Panel</title></head>
<body>
    <h1>Admin: Manage Products</h1>
    <a href="addProduct.jsp">Add New Product</a>
    <hr>
    <%
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();
        for (Product p : products) {
    %>
        <div style="border:1px solid black; margin:10px; padding:10px;">
            <h3><%= p.getName() %></h3>
            <p>Price: $<%= p.getPrice() %></p>
            <p>Stock: <%= p.getStock() %></p>
            <a href="editProduct.jsp?id=<%= p.getProductID() %>">Edit</a> |
            <a href="deleteProduct?id=<%= p.getProductID() %>">Delete</a>
        </div>
    <% } %>
</body>
</html>
