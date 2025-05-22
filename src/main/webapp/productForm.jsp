<%-- <%@ page import="DAO.ProductDAO, Model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String action = "add";
    Product p = new Product(); // default empty

    String idStr = request.getParameter("id");
    if (idStr != null) {
        int id = Integer.parseInt(idStr);
        ProductDAO dao = new ProductDAO();
        p = dao.getProductById(id);
        action = "edit";
    }
%>
<html>
<head>
    <title><%= action.equals("edit") ? "Edit" : "Add" %> Product</title>
    <link rel="stylesheet" href="styles/mainCss.css">
</head>
<body>

<%@ include file="header.jsp" %>

<main class="dashboard-container">
    <div style="max-width: 600px; margin: 0 auto; padding: 25px; background-color: #fff; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1);">
        <h2 style="text-align: center; color: #333;"><%= action.equals("edit") ? "Edit" : "Add" %> Product</h2>

        <form action="adminProduct" method="post" style="display: flex; flex-direction: column;">
            <input type="hidden" name="action" value="<%= action %>" />
            <% if (action.equals("edit")) { %>
                <input type="hidden" name="id" value="<%= p.getProductID() %>" />
            <% } %>

            <label style="margin-top: 10px;">Name:</label>
            <input type="text" name="name" value="<%= p.getName() != null ? p.getName() : "" %>" required style="padding: 8px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="margin-top: 10px;">Description:</label>
            <input type="text" name="description" value="<%= p.getDescription() != null ? p.getDescription() : "" %>" required style="padding: 8px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="margin-top: 10px;">Price:</label>
            <input type="number" step="0.01" name="price" value="<%= p.getPrice() %>" required style="padding: 8px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="margin-top: 10px;">Stock:</label>
            <input type="number" name="stock" value="<%= p.getStock() %>" required style="padding: 8px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="margin-top: 10px;">Category ID:</label>
            <input type="number" name="categoryId" value="<%= p.getCategoryID() %>" required style="padding: 8px; border: 1px solid #ccc; border-radius: 5px;">

            <label style="margin-top: 10px;">Admin ID:</label>
            <input type="number" name="adminId" value="<%= p.getAdminID() %>" required style="padding: 8px; border: 1px solid #ccc; border-radius: 5px;">

            <button type="submit" style="margin-top: 20px; padding: 10px; background-color: #007bff; border: none; color: white; font-size: 16px; border-radius: 5px; cursor: pointer;">
                <%= action.equals("edit") ? "Update" : "Add" %> Product
            </button>
        </form>
    </div>
</main>

<%@ include file="footer.jsp" %>

</body>
</html>
 --%>
 
 
 
 
 <%@ page import="DAO.ProductDAO, Model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String action = "add";
    Product p = new Product(); // default empty

    String idStr = request.getParameter("id");
    if (idStr != null) {
        int id = Integer.parseInt(idStr);
        ProductDAO dao = new ProductDAO();
        p = dao.getProductById(id);
        action = "edit";
    }
%>
<html>
<head>
    <title><%= action.equals("edit") ? "Edit" : "Add" %> Product</title>
    <link rel="stylesheet" href="styles/mainCss.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        .form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 25px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        label {
            margin-top: 10px;
            font-weight: 600;
            color: #333;
        }
        input[type="text"], input[type="number"], input[type="file"], textarea {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            box-sizing: border-box;
            margin-top: 5px;
        }
        button[type="submit"] {
            margin-top: 20px;
            padding: 10px;
            background-color: #007bff;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        .current-image img {
            max-width: 100px;
            margin-top: 10px;
            border-radius: 5px;
        }
        .error {
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<main class="dashboard-container">
    <div class="form-container">
        <h2 style="text-align: center; color: #333;"><%= action.equals("edit") ? "Edit" : "Add" %> Product</h2>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
			<form action="${pageContext.request.contextPath}/adminProduct" method="post" enctype="multipart/form-data">
    <input type="hidden" name="action" value="<%= action %>"/>
    <% if (action.equals("edit")) { %>
        <input type="hidden" name="id" value="<%= p.getProductID() %>"/>
    <% } %>
    <label>Name:</label>
    <input type="text" name="name" value="<%= p.getName() != null ? p.getName() : "" %>" required>
    <label>Description:</label>
    <textarea name="description" required><%= p.getDescription() != null ? p.getDescription() : "" %></textarea>
    <label>Price:</label>
    <input type="number" step="0.01" name="price" value="<%= p.getPrice() > 0 ? p.getPrice() : "" %>" required>
    <label>Stock:</label>
    <input type="number" name="stock" value="<%= p.getStock() > 0 ? p.getStock() : "" %>" required>
    <label>Category ID:</label>
    <input type="number" name="categoryId" value="<%= p.getCategoryID() > 0 ? p.getCategoryID() : "" %>" required>
    <label>Admin ID:</label>
    <input type="number" name="adminId" value="<%= p.getAdminID() > 0 ? p.getAdminID() : "" %>" required>
    <label>Product Image:</label>
    <input type="file" name="image" accept="image/jpeg,image/png,image/gif">
    <% if (action.equals("edit") && p.getImageUrl() != null) { %>
        <div class="current-image">
            <p>Current Image:</p>
            <img src="<%= p.getImageUrl() %>" alt="Current Image">
        </div>
    <% } %>
    <button type="submit"><%= action.equals("edit") ? "Update" : "Add" %> Product</button>
</form>
    </div>
</main>
<%@ include file="footer.jsp" %>
</body>
</html>