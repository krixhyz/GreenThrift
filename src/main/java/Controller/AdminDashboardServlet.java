/*
 * package Controller;
 * 
 * import DAO.UserDAO; import DAO.ProductDAO; import DAO.CategoryDAO;
 * 
 * import javax.servlet.*; import javax.servlet.http.*; import
 * javax.servlet.annotation.*; import java.io.IOException;
 * 
 * @WebServlet("/admin/dashboard") public class AdminDashboardServlet extends
 * HttpServlet {
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { // Fetch
 * counts from DAOs int userCount = UserDAO.getUserCount(); int productCount =
 * ProductDAO.getProductCount(); int categoryCount =
 * CategoryDAO.getCategoryCount();
 * 
 * // Set counts as request attributes to be accessible in JSP
 * request.setAttribute("userCount", userCount);
 * request.setAttribute("productCount", productCount);
 * request.setAttribute("categoryCount", categoryCount);
 * 
 * // Get or create session to store admin name HttpSession session =
 * request.getSession(); if (session.getAttribute("adminName") == null) { // You
 * can replace "Admin" with the actual logged-in admin username if available
 * session.setAttribute("adminName", "Admin"); }
 * 
 * // Forward to JSP for rendering dashboard RequestDispatcher dispatcher =
 * request.getRequestDispatcher("/admindashboard.jsp");
 * dispatcher.forward(request, response); } }
 */

package Controller;

import DAO.CategoryDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import Model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/dashboard")
public class AdminDashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch counts from DAOs
        int userCount = UserDAO.getUserCount(); // Make sure getUserCount() is static or use instance
        int productCount = ProductDAO.getProductCount();
        int categoryCount = CategoryDAO.getCategoryCount();
        int orderCount = OrderDAO.getOrderCount();
        
        // Debug prints
        System.out.println("DEBUG: User count = " + userCount);
        System.out.println("DEBUG: Product count = " + productCount);
        System.out.println("DEBUG: Category count = " + categoryCount);
        System.out.println("DEBUG: Order count = " + orderCount);

        // Get latest 5 orders
        List<Order> recentOrders = OrderDAO.getRecentOrders(5);

        // Set attributes for JSP
        request.setAttribute("userCount", userCount);
        request.setAttribute("productCount", productCount);
        request.setAttribute("categoryCount", categoryCount);
        request.setAttribute("orderCount", orderCount);
        request.setAttribute("recentOrders", recentOrders);

        // Manage session attribute
        HttpSession session = request.getSession();
        if (session.getAttribute("adminName") == null) {
            session.setAttribute("adminName", "Admin");
        }

		/*
		 * // Forward to JSP RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("/sidebar.jsp?page=dashboard");
		 * dispatcher.forward(request, response);
		 */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sidebar.jsp");
        request.setAttribute("contentPage", "adminDashboard.jsp"); // Add this line
        dispatcher.forward(request, response);

    }
}
