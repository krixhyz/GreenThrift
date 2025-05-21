//package DAO;
//
//import Model.Product;
//import Util.DBConnection;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductDAO {
//
//    public List<Product> searchProducts(String keyword) {
//        List<Product> products = new ArrayList<>();
//        String sql = "SELECT * FROM products WHERE Name LIKE ? OR Description LIKE ?";
//
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            String searchPattern = "%" + keyword + "%";
//            stmt.setString(1, searchPattern);
//            stmt.setString(2, searchPattern);
//
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                Product product = new Product();
//                product.setProductID(rs.getInt("ProductID"));
//                product.setName(rs.getString("Name"));
//                product.setDescription(rs.getString("Description"));
//                product.setPrice(rs.getDouble("Price"));
//                products.add(product);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return products;
//    }
//}
package DAO;

import Model.Product;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public List<Product> searchProducts(String keyword) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT ProductID, Name, Description, Price, Stock, DateAdded, CategoryID, AdminID, image_url FROM products WHERE Name LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("ProductID"));
                product.setName(rs.getString("Name"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getDouble("Price"));
                product.setStock(rs.getInt("Stock"));
                product.setDateAdded(rs.getDate("DateAdded"));
                product.setCategoryID(rs.getInt("CategoryID"));
                product.setAdminID(rs.getInt("AdminID"));
                product.setImageUrl(rs.getString("image_url"));
                products.add(product);
            }
            System.out.println("Searched products with keyword '" + keyword + "', found " + products.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT ProductID, Name, Description, Price, Stock, DateAdded, CategoryID, AdminID, image_url FROM products";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getDouble("Price"));
                p.setStock(rs.getInt("Stock"));
                p.setDateAdded(rs.getDate("DateAdded"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setAdminID(rs.getInt("AdminID"));
                p.setImageUrl(rs.getString("image_url"));
                products.add(p);
            }
            System.out.println("Fetched " + products.size() + " products");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getProductById(int id) {
        String sql = "SELECT ProductID, Name, Description, Price, Stock, DateAdded, CategoryID, AdminID, image_url FROM products WHERE ProductID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getDouble("Price"));
                p.setStock(rs.getInt("Stock"));
                p.setDateAdded(rs.getDate("DateAdded"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setAdminID(rs.getInt("AdminID"));
                p.setImageUrl(rs.getString("image_url"));
                System.out.println("Fetched product: ProductID=" + id);
                return p;
            }
            System.out.println("No product found for ProductID=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products (Name, Description, Price, Stock, DateAdded, CategoryID, AdminID, image_url) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());
            stmt.setDate(5, new java.sql.Date(product.getDateAdded().getTime()));
            stmt.setInt(6, product.getCategoryID());
            stmt.setInt(7, product.getAdminID());
            stmt.setString(8, product.getImageUrl());
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Added product: Name=" + product.getName() + ", rows=" + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET Name = ?, Description = ?, Price = ?, Stock = ?, DateAdded = ?, CategoryID = ?, AdminID = ?, image_url = ? WHERE ProductID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getStock());
            stmt.setDate(5, new java.sql.Date(product.getDateAdded().getTime()));
            stmt.setInt(6, product.getCategoryID());
            stmt.setInt(7, product.getAdminID());
            stmt.setString(8, product.getImageUrl());
            stmt.setInt(9, product.getProductID());
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Updated product: ProductID=" + product.getProductID() + ", rows=" + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE ProductID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, productId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Deleted product: ProductID=" + productId + ", rows=" + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static int getProductCount() {
        int count = 0;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM products");
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) count = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public List<Product> getProductsByCategory(int categoryId) {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT ProductID, Name, Description, Price, Stock, DateAdded, CategoryID, AdminID, image_url FROM products WHERE CategoryID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, categoryId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getInt("ProductID"));
                p.setName(rs.getString("Name"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getDouble("Price"));
                p.setStock(rs.getInt("Stock"));
                p.setDateAdded(rs.getDate("DateAdded"));
                p.setCategoryID(rs.getInt("CategoryID"));
                p.setAdminID(rs.getInt("AdminID"));
                p.setImageUrl(rs.getString("image_url"));
                products.add(p);
            }
            System.out.println("Fetched " + products.size() + " products for CategoryID=" + categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}