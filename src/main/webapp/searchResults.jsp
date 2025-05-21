<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>

<jsp:include page="header.jsp" />

<h2>Search Results for "<%= request.getAttribute("query") %>"</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("results");
    Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
    if (isAdmin == null) isAdmin = false;

    if (products != null && !products.isEmpty()) {
        for (Product product : products) {
%>
    <div style="border:1px solid gray; padding:10px; margin:10px;">
        <strong><%= product.getName() %></strong><br>
        Rs. <%= product.getPrice() %><br>
        <p><%= product.getDescription() %></p>
        <p>Stock: <%= product.getStock() %></p>

        <a href="productDetailsPage?productId=<%= product.getProductID() %>">View Details</a>

        <% if (isAdmin) { %>
            | <a href="editProduct.jsp?id=<%= product.getProductID() %>">Edit</a>
            | <a href="deleteProduct?id=<%= product.getProductID() %>">Delete</a>
        <% } else { %>
            | <a href="addToCart.jsp?id=<%= product.getProductID() %>">Add to Cart</a>
        <% } %>
    </div>
<%
        }
    } else {
%>
    <p>No products found matching your search.</p>
<%
    }
%>

<a href="<%= isAdmin ? "productsPageAdmin.jsp" : "productsPageUser.jsp" %>">Back to Products</a>

<jsp:include page="footer.jsp" />
 --%>
 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>

<jsp:include page="header.jsp" />

<h2>Search Results for "<%= request.getAttribute("query") %>"</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("results");
    Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
    if (isAdmin == null) isAdmin = false;

    if (products != null && !products.isEmpty()) {
        for (Product product : products) {
%>
    <div style="border:1px solid gray; padding:10px; margin:10px;">
        <strong><%= product.getName() %></strong><br>
        Rs. <%= product.getPrice() %><br>
        <p><%= product.getDescription() %></p>
        <p>Stock: <%= product.getStock() %></p>

        

        <% if (isAdmin) { %>
             <a href="productForm.jsp?id=<%= product.getProductID() %>">Edit</a>
            | <a href="adminProduct?action=delete&id=<%= product.getProductID() %>"
                 onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
        <% } else { %>
        
        		<a href="productsDetailsPage.jsp?id=<%= product.getProductID() %>">View Details</a>

            <!-- Add to Cart form -->
            <form action="cart" method="post" style="display:inline; margin-left:10px;">
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
        <% } %>
    </div>
<%
        }
    } else {
%>
    <p>No products found matching your search.</p>
<%
    }
%>

<a href="<%= isAdmin ? "productsPageAdmin.jsp" : "productsPageUser.jsp" %>">Back to Products</a>

<jsp:include page="footer.jsp" />
