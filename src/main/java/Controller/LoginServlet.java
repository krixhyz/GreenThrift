///*
// * package Controller;
// * 
// * import DAO.UserDAO; import Model.User; import javax.servlet.*; import
// * javax.servlet.http.*; import javax.servlet.annotation.*; import
// * java.io.IOException;
// * 
// * @WebServlet(name = "LoginServlet", urlPatterns = {"/login"}) public class
// * LoginServlet extends HttpServlet {
// * 
// * @Override protected void doGet(HttpServletRequest request,
// * HttpServletResponse response) throws ServletException, IOException {
// * HttpSession session = request.getSession(false); if (session != null &&
// * session.getAttribute("user") != null) { User user = (User)
// * session.getAttribute("user"); redirectBasedOnRole(user, response); return; }
// * request.getRequestDispatcher("/login.jsp").forward(request, response); }
// * 
// * @Override protected void doPost(HttpServletRequest request,
// * HttpServletResponse response) throws ServletException, IOException { String
// * username = request.getParameter("username"); String password =
// * request.getParameter("password");
// * 
// * UserDAO userDAO = new UserDAO(); User user =
// * userDAO.getUserByCredentials(username, password);
// * 
// * if (user != null) { HttpSession session = request.getSession();
// * session.setAttribute("user", user);
// * 
// * redirectBasedOnRole(user, response); } else { request.setAttribute("error",
// * "Invalid username or password");
// * request.getRequestDispatcher("/login.jsp").forward(request, response); } }
// * 
// * private void redirectBasedOnRole(User user, HttpServletResponse response)
// * throws IOException { if ("admin".equalsIgnoreCase(user.getRole())) {
// * response.sendRedirect("adminDashboard.jsp"); } else {
// * response.sendRedirect("userDashboard.jsp"); } } }
// */
//

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
//
//@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        
//        // If session exists and the user is already logged in, redirect based on the role
//        if (session != null && session.getAttribute("user") != null) {
//            User user = (User) session.getAttribute("user");
//            redirectBasedOnRole(user, response);
//            return;
//        }
//        
//        // If no active session, forward to the login page
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        UserDAO userDAO = new UserDAO();
//        
//        // Fetch the user from the database using the entered username
//        User user = userDAO.getUserByUsername(username);
//        
//        // If user exists and password matches
//        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
//            // If the password is correct, create a session and store the user object
//            HttpSession session = request.getSession(true); // Use `true` to create a new session if needed
//            session.setAttribute("user", user);
//            
//            // Redirect based on the user's role
//            redirectBasedOnRole(user, response);
//        } else {
//            // If authentication fails, set an error message and forward to the login page
//            request.setAttribute("error", "Invalid username or password");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
//    }
//
//    private void redirectBasedOnRole(User user, HttpServletResponse response) throws IOException {
//        // Redirect based on user role: admin or regular user
//        if ("admin".equalsIgnoreCase(user.getRole())) {
//            response.sendRedirect("adminDashboard.jsp");
//        } else {
//            response.sendRedirect("userDashboard.jsp");
//        }
//    }
//}



//
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
//
//@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
//public class LoginServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        if (session != null && session.getAttribute("user") != null) {
//            User user = (User) session.getAttribute("user");
//            redirectBasedOnRole(user, response);
//            return;
//        }
//
//        request.getRequestDispatcher("/login.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        UserDAO userDAO = new UserDAO();
//        User user = userDAO.getUserByUsername(username);
//
//        if (user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
//            HttpSession session = request.getSession(true);
//            session.setAttribute("user", user);
//            redirectBasedOnRole(user, response);
//        } else {
//            request.setAttribute("error", "Invalid username or password");
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
//        }
//    }
//
//    private void redirectBasedOnRole(User user, HttpServletResponse response) throws IOException {
//        String role = user.getRole();
//        System.out.println("User role: " + role); // Debug print to confirm role at login
//
//        if ("admin".equalsIgnoreCase(role)) {
//            response.sendRedirect("adminDashboard.jsp");
//        } else {
//            response.sendRedirect("userDashboard.jsp");
//        }
//    }
//}


package Controller;

import DAO.UserDAO;
import Model.User;
import Util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            redirectBasedOnRole(user, response);
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);

        if (user == null) {
            request.setAttribute("error", "Username does not exist.");
        } else if (!PasswordUtil.checkPassword(password, user.getPassword())) {
            request.setAttribute("error", "Incorrect password.");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            redirectBasedOnRole(user, response);
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private void redirectBasedOnRole(User user, HttpServletResponse response) throws IOException {
        String role = user.getRole();
        if ("admin".equalsIgnoreCase(role)) {
            response.sendRedirect("adminDashboard.jsp");
        } else {
            response.sendRedirect("userDashboard.jsp");
        }
    }
}
