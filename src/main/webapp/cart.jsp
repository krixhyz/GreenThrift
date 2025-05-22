<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.CartItem" %>

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

        function changeQuantity(productId, delta) {
            const qtyInput = document.getElementById('qty-' + productId);
            let qty = parseInt(qtyInput.value);
            qty = Math.max(1, qty + delta);
            qtyInput.value = qty;
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

        window.onload = calculateSummary;
    </script>
</head>
<body>
<div class="cart-container">
    <h2>Your Shopping Cart</h2>
    <div class="cart-columns">
        <!-- Left Column: Cart Items -->
        <div class="cart-left">
            <table>
                <thead>
                <tr>
                    <th><input type="checkbox" id="select-all" onclick="toggleSelectAll(this)" checked /></th>
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
                            double total = item.getTotalPrice();
                %>
                <tr class="cart-item-row" data-price="<%= item.getProductPrice() %>">
                    <td><input type="checkbox" class="item-checkbox" checked onclick="checkboxChanged()" /></td>
                    <td class="product-info">
                        <img src="images/default-product.png" alt="<%= item.getProductName() %>" />
                        <span><%= item.getProductName() %></span>
                    </td>
                    <td>Rs. <%= String.format("%.2f", item.getProductPrice()) %></td>
                    <td>
                        <button type="button" onclick="changeQuantity(<%= item.getProductId() %>, -1)">-</button>
                        <input type="text" id="qty-<%= item.getProductId() %>" class="quantity-input" value="<%= item.getQuantity() %>" readonly />
                        <button type="button" onclick="changeQuantity(<%= item.getProductId() %>, 1)">+</button>
                    </td>
                    <td>Rs. <%= String.format("%.2f", total) %></td>
                    <td>
                        <form action="cart" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="remove">
                            <input type="hidden" name="productId" value="<%= item.getProductId() %>">
                            <button type="submit" class="delete-btn">Delete</button>
                        </form>
                    </td>
                </tr>
                <%      }
                    }
                %>
                </tbody>
            </table>
        </div>

        <!-- Right Column: Summary -->
        <div class="cart-right">
            <div class="shipping-address">
                <h3>Shipping Address</h3>
                <p>123 Green Street,<br /> Kathmandu, Nepal</p><br>
            </div>

            <div class="order-summary">
                <h3>Order Summary</h3>
                <p>Subtotal (<span id="subtotal-items">0 items</span>): <span id="subtotal-amount">Rs. 0.00</span></p>
                <p>Shipping Fee: <span id="shipping-fee">Rs. 100.00</span></p>
                <hr />
                <p><strong>Total: <span id="total-amount">Rs. 0.00</span></strong></p>
                <button class="checkout-btn" onclick="alert('Proceeding to checkout...')">Proceed to Checkout</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>