package DAO;

import Util.DBConnection;

import java.sql.*;

public class ContactDAO {
    public boolean saveContact(String name, String email, String message) {
        String sql = "INSERT INTO contacts (name, email, message, created_at) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, message);
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
