<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, javax.sql.*, java.util.*" %>
<%@ page session="true" %>

<%
    Model.User user = (Model.User) session.getAttribute("user");
    if (user == null || !"admin".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
%>

<jsp:include page="header.jsp" />

<link rel="stylesheet" href="styles/mainCss.css" />

<div class="dashboard-container">
    <h1>Contact Inquiries</h1>
    <table class="contact-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Submitted At</th>
            </tr>
        </thead>
        <tbody>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/coursework", "root", "");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM contacts ORDER BY created_at DESC");

                while (rs.next()) {
        %>
            <tr>
                <td><%= rs.getInt("id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("email") %></td>
                <td><%= rs.getString("message") %></td>
                <td><%= rs.getTimestamp("created_at") %></td>
            </tr>
        <%
                }
            } catch (Exception e) {
        %>
            <tr>
                <td colspan="5" style="color: red; text-align: center;">Error: <%= e.getMessage() %></td>
            </tr>
        <%
            } finally {
                if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
                if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
                if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
            }
        %>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp" />
