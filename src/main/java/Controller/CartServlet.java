package Controller;

import DAO.CartDAO;
import Model.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        String action = request.getParameter("action");

        HttpSession session = request.getSession();
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        CartDAO cartDAO = new CartDAO();

        switch (action) {
            case "add":
                cartDAO.addToCart(cart, productId);
                response.sendRedirect("cart.jsp");
                break;

            case "buy":
                cartDAO.addToCart(cart, productId);
                response.sendRedirect("checkout.jsp"); // placeholder page
                break;

            case "remove":
                cartDAO.removeFromCart(cart, productId);
                response.sendRedirect("cart.jsp");
                break;

            case "clear":
                cartDAO.clearCart(cart);
                response.sendRedirect("cart.jsp");
                break;

            default:
                response.sendRedirect("productsPageUser.jsp");
                break;
        }

        session.setAttribute("cart", cart);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
