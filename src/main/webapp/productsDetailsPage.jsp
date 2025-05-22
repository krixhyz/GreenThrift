<%-- 
<%@ page import="Model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    Object sessionUser = session.getAttribute("user");
    String userIdValue = (sessionUser != null) ? ((Model.User) sessionUser).getId() + "" : "";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="styles/productDetails.css">
    <link rel="stylesheet" href="styles/productDetailsToast.css">
</head>
<body>

<!-- Back to Products Button (Top-Left Corner) -->
<a href="productsPageUser.jsp" class="back-button-top">← Back to Products</a>

<!-- Toast container ABOVE the product container -->
<div id="toast" class="toast">Product added to cart successfully!</div>

<div class="product-container">
    <% if (product == null) { %>
        <p>Product not found.</p>
    <% } else {
        int stockQuantity = product.getStock();
    %>
    <div class="product-image-column">
        <img src="<%= product.getImageUrl() %>" alt="Product Image" class="product-image">
    </div>

    <div class="product-details-column">
        <h2><%= product.getName() %></h2>
        <p><%= product.getDescription() %></p>
        <p><strong>Price:</strong> Rs. <%= product.getPrice() %></p>
        <p><strong>Stock:</strong>
            <span class='<%= stockQuantity > 0 ? "in-stock" : "out-of-stock" %>'>
                <%= stockQuantity > 0 ? "In Stock" : "Out of Stock" %>
            </span>
        </p>

        <div class="button-group">
            <!-- Add to Cart Form -->
            <form id="addToCartForm" action="addToCart" method="post">
                <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                <input type="hidden" name="price" value="<%= product.getPrice() %>">
                <button type="submit" class="add-to-cart-button" <%= stockQuantity <= 0 ? "disabled" : "" %>>Add to Cart</button>
            </form>

            <!-- Buy Now Form -->
            <form action="buyNow" method="post">
                <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                <button type="submit" class="buy-now-button" <%= stockQuantity <= 0 ? "disabled" : "" %>>Buy Now</button>
            </form>
        </div>
    </div>
</div>

<script>
    document.getElementById('addToCartForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const form = this;
        const xhr = new XMLHttpRequest();
        xhr.open(form.method, form.action, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        const formData = new URLSearchParams(new FormData(form)).toString();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    if (xhr.responseURL.includes('login.jsp')) {
                        window.location.href = xhr.responseURL;
                    } else {
                        const toast = document.getElementById('toast');
                        toast.classList.add('show');
                        setTimeout(() => toast.classList.remove('show'), 3000);
                    }
                } else {
                    alert('Failed to add product to cart.');
                }
            }
        };
        xhr.send(formData);
    });
</script>

<% } %>
</body>
</html> --%>
 
 
 
 
 
 
<%@ page import="Model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product product = (Product) request.getAttribute("product");
    Object sessionUser = session.getAttribute("user");
    String userIdValue = (sessionUser != null) ? ((Model.User) sessionUser).getId() + "" : "";
%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" href="styles/productDetails.css">
    <link rel="stylesheet" href="styles/productDetailsToast.css">
</head>
<body>

<!-- Back to Products Button (Top-Left Corner) -->
<a href="productsPageUser.jsp" class="back-button-top">← Back to Products</a>

<!-- Toast container ABOVE the product container -->
<div id="toast" class="toast">Product added to cart successfully!</div>

<div class="product-container">
    <% if (product == null) { %>
        <p>Product not found.</p>
    <% } else {
        int stockQuantity = product.getStock();
    %>
    <div class="product-image-column">
        <img src="<%= product.getImageUrl() %>" alt="Product Image" class="product-image">
    </div>

    <div class="product-details-column">
        <h2><%= product.getName() %></h2>
        <p><%= product.getDescription() %></p>
        <p><strong>Price:</strong> Rs. <%= product.getPrice() %></p>
        <p><strong>Stock:</strong>
            <span class='<%= stockQuantity > 0 ? "in-stock" : "out-of-stock" %>'>
                <%= stockQuantity > 0 ? "In Stock" : "Out of Stock" %>
            </span>
        </p>

        <div class="button-group">
            <!-- Add to Cart Form -->
            <form id="addToCartForm" action="addToCart" method="post">
                <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                <input type="hidden" name="price" value="<%= product.getPrice() %>">
                <button type="submit" class="add-to-cart-button" <%= stockQuantity <= 0 ? "disabled" : "" %>>Add to Cart</button>
            </form>

 <form action="Checkout" method="get">
    <input type="hidden" name="productId" value="<%= product.getProductID() %>">
    <button type="submit" class="buy-now-button" <%= stockQuantity <= 0 ? "disabled" : "" %>>Buy Now</button>
</form>
 
 



      
      


        </div>
    </div>
</div>

<script>
    document.getElementById('addToCartForm').addEventListener('submit', function(event) {
        event.preventDefault();
        const form = this;
        const xhr = new XMLHttpRequest();
        xhr.open(form.method, form.action, true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        const formData = new URLSearchParams(new FormData(form)).toString();

        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    if (xhr.responseURL.includes('login.jsp')) {
                        window.location.href = xhr.responseURL;
                    } else {
                        const toast = document.getElementById('toast');
                        toast.classList.add('show');
                        setTimeout(() => toast.classList.remove('show'), 3000);
                    }
                } else {
                    alert('Failed to add product to cart.');
                }
            }
        };
        xhr.send(formData);
    });
</script>

<% } %>
</body>
</html>