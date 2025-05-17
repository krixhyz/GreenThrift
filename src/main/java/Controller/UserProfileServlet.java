package Controller;

import DAO.UserDAO;
import Model.User;
import Util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && !email.trim().isEmpty()) {
            currentUser.setEmail(email);
        }

        if (password != null && !password.trim().isEmpty()) {
            currentUser.setPassword(PasswordUtil.hashPassword(password));
        }

        UserDAO userDAO = new UserDAO();
        boolean updated = userDAO.updateUserProfile(currentUser);

        if (updated) {
            session.setAttribute("user", currentUser);
            request.setAttribute("message", "Profile updated successfully.");
        } else {
            request.setAttribute("message", "Profile update failed.");
        }

        request.setAttribute("user", currentUser); // Send user to JSP
        request.getRequestDispatcher("userProfile.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        request.setAttribute("user", user);
        request.getRequestDispatcher("userProfile.jsp").forward(request, response);
    }
}
