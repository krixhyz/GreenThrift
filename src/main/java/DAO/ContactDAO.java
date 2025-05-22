package DAO;

import Model.Contact;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/coursework";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM contacts ORDER BY id ASC")) {  // Changed to id ASC
            
            while (rs.next()) {
                contacts.add(new Contact(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("message"),
                    rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching contacts: " + e.getMessage());
            e.printStackTrace();
        }
        return contacts;
    }

    public static boolean saveContact(String name, String email, String message) {
        String sql = "INSERT INTO contacts (name, email, message) VALUES (?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, message);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error saving contact: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Additional useful method
    public static Contact getContactById(int id) {
        String sql = "SELECT * FROM contacts WHERE id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Contact(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("message"),
                    rs.getTimestamp("created_at")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error fetching contact by ID: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}