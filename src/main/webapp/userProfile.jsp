<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<jsp:useBean id="user" class="Model.User" scope="session" />
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
    <style>
       * {
    box-sizing: border-box;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	}
	
	body {
	    background: linear-gradient(135deg, #e0f2e9, #a5d6a7);
	    margin: 0;
	    padding: 0;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 100vh;
	}
	
	.card {
	    background-color: #fff;
	    padding: 20px 30px;      
	    width: 350px;
	    border-radius: 15px;
	    box-shadow: 0 15px 40px rgba(46, 125, 50, 0.2);
	    border-top: 6px solid #4CAF50;
	    transition: box-shadow 0.3s ease;
	}
	
	.card:hover {
	    box-shadow: 0 20px 50px rgba(46, 125, 50, 0.35);
	}
	
	h2 {
	    text-align: center;
	    color: #2e7d32;
	    margin-bottom: 20px;   
	    font-weight: 700;
	    letter-spacing: 1.2px;
	    font-size: 22px;        
	}
	
	label {
	    display: block;
	    margin-bottom: 4px;     
	    font-weight: 700;
	    color: #2b2b2b;
	    letter-spacing: 0.3px;
	    font-size: 14px;
	}
	
	input[type="text"],
	input[type="email"],
	input[type="password"],
	select.gender-select {
	    width: 100%;
	    padding: 10px 12px;     
	    margin-bottom: 12px;    
	    border: 2px solid #c8e6c9;
	    border-radius: 10px;
	    font-size: 14px;
	    color: #2e7d32;
	    background-color: #f9fff9;
	    box-shadow: inset 0 2px 6px rgba(34, 139, 34, 0.05);
	    transition: border-color 0.3s ease, box-shadow 0.3s ease;
	}
	
	input[type="text"]:focus,
	input[type="email"]:focus,
	input[type="password"]:focus,
	select.gender-select:focus {
	    border-color: #4CAF50;
	    box-shadow: 0 0 8px rgba(76, 175, 80, 0.6);
	    outline: none;
	    background-color: #ffffff;
	}
	
	button {
	    width: 100%;
	    padding: 10px;          
	    background: linear-gradient(45deg, #4CAF50, #388e3c);
	    color: #fff;
	    border: none;
	    border-radius: 12px;
	    font-size: 15px;
	    font-weight: 700;
	    letter-spacing: 1px;
	    cursor: pointer;
	    box-shadow: 0 8px 18px rgba(56, 142, 60, 0.4);
	    transition: background 0.3s ease, box-shadow 0.3s ease;
	}
	
	button:hover {
	    background: linear-gradient(45deg, #388e3c, #2e7d32);
	    box-shadow: 0 12px 28px rgba(46, 125, 50, 0.6);
	}
	
	.message {
	    text-align: center;
	    margin-top: 12px;       
	    color: #2e7d32;
	    font-weight: 700;
	    font-size: 14px;
	    letter-spacing: 0.4px;
	}
    </style>
</head>
<body>
<div class="card">
    <h2>User Profile</h2>
    <form method="post" action="<%= request.getContextPath() %>/UserProfileServlet">
        <label>Username</label>
        <input type="text" name="username" value="<%= user.getUsername() %>" readonly />

        <label>Email</label>
        <input type="email" name="email" value="<%= user.getEmail() %>" required />

        <label>Gender</label>
		<select name="gender" class="gender-select">
		    <option value="" <%= (user.getGender() == null || user.getGender().isEmpty()) ? "selected" : "" %>>Select Gender</option>
		    <option value="Male" <%= "Male".equalsIgnoreCase(user.getGender()) ? "selected" : "" %>>Male</option>
		    <option value="Female" <%= "Female".equalsIgnoreCase(user.getGender()) ? "selected" : "" %>>Female</option>
		    <option value="Other" <%= "Other".equalsIgnoreCase(user.getGender()) ? "selected" : "" %>>Other</option>
		</select>


        <label>Address</label>
        <input type="text" name="address" value="<%= user.getAddress() != null ? user.getAddress() : "" %>" placeholder="Enter your address" />

        <label>Current Password</label>
        <input type="password" name="currentPassword" placeholder="Enter current password" />

        <label>New Password</label>
        <input type="password" name="newPassword" placeholder="Enter new password" />

        <label>Confirm Password</label>
        <input type="password" name="confirmPassword" placeholder="Confirm new password" />

        <button type="submit">Update Profile</button>
    </form>

    <% if (message != null) { %>
        <div class="message"><%= message %></div>
    <% } %>
</div>
</body>
</html>
