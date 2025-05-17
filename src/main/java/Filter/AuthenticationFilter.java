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
        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("user") != null) {
            session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("login.jsp");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    @Override
    public void destroy() {}
}

