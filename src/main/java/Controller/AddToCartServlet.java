/*
 * package Controller;
 * 
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 *//**
	 * Servlet implementation class AddToCartServlet
	 */
/*
 * @WebServlet("/AddToCartServlet") public class AddToCartServlet extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public AddToCartServlet() { super(); // TODO Auto-generated constructor stub
 * }
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
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*;
 * 
 * import Model.Cart;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { String productId =
 * request.getParameter("productId");
 * 
 * // Example: add product to cart stored in session HttpSession session =
 * request.getSession(); Cart cart = (Cart) session.getAttribute("cart"); if
 * (cart == null) { cart = new Cart(); session.setAttribute("cart", cart); }
 * 
 * // Assume you have a method to add product by id cart.addProduct(productId);
 * 
 * // Redirect back to productDetailsPage.jsp with success param
 * response.sendRedirect(request.getContextPath() +
 * "/productDetailsPage.jsp?productId=" + productId + "&success=1"); } }
 */

/*
 * package Controller;
 * 
 * import DAO.CartDAO; import Util.DBConnection;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException; import java.sql.*;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { int productId =
 * Integer.parseInt(request.getParameter("productId")); int quantity = 1; //
 * default to 1 for simplicity double price =
 * Double.parseDouble(request.getParameter("price")); // get from form or DB int
 * userId = Integer.parseInt(request.getParameter("userId")); // or get from
 * session
 * 
 * try (Connection conn = DBConnection.getConnection()) { CartDAO cartDAO = new
 * CartDAO(conn); int cartId = cartDAO.getOrCreateCartIdByUser(userId);
 * cartDAO.addProductToCart(cartId, productId, quantity, price);
 * 
 * // Redirect to productDetailsPage.jsp with a success message
 * response.sendRedirect(request.getContextPath() +
 * "/productDetailsPage.jsp?productId=" + productId + "&success=1"); } catch
 * (Exception e) { e.printStackTrace();
 * response.sendRedirect(request.getContextPath() +
 * "/productDetailsPage.jsp?productId=" + productId + "&error=1"); } } }
 */


/*
 * package Controller;
 * 
 * import DAO.CartDAO; import Util.DBConnection;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException; import java.sql.*;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { try { // Get parameters from
 * request String productIdParam = request.getParameter("productId"); String
 * priceParam = request.getParameter("price"); String userIdParam =
 * request.getParameter("userId");
 * 
 * // Fallback to session if userId is not sent in the form HttpSession session
 * = request.getSession(); if (userIdParam == null) { Object sessionUserId =
 * session.getAttribute("userId"); if (sessionUserId != null) { userIdParam =
 * sessionUserId.toString(); } }
 * 
 * // Check for missing parameters if (productIdParam == null || priceParam ==
 * null || userIdParam == null) { throw new
 * ServletException("Missing one or more required parameters (productId, price, userId)."
 * ); }
 * 
 * // Parse parameters int productId = Integer.parseInt(productIdParam); double
 * price = Double.parseDouble(priceParam); int userId =
 * Integer.parseInt(userIdParam); int quantity = 1; // Default quantity
 * 
 * // Use CartDAO to add item try (Connection conn =
 * DBConnection.getConnection()) { CartDAO cartDAO = new CartDAO(conn); int
 * cartId = cartDAO.getOrCreateCartIdByUser(userId);
 * cartDAO.addProductToCart(cartId, productId, quantity, price);
 * 
 * // Redirect with success response.sendRedirect(request.getContextPath() +
 * "/productDetailsPage.jsp?productId=" + productId + "&success=1"); }
 * 
 * } catch (NumberFormatException e) { e.printStackTrace();
 * response.sendError(HttpServletResponse.SC_BAD_REQUEST,
 * "Invalid number format in form data."); } catch (Exception e) {
 * e.printStackTrace();
 * response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
 * "Error adding product to cart."); } } }
 */


