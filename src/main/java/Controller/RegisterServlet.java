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

//package Controller;
//
//import DAO.UserDAO;
//import Model.User;
//import Util.PasswordUtil;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.util.regex.Pattern;

//@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
//public class RegisterServlet extends HttpServlet {
//
//    private static final int MIN_PASSWORD_LENGTH = 8;
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/register.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//        
//        String role;
//        if ("admin@gt.com".equalsIgnoreCase(email)) {
//            role = "admin";
//        } else {
//            role = "user";
//        }
//
//        // Validation
//        if (username == null || username.trim().isEmpty() ||
//            password == null || password.trim().isEmpty() ||
//            email == null || email.trim().isEmpty()) {
//            setErrorAndRedirect(request, response, "All fields are required.");
//            return;
//        }
//
//        username = username.trim();
//        password = password.trim();
//        email = email.trim();
//
//        if (password.length() < MIN_PASSWORD_LENGTH) {
//            setErrorAndRedirect(request, response,
//                "Password must be at least " + MIN_PASSWORD_LENGTH + " characters.");
//            return;
//        }
//
//        try {
//            UserDAO userDAO = new UserDAO();
//
//            if (userDAO.usernameExists(username)) {
//                setErrorAndRedirect(request, response, "Username already taken.");
//                return;
//            }
//
//            // ✅ Hash the password before saving
//            String hashedPassword = PasswordUtil.hashPassword(password);
//
//            User newUser = new User();
//            newUser.setUsername(username);
//            newUser.setPassword(hashedPassword);
//            newUser.setEmail(email);
//            newUser.setRole(role);
//
//            if (userDAO.createUser(newUser)) {
//                request.setAttribute("success", "Registration successful! Please login.");
//                request.getRequestDispatcher("/login.jsp").forward(request, response);
//            } else {
//                setErrorAndRedirect(request, response, "Registration failed. Please try again.");
//            }
//        } catch (Exception e) {
//            log("Registration error for username: " + username, e);
//            setErrorAndRedirect(request, response, "System error during registration.");
//        }
//    }
//
//    private void setErrorAndRedirect(HttpServletRequest request,
//                                     HttpServletResponse response,
//                                     String errorMessage)
//            throws ServletException, IOException {
//        request.setAttribute("error", errorMessage);
//        request.getRequestDispatcher("/register.jsp").forward(request, response);
//    }
//}
/*
 * package Controller;
 * 
 * import DAO.UserDAO; import Model.User; import Util.PasswordUtil;
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
 * String firstname = request.getParameter("firstname"); String lastname =
 * request.getParameter("lastname"); String username =
 * request.getParameter("username"); String password =
 * request.getParameter("password"); String confirmPassword =
 * request.getParameter("confirm_password"); String email =
 * request.getParameter("email"); String phone = request.getParameter("phone");
 * String address = request.getParameter("address"); String gender =
 * request.getParameter("gender");
 * 
 * // Role assignment String role = "admin@gt.com".equalsIgnoreCase(email) ?
 * "admin" : "user";
 * 
 * // Basic validation if (firstname == null || firstname.trim().isEmpty() ||
 * lastname == null || lastname.trim().isEmpty() || username == null ||
 * username.trim().isEmpty() || password == null || password.trim().isEmpty() ||
 * confirmPassword == null || confirmPassword.trim().isEmpty() || email == null
 * || email.trim().isEmpty() || phone == null || phone.trim().isEmpty() ||
 * address == null || address.trim().isEmpty() || gender == null ||
 * gender.trim().isEmpty()) {
 * 
 * setErrorAndRedirect(request, response, "All fields are required."); return; }
 * 
 * // Trim inputs firstname = firstname.trim(); lastname = lastname.trim();
 * username = username.trim(); password = password.trim(); confirmPassword =
 * confirmPassword.trim(); email = email.trim(); phone = phone.trim(); address =
 * address.trim(); gender = gender.trim();
 * 
 * // Confirm password check if (!password.equals(confirmPassword)) {
 * setErrorAndRedirect(request, response, "Passwords do not match."); return; }
 * 
 * // Phone number format check if (!phone.matches("\\+977\\d{10}")) {
 * setErrorAndRedirect(request, response,
 * "Phone number must be in the format +977XXXXXXXXXX."); return; }
 * 
 * // Password length check if (password.length() < MIN_PASSWORD_LENGTH) {
 * setErrorAndRedirect(request, response, "Password must be at least " +
 * MIN_PASSWORD_LENGTH + " characters."); return; }
 * 
 * try { UserDAO userDAO = new UserDAO();
 * 
 * if (userDAO.usernameExists(username)) { setErrorAndRedirect(request,
 * response, "Username already taken."); return; }
 * 
 * String hashedPassword = PasswordUtil.hashPassword(password);
 * 
 * User newUser = new User(); newUser.setFirstname(firstname);
 * newUser.setLastname(lastname); newUser.setUsername(username);
 * newUser.setPassword(hashedPassword); newUser.setEmail(email);
 * newUser.setPhone(phone); newUser.setRole(role); newUser.setAddress(address);
 * newUser.setGender(gender);
 * 
 * if (userDAO.createUser(newUser)) { request.setAttribute("success",
 * "Registration successful! Please login.");
 * request.getRequestDispatcher("/login.jsp").forward(request, response); } else
 * { setErrorAndRedirect(request, response,
 * "Registration failed. Please try again."); }
 * 
 * } catch (Exception e) { log("Registration error for username: " + username,
 * e); setErrorAndRedirect(request, response,
 * "System error during registration."); } }
 * 
 * private void setErrorAndRedirect(HttpServletRequest request,
 * HttpServletResponse response, String errorMessage) throws ServletException,
 * IOException { request.setAttribute("error", errorMessage);
 * request.getRequestDispatcher("/register.jsp").forward(request, response); } }
 */










