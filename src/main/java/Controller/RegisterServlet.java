/*
 * package Controller;
 * 
 * import DAO.UserDAO; import Model.User; import javax.servlet.*; import
 * javax.servlet.http.*; import javax.servlet.annotation.*; import
 * java.io.IOException;
 * 
 * @WebServlet(name = "RegisterServlet", urlPatterns = {"/register"}) public
 * class RegisterServlet extends HttpServlet {
 * 
 * private static final int MIN_PASSWORD_LENGTH = 8;
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * request.getRequestDispatcher("/register.jsp").forward(request, response); }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { String
 * username = request.getParameter("username"); String password =
 * request.getParameter("password"); String email =
 * request.getParameter("email"); String role = request.getParameter("role");
 * 
 * if (username == null || username.trim().isEmpty() || password == null ||
 * password.trim().isEmpty() || email == null || email.trim().isEmpty()) {
 * setErrorAndRedirect(request, response, "All fields are required"); return; }
 * 
 * username = username.trim(); password = password.trim(); email = email.trim();
 * role = (role == null || role.trim().isEmpty()) ? "user" : role.trim();
 * 
 * if (password.length() < MIN_PASSWORD_LENGTH) { setErrorAndRedirect(request,
 * response, "Password must be at least " + MIN_PASSWORD_LENGTH +
 * " characters"); return; }
 * 
 * try { UserDAO userDAO = new UserDAO();
 * 
 * if (userDAO.usernameExists(username)) { setErrorAndRedirect(request,
 * response, "Username already taken"); return; }
 * 
 * User newUser = new User(); newUser.setUsername(username);
 * newUser.setPassword(password); newUser.setEmail(email);
 * newUser.setRole(role);
 * 
 * if (userDAO.createUser(newUser)) {
 * 
 * request.setAttribute("success", "Registration successful! Please login.");
 * request.getRequestDispatcher("/login.jsp").forward(request, response); } else
 * { setErrorAndRedirect(request, response,
 * "Registration failed. Please try again."); } } catch (Exception e) {
 * log("Registration error for username: " + username, e);
 * setErrorAndRedirect(request, response, "System error during registration"); }
 * }
 * 
 * private void setErrorAndRedirect(HttpServletRequest request,
 * HttpServletResponse response, String errorMessage) throws ServletException,
 * IOException { request.setAttribute("error", errorMessage);
 * request.getRequestDispatcher("/register.jsp").forward(request, response); } }
 * 
 * 
 * 
 * package Controller;
 * 
 * import DAO.UserDAO; import Model.User; import Util.PasswordUtil;
 * 
 * 
 * import javax.servlet.*; import javax.servlet.http.*; import
 * javax.servlet.annotation.*; import java.io.IOException;
 * 
 * @WebServlet(name = "RegisterServlet", urlPatterns = {"/register"}) public
 * class RegisterServlet extends HttpServlet {
 * 
 * private static final int MIN_PASSWORD_LENGTH = 8;
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * request.getRequestDispatcher("/register.jsp").forward(request, response); }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * String username = request.getParameter("username"); String password =
 * request.getParameter("password"); String email =
 * request.getParameter("email"); String role = "user"; // ✅ Secure default role
 * assignment
 * 
 * // Validation if (username == null || username.trim().isEmpty() || password
 * == null || password.trim().isEmpty() || email == null ||
 * email.trim().isEmpty()) { setErrorAndRedirect(request, response,
 * "All fields are required."); return; }
 * 
 * username = username.trim(); password = password.trim(); email = email.trim();
 * 
 * if (password.length() < MIN_PASSWORD_LENGTH) { setErrorAndRedirect(request,
 * response, "Password must be at least " + MIN_PASSWORD_LENGTH +
 * " characters."); return; }
 * 
 * try { UserDAO userDAO = new UserDAO();
 * 
 * if (userDAO.usernameExists(username)) { setErrorAndRedirect(request,
 * response, "Username already taken."); return; }
 * 
 * User newUser = new User(); newUser.setUsername(username);
 * newUser.setPassword(password); // You should hash this in real apps
 * newUser.setEmail(email); newUser.setRole(role);
 * 
 * if (userDAO.createUser(newUser)) { request.setAttribute("success",
 * "Registration successful! Please login.");
 * request.getRequestDispatcher("/login.jsp").forward(request, response); } else
 * { setErrorAndRedirect(request, response,
 * "Registration failed. Please try again."); } } catch (Exception e) {
 * log("Registration error for username: " + username, e);
 * setErrorAndRedirect(request, response, "System error during registration.");
 * } }
 * 
 * private void setErrorAndRedirect(HttpServletRequest request,
 * HttpServletResponse response, String errorMessage) throws ServletException,
 * IOException { request.setAttribute("error", errorMessage);
 * request.getRequestDispatcher("/register.jsp").forward(request, response); } }
 * 
 */

package Controller;

import DAO.UserDAO;
import Model.User;
import Util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final int MIN_PASSWORD_LENGTH = 8;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        
        String role;
        if ("admin@gt.com".equalsIgnoreCase(email)) {
            role = "admin";
        } else {
            role = "user";
        }

        // Validation
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            setErrorAndRedirect(request, response, "All fields are required.");
            return;
        }

        username = username.trim();
        password = password.trim();
        email = email.trim();

        if (password.length() < MIN_PASSWORD_LENGTH) {
            setErrorAndRedirect(request, response,
                "Password must be at least " + MIN_PASSWORD_LENGTH + " characters.");
            return;
        }

        try {
            UserDAO userDAO = new UserDAO();

            if (userDAO.usernameExists(username)) {
                setErrorAndRedirect(request, response, "Username already taken.");
                return;
            }

            // ✅ Hash the password before saving
            String hashedPassword = PasswordUtil.hashPassword(password);

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(hashedPassword);
            newUser.setEmail(email);
            newUser.setRole(role);

            if (userDAO.createUser(newUser)) {
                request.setAttribute("success", "Registration successful! Please login.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                setErrorAndRedirect(request, response, "Registration failed. Please try again.");
            }
        } catch (Exception e) {
            log("Registration error for username: " + username, e);
            setErrorAndRedirect(request, response, "System error during registration.");
        }
    }

    private void setErrorAndRedirect(HttpServletRequest request,
                                     HttpServletResponse response,
                                     String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("error", errorMessage);
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
