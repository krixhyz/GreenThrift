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
            response.sendRedirect("productPageUser.jsp"); // fallback
            return;
        }

        ProductDAO productDAO = new ProductDAO();
        List<Product> results = productDAO.searchProducts(query.trim());

        request.setAttribute("results", results);
        request.setAttribute("query", query);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchResults.jsp");
        dispatcher.forward(request, response);
    }
}
