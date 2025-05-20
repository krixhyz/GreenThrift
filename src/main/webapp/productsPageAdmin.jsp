<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="styles/mainCss.css">
    <title>Admin Product Panel</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <h1>Admin: Manage Products</h1>
    <a href="productForm.jsp">Add New Product</a>
    <hr>

    <%
        ProductDAO dao = new ProductDAO();
        List<Product> products = dao.getAllProducts();
        for (Product p : products) {
    %>
        <div style="border:1px solid black; margin:10px; padding:10px;">
            <h3><%= p.getName() %></h3>
            <p>Description: <%= p.getDescription() %></p>
            <p>Price: $<%= p.getPrice() %></p>
            <p>Stock: <%= p.getStock() %></p>
            <p>Category ID: <%= p.getCategoryID() %></p>
            <p>Admin ID: <%= p.getAdminID() %></p>
            <a href="productForm.jsp?id=<%= p.getProductID() %>">Edit</a> |
            <a href="adminProduct?action=delete&id=<%= p.getProductID() %>" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
        </div>
    <%
        }
    %>

    <%@ include file="footer.jsp" %>
</body>
</html>
