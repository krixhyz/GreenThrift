<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
    <style>
    .sidebar {
        width: 250px;
        height: 100vh;
        background-color: #4fd15c;
        color: white;
        padding: 20px;
        position: fixed;
        top: 0;
        left: 0;
        transition: left 0.3s;
        overflow-y: auto;
        box-shadow: 2px 0 10px rgba(0, 0, 0, 0.05);
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
        font-weight: 500;
    }

    .sidebar a:hover {
        background-color: #3bb64b;
    }

    .sidebar .logout {
        margin-top: auto;
        background-color: #4fd15c;
        color: white;
        border: none;
        padding: 10px;
        border-radius: 5px;
        text-align: center;
        cursor: pointer;
        font-weight: 600;
    }

    .sidebar .logout:hover {
        background-color: #3bb64b;
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
