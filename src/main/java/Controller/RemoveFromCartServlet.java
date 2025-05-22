package Controller;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.CartDAO;
import Model.User;

import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RemoveFromCartServlet", urlPatterns = {"/RemoveFromCartServlet"})
public class RemoveFromCartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("🟢 RemoveFromCartServlet called");

        // Get user from session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        System.out.println("User ID from session user object: " + userId);

        // Get productId parameter from request
        int productId = Integer.parseInt(request.getParameter("productId"));
        System.out.println("Removing productId: " + productId);

        CartDAO cartDAO = new CartDAO();

        // Get cart ID for user
        int cartId = cartDAO.getCartIdByUserId(userId);
        System.out.println("Cart ID for user: " + cartId);

        if (cartId == -1) {
            System.out.println("❌ No cart found for user");
            response.sendRedirect("cart.jsp");
            return;
        }

        // Remove item from cart_items by cartId and productId
        boolean removed = cartDAO.removeItemFromCart(cartId, productId);

        if (removed) {
            System.out.println("✅ Removed from DB");
        } else {
            System.out.println("❌ Remove failed");
        }

        // Redirect back to cart page
		/* response.sendRedirect("/cart"); */
        
        response.sendRedirect(request.getContextPath() + "/cart");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    

}
