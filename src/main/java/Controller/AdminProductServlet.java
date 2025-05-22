/*
 * package Controller;
 * 
 * import DAO.ProductDAO; import Model.Product;
 * 
 * import javax.servlet.*; import javax.servlet.http.*; import
 * javax.servlet.annotation.*; import java.io.IOException; import
 * java.util.Date;
 * 
 * @WebServlet("/adminProduct") public class AdminProductServlet extends
 * HttpServlet { protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * String action = request.getParameter("action"); ProductDAO dao = new
 * ProductDAO();
 * 
 * // Common input String name = request.getParameter("name"); String
 * description = request.getParameter("description"); double price =
 * Double.parseDouble(request.getParameter("price")); int stock =
 * Integer.parseInt(request.getParameter("stock")); int categoryId =
 * Integer.parseInt(request.getParameter("categoryId")); int adminId =
 * Integer.parseInt(request.getParameter("adminId"));
 * 
 * if ("add".equalsIgnoreCase(action)) { Product p = new Product();
 * p.setName(name); p.setDescription(description); p.setPrice(price);
 * p.setStock(stock); p.setCategoryID(categoryId); p.setAdminID(adminId);
 * p.setDateAdded(new Date());
 * 
 * dao.addProduct(p); }
 * 
 * if ("edit".equalsIgnoreCase(action)) { int id =
 * Integer.parseInt(request.getParameter("id")); Product p = new Product();
 * p.setProductID(id); p.setName(name); p.setDescription(description);
 * p.setPrice(price); p.setStock(stock); p.setCategoryID(categoryId);
 * p.setAdminID(adminId); p.setDateAdded(new Date());
 * 
 * dao.updateProduct(p); }
 * 
 * response.sendRedirect("productsPageAdmin.jsp"); }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { String action =
 * request.getParameter("action"); if ("delete".equalsIgnoreCase(action)) { int
 * id = Integer.parseInt(request.getParameter("id")); ProductDAO dao = new
 * ProductDAO(); dao.deleteProduct(id); }
 * response.sendRedirect("productsPageAdmin.jsp"); } }
 */


package Controller;



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import DAO.ProductDAO;
import Model.Product;

@WebServlet("/adminProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class AdminProductServlet extends HttpServlet {
    private static final String UPLOAD_DIR = "images/products";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ProductDAO dao = new ProductDAO();

        // Extract form data
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price;
        try {
            price = Double.parseDouble(request.getParameter("price"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid price format.");
            request.getRequestDispatcher("productForm.jsp").forward(request, response);
            return;
        }
        int stock;
        try {
            stock = Integer.parseInt(request.getParameter("stock"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid stock format.");
            request.getRequestDispatcher("productForm.jsp").forward(request, response);
            return;
        }
        int categoryId;
        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid category ID.");
            request.getRequestDispatcher("productForm.jsp").forward(request, response);
            return;
        }
        int adminId;
        try {
            adminId = Integer.parseInt(request.getParameter("adminId"));
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid admin ID.");
            request.getRequestDispatcher("productForm.jsp").forward(request, response);
            return;
        }
        String imageUrl = null;

        // Handle file upload
        Part filePart = request.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = extractFileName(filePart);
            // Validate file type
            if (!fileName.matches(".*\\.(jpg|jpeg|png|gif)$")) {
                request.setAttribute("error", "Invalid file type. Only JPG, PNG, and GIF are allowed.");
                request.getRequestDispatcher("productForm.jsp").forward(request, response);
                return;
            }
            // Sanitize file name with timestamp
            fileName = System.currentTimeMillis() + "_" + fileName.replaceAll("[^a-zA-Z0-9._-]", "_");
            // Save to src/main/webapp/images/products on Desktop
            String uploadPath = "C:\\Users\\jarvis\\Desktop\\GreenThrift\\src\\main\\webapp\\images\\products";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            imageUrl = UPLOAD_DIR + "/" + fileName; // Relative path: images/products/<filename>
            
        
        } else if ("edit".equals(action)) {
            // Retain existing image_url
            int id = Integer.parseInt(request.getParameter("id"));
            Product existingProduct = dao.getProductById(id);
            imageUrl = existingProduct.getImageUrl();
        }

        if ("add".equals(action)) {
            Product product = new Product(name, description, price, stock, categoryId, adminId, imageUrl);
            dao.addProduct(product);
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = new Product(id, name, description, price, stock, new Date(), categoryId, adminId, imageUrl);
            dao.updateProduct(product);
        }

        response.sendRedirect("productsPageAdmin.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDAO dao = new ProductDAO();
            dao.deleteProduct(id);
            response.sendRedirect("productsPageAdmin.jsp");
        }
    }

    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        String[] items = contentDisposition.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}