<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.math.BigDecimal" %>
<%
    String fullName = (String) session.getAttribute("shippingFullName");
    String address = (String) session.getAttribute("shippingAddress");
    BigDecimal totalAmount = (BigDecimal) session.getAttribute("totalAmount");
    if (totalAmount == null) totalAmount = BigDecimal.ZERO;
%>
<html>
<head>
    <title>make Payment</title>
    <style>
        .container {
            width: 400px;
            margin: 30px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-family: Arial, sans-serif;
        }
        .payment-gateways {
            margin-bottom: 20px;
        }
        .payment-gateways label {
            margin-right: 20px;
            cursor: pointer;
            display: inline-block;
            text-align: center;
        }
        .payment-gateways img {
            height: 50px;
            display: block;
            margin: 0 auto 5px;
        }
        input[type="text"], textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
        }
        #successPopup {
            display: none;
            background-color: #d4edda;
            color: #155724;
            padding: 15px;
            margin-top: 15px;
            border-radius: 5px;
            font-weight: bold;
            text-align: center;
        }
        .payment-icons label {
		    display: inline-block;
		    margin-right: 20px;
		    cursor: pointer;
		    vertical-align: middle;
		}
		.payment-icons img {
		    height: 50px;
		    margin-left: 8px;
		    vertical-align: middle;
		}
        
    </style>
</head>
<body>
<div class="container">
    <h2>Online Payment</h2>

    <div class="payment-gateways">
        <label><input type="radio" name="gateway" value="eSewa" required> <img src="Images/esewa.png" alt="eSewa"></label>
        <label><input type="radio" name="gateway" value="IME Pay" required> <img src="Images/IME Pay.png" alt="IME Pay"></label>
        <label><input type="radio" name="gateway" value="Khalti" required> <img src="Images/khalti.png" alt="Khalti"></label>
    </div>

     <form id="paymentForm" action="ProcessPayment" method="post">
     <input type="hidden" name="gateway" id="selectedGateway">
        <label>Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter phone number">

        <label>Remarks:</label>
        <textarea id="remarks" name="remarks" rows="3" placeholder="Any remarks"></textarea>

        <label>Total Amount:</label>
        <input type="text" value="Rs. <%= String.format("%.2f", totalAmount.doubleValue()) %>" readonly>

        <button type="submit">Pay Now</button>
    </form>
</div>


<script>
document.getElementById('paymentForm').addEventListener('submit', function() {
    // Capture the selected payment gateway
    var selected = document.querySelector('input[name="gateway"]:checked');
    document.getElementById('selectedGateway').value = selected ? selected.value : 'Unknown';
});
</script>

<!-- <script>
    function payNow(event) {
        event.preventDefault();

        // Optionally, validate here if needed

        // Simulate payment success
        document.getElementById("paymentForm").reset();
        document.getElementById("successPopup").style.display = "block";

        // Clear cart (example using localStorage)
        localStorage.removeItem("cart");

        // Disable the button to prevent multiple clicks
        event.target.querySelector("button").disabled = true;

        return false;
    }
</script> -->
</body>
</html>
