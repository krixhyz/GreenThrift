<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html> --%>

<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Category</title>
</head>
<body>

<h2>Add New Category</h2>

<form action="${pageContext.request.contextPath}/admin/addCategory" method="post">
    <label for="name">Category Name:</label><br>
    <input type="text" id="name" name="name" required><br><br>

    <label for="description">Description:</label><br>
    <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

    <input type="submit" value="Add Category">
</form>

</body>
</html>
 --%>
 

 <%--  
  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Category</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addCategory.css">
</head>
<body>

<% String message = (String) request.getAttribute("message"); %>
<% if (message != null) { %>
    <div style="color: green; font-weight: bold;"><%= message %></div><br>
<% } %>


<div class="container">
    <form action="${pageContext.request.contextPath}/admin/categories" method="post">
        <h2>Add New Category</h2>

        <label for="name">Category Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Add Category">
    </form>
</div>

</body>
</html>
   --%>
   
   
   
 <%--   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Category</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addCategory.css">
</head>
<body>

<div class="container">
    <form action="${pageContext.request.contextPath}/admin/categories" method="post">
        <h2>Add New Category</h2>

        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <div class="message"><%= message %></div>
        <% } %>

        <label for="name">Category Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Add Category">
    </form>
</div>

</body>
</html>
    --%>
    
<%--     
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Category</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addCategory.css">
</head>
<body>

<div class="container">

    <form action="${pageContext.request.contextPath}/admin/categories" method="post">
        <h2>Add New Category</h2>

        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <div class="message-container">
                <div class="message"><%= message %></div>
            </div>
        <% } %>

        <label for="name">Category Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Add Category">
    </form>
</div>

</body>
</html>
     --%>
     
     
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Category</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/addCategory.css">
</head>
<body>

<div class="container">
    <form action="${pageContext.request.contextPath}/admin/categories" method="post">
        <h2 class="h2">Add New Category</h2>

        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <div class="message-box">
                <%= message %>
            </div>
        <% } %>

        <label for="name">Category Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="description">Description:</label><br>
        <textarea id="description" name="description" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Add Category">
    </form>
</div>

</body>
</html>
     