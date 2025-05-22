
package Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import DAO.*;
import Model.*;

@WebServlet("/Checkout")
public class CheckoutServlet extends HttpServlet {
	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * // Existing single product checkout logic String productIdParam =
	 * request.getParameter("productId"); if (productIdParam == null) {
	 * response.sendRedirect("products.jsp"); return; }
	 * 
	 * int productId = Integer.parseInt(productIdParam); Product product = new
	 * ProductDAO().getProductById(productId);
	 * 
	 * if (product == null) { request.setAttribute("error", "Product not found.");
	 * request.getRequestDispatcher("products.jsp").forward(request, response);
	 * return; }
	 * 
	 * request.setAttribute("product", product); request.setAttribute("fromCart",
	 * false); // Flag for single product checkout
	 * request.getRequestDispatcher("checkout.jsp").forward(request, response); }
	 */
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    String productIdParam = request.getParameter("productId");

	    if (productIdParam != null) {
	        // ✅ Single product checkout
	        int productId = Integer.parseInt(productIdParam);
	        Product product = new ProductDAO().getProductById(productId);

	        if (product == null) {
	            request.setAttribute("error", "Product not found.");
	            request.getRequestDispatcher("products.jsp").forward(request, response);
	            return;
	        }

	        request.setAttribute("product", product);
	        request.setAttribute("fromCart", false);
	    } else {
	        // ✅ Cart-based checkout
	        @SuppressWarnings("unchecked")
	        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");

	        if (cartItems == null || cartItems.isEmpty()) {
	            response.sendRedirect("cart.jsp"); // No items in cart
	            return;
	        }

	        request.setAttribute("cartItems", cartItems);
	        request.setAttribute("fromCart", true);
	    }

	    request.getRequestDispatcher("checkout.jsp").forward(request, response);
	}

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Get form parameters
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String paymentMethod = request.getParameter("paymentMethod");
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Get product details
        Product product = new ProductDAO().getProductById(productId);
        if (product == null) {
            request.setAttribute("error", "Product not found.");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
            return;
        }

        // Calculate total
        BigDecimal subtotal = BigDecimal.valueOf(product.getPrice())
                                  .multiply(BigDecimal.valueOf(quantity));
        BigDecimal shipping = BigDecimal.valueOf(100);
        BigDecimal total = subtotal.add(shipping);

        // Create order object
        Order order = new Order();
        order.setUserID(user.getId());
        order.setFullName(fullName); 
        order.setAddress(address);
        order.setPhone(phone);
        order.setProductID(productId);
        order.setTotalAmount(total);
        order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));
        order.setPaymentMethod(paymentMethod);

        
        
        OrderDAO orderDAO = new OrderDAO();
        boolean success = orderDAO.placeOrder(order);

        if (success) {
            // Store order in session for orderSuccess.jsp
            session.setAttribute("currentOrder", order);
            
            if ("Cash on Delivery".equals(paymentMethod)) {
         
                response.sendRedirect("orderSuccess.jsp");
            } else if ("Online Payment".equals(paymentMethod)) {
                // Store details in session for online payment
                session.setAttribute("shippingFullName", fullName);
                session.setAttribute("shippingAddress", address);
                session.setAttribute("totalAmount", total);
                session.setAttribute("productId", productId);
                session.setAttribute("quantity", quantity);
                
                response.sendRedirect("selectPayment.jsp");
            }
        } else {
            request.setAttribute("error", "Failed to place order. Please try again.");
            request.setAttribute("product", product);
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        }
    
    }
    }