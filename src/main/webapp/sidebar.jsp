<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <style>
        /* Sidebar Styling */
        .sidebar {
            width: 250px;
            height: 100vh;
            background-color: #2ecc71; /* Green background */
            color: white;
            padding: 20px;
            position: fixed;
            top: 0;
            left: 0;
            transition: left 0.3s;
            overflow-y: auto; /* Ensures sidebar content doesn't overflow vertically */
        }

        .sidebar h2 {
            color: white;
            text-align: center;
            margin-bottom: 20px;
            font-size: 24px;
        }

        .sidebar a {
            display: block;
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 10px 0;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .sidebar a:hover {
            background-color: #27ae60; /* Darker green on hover */
        }

        .sidebar .logout {
            margin-top: auto;
            background-color: #2ecc71; /* Green background */
            color: white;
            border: none;
            padding: 10px;
            border-radius: 5px;
            text-align: center;
        }

        .sidebar .logout:hover {
            background-color: #27ae60; /* Darker green on hover */
        }
    </style>
</head>
<body>

<!-- Sidebar -->
<div class="sidebar">
    <h2>green thrift</h2>
    <a href="#">Home</a>
    <a href="#">Categories</a>
    <a href="#">Add Categories</a>
    <a href="#">View Products</a>
    <a href="#">Users</a>
    <a href="#">Orders</a>
    <button class="logout">Logout</button>
</div>



</body>
</html>
