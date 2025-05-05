package Controller;

import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Redirect to login if user is not authenticated
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        // Redirect based on role
        if ("admin".equalsIgnoreCase(user.getRole())) {
            response.sendRedirect("adminDashboard.jsp");
        } else {
            // Forward regular users to the homepage
            RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
