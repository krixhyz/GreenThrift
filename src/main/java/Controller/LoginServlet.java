/*
 * package Controller;
 * 
 * import DAO.UserDAO; import Model.User; import Util.PasswordUtil; import
 * javax.servlet.*; import javax.servlet.http.*; import
 * javax.servlet.annotation.*; import java.io.IOException;
 * 
 * @WebServlet(name = "LoginServlet", urlPatterns = {"/login"}) public class
 * LoginServlet extends HttpServlet {
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * HttpSession session = request.getSession(false);
 * 
 * if (session != null && session.getAttribute("user") != null) { User user =
 * (User) session.getAttribute("user"); redirectBasedOnRole(user, response);
 * return; }
 * 
 * request.getRequestDispatcher("/login.jsp").forward(request, response); }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { String
 * username = request.getParameter("username"); String password =
 * request.getParameter("password");
 * 
 * UserDAO userDAO = new UserDAO(); User user =
 * userDAO.getUserByUsername(username);
 * 
 * if (user == null) { request.setAttribute("error",
 * "Username does not exist."); } else if (!PasswordUtil.checkPassword(password,
 * user.getPassword())) { request.setAttribute("error", "Incorrect password.");
 * } else { HttpSession session = request.getSession(true);
 * session.setAttribute("user", user); redirectBasedOnRole(user, response);
 * return; }
 * 
 * request.getRequestDispatcher("/login.jsp").forward(request, response); }
 * 
 * private void redirectBasedOnRole(User user, HttpServletResponse response)
 * throws IOException { if ("admin".equalsIgnoreCase(user.getRole())) {
 * response.sendRedirect("adminDashboard.jsp"); } else {
 * response.sendRedirect("homepage.jsp"); } } }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * package Controller;
 * 
 * import DAO.UserDAO; import Model.User; import Util.PasswordUtil;
 * 
 * import javax.servlet.*; import javax.servlet.http.*; import
 * javax.servlet.annotation.*; import java.io.IOException;
 * 
 * @WebServlet(name = "LoginServlet", urlPatterns = {"/login"}) public class
 * LoginServlet extends HttpServlet {
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * HttpSession session = request.getSession(false);
 * 
 * if (session != null && session.getAttribute("user") != null) { User user =
 * (User) session.getAttribute("user");
 * System.out.println("✅ User already logged in: " + user.getUsername());
 * redirectBasedOnRole(user, response); return; }
 * 
 * request.getRequestDispatcher("/login.jsp").forward(request, response); }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { String
 * username = request.getParameter("username"); String password =
 * request.getParameter("password");
 * 
 * UserDAO userDAO = new UserDAO(); User user =
 * userDAO.getUserByUsername(username);
 * 
 * if (user == null) {
 * System.out.println("❌ Login failed: username not found.");
 * request.setAttribute("error", "Username does not exist."); } else if
 * (!PasswordUtil.checkPassword(password, user.getPassword())) {
 * System.out.println("❌ Login failed: incorrect password.");
 * request.setAttribute("error", "Incorrect password."); } else { HttpSession
 * session = request.getSession(true); session.setAttribute("user", user);
 * session.setMaxInactiveInterval(30 * 60); // 30 minutes
 * 
 * System.out.println("✅ Login success: user = " + user.getUsername());
 * System.out.println("✅ Session ID: " + session.getId());
 * 
 * redirectBasedOnRole(user, response); return; }
 * 
 * request.getRequestDispatcher("/login.jsp").forward(request, response); }
 * 
 * private void redirectBasedOnRole(User user, HttpServletResponse response)
 * throws IOException { if ("admin".equalsIgnoreCase(user.getRole())) {
 * response.sendRedirect("adminDashboard.jsp"); } else {
 * response.sendRedirect("cart.jsp"); } } }
 */

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
            System.out.println("✅ User already logged in: " + user.getUsername());
            redirectAfterLogin(user, session, request, response);
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
            System.out.println("❌ Login failed: username not found.");
            request.setAttribute("error", "Username does not exist.");
        } else if (!PasswordUtil.checkPassword(password, user.getPassword())) {
            System.out.println("❌ Login failed: incorrect password.");
            request.setAttribute("error", "Incorrect password.");
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            System.out.println("✅ Login success: user = " + user.getUsername());
            System.out.println("✅ Session ID: " + session.getId());

            redirectAfterLogin(user, session, request, response);
            return;
        }

        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    private void redirectAfterLogin(User user, HttpSession session, HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String redirectPath = (String) session.getAttribute("redirectAfterLogin");
        if (redirectPath != null) {
            session.removeAttribute("redirectAfterLogin");
            response.sendRedirect(request.getContextPath() + redirectPath);
        } else {
            if ("admin".equalsIgnoreCase(user.getRole())) {
                response.sendRedirect("adminDashboard.jsp");
            } else {
                response.sendRedirect("homepage.jsp");
            }
        }
    }
}
