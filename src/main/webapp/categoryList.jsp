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

  
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="DAO.CategoryDAO" %>
<%@ page import="Model.Category" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Category> categories = CategoryDAO.getAllCategories();
    request.setAttribute("categories", categories);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Category List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/category.css">
</head>
<body>
    <h2 class="center-title">Category List</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="category" items="${categories}">
                <tr>
                    <td>${category.categoryId}</td>
                    <td>${category.name}</td>
                    <td>${category.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
  