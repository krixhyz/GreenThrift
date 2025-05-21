<%-- 
 
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
        // Log error for debugging
        e.printStackTrace();
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
        <form action="add-to-cart" method="post" style="display:inline;">
            <input type="hidden" name="productId" value="<%= product.getProductID() %>">
            <input type="number" name="quantity" value="1" min="1" max="<%= product.getStock() %>" required>
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
</html> --%>


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
        // Log error for debugging
        e.printStackTrace();
    }
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Product Details</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/product-details.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>

<main>
    <section class="product-details">
        <%
            if (product != null) {
        %>
        <div class="product-card">
            <div class="product-image">
                <img src="https://via.placeholder.com/400x500" alt="<%= product.getName() %>">
            </div>
            <div class="product-info">
                <h2><%= product.getName() %></h2>
                <p class="description"><strong>Description:</strong> <%= product.getDescription() %></p>
                <p><strong>Price:</strong> Rs. <%= product.getPrice() %></p>
                <p><strong>Stock Available:</strong> <%= product.getStock() %></p>
                <p><strong>Date Added:</strong> <%= product.getDateAdded() %></p>
                <div class="product-actions">
                    <form action="add-to-cart" method="post" class="cart-form">
                        <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                        <input type="number" name="quantity" value="1" min="1" max="<%= product.getStock() %>" required>
                        <button type="submit" class="btn secondary"><i class="fas fa-shopping-cart"></i> Add to Cart</button>
                    </form>
                    <form action="CheckoutServlet" method="post" class="buy-form">
                        <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                        <input type="hidden" name="action" value="buy">
                        <button type="submit" class="btn primary"><i class="fas fa-credit-card"></i> Buy Now</button>
                    </form>
                </div>
                <a href="productsPageUser.jsp" class="btn back"><i class="fas fa-arrow-left"></i> Back to Products</a>
            </div>
        </div>
        <%
            } else {
        %>
        <div class="no-product">
            <p>Product not found or invalid product ID.</p>
            <a href="productsPageUser.jsp" class="btn back"><i class="fas fa-arrow-left"></i> Back to Products</a>
        </div>
        <%
            }
        %>
    </section>
</main>

<jsp:include page="footer.jsp" />
</body>
</html>