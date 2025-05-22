/*
 * package Controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import DAO.UserDAO; import Model.User;
 * 
 * @WebServlet("/ManageUserServlet") public class ManageUserServlet extends
 * HttpServlet {
 * 
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * String action = request.getParameter("action"); String idStr =
 * request.getParameter("id"); UserDAO userDAO = new UserDAO();
 * 
 * if ("edit".equals(action) && idStr != null) { try { int id =
 * Integer.parseInt(idStr); User user = userDAO.getUserById(id); if (user !=
 * null) { request.setAttribute("user", user); // Directly show editUser.jsp
 * without sidebar request.getRequestDispatcher("editUser.jsp").forward(request,
 * response); } else { response.sendRedirect("ManageUserServlet"); // If user
 * not found } return; } catch (NumberFormatException e) { e.printStackTrace();
 * response.sendRedirect("error.jsp"); return; } }
 * 
 * // Default: show all users inside sidebar layout List<User> users =
 * userDAO.getAllUsers(); request.setAttribute("userList", users);
 * request.setAttribute("contentPage", "manageUser.jsp"); }
 * 
 * 
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * String action = request.getParameter("action"); UserDAO userDAO = new
 * UserDAO();
 * 
 * if ("update".equals(action)) { try { int id =
 * Integer.parseInt(request.getParameter("id")); String username =
 * request.getParameter("username"); String email =
 * request.getParameter("email"); String role = request.getParameter("role");
 * String firstname = request.getParameter("firstname"); String lastname =
 * request.getParameter("lastname"); String phone =
 * request.getParameter("phone"); String password =
 * request.getParameter("password"); String gender =
 * request.getParameter("gender"); String address =
 * request.getParameter("address");
 * 
 * User user = userDAO.getUserById(id); if (user != null) {
 * user.setUsername(username); user.setEmail(email); user.setRole(role);
 * user.setFirstname(firstname); user.setLastname(lastname);
 * user.setPhone(phone); user.setGender(gender); user.setAddress(address);
 * 
 * // Update password only if it's not null or empty if (password != null &&
 * !password.trim().isEmpty()) { user.setPassword(password); }
 * 
 * boolean updated = userDAO.updateUser(user); if (updated) {
 * System.out.println("User updated successfully: ID = " + id); } else {
 * System.out.println("User update failed for ID = " + id); } } else {
 * System.out.println("User not found with ID = " + id); }
 * response.sendRedirect("ManageUserServlet"); } catch (NumberFormatException e)
 * { e.printStackTrace(); response.sendRedirect("error.jsp"); } } else if
 * ("delete".equals(action)) { try { int id =
 * Integer.parseInt(request.getParameter("id")); boolean deleted =
 * userDAO.deleteUser(id); if (deleted) {
 * System.out.println("User deleted successfully: ID = " + id); } else {
 * System.out.println("Failed to delete user: ID = " + id); }
 * response.sendRedirect("ManageUserServlet"); } catch (NumberFormatException e)
 * { e.printStackTrace(); response.sendRedirect("error.jsp"); } } else { //
 * Unknown action - redirect to list response.sendRedirect("ManageUserServlet");
 * } } }
 */
















package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import Model.User;

@WebServlet("/manageUser")
public class ManageUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                    response.sendRedirect("manageUser"); // If user not found
                }
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
                return;
            }
        }

        List<User> users = userDAO.getAllUsers();
        request.setAttribute("userList", users);
        request.setAttribute("contentPage", "manageUser.jsp");
        request.getRequestDispatcher("sidebar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");

                User user = userDAO.getUserById(id);
                if (user != null) {
                    user.setUsername(username);
                    user.setEmail(email);
                    user.setRole(role);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setPhone(phone);
                    user.setGender(gender);
                    user.setAddress(address);

                    // Update password only if it's not null or empty
                    if (password != null && !password.trim().isEmpty()) {
                        user.setPassword(password);
                    }

                    boolean updated = userDAO.updateUser(user);
                    if (updated) {
                        System.out.println("User updated successfully: ID = " + id);
                    } else {
                        System.out.println("User update failed for ID = " + id);
                    }
                } else {
                    System.out.println("User not found with ID = " + id);
                }
                response.sendRedirect("manageUser");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else if ("delete".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                boolean deleted = userDAO.deleteUser(id);
                if (deleted) {
                    System.out.println("User deleted successfully: ID = " + id);
                } else {
                    System.out.println("Failed to delete user: ID = " + id);
                }
                response.sendRedirect("manageUser");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
            }
        } else {
            // Unknown action - redirect to list
            response.sendRedirect("manageUser");
        }
    }
}
