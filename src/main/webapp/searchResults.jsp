<%-- 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Search Results</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/search-results.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />

<main>
    <section class="search-results">
        <h2>Search Results for "<%= request.getAttribute("query") %>"</h2>

        <%
            List<Product> products = (List<Product>) request.getAttribute("results");
            Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
            if (isAdmin == null) isAdmin = false;

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
                <p class="description"><%= product.getDescription() %></p>
                <p>Stock: <%= product.getStock() %></p>
                <div class="product-actions">
                    <% if (isAdmin) { %>
                    <a href="productForm.jsp?id=<%= product.getProductID() %>" class="btn secondary">Edit</a>
                    <a href="adminProduct?action=delete&id=<%= product.getProductID() %>" class="btn delete" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
                    <% } else { %>
                    <a href="productsDetailsPage.jsp?productId=<%= product.getProductID() %>" class="btn secondary">View Details</a>
                    <form action="cart" method="post" class="cart-form">
                        <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                        <input type="hidden" name="action" value="add">
                        <button type="submit" class="btn secondary">Add to Cart</button>
                    </form>
                    <form action="CheckoutServlet" method="post" class="buy-form">
                        <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                        <input type="hidden" name="action" value="buy">
                        <button type="submit" class="btn primary">Buy Now</button>
                    </form>
                    <% } %>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <%
            } else {
        %>
        <p class="no-products">No products found matching your search.</p>
        <%
            }
        %>
        <a href="<%= isAdmin ? "productsPageAdmin.jsp" : "productsPageUser.jsp" %>" class="btn back">Back to Products</a>
    </section>
</main>

<jsp:include page="footer.jsp" />
</body>
</html> --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Green Thrifts - Search Results</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link rel="stylesheet" href="styles/search-results.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="header.jsp" />

<main>
    <section class="search-results">
        <h2>Search Results for "<%= request.getAttribute("query") %>"</h2>

        <%
            List<Product> products = (List<Product>) request.getAttribute("results");
            Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
            if (isAdmin == null) isAdmin = false;

            if (products != null && !products.isEmpty()) {
        %>
        <div class="product-grid">
            <%
                for (Product product : products) {
            %>
            <div class="product-card">
                <div class="product-image">
                    <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() != null ? product.getImageUrl() : "https://via.placeholder.com/300x400" %>" alt="<%= product.getName() != null ? product.getName() : "Product Image" %>">
                </div>
                <h3><%= product.getName() %></h3>
                <p>Rs. <%= product.getPrice() %></p>
                <p class="description"><%= product.getDescription() %></p>
                <p>Stock: <%= product.getStock() %></p>
                <div class="product-actions">
                    <% if (isAdmin) { %>
                    <a href="productForm.jsp?id=<%= product.getProductID() %>" class="btn secondary">Edit</a>
                    <a href="adminProduct?action=delete&id=<%= product.getProductID() %>" class="btn delete" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
                    <% } else { %>
                    <a href="productsDetailsPage.jsp?productId=<%= product.getProductID() %>" class="btn secondary">View Details</a>
                    <form action="cart" method="post" class="cart-form">
                        <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                        <input type="hidden" name="action" value="add">
                        <button type="submit" class="btn secondary">Add to Cart</button>
                    </form>
                    <form action="CheckoutServlet" method="post" class="buy-form">
                        <input type="hidden" name="productId" value="<%= product.getProductID() %>">
                        <input type="hidden" name="action" value="buy">
                        <button type="submit" class="btn primary">Buy Now</button>
                    </form>
                    <% } %>
                </div>
            </div>
            <%
                }
            %>
        </div>
        <%
            } else {
        %>
        <p class="no-products">No products found matching your search.</p>
        <%
            }
        %>
        <a href="<%= isAdmin ? "productsPageAdmin.jsp" : "productsPageUser.jsp" %>" class="btn back">Back to Products</a>
    </section>
</main>

<jsp:include page="footer.jsp" />
</body>
</html>