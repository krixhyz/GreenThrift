<%@ page import="Model.Product" %>

<%@ page import="java.math.BigDecimal" %>
<%
    Product product = (Product) request.getAttribute("product");
    String success = (String) request.getAttribute("success");
    String error = (String) request.getAttribute("error");
    
    // Calculate total including shipping
    BigDecimal total = BigDecimal.ZERO;
    if (product != null) {
        total = BigDecimal.valueOf(product.getPrice()).add(BigDecimal.valueOf(100)); // 100 shipping
    }
%>

<html>
<head>
    <title>Checkout</title>
    <style>
        /* Use the same CSS from your original checkout page here */
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #e6f2e6;
            margin: 0;
            padding: 0;
            color: black;
        }
        .container {
            display: flex;
            justify-content: space-between;
            max-width: 900px;
            margin: 40px auto;
            padding: 20px;
            gap: 20px;
        }
        .form-box, .summary-box {
            background: white;
            border-radius: 12px;
            box-shadow: 0 6px 15px rgba(46, 139, 87, 0.2);
            width: 48%;
            padding: 25px 30px;
            box-sizing: border-box;
            transition: transform 0.3s ease;
        }
        .form-box:hover, .summary-box:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 25px rgba(46, 139, 87, 0.35);
        }
        h2, h3 { color: black; margin-bottom: 20px; }
        label {
            font-weight: 600;
            display: block;
            margin-bottom: 6px;
        }
        input[type="text"], input[type="tel"], textarea, select {
            width: 100%;
            padding: 12px 15px;
            margin-bottom: 18px;
            border: 1.8px solid #a6d1a6;
            border-radius: 8px;
            font-size: 16px;
            transition: border-color 0.25s ease;
            outline: none;
        }
        input[type="text"]:focus,
        input[type="tel"]:focus,
        textarea:focus,
        select:focus {
            border-color: #4caf50;
            box-shadow: 0 0 6px #a6d1a6;
        }
        button[type="submit"] {
            background: #a7d7a7;
            border: none;
            padding: 14px 0;
            width: 100%;
            font-size: 18px;
            font-weight: 700;
            color: #2f4f2f;
            border-radius: 10px;
            cursor: pointer;
            transition: background 0.4s ease, transform 0.3s ease;
            box-shadow: 0 6px 12px rgba(72, 164, 72, 0.4);
        }
        button[type="submit"]:hover {
            background: #4caf50;
            color: white;
            transform: scale(1.05);
            box-shadow: 0 9px 18px rgba(72, 164, 72, 0.6);
        }
        .summary-box p {
            font-size: 17px;
            margin: 12px 0;
        }
        .summary-box hr {
            border: 0;
            border-top: 2px solid #a6d1a6;
            margin: 15px 0;
        }
    </style>
</head>
<body>
<% if (product != null) { %>

<% if (success != null) { %>
    <div style="text-align:center; background-color: #d4edda; color: #155724; padding: 15px; margin: 20px auto; max-width: 900px; border-radius: 5px;">
        ✅ <%= success %>
    </div>
<% } %>

<% if (error != null) { %>
    <div style="text-align:center; background-color: #f8d7da; color: #721c24; padding: 15px; margin: 20px auto; max-width: 900px; border-radius: 5px;">
        ❌ <%= error %>
    </div>
<% } %>
<div class="container">
    <div class="form-box">
        <h2>Shipping Details</h2>
        <form action="Checkout" method="post">
            <input type="hidden" name="productId" value="${product.productID}">
            <input type="hidden" name="quantity" value="1">

            <label>Full Name:</label>
            <input type="text" name="fullName" required>

            <label>Address:</label>
            <input type="text" name="address" required>

            <label>Phone:</label>
            <input type="tel" name="phone" pattern="[0-9]{10}" placeholder="10-digit number" required>

            <label>Payment Method:</label>
			<div>
			    <label><input type="radio" name="paymentMethod" value="Cash on Delivery" required> Cash on Delivery</label><br>
			    <label><input type="radio" name="paymentMethod" value="Online Payment" required> Online Payment</label>
			</div>


            <button type="submit">Place Order</button>
        </form>
    </div>


<div class="summary-box">
    <h3>Order Summary</h3>
    <p><strong>Product:</strong> <%= product.getName() %></p>
    <p><strong>Price:</strong> Rs. <%= product.getPrice() %></p>
    <p><strong>Shipping:</strong> Rs. 100.00</p>
    <hr>
    <p style="font-weight: bold;">Total: Rs. <%= total.setScale(2) %></p>
</div>


<% } else { %>
    <div style="text-align:center; margin-top:50px;">
        <p>Product details not available.</p>
    </div>
<% } %>




</body>
</html>