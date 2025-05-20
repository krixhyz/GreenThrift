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
