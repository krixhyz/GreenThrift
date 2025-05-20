/*
 * package DAO;
 * 
 * import java.sql.*;
 * 
 * import Util.DBConnection;
 * 
 * public class CategoryDAO { public static int getCategoryCount() { int count =
 * 0; try (Connection conn = DBConnection.getConnection(); PreparedStatement
 * stmt = conn.prepareStatement("SELECT COUNT(*) FROM category"); ResultSet rs =
 * stmt.executeQuery()) { if (rs.next()) count = rs.getInt(1); } catch
 * (Exception e) { e.printStackTrace(); } return count; } }
 */


package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Util.DBConnection;

public class CategoryDAO {
    public static int getCategoryCount() {
        int count = 0;
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM category");
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) count = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    
    public static List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT CategoryID, Name, Description FROM category";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Category c = new Category(
                    rs.getInt("CategoryID"),
                    rs.getString("Name"),
                    rs.getString("Description")
                );
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
	/*
	 * public void addCategory(Category category) { String sql =
	 * "INSERT INTO category (name, description) VALUES (?, ?)"; try (Connection
	 * conn = DBConnection.getConnection(); PreparedStatement stmt =
	 * conn.prepareStatement(sql)) { stmt.setString(1, category.getName());
	 * stmt.setString(2, category.getDescription()); stmt.executeUpdate(); } catch
	 * (Exception e) { e.printStackTrace(); } }
	 */
    
 // DAO addCategory method
    public void addCategory(Category category) throws SQLException {
        String sql = "INSERT INTO category (name, description) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows inserted: " + rowsAffected);
        }
    }


}
