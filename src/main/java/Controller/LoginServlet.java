package Controller;
import DAO.UserDAO;import Model.User;
import Util.PasswordUtil;
import javax.servlet.*;import javax.servlet.http.*;
import javax.servlet.annotation.*;import java.io.IOException;
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {            User user = (User) session.getAttribute("user");
            redirectBasedOnRole(user, response);            return;
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();        User user = userDAO.getUserByUsername(username);
        if (user == null) {
            request.setAttribute("error", "Username does not exist.");        } else if (!PasswordUtil.checkPassword(password, user.getPassword())) {
            request.setAttribute("error", "Incorrect password.");        } else {
            HttpSession session = request.getSession(true);            session.setAttribute("user", user);
            redirectBasedOnRole(user, response);            return;
        }
        request.getRequestDispatcher("/login.jsp").forward(request, response);    }
    private void redirectBasedOnRole(User user, HttpServletResponse response) throws IOException {
        String role = user.getRole();        if ("admin".equalsIgnoreCase(role)) {
            response.sendRedirect("adminDashboard.jsp");        } else {
            response.sendRedirect("userDashboard.jsp");        }
    }}