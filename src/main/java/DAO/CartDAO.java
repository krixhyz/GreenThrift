package DAO;

import Model.CartItem;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    private int getOrCreateCartId(int userId) throws SQLException {
        int cartId = -1;

        try (Connection conn = DBConnection.getConnection()) {
            // Check if cart already exists
            String select = "SELECT CartID FROM cart WHERE UserID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(select)) {
                stmt.setInt(1, userId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) return rs.getInt("CartID");
                }
            }

            // Create new cart
            String insert = "INSERT INTO cart (UserID) VALUES (?)";
            try (PreparedStatement stmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setInt(1, userId);
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Created cart for UserID=" + userId + ", rows=" + rowsAffected);
                try (ResultSet keys = stmt.getGeneratedKeys()) {
                    if (keys.next()) cartId = keys.getInt(1);
                }
            }
        }

        return cartId;
    }

    public int getCartIdByUserId(int userId) {
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT CartID FROM cart WHERE UserID = ?");
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt("CartID");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<CartItem> getCartItemsByCartId(int cartId) {
        List<CartItem> items = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT ci.CartItemID, ci.ProductID, ci.Quantity, p.Name, p.Price " +
                         "FROM cart_items ci " +
                         "JOIN products p ON ci.ProductID = p.ProductID " +
                         "WHERE ci.CartID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem();
                item.setCartItemId(rs.getInt("CartItemID"));
                item.setProductId(rs.getInt("ProductID"));
                item.setQuantity(rs.getInt("Quantity"));
                item.setProductName(rs.getString("Name"));
                item.setProductPrice(rs.getDouble("Price"));
                items.add(item);
            }
            System.out.println("Retrieved " + items.size() + " cart items for CartID=" + cartId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public List<CartItem> getCartItems(int userId) {
        int cartId = getCartIdByUserId(userId);
        if (cartId == -1) {
            System.out.println("No cart found for UserID=" + userId);
            return new ArrayList<>();
        }
        return getCartItemsByCartId(cartId);
    }

    public void removeCartItem(int userId, int productId) {
        String sql = "DELETE FROM cart_items WHERE CartID = (SELECT CartID FROM cart WHERE UserID = ?) AND ProductID = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Removed cart item: UserID=" + userId + ", ProductID=" + productId + ", rows=" + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearCart(int userId) {
        String sql = "DELETE FROM cart_items WHERE CartID = (SELECT CartID FROM cart WHERE UserID = ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Cleared cart for UserID=" + userId + ", rows=" + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CartItem getCartItem(int userId, int productId) {
        String sql = "SELECT ci.Quantity, p.Name, p.Price FROM cart_items ci " +
                     "JOIN cart c ON ci.CartID = c.CartID " +
                     "JOIN products p ON ci.ProductID = p.ProductID " +
                     "WHERE c.UserID = ? AND ci.ProductID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CartItem item = new CartItem();
                    item.setProductId(productId);
                    item.setProductName(rs.getString("Name"));
                    item.setProductPrice(rs.getDouble("Price"));
                    item.setQuantity(rs.getInt("Quantity"));
                    return item;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateCartItem(CartItem item) {
        try (Connection conn = DBConnection.getConnection()) {
            int cartId = getOrCreateCartId(item.getUserId());
            String sql = "UPDATE cart_items SET Quantity = ? WHERE CartID = ? AND ProductID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, item.getQuantity());
                stmt.setInt(2, cartId);
                stmt.setInt(3, item.getProductId());
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Updated cart item: CartID=" + cartId + ", ProductID=" + item.getProductId() + ", Quantity=" + item.getQuantity() + ", rows=" + rowsAffected);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCartItem(CartItem item) {
        try (Connection conn = DBConnection.getConnection()) {
            int cartId = getOrCreateCartId(item.getUserId());
            String sql = "INSERT INTO cart_items (CartID, ProductID, Quantity) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, cartId);
                stmt.setInt(2, item.getProductId());
                stmt.setInt(3, item.getQuantity());
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Added cart item: CartID=" + cartId + ", ProductID=" + item.getProductId() + ", Quantity=" + item.getQuantity() + ", rows=" + rowsAffected);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOrUpdateCartItem(int userId, int productId, int quantity) {
        try (Connection conn = DBConnection.getConnection()) {
            int cartId = getOrCreateCartId(userId);
            String check = "SELECT Quantity FROM cart_items WHERE CartID = ? AND ProductID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(check)) {
                stmt.setInt(1, cartId);
                stmt.setInt(2, productId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        String update = "UPDATE cart_items SET Quantity = Quantity + ? WHERE CartID = ? AND ProductID = ?";
                        try (PreparedStatement updateStmt = conn.prepareStatement(update)) {
                            updateStmt.setInt(1, quantity);
                            updateStmt.setInt(2, cartId);
                            updateStmt.setInt(3, productId);
                            int rowsAffected = updateStmt.executeUpdate();
                            System.out.println("Updated cart item: CartID=" + cartId + ", ProductID=" + productId + ", Quantity increment=" + quantity + ", rows=" + rowsAffected);
                        }
                    } else {
                        String insert = "INSERT INTO cart_items (CartID, ProductID, Quantity) VALUES (?, ?, ?)";
                        try (PreparedStatement insertStmt = conn.prepareStatement(insert)) {
                            insertStmt.setInt(1, cartId);
                            insertStmt.setInt(2, productId);
                            insertStmt.setInt(3, quantity);
                            int rowsAffected = insertStmt.executeUpdate();
                            System.out.println("Inserted cart item: CartID=" + cartId + ", ProductID=" + productId + ", Quantity=" + quantity + ", rows=" + rowsAffected);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}