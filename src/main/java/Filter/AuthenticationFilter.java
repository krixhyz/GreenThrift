/*
 * package Filter;
 * 
 * import javax.servlet.*; import javax.servlet.annotation.WebFilter; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession; import java.io.IOException;
 * 
 * @WebFilter(urlPatterns = {"/adminDashboard.jsp", "/userDashboard.jsp",
 * "/productsPageAdmin.jsp", "/manageUser.jsp"}) public class
 * AuthenticationFilter implements Filter { private static final int
 * MAX_INACTIVE_INTERVAL = 30 * 60; // 30 minutes
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * HttpServletRequest req = (HttpServletRequest) request; HttpServletResponse
 * res = (HttpServletResponse) response; HttpSession session =
 * req.getSession(false);
 * 
 * 
 * System.out.println("Session user: " + (session != null ?
 * session.getAttribute("user") : "null"));
 * 
 * if (session != null && session.getAttribute("user") != null) {
 * session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
 * chain.doFilter(request, response); } else { res.sendRedirect("login.jsp"); }
 * }
 * 
 * @Override public void init(FilterConfig filterConfig) throws ServletException
 * {}
 * 
 * @Override public void destroy() {} }
 * 
 */


package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/adminDashboard.jsp", "/userDashboard.jsp", "/productsPageAdmin.jsp", "/manageUser.jsp"})
public class AuthenticationFilter implements Filter {

    private static final int MAX_INACTIVE_INTERVAL = 30 * 60; // 30 minutes

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false); // don't create new session

        // Check if user is logged in
        if (session != null && session.getAttribute("user") != null) {
            // Optional: Refresh session timeout
            session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);

            // Proceed to requested resource
            chain.doFilter(request, response);

        } else {
            // User not logged in, redirect to login page
            // Use context path in case app is not deployed at root
            String loginPage = req.getContextPath() + "/login.jsp";
            res.sendRedirect(loginPage);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // You can initialize resources here if needed
    }

    @Override
    public void destroy() {
        // Cleanup code if any when filter is destroyed
    }
}
