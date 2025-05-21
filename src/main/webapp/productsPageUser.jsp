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
 