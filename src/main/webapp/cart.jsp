
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.CartItem" %>
<%@ page import="DAO.ProductDAO" %>
<%@ page import="Model.Product" %>
<%
    // Initialize ProductDAO instance
    ProductDAO productDAO = new ProductDAO();
%>
<%
    if (request.getAttribute("cartItems") == null) {
        response.sendRedirect("cart");
        return;
    }
%>
<html>
<head>
    <title>Your Cart</title>
    <link rel="stylesheet" href="styles/cart.css">
    <script>
        function toggleSelectAll(source) {
            const checkboxes = document.querySelectorAll('.item-checkbox');
            checkboxes.forEach(cb => cb.checked = source.checked);
            calculateSummary();
        }

        function checkboxChanged() {
            const allCheckbox = document.getElementById('select-all');
            const checkboxes = document.querySelectorAll('.item-checkbox');
            allCheckbox.checked = Array.from(checkboxes).every(cb => cb.checked);
            calculateSummary();
        }

        function calculateSummary() {
            const rows = document.querySelectorAll('.cart-item-row');
            let subtotal = 0;
            let totalItems = 0;
            rows.forEach(row => {
                const checkbox = row.querySelector('.item-checkbox');
                if (checkbox.checked) {
                    const price = parseFloat(row.dataset.price);
                    const qty = parseInt(row.querySelector('.quantity-input').value);
                    subtotal += price * qty;
                    totalItems += qty;
                }
            });
            document.getElementById('subtotal-items').innerText = totalItems + " item" + (totalItems !== 1 ? "s" : "");
            document.getElementById('subtotal-amount').innerText = "Rs. " + subtotal.toFixed(2);
            const shippingFee = totalItems > 0 ? 100 : 0;
            document.getElementById('shipping-fee').innerText = "Rs. " + shippingFee.toFixed(2);
            const total = subtotal + shippingFee;
            document.getElementById('total-amount').innerText = "Rs. " + total.toFixed(2);
        }

        document.addEventListener("DOMContentLoaded", calculateSummary);
    </script>
</head>
<body>

<div class="cart-container">
    <h2>Your Shopping Cart</h2>

    <div class="cart-columns">
        <div class="cart-left">
            <table>
                <thead>
                <tr>
                    <th><input type="checkbox" id="select-all" onclick="toggleSelectAll(this)" aria-label="Select all items"/></th>
                    <th>Product</th>
                    <th>Price (Each)</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<CartItem> cartItems = (List<CartItem>) request.getAttribute("cartItems");
                    if (cartItems == null || cartItems.isEmpty()) {
                %>
                    <tr><td colspan="6" style="text-align:center;">Your cart is empty.</td></tr>
                <%
                    } else {
                        for (CartItem item : cartItems) {
                            Product product = productDAO.getProductById(item.getProductId());
                            if (product == null) continue;
                            double total = item.getQuantity() * item.getPrice();
                %>
                <tr class="cart-item-row" data-price="<%= item.getPrice() %>">
                    <td>
                        <input type="checkbox" class="item-checkbox" name="selectedItems" value="<%= product.getProductID() %>" checked onclick="checkboxChanged()" aria-label="Select <%= product.getName() %>" />
                    </td>
                    <td class="product-info">
                        <img src="<%= product.getImageUrl() != null ? product.getImageUrl() : "images/default-product.png" %>" alt="<%= product.getName() %>" width="60" />
                        <span><%= product.getName() %></span>
                    </td>
                    <td>Rs. <%= String.format("%.2f", item.getPrice()) %></td>
					                    <td>
					  <div class="quantity-controls">
					    <form action="UpdateQuantityServlet" method="post" style="display: contents;">
					      <input type="hidden" name="productId" value="<%= product.getProductID() %>" />
					      <button type="submit" name="delta" value="-1" aria-label="Decrease quantity of <%= product.getName() %>">-</button>
					    </form>
					
					    <input type="text" id="qty-<%= product.getProductID() %>" class="quantity-input" value="<%= item.getQuantity() %>" readonly aria-label="Quantity of <%= product.getName() %>" />
					
					    <form action="UpdateQuantityServlet" method="post" style="display: contents;">
					      <input type="hidden" name="productId" value="<%= product.getProductID() %>" />
					      <button type="submit" name="delta" value="1" aria-label="Increase quantity of <%= product.getName() %>">+</button>
					    </form>
					  </div>
					</td>
                    <td>Rs. <%= String.format("%.2f", total) %></td>
                    <td>
                        <form action="RemoveFromCartServlet" method="post" onsubmit="return confirm('Are you sure you want to remove this item?');">
                            <input type="hidden" name="productId" value="<%= item.getProductId() %>" />
                            <button type="submit" class="delete-btn" aria-label="Delete <%= product.getName() %> from cart">Delete</button>
                        </form>
                    </td>
                </tr>
                <%      }
                    }
                %>
                </tbody>
            </table>
        </div>

        <div class="cart-right">
            <div class="shipping-address">
                <h3>Shipping Address</h3>
                <%
                    String address = (String) request.getAttribute("shippingAddress");
                    if (address == null) address = "123 Green Street, Kathmandu, Nepal";
                    String formattedAddress = address.replaceAll(",", "<br/>");
                %>
                <p><%= formattedAddress %></p><br>
            </div>

            <div class="order-summary">
                <h3>Order Summary</h3>
                <p>Subtotal (<span id="subtotal-items">0 items</span>): <span id="subtotal-amount">Rs. 0.00</span></p>
                <p>Shipping Fee: <span id="shipping-fee">Rs. 100.00</span></p>
                <hr />
                <p><strong>Total: <span id="total-amount">Rs. 0.00</span></strong></p>
              <button class="checkout-btn" onclick="window.location.href='Checkout'">Proceed to Checkout</button>

            </div>
        </div>
    </div>
</div>

</body>
</html>
 