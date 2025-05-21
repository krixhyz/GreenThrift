<%-- <%@ page import="Model.Product" %>
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
 --%>
 
<%@ page import="DAO.ProductDAO, Model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id = 0;
    Product product = null;

    try {
    	id = Integer.parseInt(request.getParameter("productId"));
        ProductDAO dao = new ProductDAO();
        product = dao.getProductById(id);
    } catch (Exception e) {
        // handle bad id or DAO error
    }
%>

<html>
<head>
    <link rel="stylesheet" href="styles/mainCss.css">
    <title>Product Details</title>
</head>
<body>
    <%@ include file="header.jsp" %>

    <%
        if (product != null) {
    %>
        <h2><%= product.getName() %></h2>
        <p><strong>Description:</strong> <%= product.getDescription() %></p>
        <p><strong>Price:</strong> Rs. <%= product.getPrice() %></p>
        <p><strong>Stock Available:</strong> <%= product.getStock() %></p>
        <p><strong>Date Added:</strong> <%= product.getDateAdded() %></p>

        <!-- Add to Cart form -->
        <form action="cart" method="post" style="display:inline;">
            <input type="hidden" name="productId" value="<%= product.getProductID() %>">
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add to Cart">
        </form>

        <!-- Buy Now form -->
        <form action="CheckoutServlet" method="post" style="display:inline; margin-left:10px;">
            <input type="hidden" name="productId" value="<%= product.getProductID() %>">
            <input type="hidden" name="action" value="buy">
            <input type="submit" value="Buy Now">
        </form>

        <br><br>
        <a href="productsPageUser.jsp">Back to Products</a>
    <%
        } else {
    %>
        <p>Product not found or invalid product ID.</p>
        <a href="productsPageUser.jsp">Back to Products</a>
    <%
        }
    %>

    <jsp:include page="footer.jsp" />
</body>
</html>
