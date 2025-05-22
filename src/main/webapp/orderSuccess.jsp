<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Order" %>
<%
    Order order = (Order) session.getAttribute("currentOrder");
%>

<html>
<head>
    <title>Order Confirmation</title>
    <style>
        :root {
            --primary-color: #4CAF50;
            --secondary-color: #45a049;
            --light-color: #f8f9fa;
            --dark-color: #343a40;
        }
        
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        
        .confirmation-container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 90%;
            max-width: 600px;
            text-align: center;
            animation: fadeIn 0.5s ease-in-out;
        }
        
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        
        .success-icon {
            font-size: 60px;
            color: var(--primary-color);
            margin-bottom: 20px;
        }
        
        h1 {
            color: var(--dark-color);
            margin-bottom: 15px;
        }
        
        .confirmation-message {
            color: #555;
            font-size: 18px;
            margin-bottom: 30px;
            line-height: 1.6;
        }
        
        .order-details {
            background-color: var(--light-color);
            border-radius: 8px;
            padding: 20px;
            margin-bottom: 30px;
            text-align: left;
        }
        
        .detail-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
            padding-bottom: 10px;
            border-bottom: 1px solid #eee;
        }
        
        .detail-label {
            font-weight: 600;
            color: var(--dark-color);
        }
        
        .detail-value {
            color: #555;
        }
        
        .btn-continue {
            display: inline-block;
            background-color: var(--primary-color);
            color: white;
            text-decoration: none;
            padding: 12px 30px;
            border-radius: 50px;
            font-weight: 600;
            transition: all 0.3s ease;
            border: none;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
        }
        
        .btn-continue:hover {
            background-color: var(--secondary-color);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="confirmation-container">
        <div class="success-icon">✓</div>
        <h1>Order Placed Successfully!</h1>
        
        <p class="confirmation-message">
            Thank you for your purchase! Your order has been confirmed and will be processed shortly.
        </p>
        
        <a href="productsPageUser.jsp" class="btn-continue">Continue Shopping</a>
    </div>
</body>
</html>