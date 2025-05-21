package Controller;

import DAO.ProductDAO;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/adminProduct")
public class AdminProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        ProductDAO dao = new ProductDAO();

        // Common input
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int adminId = Integer.parseInt(request.getParameter("adminId"));

        if ("add".equalsIgnoreCase(action)) {
            Product p = new Product();
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            p.setStock(stock);
            p.setCategoryID(categoryId);
            p.setAdminID(adminId);
            p.setDateAdded(new Date());

            dao.addProduct(p);
        }

        if ("edit".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product p = new Product();
            p.setProductID(id);
            p.setName(name);
            p.setDescription(description);
            p.setPrice(price);
            p.setStock(stock);
            p.setCategoryID(categoryId);
            p.setAdminID(adminId);
            p.setDateAdded(new Date());

            dao.updateProduct(p);
        }

        response.sendRedirect("productsPageAdmin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDAO dao = new ProductDAO();
            dao.deleteProduct(id);
        }
        response.sendRedirect("productsPageAdmin.jsp");
    }
}
