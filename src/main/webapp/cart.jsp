<%@ page import="java.util.*, Model.CartItem" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
    if (cart == null) cart = new ArrayList<>();
%>
<h1>Your Cart</h1>
<% if (cart.isEmpty()) { %>
    <p>Your cart is empty.</p>
<% } else { %>
    <table border="1">
        <tr><th>Name</th><th>Price</th><th>Quantity</th><th>Total</th></tr>
        <% double grandTotal = 0;
           for (CartItem item : cart) {
               grandTotal += item.getTotalPrice();
        %>
            <tr>
                <td><%= item.getProduct().getName() %></td>
                <td>$<%= item.getProduct().getPrice() %></td>
                <td><%= item.getQuantity() %></td>
                <td>$<%= item.getTotalPrice() %></td>
            </tr>
        <% } %>
        <tr><td colspan="3">Grand Total</td><td>$<%= grandTotal %></td></tr>
    </table>
<% } %>
