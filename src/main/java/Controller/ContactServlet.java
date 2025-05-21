package Controller;

import DAO.ContactDAO;
import DAO.UserDAO;
import Model.Contact;
import Model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/contact")
public class ContactServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (!"admin".equals(user.getRole())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Admin access required");
            return;
        }

        try {
            List<Contact> contacts = ContactDAO.getAllContacts();
            request.setAttribute("contacts", contacts);
            request.getRequestDispatcher("/contactData.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Failed to load contact data: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name") != null ? request.getParameter("name").trim() : "";
        String email = request.getParameter("email") != null ? request.getParameter("email").trim() : "";
        String message = request.getParameter("message") != null ? request.getParameter("message").trim() : "";

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("messageContent", message); // Use a different key

        if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/contact.jsp").forward(request, response);
            return;
        }

        if (!isValidEmail(email)) {
            request.setAttribute("error", "Please enter a valid email address.");
            request.getRequestDispatcher("/contact.jsp").forward(request, response);
            return;
        }

        try {
            if (!UserDAO.isEmailRegistered(email)) {
                request.setAttribute("error", "Only registered email addresses can submit contact forms.");
                request.getRequestDispatcher("/contact.jsp").forward(request, response);
                return;
            }
        } catch (Exception e) {
            request.setAttribute("error", "Error validating email: " + e.getMessage());
            request.getRequestDispatcher("/contact.jsp").forward(request, response);
            return;
        }

        try {
            boolean success = ContactDAO.saveContact(name, email, message);

            if (success) {
                request.setAttribute("successMessage", "Thank you for your message! We'll get back to you soon.");
                request.setAttribute("name", "");
                request.setAttribute("email", "");
                request.setAttribute("messageContent", "");
            } else {
                request.setAttribute("error", "Failed to send message. Please try again later.");
            }
        } catch (Exception e) {
            request.setAttribute("error", "System error: " + e.getMessage());
        }

        request.getRequestDispatcher("/contact.jsp").forward(request, response);
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
