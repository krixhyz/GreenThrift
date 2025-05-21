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
  --%>
 <%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Products</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/products.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

<main>
    <section class="products">
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
        %>
        <div class="product-grid">
            <%
                for (Product product : products) {
            %>
            <div class="product-card">
                <div class="product-image">
                    <img src="https://via.placeholder.com/300x400" alt="<%= product.getName() %>">
                </div>
                <h3><%= product.getName() %></h3>
                <p>Rs. <%= product.getPrice() %></p>
                <a href="productDetails?productId=<%= product.getProductID() %>" class="btn secondary">View Details</a>
            </div>
            <%
                }
            %>
        </div>
        <%
            } else {
        %>
        <p class="no-products">No products found for this category.</p>
        <%
            }
        %>
    </section>
</main>

<%@ include file="footer.jsp" %>
</body>
</html>