/*
 * package Controller;
 * 
 * import DAO.CartDAO; import Util.DBConnection;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException; import java.sql.Connection;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { try { //
 * Get parameters from request String productIdParam =
 * request.getParameter("productId"); String priceParam =
 * request.getParameter("price"); String userIdParam =
 * request.getParameter("userId");
 * 
 * // Fallback to session if userId is not sent in the form HttpSession session
 * = request.getSession(); if (userIdParam == null ||
 * userIdParam.equals("null")) { Object sessionUserId =
 * session.getAttribute("userId"); if (sessionUserId != null) { userIdParam =
 * sessionUserId.toString(); } }
 * 
 * // Validate parameters if (productIdParam == null || priceParam == null ||
 * userIdParam == null || productIdParam.trim().isEmpty() ||
 * priceParam.trim().isEmpty() || userIdParam.trim().isEmpty()) {
 * response.sendError(HttpServletResponse.SC_BAD_REQUEST,
 * "Missing or invalid form data."); return; }
 * 
 * // Parse parameters int productId = Integer.parseInt(productIdParam); double
 * price = Double.parseDouble(priceParam); int userId =
 * Integer.parseInt(userIdParam); int quantity = 1;
 * 
 * // Perform database operation try (Connection conn =
 * DBConnection.getConnection()) { CartDAO cartDAO = new CartDAO(conn); int
 * cartId = cartDAO.getOrCreateCartIdByUser(userId);
 * cartDAO.addProductToCart(cartId, productId, quantity, price);
 * 
 * // Redirect back with success response.sendRedirect(request.getContextPath()
 * + "/productDetailsPage.jsp?productId=" + productId + "&success=1"); }
 * 
 * } catch (NumberFormatException e) { e.printStackTrace();
 * response.sendError(HttpServletResponse.SC_BAD_REQUEST,
 * "Invalid number format in form data."); } catch (Exception e) {
 * e.printStackTrace();
 * response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
 * "Error adding product to cart."); } } }
 */



/*
 * package Controller;
 * 
 * import DAO.CartDAO; import Util.DBConnection;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException; import java.sql.Connection;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { try { //
 * Get parameters from request String productIdParam =
 * request.getParameter("productId"); String priceParam =
 * request.getParameter("price"); String userIdParam =
 * request.getParameter("userId");
 * 
 * // Fallback to session if userId is not sent in the form HttpSession session
 * = request.getSession(); if (userIdParam == null ||
 * userIdParam.equals("null")) { Object sessionUserId =
 * session.getAttribute("userId"); if (sessionUserId != null) { userIdParam =
 * sessionUserId.toString(); } }
 * 
 * // Validate parameters if (productIdParam == null || priceParam == null ||
 * userIdParam == null || productIdParam.trim().isEmpty() ||
 * priceParam.trim().isEmpty() || userIdParam.trim().isEmpty()) {
 * response.sendError(HttpServletResponse.SC_BAD_REQUEST,
 * "Missing or invalid form data."); return; }
 * 
 * // Parse parameters int productId = Integer.parseInt(productIdParam); double
 * price = Double.parseDouble(priceParam); int userId =
 * Integer.parseInt(userIdParam); int quantity = 1;
 * 
 * // Perform database operation try (Connection conn =
 * DBConnection.getConnection()) { CartDAO cartDAO = new CartDAO(conn); int
 * cartId = cartDAO.getOrCreateCartIdByUser(userId);
 * cartDAO.addProductToCart(cartId, productId, quantity, price); }
 * 
 * // Send 200 OK, no redirect for AJAX
 * response.setStatus(HttpServletResponse.SC_OK); // Optional: write success
 * message response.getWriter().write("success");
 * 
 * } catch (NumberFormatException e) { e.printStackTrace();
 * response.sendError(HttpServletResponse.SC_BAD_REQUEST,
 * "Invalid number format in form data."); } catch (Exception e) {
 * e.printStackTrace();
 * response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
 * "Error adding product to cart."); } } }
 */


