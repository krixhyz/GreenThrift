package Controller;

import DAO.CartDAO;
import Model.CartItem;
import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/cart")  // Maps this servlet to handle requests at /cart URL
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Check if user is logged in; if not, redirect to login page
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            User user = (User) session.getAttribute("user");
            int userId = user.getId(); // Make sure getId() method exists in User class

            CartDAO cartDAO = new CartDAO();

            // Fetch cart items for this user
            List<CartItem> cartItems = cartDAO.getCartItemsByUserId(userId);

            // Optional debug info in server console
            System.out.println("User ID: " + userId);
            System.out.println("Cart items retrieved: " + cartItems.size());

            // Set cart items as request attribute for cart.jsp to display
            request.setAttribute("cartItems", cartItems);

            // Forward request to cart.jsp for rendering
            RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred while loading your cart.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
