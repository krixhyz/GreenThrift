<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/contactData.css" />

<h2 class="center-title">Contact Inquiries</h2>

<table>
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
        <c:choose>
            <c:when test="${not empty contacts}">
                <c:forEach var="contact" items="${contacts}">
                    <tr>
                        <td>${contact.id}</td>
                        <td>${contact.name}</td>
                        <td>${contact.email}</td>
                        <td class="message-cell">${contact.message}</td>
                        <td>${contact.createdAt}</td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5" class="no-data">No contact inquiries found</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </tbody>
</table>