/*
 * package Controller;
 * 
 * import DAO.CartDAO;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws IOException { String userId =
 * request.getParameter("userId"); String productId =
 * request.getParameter("productId"); String price =
 * request.getParameter("price");
 * 
 * try { CartDAO cartDAO = new CartDAO(); int cartId =
 * cartDAO.getOrCreateCartId(userId); cartDAO.addOrUpdateCartItem(cartId,
 * productId, Double.parseDouble(price));
 * 
 * response.setStatus(HttpServletResponse.SC_OK);
 * response.getWriter().write("success"); } catch (Exception e) {
 * e.printStackTrace();
 * response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
 * response.getWriter().write("error"); } } }
 */


/*
 * package Controller;
 * 
 * import DAO.CartDAO; import javax.servlet.*; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws IOException { HttpSession session =
 * request.getSession(false);
 * 
 * String productId = request.getParameter("productId"); String price =
 * request.getParameter("price");
 * 
 * if (session == null || session.getAttribute("userId") == null) {
 * response.sendRedirect("login.jsp?redirectFrom=addToCart&productId=" +
 * productId + "&price=" + price); return; }
 * 
 * String userId = session.getAttribute("userId").toString();
 * 
 * try { CartDAO cartDAO = new CartDAO(); int cartId =
 * cartDAO.getOrCreateCartId(userId); cartDAO.addOrUpdateCartItem(cartId,
 * productId, Double.parseDouble(price));
 * 
 * session.setAttribute("cartSuccess", "Product added to cart successfully");
 * response.sendRedirect("product.jsp?productId=" + productId); } catch
 * (Exception e) { e.printStackTrace(); response.sendRedirect("error.jsp"); } }
 * }
 */

/*
 * package Controller;
 * 
 * import DAO.CartDAO; import Model.User; import javax.servlet.*; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.*; import
 * java.io.IOException;
 * 
 * @WebServlet("/addToCart") public class AddToCartServlet extends HttpServlet {
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws IOException { HttpSession session =
 * request.getSession(false);
 * 
 * String productId = request.getParameter("productId"); String price =
 * request.getParameter("price");
 * 
 * // Check if user is logged in by checking the "user" attribute in session if
 * (session == null || session.getAttribute("user") == null) { // Redirect to
 * login page and pass productId and price as parameters so user can continue
 * after login
 * response.sendRedirect("login.jsp?redirectFrom=addToCart&productId=" +
 * productId + "&price=" + price); return; }
 * 
 * // User is logged in, get the user object and userId User user = (User)
 * session.getAttribute("user"); String userId = String.valueOf(user.getId());
 * 
 * try { CartDAO cartDAO = new CartDAO(); int cartId =
 * cartDAO.getOrCreateCartId(userId); cartDAO.addOrUpdateCartItem(cartId,
 * productId, Double.parseDouble(price));
 * 
 * // Store success message in session to show toast after redirect
 * session.setAttribute("cartSuccess", "Product added to cart successfully");
 * response.sendRedirect("product.jsp?productId=" + productId); } catch
 * (Exception e) { e.printStackTrace(); response.sendRedirect("error.jsp"); } }
 * }
 */



package Controller;

import DAO.CartDAO;
import Model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);

        String productId = request.getParameter("productId");
        String price = request.getParameter("price");

        if (session == null || session.getAttribute("user") == null) {
            // Redirect with query for product & price to use after login
            response.setStatus(HttpServletResponse.SC_FOUND); // 302
            response.setHeader("Location", "login.jsp?redirectFrom=addToCart&productId=" + productId + "&price=" + price);
            return;
        }

        User user = (User) session.getAttribute("user");
        String userIdStr = String.valueOf(user.getId());  // originally String
        int userId = Integer.parseInt(userIdStr);         // convert String to int

        try {
            CartDAO cartDAO = new CartDAO();
            int cartId = cartDAO.getOrCreateCartId(userId); // pass int userId here
            cartDAO.addOrUpdateCartItem(cartId, productId, Double.parseDouble(price));

            // Direct success message output for AJAX
            response.setContentType("text/plain");
            response.getWriter().write("success");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error occurred.");
        }
    }
}
