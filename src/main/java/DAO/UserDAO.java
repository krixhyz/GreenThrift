/*
 * package DAO;
 * 
 * import Model.User; import Util.DBConnection; import java.sql.*; import
 * java.util.ArrayList; import java.util.List;
 * 
 * public class UserDAO { public boolean createUser(User user) { String sql =
 * "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
 * try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql)) {
 * 
 * stmt.setString(1, user.getUsername()); stmt.setString(2, user.getPassword());
 * stmt.setString(3, user.getEmail()); stmt.setString(4, user.getRole());
 * 
 * return stmt.executeUpdate() > 0; } catch (SQLException e) {
 * e.printStackTrace(); return false; } }
 * 
 * 
 * 
 * public User getUserByUsername(String username) { String sql =
 * "SELECT * FROM users WHERE username = ?"; try (Connection conn =
 * DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql)) {
 * 
 * stmt.setString(1, username); ResultSet rs = stmt.executeQuery();
 * 
 * if (rs.next()) { User user = new User(); user.setId(rs.getInt("id"));
 * user.setUsername(rs.getString("username"));
 * user.setPassword(rs.getString("password")); // hashed password
 * user.setEmail(rs.getString("email")); user.setRole(rs.getString("role"));
 * return user; } } catch (SQLException e) { e.printStackTrace(); } return null;
 * }
 * 
 * 
 * public boolean usernameExists(String username) { String sql =
 * "SELECT COUNT(*) FROM users WHERE username = ?"; try (Connection conn =
 * DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql)) {
 * 
 * stmt.setString(1, username); ResultSet rs = stmt.executeQuery(); if
 * (rs.next()) { return rs.getInt(1) > 0; } } catch (SQLException e) {
 * e.printStackTrace(); } return false; }
 * 
 * public List<User> getAllUsers() { List<User> users = new ArrayList<>();
 * String sql = "SELECT * FROM users"; try (Connection conn =
 * DBConnection.getConnection(); Statement stmt = conn.createStatement();
 * ResultSet rs = stmt.executeQuery(sql)) {
 * 
 * while (rs.next()) { User user = new User(); user.setId(rs.getInt("id"));
 * user.setUsername(rs.getString("username"));
 * user.setEmail(rs.getString("email")); user.setRole(rs.getString("role"));
 * users.add(user); } } catch (SQLException e) { e.printStackTrace(); } return
 * users; } }
 */



package DAO;

import Model.User;
import Util.DBConnection;
import Util.PasswordUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Create a new user
    public boolean createUser(User user) {
        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword()); // password should already be hashed before storing
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getRole());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if the username exists in the database
    public boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Get a user by username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password")); // password is stored hashed
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get all users (useful for admin view or any other admin-related features)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Authenticate user by username and password (with hashed password)
    public User getUserByCredentials(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String storedHashedPassword = rs.getString("password");

                // Compare hashed password (input password is hashed before comparison)
                if (PasswordUtil.checkPassword(password, storedHashedPassword)) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(storedHashedPassword); // storing the hashed password
                    user.setEmail(rs.getString("email"));
                    user.setRole(rs.getString("role"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
