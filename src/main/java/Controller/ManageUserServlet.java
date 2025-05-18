
package Controller;

import DAO.UserDAO;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ManageUserServlet")
public class ManageUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idStr = request.getParameter("id");
        UserDAO userDAO = new UserDAO();

        if ("edit".equals(action) && idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                User user = userDAO.getUserById(id);
                if (user != null) {
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("editUser.jsp").forward(request, response);
                } else {
                    response.sendRedirect("ManageUserServlet"); // User not found
                }
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
                return;
            }
        }

        // Default: list all users
        List<User> users = userDAO.getAllUsers();
        request.setAttribute("userList", users);
        request.getRequestDispatcher("manageUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        UserDAO userDAO = new UserDAO();

        if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                String role = request.getParameter("role");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");

                User user = userDAO.getUserById(id);
                if (user != null) {
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setRole(role);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setPhone(phone);

                    // Update password only if it's not null or empty
                    if (password != null && !password.trim().isEmpty()) {
                        user.setPassword(password);
                    }

                    userDAO.updateUser(user);
                }
                
                response.sendRedirect("ManageUserServlet");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else if ("delete".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                userDAO.deleteUser(id);
                response.sendRedirect("ManageUserServlet");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            // Unknown action - redirect to list
            response.sendRedirect("ManageUserServlet");
        }
    }
}



