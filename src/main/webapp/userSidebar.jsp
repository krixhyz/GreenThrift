<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="sidebar">
    <h2>Green Thrift</h2>

    <a href="userDashboard.jsp" class="${param.page == 'dashboard' ? 'active' : ''}">
        <i class="fas fa-home"></i> Dashboard
    </a>

    <a href="userOrders.jsp" class="${param.page == 'orders' ? 'active' : ''}">
        <i class="fas fa-shopping-cart"></i> Orders
    </a>

    <a href="homepage.jsp">
        <i class="fas fa-arrow-left"></i> Home
    </a>

    <a href="${pageContext.request.contextPath}/logout">
        <i class="fas fa-sign-out-alt"></i> Logout
    </a>
</div>
