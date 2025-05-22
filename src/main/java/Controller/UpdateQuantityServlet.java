/*
 * package Controller;
 * 
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 *//**
	 * Servlet implementation class UpdateQuantityServlet
	 */
/*
 * @WebServlet("/UpdateQuantityServlet") public class UpdateQuantityServlet
 * extends HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public UpdateQuantityServlet() { super(); // TODO Auto-generated constructor
 * stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub
 * response.getWriter().append("Served at: ").append(request.getContextPath());
 * }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */

/*
 * package Controller;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import Model.CartItem;
 * 
 * @WebServlet("/UpdateQuantityServlet") public class UpdateQuantityServlet
 * extends HttpServlet { protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { String
 * productIdStr = request.getParameter("productId"); String deltaStr =
 * request.getParameter("delta"); // expected to be "1" or "-1"
 * 
 * if (productIdStr == null || deltaStr == null) {
 * response.sendRedirect("cart.jsp"); return; }
 * 
 * int productId = Integer.parseInt(productIdStr); int delta =
 * Integer.parseInt(deltaStr);
 * 
 * HttpSession session = request.getSession(); List<CartItem> cart =
 * (List<CartItem>) session.getAttribute("cart"); if (cart != null) { for
 * (CartItem item : cart) { if (item.getProductId() == productId) { int newQty =
 * item.getQuantity() + delta; if (newQty <= 0) { // Remove the item if quantity
 * is zero or less cart.remove(item); } else { item.setQuantity(newQty); }
 * break; } } session.setAttribute("cart", cart); }
 * response.sendRedirect("cart.jsp"); } }
 */

/*
 * package Controller;
 * 
 * import DAO.CartDAO; import Model.User;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException;
 * 
 * @WebServlet("/UpdateQuantityServlet") public class UpdateQuantityServlet
 * extends HttpServlet { private CartDAO cartDAO = new CartDAO();
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * HttpSession session = request.getSession(false); User user = (User) (session
 * != null ? session.getAttribute("user") : null);
 * 
 * if (user == null) { // User not logged in, redirect to login
 * response.sendRedirect("login.jsp"); return; }
 * 
 * try { int productId = Integer.parseInt(request.getParameter("productId"));
 * int delta = Integer.parseInt(request.getParameter("delta"));
 * 
 * // Update quantity in the cart cartDAO.updateQuantity(user.getId(),
 * productId, delta);
 * 
 * } catch (NumberFormatException e) { e.printStackTrace(); }
 * 
 * // Redirect back to the cart page after updating quantity
 * response.sendRedirect("cart.jsp"); } }
 */



package Controller;

import DAO.CartDAO;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/UpdateQuantityServlet")
public class UpdateQuantityServlet extends HttpServlet {
    private CartDAO cartDAO = new CartDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        if (user == null) {
            // User not logged in, redirect to login
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            int delta = Integer.parseInt(request.getParameter("delta"));

            // Update quantity in the cart
            cartDAO.updateQuantity(user.getId(), productId, delta);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // Redirect to CartServlet after update to reload cart items
        response.sendRedirect("cart");
    }
}
