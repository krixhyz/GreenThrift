<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<jsp:include page="header.jsp" />

<h2>Search Results for "<%= request.getAttribute("searchQuery") %>"</h2>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    if (products != null && !products.isEmpty()) {
        for (Product p : products) {
%>
            <div>
                <h3><%= p.getName() %></h3>
                <p><%= p.getDescription() %></p>
                <p>Price: $<%= p.getPrice() %></p>
            </div>
<%
        }
    } else {
%>
        <p>No products found.</p>
<%
    }
%>
