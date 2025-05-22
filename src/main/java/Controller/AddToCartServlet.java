package Controller;

import DAO.CartDAO;
import DAO.ProductDAO;
import Model.CartItem;
import Model.Product;
import Model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    private ProductDAO productDAO;
    private CartDAO cartDAO;

    @Override
    public void init() {
        productDAO = new ProductDAO();
        cartDAO = new CartDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int productId;
        int quantity;

        try {
            productId = Integer.parseInt(request.getParameter("productId"));
            quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            response.sendRedirect("products.jsp?error=InvalidQuantity");
            return;
        }

        Product product = productDAO.getProductById(productId);
        if (product == null) {
            response.sendRedirect("products.jsp?error=ProductNotFound");
            return;
        }

        cartDAO.addOrUpdateCartItem(user.getId(), productId, quantity);
        response.sendRedirect("cart");
    }
}