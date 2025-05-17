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



//package DAO;
//
//import Model.User;
//import Util.DBConnection;
//import Util.PasswordUtil;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDAO {
//
//    // Create a new user
//    public boolean createUser(User user) {
//        String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, user.getUsername());
//            stmt.setString(2, user.getPassword()); // password should already be hashed before storing
//            stmt.setString(3, user.getEmail());
//            stmt.setString(4, user.getRole());
//
//            return stmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    // Check if the username exists in the database
//    public boolean usernameExists(String username) {
//        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, username);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    // Get a user by username
//    public User getUserByUsername(String username) {
//        String sql = "SELECT * FROM users WHERE username = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, username);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setUsername(rs.getString("username"));
//                user.setPassword(rs.getString("password")); // password is stored hashed
//                user.setEmail(rs.getString("email"));
//                user.setRole(rs.getString("role"));
//                return user;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    // Get all users (useful for admin view or any other admin-related features)
//    public List<User> getAllUsers() {
//        List<User> users = new ArrayList<>();
//        String sql = "SELECT * FROM users";
//        try (Connection conn = DBConnection.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setUsername(rs.getString("username"));
//                user.setEmail(rs.getString("email"));
//                user.setRole(rs.getString("role"));
//                users.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    // Authenticate user by username and password (with hashed password)
//    public User getUserByCredentials(String username, String password) {
//        String sql = "SELECT * FROM users WHERE username = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, username);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                String storedHashedPassword = rs.getString("password");
//
//                // Compare hashed password (input password is hashed before comparison)
//                if (PasswordUtil.checkPassword(password, storedHashedPassword)) {
//                    User user = new User();
//                    user.setId(rs.getInt("id"));
//                    user.setUsername(rs.getString("username"));
//                    user.setPassword(storedHashedPassword); // storing the hashed password
//                    user.setEmail(rs.getString("email"));
//                    user.setRole(rs.getString("role"));
//                    return user;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//}








/*
 * package DAO;
 * 
 * import Model.User; import Util.DBConnection;
 * 
 * import java.sql.*; import java.util.ArrayList; import java.util.List;
 * 
 * public class UserDAO {
 * 
 * public boolean createUser(User user) { String sql =
 * "INSERT INTO users (first_name, last_name, username, password, email, phone_number, role) VALUES (?, ?, ?, ?, ?, ?, ?)"
 * ; try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt
 * = conn.prepareStatement(sql)) {
 * 
 * stmt.setString(1, user.getFirstname()); stmt.setString(2,
 * user.getLastname()); stmt.setString(3, user.getUsername()); stmt.setString(4,
 * user.getPassword()); stmt.setString(5, user.getEmail()); stmt.setString(6,
 * user.getPhone()); stmt.setString(7, user.getRole());
 * 
 * return stmt.executeUpdate() > 0; } catch (SQLException e) {
 * e.printStackTrace(); // Will show the SQL error return false; } }
 * 
 * public boolean usernameExists(String username) { String sql =
 * "SELECT COUNT(*) FROM users WHERE username = ?"; try (Connection conn =
 * DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql)) {
 * 
 * stmt.setString(1, username); ResultSet rs = stmt.executeQuery(); return
 * rs.next() && rs.getInt(1) > 0;
 * 
 * } catch (SQLException e) { e.printStackTrace(); return false; } }
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
 * user.setPassword(rs.getString("password")); // ✅ IMPORTANT
 * user.setEmail(rs.getString("email")); user.setRole(rs.getString("role"));
 * user.setFirstname(rs.getString("first_name"));
 * user.setLastname(rs.getString("last_name"));
 * user.setPhone(rs.getString("phone_number")); return user; }
 * 
 * } catch (SQLException e) { e.printStackTrace(); } return null; }
 * 
 * 
 * 
 * public boolean updateUserProfile(User user) { String sql =
 * "UPDATE users SET email = ?, password = ? WHERE id = ?"; try (Connection conn
 * = DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql)) {
 * 
 * stmt.setString(1, user.getEmail()); stmt.setString(2, user.getPassword()); //
 * hashed stmt.setInt(3, user.getId());
 * 
 * return stmt.executeUpdate() > 0; } catch (SQLException e) {
 * e.printStackTrace(); return false; } }
 * 
 * public List<User> getAllUsers() { List<User> users = new ArrayList<>();
 * String sql = "SELECT * FROM users";
 * 
 * try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
 * 
 * while (rs.next()) { User user = new User(); user.setId(rs.getInt("id"));
 * user.setUsername(rs.getString("username"));
 * user.setEmail(rs.getString("email")); user.setRole(rs.getString("role")); //
 * Set other fields if needed users.add(user); }
 * 
 * } catch (SQLException e) { e.printStackTrace(); }
 * 
 * return users; } public User getUserById(int id) { String sql =
 * "SELECT * FROM users WHERE id = ?"; try (Connection conn =
 * DBConnection.getConnection(); PreparedStatement stmt =
 * conn.prepareStatement(sql)) {
 * 
 * stmt.setInt(1, id); ResultSet rs = stmt.executeQuery();
 * 
 * if (rs.next()) { User user = new User(); user.setId(rs.getInt("id"));
 * user.setUsername(rs.getString("username"));
 * user.setPassword(rs.getString("password"));
 * user.setEmail(rs.getString("email")); user.setRole(rs.getString("role"));
 * user.setFirstname(rs.getString("first_name"));
 * user.setLastname(rs.getString("last_name"));
 * user.setPhone(rs.getString("phone_number")); return user; }
 * 
 * } catch (SQLException e) { e.printStackTrace(); } return null; }
 * 
 * }
 */














package DAO;

import Model.User;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Create a new user in the database
    public boolean createUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, username, password, email, phone_number, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getFirstname());
            stmt.setString(2, user.getLastname());
            stmt.setString(3, user.getUsername());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getPhone());
            stmt.setString(7, user.getRole());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if username already exists to avoid duplicates
    public boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fetch user details by username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                User user = extractUserFromResultSet(rs);
                return user;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update user email and role based on id
    public boolean updateUser(User user) {
        boolean rowUpdated = false;
        String sql = "UPDATE users SET first_name=?, last_name=?, username=?, email=?, password=?, phone_number=?, role=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
        	stmt.setString(1, user.getFirstname());
        	stmt.setString(2, user.getLastname());
        	stmt.setString(3, user.getUsername());
        	stmt.setString(4, user.getEmail());
        	stmt.setString(5, user.getPassword());
        	stmt.setString(6, user.getPhone());
        	stmt.setString(7, user.getRole());
        	stmt.setInt(8, user.getId());
        	rowUpdated = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }


    // Delete a user by id
    public boolean deleteUser(int id) {
        boolean rowDeleted = false;
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            rowDeleted = stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    
    // Get list of all normal users (role = 'user')
    public List<User> getAllNormalUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'user'"; 

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
    
    
    public boolean updateUserProfile(User user) {
        String sql = "UPDATE users SET email = ?, password = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getPassword()); // hashed
            stmt.setInt(3, user.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get user details by user id
    public User getUserById(int id) {
        User user = null;
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setPhone(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    // Helper method to reduce repeated code when extracting User object from ResultSet
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setFirstname(rs.getString("first_name"));
        user.setLastname(rs.getString("last_name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone_number"));
        user.setRole(rs.getString("role"));
        return user;
    }
    
    

    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone_number"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}
