package Controller;

import DAO.UserDAO;
import Model.User;
import Util.PasswordUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User currentUser = (User) session.getAttribute("user");

        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");

        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        // Validate new password inputs
        if (!newPassword.isEmpty() || !confirmPassword.isEmpty()) {
            if (!PasswordUtil.checkPassword(currentPassword, currentUser.getPassword())) {
                request.setAttribute("message", "Incorrect current password.");
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
                return;
            }

            if (!newPassword.equals(confirmPassword)) {
                request.setAttribute("message", "New password and confirmation do not match.");
                request.getRequestDispatcher("userProfile.jsp").forward(request, response);
                return;
            }

            // Update password
            String hashedPassword = PasswordUtil.hashPassword(newPassword);
            currentUser.setPassword(hashedPassword);
        }

        // Update other fields
        currentUser.setEmail(email);
        currentUser.setGender(gender);
        currentUser.setAddress(address);

        UserDAO userDAO = new UserDAO();
        boolean updated = userDAO.updateUser(currentUser);

        if (updated) {
            session.setAttribute("user", currentUser); // Update session info
            request.setAttribute("message", "Profile updated successfully.");
        } else {
            request.setAttribute("message", "Error updating profile.");
        }

        request.getRequestDispatcher("userProfile.jsp").forward(request, response);
    }
}
