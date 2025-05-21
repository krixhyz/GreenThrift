
/*
 * package Filter;
 * 
 * import Model.User;
 * 
 * import javax.servlet.*; import javax.servlet.annotation.WebFilter; import
 * javax.servlet.http.*; import java.io.IOException; import java.util.Arrays;
 * import java.util.List;
 * 
 * @WebFilter("/*") // Apply filter to all URLs public class
 * AuthenticationFilter implements Filter {
 * 
 * // Protected paths for regular users (excluding public pages) private static
 * final List<String> USER_PATHS = Arrays.asList( "/cart.jsp",
 * "/userProfile.jsp", "/user/dashboard", "/user/orders" );
 * 
 * // Protected paths for admins private static final List<String> ADMIN_PATHS =
 * Arrays.asList( "/adminDashboard.jsp", "/productsPageAdmin.jsp",
 * "/manageUser.jsp", "/admin/dashboard", "/admin/categories", "/admin/orders"
 * ); private static final int MAX_INACTIVE_INTERVAL = 30 * 60; // 30 minutes
 * 
 * @Override public void doFilter(ServletRequest request, ServletResponse
 * response, FilterChain chain) throws IOException, ServletException {
 * 
 * HttpServletRequest req = (HttpServletRequest) request; HttpServletResponse
 * res = (HttpServletResponse) response; String path = req.getServletPath();
 * 
 * HttpSession session = req.getSession(false); User user = (session != null) ?
 * (User) session.getAttribute("user") : null;
 * 
 * // Debug logs System.out.println("Requested path: " + path);
 * System.out.println("User role: " + (user != null ? user.getRole() : "none"));
 * 
 * boolean isUserPath = USER_PATHS.contains(path); boolean isAdminPath =
 * ADMIN_PATHS.contains(path);
 * 
 * // Allow public pages if (!isUserPath && !isAdminPath) {
 * chain.doFilter(request, response); return; }
 * 
 * // Block if not logged in if (user == null) {
 * res.sendRedirect(req.getContextPath() + "/login.jsp"); return; }
 * 
 * // Extend session timeout
 * session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
 * 
 * // Enforce role restrictions if (isUserPath &&
 * !"user".equalsIgnoreCase(user.getRole())) {
 * res.sendError(HttpServletResponse.SC_FORBIDDEN, "User role required.");
 * return; } else if (isAdminPath && !"admin".equalsIgnoreCase(user.getRole()))
 * { res.sendError(HttpServletResponse.SC_FORBIDDEN, "Admin role required.");
 * return; }
 * 
 * // All good — continue chain.doFilter(request, response); }
 * 
 * @Override public void init(FilterConfig filterConfig) {}
 * 
 * @Override public void destroy() {} }
 */

package Filter;

import Model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private static final List<String> USER_PATHS = Arrays.asList(
        "/cart.jsp",
        "/userProfile.jsp",
        "/user/dashboard",
        "/user/orders"
    );

    private static final List<String> ADMIN_PATHS = Arrays.asList(
        "/adminDashboard.jsp",
        "/productsPageAdmin.jsp",
        "/manageUser.jsp",
        "/admin/dashboard",
        "/admin/categories",
        "/admin/orders"
    );

    private static final int MAX_INACTIVE_INTERVAL = 30 * 60;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getServletPath();

        HttpSession session = req.getSession(false);
        User user = (session != null) ? (User) session.getAttribute("user") : null;

        boolean isUserPath = USER_PATHS.contains(path);
        boolean isAdminPath = ADMIN_PATHS.contains(path);

        if (!isUserPath && !isAdminPath) {
            chain.doFilter(request, response);
            return;
        }

        if (user == null) {
            // Save intended destination
            req.getSession(true).setAttribute("redirectAfterLogin", path);
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        // Extend session timeout
        session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);

        if (isUserPath && !"user".equalsIgnoreCase(user.getRole())) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "User role required.");
            return;
        } else if (isAdminPath && !"admin".equalsIgnoreCase(user.getRole())) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Admin role required.");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void destroy() {}
}

