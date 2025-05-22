package Controller;

import Model.CartItem;
import Model.User;
import DAO.CartDAO;
import DAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    private CartDAO cartDAO;

    @Override
    public void init() {
        cartDAO = new CartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<CartItem> cartItems = cartDAO.getCartItems(user.getId());
        double total = cartItems.stream().mapToDouble(CartItem::getTotalPrice).sum();

        request.setAttribute("cartItems", cartItems);
        request.setAttribute("total", total);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        int productId = Integer.parseInt(request.getParameter("productId"));

        switch (action) {
            case "update":
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                CartItem itemToUpdate = new CartItem(user.getId(), productId, quantity);
                cartDAO.updateCartItem(itemToUpdate);
                break;

            case "remove":
                cartDAO.removeCartItem(user.getId(), productId);
                break;
        }

        response.sendRedirect("cart");
    }
}