package Controller;

import DAO.UserDAO;
import Model.User;
import Util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        // Retrieve form data
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");

        // Role assignment logic
        String role = "admin@gt.com".equalsIgnoreCase(email) ? "admin" : "user";

        // Field validation
        if (firstname == null || lastname == null || username == null || password == null ||
            confirmPassword == null || email == null || phone == null || address == null || gender == null ||
            firstname.trim().isEmpty() || lastname.trim().isEmpty() || username.trim().isEmpty() ||
            password.trim().isEmpty() || confirmPassword.trim().isEmpty() || email.trim().isEmpty() ||
            phone.trim().isEmpty() || address.trim().isEmpty() || gender.trim().isEmpty()) {

            setError(request, response, "All fields are required.");
            return;
        }

        // Trim whitespace
        firstname = firstname.trim();
        lastname = lastname.trim();
        username = username.trim();
        password = password.trim();
        confirmPassword = confirmPassword.trim();
        email = email.trim();
        phone = phone.trim();
        address = address.trim();
        gender = gender.trim();

        // Password check
        if (!password.equals(confirmPassword)) {
            setError(request, response, "Passwords do not match.");
            return;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            setError(request, response, "Password must be at least " + MIN_PASSWORD_LENGTH + " characters long.");
            return;
        }

        // Phone number format validation
        if (!phone.matches("\\+977\\d{10}")) {
            setError(request, response, "Phone number must be in the format +977XXXXXXXXXX.");
            return;
        }

        try {
            UserDAO userDAO = new UserDAO();

            if (userDAO.usernameExists(username)) {
                setError(request, response, "Username already taken.");
                return;
            }

            String hashedPassword = PasswordUtil.hashPassword(password);

            User newUser = new User();
            newUser.setFirstname(firstname);
            newUser.setLastname(lastname);
            newUser.setUsername(username);
            newUser.setPassword(hashedPassword);
            newUser.setEmail(email);
            newUser.setPhone(phone);
            newUser.setRole(role);
            newUser.setAddress(address);
            newUser.setGender(gender);

            if (userDAO.createUser(newUser)) {
                request.setAttribute("success", "Registration successful! Please login.");
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            } else {
                setError(request, response, "Registration failed. Please try again.");
            }

        } catch (Exception e) {
            log("Error during registration", e);
            setError(request, response, "System error. Please try again later.");
        }
    }

    private void setError(HttpServletRequest request, HttpServletResponse response, String errorMessage)
            throws ServletException, IOException {
        request.setAttribute("error", errorMessage);
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
