<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="login-container">
        <h1>Register</h1>
        <form action="register" method="post">
            <% if (request.getAttribute("error") != null) { %>
                <div class="error-message"><%= request.getAttribute("error") %></div>
            <% } %>
            
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <div class="form-group">
                <label for="role">Role:</label>
                <select id="role" name="role">
                    <option value="user">User</option>
                    <option value="admin">Admin</option>
                </select>
            </div>
            
            <button type="submit">Register</button>
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </form>
    </div>
</body>
</html> --%>

<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="login-container">
        <h1>Register</h1>
        <form action="register" method="post">
            <% if (request.getAttribute("error") != null) { %>
                <div class="error-message"><%= request.getAttribute("error") %></div>
            <% } %>

            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <button type="submit">Register</button>
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
        </form>
    </div>
</body>
</html>
 --%>
 
 
 
 
 
 
 
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
<div class="login-container">
    <h1>Register</h1>

    Show error if exists
    <% if (request.getAttribute("error") != null) { %>
        <div class="error-message" style="color: red; font-weight: bold; margin-bottom: 10px;">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <form action="register" method="post">
        <div class="form-group">
            <label for="firstname">First Name:</label>
            <input type="text" id="firstname" name="firstname" required>
        </div>

        <div class="form-group">
            <label for="lastname">Last Name:</label>
            <input type="text" id="lastname" name="lastname" required>
        </div>

        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" value="+977" required pattern="\\+977\\d{10}" title="Phone number must be in the format +977XXXXXXXXXX">
        </div>

        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
        </div>

        <div class="form-group">
            <label for="gender">Gender:</label>
            <select id="gender" name="gender" required>
                <option value="">-- Select Gender --</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
                <option value="other">Other</option>
            </select>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>

        <div class="form-group">
            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
        </div>

        <button type="submit">Register</button>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </form>
</div>
</body>
</html>
 --%>
 
 
 
 
 
 
 
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="styles/register.css">
</head>
<body>
<div class="register-container">
    <h1>Register</h1>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error-message"><%= request.getAttribute("error") %></div>
    <% } %>

    <% if (request.getAttribute("success") != null) { %>
        <div class="success-message"><%= request.getAttribute("success") %></div>
    <% } %>

    <form action="register" method="post">

        <div class="form-row">
            <div class="form-group">
                <label for="firstname">First Name:</label>
                <input type="text" id="firstname" name="firstname" required>
            </div>

            <div class="form-group">
                <label for="lastname">Last Name:</label>
                <input type="text" id="lastname" name="lastname" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>

            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="+977" required pattern="\+977\d{10}" title="Phone number must be in the format +977XXXXXXXXXX">
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender" required>
                    <option value="">-- Select Gender --</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
        </div>

        <div class="form-group">
            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
        </div>

        <button type="submit">Register</button>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
    </form>
</div>
</body>
</html>


 