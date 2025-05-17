package Controller;

import DAO.ContactDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactDAO contactDAO = new ContactDAO();
        boolean success = contactDAO.saveContact(name, email, message);

        request.setAttribute("message", success ? "Message sent successfully." : "Failed to send message.");
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }
}
