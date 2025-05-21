package Controller;

import DAO.ProductDAO;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String query = request.getParameter("query");

        if (query == null || query.trim().isEmpty()) {
            response.sendRedirect("homepage.jsp");
            return;
        }

        HttpSession session = request.getSession(false);
        boolean isAdmin = false;

        if (session != null && session.getAttribute("user") != null) {
            Model.User user = (Model.User) session.getAttribute("user");
            isAdmin = "admin".equalsIgnoreCase(user.getRole());
        }

        ProductDAO productDAO = new ProductDAO();
        List<Product> results = productDAO.searchProducts(query.trim());

        request.setAttribute("results", results);
        request.setAttribute("query", query);
        request.setAttribute("isAdmin", isAdmin); // ✅ pass correct flag

        request.getRequestDispatcher("searchResults.jsp").forward(request, response);
    }
}
