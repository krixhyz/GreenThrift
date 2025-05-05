<%@ page import="Model.Product" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProductDAO dao = new ProductDAO();
    Product p = dao.getProductById(id);
%>

<html>
<head><title>Product Details</title></head>
<body>
    <h1><%= p.getName() %></h1>
    <p><strong>Description:</strong> <%= p.getDescription() %></p>
    <p><strong>Price:</strong> $<%= p.getPrice() %></p>
    <p><strong>Stock:</strong> <%= p.getStock() %></p>
    <a href="addToCart.jsp?id=<%= p.getProductID() %>">Add to Cart</a>
</body>
</html>
