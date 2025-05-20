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

    // Create a new user
    public boolean createUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, username, password, email, phone_number, role, address, gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getRole());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getGender());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check if a username already exists
    public boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            return rs.next() && rs.getInt(1) > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get a user by username
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get user by ID
    public User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateUser(User user) {
    	
    	 System.out.println("Updating user with ID: " + user.getId());
    	 System.out.println("Email: " + user.getEmail());
    	 System.out.println("First Name: " + user.getFirstname());
    	 System.out.println("Last Name: " + user.getLastname());
         System.out.println("Phone: " + user.getPhone());
         System.out.println("Gender: " + user.getGender());
   	     System.out.println("Address: " + user.getAddress());
    	
    	
   	    String sql = "UPDATE users SET email = ?, first_name = ?, last_name = ?, phone_number=? , gender = ?, address = ? WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getFirstname());
            stmt.setString(3, user.getLastname());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getGender());
            stmt.setString(6, user.getAddress());
            stmt.setInt(7, user.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

 // Update full profile info
    public boolean updateUserProfile(User user) {
        String sql = "UPDATE users SET first_name=?, last_name=?, email=?, phone_number=?, gender=?, address=? WHERE id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getFirstname());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getGender());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setInt(7, user.getId());

            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Delete a user
    public boolean deleteUser(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all users (any role)
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                users.add(extractUserFromResultSet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Get all users with role = 'user'
    public List<User> getAllNormalUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'user'";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

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

    // Get total number of users
    public static int getUserCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    // Extract a User object from a ResultSet (reusable helper)
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
        user.setAddress(rs.getString("address"));
        user.setGender(rs.getString("gender"));
        return user;
    }
}
