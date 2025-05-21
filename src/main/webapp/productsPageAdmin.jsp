<%-- <%@ page import="java.util.List" %>
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
 --%>
 
 
 <%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Admin Product Panel</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/admin-products.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

<main>
    <section class="admin-products">
        <h1>Admin: Manage Products</h1>
        <a href="productForm.jsp" class="btn primary"><i class="fas fa-plus"></i> Add New Product</a>
        <div class="product-grid">
            <%
                ProductDAO dao = new ProductDAO();
                List<Product> products = dao.getAllProducts();
                if (products != null && !products.isEmpty()) {
                    for (Product p : products) {
            %>
            <div class="product-card">
                <div class="product-image">
                    <img src="https://via.placeholder.com/300x400" alt="<%= p.getName() %>">
                </div>
                <h3><%= p.getName() %></h3>
                <p class="description"><%= p.getDescription() %></p>
                <p>Price: Rs. <%= p.getPrice() %></p>
                <p>Stock: <%= p.getStock() %></p>
                <p>Category ID: <%= p.getCategoryID() %></p>
                <p>Admin ID: <%= p.getAdminID() %></p>
                <div class="product-actions">
                    <a href="productForm.jsp?id=<%= p.getProductID() %>" class="btn secondary"><i class="fas fa-edit"></i> Edit</a>
                    <a href="adminProduct?action=delete&id=<%= p.getProductID() %>" class="btn delete" onclick="return confirm('Are you sure you want to delete this product?');"><i class="fas fa-trash"></i> Delete</a>
                </div>
            </div>
            <%
                    }
                } else {
            %>
            <p class="no-products">No products available.</p>
            <%
                }
            %>
        </div>
    </section>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>