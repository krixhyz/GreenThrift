/* package Controller; */

/*
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 *//**
	 * Servlet implementation class CategoryServlet
	 */
/*
 * @WebServlet("/CategoryServlet") public class CategoryServlet extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public CategoryServlet() { super(); // TODO Auto-generated constructor stub }
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
 * 
 * import javax.servlet.*; import javax.servlet.annotation.WebServlet; import
 * javax.servlet.http.*;
 * 
 * import DAO.CategoryDAO; import Model.Category;
 * 
 * import java.io.IOException; import java.sql.*; import java.util.List;
 * 
 * 
 * 
 * @WebServlet("/admin/categories") public class CategoryServlet extends
 * HttpServlet {
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * List<Category> categories = CategoryDAO.getAllCategories();
 * 
 * request.setAttribute("categories", categories); RequestDispatcher dispatcher
 * = request.getRequestDispatcher("/webapp/categoryList.jsp");
 * dispatcher.forward(request, response); } }
 */

/*
 * 
 * package Controller;
 * 
 * import javax.servlet.*; import javax.servlet.annotation.WebServlet; import
 * javax.servlet.http.*;
 * 
 * import DAO.CategoryDAO; import Model.Category;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * 
 * 
 * @WebServlet("/admin/categories") public class CategoryServlet extends
 * HttpServlet { protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { // Load
 * categories from DAO and set attributes if needed
 * 
 * request.setAttribute("contentPage", "categoryList.jsp"); RequestDispatcher
 * dispatcher = request.getRequestDispatcher("/sidebar.jsp");
 * dispatcher.forward(request, response);
 * 
 * RequestDispatcher dispatcher = request.getRequestDispatcher("/sidebar.jsp");
 * request.setAttribute("contentPage", "categoryList.jsp"); // Add this line
 * dispatcher.forward(request, response); } }
 */

/*
 * package Controller;
 * 
 * import javax.servlet.*; import javax.servlet.annotation.WebServlet; import
 * javax.servlet.http.*;
 * 
 * import DAO.CategoryDAO; import Model.Category;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * @WebServlet("/admin/categories") public class CategoryServlet extends
 * HttpServlet {
 * 
 * private CategoryDAO categoryDAO = new CategoryDAO();
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { // Load
 * all categories List<Category> categories = categoryDAO.getAllCategories();
 * request.setAttribute("categoryList", categories);
 * 
 * // Set the content page for sidebar layout
 * request.setAttribute("contentPage", "categoryList.jsp"); RequestDispatcher
 * dispatcher = request.getRequestDispatcher("/admin/sidebar.jsp");
 * dispatcher.forward(request, response); }
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { //
 * Handle adding a new category String name = request.getParameter("name");
 * String description = request.getParameter("description");
 * 
 * if (name != null && !name.trim().isEmpty()) { Category category = new
 * Category(); category.setName(name); category.setDescription(description);
 * 
 * categoryDAO.addCategory(category); }
 * 
 * // Redirect back to the categories page (GET) to show updated list
 * response.sendRedirect(request.getContextPath() + "/admin/categories"); } }
 * 
 */

package Controller;

import DAO.CategoryDAO;
import Model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/categories")
public class CategoryServlet extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // If there is an action parameter, handle it
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Show add category form inside the sidebar layout
            request.setAttribute("contentPage", "addCategory.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/sidebar.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Default: show list of categories
        List<Category> categories = categoryDAO.getAllCategories();
        request.setAttribute("categories", categories);
        request.setAttribute("contentPage", "categoryList.jsp");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/sidebar.jsp");
        dispatcher.forward(request, response);
    }

	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // Handle add category form
	 * submission String name = request.getParameter("name"); String description =
	 * request.getParameter("description");
	 * 
	 * // Create Category object using existing constructor with dummy ID 0 Category
	 * category = new Category(0, name, description);
	 * 
	 * // Save category via DAO categoryDAO.addCategory(category);
	 * 
	 * // After adding, redirect back to categories list
	 * response.sendRedirect(request.getContextPath() + "/admin/categories"); }
	 */
    
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { String name =
	 * request.getParameter("name"); String description =
	 * request.getParameter("description");
	 * 
	 * Category category = new Category(0, name, description);
	 * 
	 * // Save the category categoryDAO.addCategory(category);
	 * 
	 * // Show success message request.setAttribute("message",
	 * "Category added successfully!"); request.setAttribute("contentPage",
	 * "addCategory.jsp");
	 * 
	 * // Forward back to sidebar.jsp with success message RequestDispatcher
	 * dispatcher = request.getRequestDispatcher("/sidebar.jsp");
	 * dispatcher.forward(request, response); }
	 */
    
 // Servlet doPost
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");

        Category category = new Category(0, name, description);

        try {
            categoryDAO.addCategory(category);
            request.setAttribute("message", "Category added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Failed to add category: " + e.getMessage());
        }

        request.setAttribute("contentPage", "addCategory.jsp");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/sidebar.jsp");
        dispatcher.forward(request, response);
    }


    
}
