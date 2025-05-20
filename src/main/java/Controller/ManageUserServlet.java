/*
 * package Controller;
 * 
 * import DAO.UserDAO; import Model.User;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException; import java.util.List;
 * 
 * @WebServlet("/ManageUserServlet") public class ManageUserServlet extends
 * HttpServlet {
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * String action = request.getParameter("action"); String idStr =
 * request.getParameter("id"); UserDAO userDAO = new UserDAO();
 * 
 * if ("edit".equals(action) && idStr != null) { try { int id =
 * Integer.parseInt(idStr); User user = userDAO.getUserById(id); if (user !=
 * null) { request.setAttribute("user", user);
 * request.getRequestDispatcher("editUser.jsp").forward(request, response); }
 * else { response.sendRedirect("ManageUserServlet"); // User not found }
 * return; } catch (NumberFormatException e) { e.printStackTrace();
 * response.sendRedirect("error.jsp"); return; } }
 * 
 * // Default: list all users List<User> users = userDAO.getAllUsers();
 * request.setAttribute("userList", users);
 * request.getRequestDispatcher("manageUser.jsp").forward(request, response); }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * 
 * String action = request.getParameter("action"); UserDAO userDAO = new
 * UserDAO();
 * 
 * if ("update".equals(action)) { try { int id =
 * Integer.parseInt(request.getParameter("id"));
 * 
 * String email = request.getParameter("email"); String firstname =
 * request.getParameter("firstname"); String lastname =
 * request.getParameter("lastname"); String phone =
 * request.getParameter("phone"); String gender =
 * request.getParameter("gender"); String address =
 * request.getParameter("address");
 * 
 * User user = userDAO.getUserById(id); if (user != null) {
 * 
 * user.setEmail(email); user.setFirstname(firstname);
 * user.setLastname(lastname); user.setPhone(phone); user.setGender(gender);
 * user.setAddress(address);
 * 
 * boolean updated = userDAO.updateUser(user); if (updated) {
 * System.out.println("User updated successfully: ID = " + id); } else {
 * System.out.println("User update failed for ID = " + id); } } else {
 * System.out.println("User not found with ID = " + id); }
 * 
 * response.sendRedirect("ManageUserServlet"); } catch (NumberFormatException e)
 * { e.printStackTrace(); response.sendRedirect("error.jsp"); }
 * 
 * } else if ("delete".equals(action)) { try { int id =
 * Integer.parseInt(request.getParameter("id")); userDAO.deleteUser(id);
 * response.sendRedirect("ManageUserServlet"); } catch (NumberFormatException e)
 * { e.printStackTrace(); response.sendRedirect("error.jsp"); } } else {
 * response.sendRedirect("ManageUserServlet"); } } }
 */






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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String idStr = request.getParameter("id");
        UserDAO userDAO = new UserDAO();

        // If the action is "edit", forward to editUser.jsp with user data
        if ("edit".equals(action) && idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                User user = userDAO.getUserById(id);
                if (user != null) {
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("editUser.jsp").forward(request, response);
                } else {
                    response.sendRedirect("ManageUserServlet"); // If user not found
                }
                return;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.sendRedirect("error.jsp");
                return;
            }
        }

        // Default: show all users
        List<User> users = userDAO.getAllUsers();
        request.setAttribute("userList", users);
        request.getRequestDispatcher("manageUser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        UserDAO userDAO = new UserDAO();

        if ("update".equals(action)) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                String email = request.getParameter("email");
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String phone = request.getParameter("phone");
                String gender = request.getParameter("gender");
                String address = request.getParameter("address");

                User user = userDAO.getUserById(id);
                if (user != null) {
                    user.setEmail(email);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);
                    user.setPhone(phone);
                    user.setGender(gender);
                    user.setAddress(address);

                    boolean updated = userDAO.updateUser(user);
                    if (updated) {
                        System.out.println("User updated successfully: ID = " + id);
                    } else {
                        System.out.println("User update failed for ID = " + id);
                    }
                } else {
                    System.out.println("User not found with ID = " + id);
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
            response.sendRedirect("ManageUserServlet");
        }
    }
}
