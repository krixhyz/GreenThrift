package Controller;

import javax.servlet.*;
import javax.servlet.http.*;



import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.*;
import Model.*;




@WebServlet("/ProcessPayment")
public class ProcessPaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        // Get payment details
        String gateway = request.getParameter("gateway");
        String phoneNumber = request.getParameter("phoneNumber");
        String remarks = request.getParameter("remarks");
        
        // Get order details from session
        String fullName = (String) session.getAttribute("shippingFullName");
        String address = (String) session.getAttribute("shippingAddress");
        BigDecimal totalAmount = (BigDecimal) session.getAttribute("totalAmount");
        Integer productId = (Integer) session.getAttribute("productId");
        Integer quantity = (Integer) session.getAttribute("quantity");
        User user = (User) session.getAttribute("user");

        // Create order
        Order order = new Order();
        if (user != null) {
            order.setUserID(user.getId());
        }
        order.setFullName(fullName);
        order.setAddress(address);
        order.setPhone(phoneNumber != null ? phoneNumber : "");
        order.setPaymentMethod("Online Payment (" + gateway + ")");
        order.setTotalAmount(totalAmount);
        order.setOrderStatus("Paid");
        order.setOrderDate(new java.sql.Date(System.currentTimeMillis()));
        order.setProductID(productId != null ? productId : 0);
        order.setQuantity(quantity != null ? quantity : 1);

        // Save order
        OrderDAO orderDAO = new OrderDAO();
        boolean success = orderDAO.placeOrder(order);

        // Clear session attributes
        session.removeAttribute("shippingFullName");
        session.removeAttribute("shippingAddress");
        session.removeAttribute("totalAmount");
        session.removeAttribute("productId");
        session.removeAttribute("quantity");

        if (success) {
            response.sendRedirect("orderSuccess.jsp");
        } else {
            request.setAttribute("error", "Payment processing failed. Please try again.");
            request.getRequestDispatcher("selectPayment.jsp").forward(request, response);
        }
    }
}