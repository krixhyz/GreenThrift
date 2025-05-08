package Controller;

import DAO.UserDAO;
import Model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ManageUserServlet")
public class ManageUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getAllUsers();

        // DEBUG
        System.out.println("Fetched users: " + (userList != null ? userList.size() : "null"));

        request.setAttribute("userList", userList);
        request.getRequestDispatcher("manageUser.jsp").forward(request, response);
    }
}