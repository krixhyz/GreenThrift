/*
 * package DAO;
 * 
 * import Model.CartItem; import Model.Product;
 * 
 * import java.util.List;
 * 
 * public class CartDAO {
 * 
 * private final ProductDAO productDAO;
 * 
 * public CartDAO() { this.productDAO = new ProductDAO(); }
 * 
 * public void addToCart(List<CartItem> cart, int productId) { boolean found =
 * false;
 * 
 * for (CartItem item : cart) { if (item.getProduct().getProductID() ==
 * productId) { item.setQuantity(item.getQuantity() + 1); found = true; break; }
 * }
 * 
 * if (!found) { Product product = productDAO.getProductById(productId); if
 * (product != null) { cart.add(new CartItem(product, 1)); } } }
 * 
 * // Optional: other cart operations public void removeFromCart(List<CartItem>
 * cart, int productId) { cart.removeIf(item -> item.getProduct().getProductID()
 * == productId); }
 * 
 * public void clearCart(List<CartItem> cart) { cart.clear(); } }
 */

/*
 * package DAO;
 * 
 * import java.sql.*; import Model.Cart;
 * 
 * public class CartDAO {
 * 
 * private Connection connection;
 * 
 * public CartDAO(Connection connection) { this.connection = connection; }
 * 
 * public boolean addProductToCart(int cartId, int productId, int quantity,
 * double price) { String sql =
 * "INSERT INTO cart_items (cart_id, product_id, quantity, price) VALUES (?, ?, ?, ?)"
 * ; try (PreparedStatement ps = connection.prepareStatement(sql)) {
 * ps.setInt(1, cartId); ps.setInt(2, productId); ps.setInt(3, quantity);
 * ps.setDouble(4, price); int rowsInserted = ps.executeUpdate(); return
 * rowsInserted > 0; } catch (SQLException e) { e.printStackTrace(); return
 * false; } }
 * 
 * // You can add methods like createCart, getCartByUserId,
 * updateCartItemQuantity, etc. }
 */

/*
 * 
 * package DAO;
 * 
 * import java.sql.*;
 * 
 * public class CartDAO { private Connection conn;
 * 
 * public CartDAO(Connection conn) { this.conn = conn; }
 * 
 * public int getOrCreateCartIdByUser(int userId) throws SQLException { String
 * selectQuery = "SELECT cart_id FROM cart WHERE user_id = ?"; PreparedStatement
 * ps = conn.prepareStatement(selectQuery); ps.setInt(1, userId); ResultSet rs =
 * ps.executeQuery();
 * 
 * if (rs.next()) { return rs.getInt("cart_id"); } else { String insertQuery =
 * "INSERT INTO cart (user_id, created_at, updated_at) VALUES (?, NOW(), NOW())"
 * ; ps = conn.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
 * ps.setInt(1, userId); ps.executeUpdate(); rs = ps.getGeneratedKeys(); if
 * (rs.next()) { return rs.getInt(1); } }
 * 
 * return -1; // error }
 * 
 * public boolean addProductToCart(int cartId, int productId, int quantity,
 * double price) throws SQLException { // Check if the item already exists
 * String checkQuery =
 * "SELECT quantity FROM cart_items WHERE cart_id = ? AND product_id = ?";
 * PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
 * checkStmt.setInt(1, cartId); checkStmt.setInt(2, productId); ResultSet rs =
 * checkStmt.executeQuery();
 * 
 * if (rs.next()) { // Update quantity int newQty = rs.getInt("quantity") +
 * quantity; String updateQuery =
 * "UPDATE cart_items SET quantity = ?, price = ? WHERE cart_id = ? AND product_id = ?"
 * ; PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
 * updateStmt.setInt(1, newQty); updateStmt.setDouble(2, price);
 * updateStmt.setInt(3, cartId); updateStmt.setInt(4, productId); return
 * updateStmt.executeUpdate() > 0; } else { // Insert new cart item String
 * insertQuery =
 * "INSERT INTO cart_items (cart_id, product_id, quantity, price) VALUES (?, ?, ?, ?)"
 * ; PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
 * insertStmt.setInt(1, cartId); insertStmt.setInt(2, productId);
 * insertStmt.setInt(3, quantity); insertStmt.setDouble(4, price); return
 * insertStmt.executeUpdate() > 0; } } }
 */

/*
 * package DAO;
 * 
 * import Util.DBConnection; import java.sql.*;
 * 
 * public class CartDAO {
 * 
 * public int getOrCreateCartId(String userId) throws Exception { Connection
 * conn = null; PreparedStatement ps = null; ResultSet rs = null;
 * 
 * try { conn = DBConnection.getConnection();
 * 
 * // Check if cart exists String sqlCheck =
 * "SELECT cartid FROM cart WHERE userid = ?"; ps =
 * conn.prepareStatement(sqlCheck); ps.setString(1, userId); rs =
 * ps.executeQuery();
 * 
 * if (rs.next()) { return rs.getInt("cartid"); } rs.close(); ps.close();
 * 
 * // Create new cart String sqlInsert =
 * "INSERT INTO cart (userid, created_at, updated_at) VALUES (?, NOW(), NOW())";
 * ps = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
 * ps.setString(1, userId); ps.executeUpdate();
 * 
 * rs = ps.getGeneratedKeys(); if (rs.next()) { return rs.getInt(1); }
 * 
 * throw new SQLException("Creating cart failed, no ID obtained."); } finally {
 * if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn != null)
 * conn.close(); } }
 * 
 * public void addOrUpdateCartItem(int cartId, String productId, double price)
 * throws Exception { Connection conn = null; PreparedStatement ps = null;
 * ResultSet rs = null;
 * 
 * try { conn = DBConnection.getConnection();
 * 
 * // Check if product already in cart String sqlCheck =
 * "SELECT quantity FROM cart_items WHERE cartid = ? AND productid = ?"; ps =
 * conn.prepareStatement(sqlCheck); ps.setInt(1, cartId); ps.setString(2,
 * productId); rs = ps.executeQuery();
 * 
 * if (rs.next()) { int quantity = rs.getInt("quantity"); rs.close();
 * ps.close();
 * 
 * String sqlUpdate =
 * "UPDATE cart_items SET quantity = ?, price = ?, updated_at = NOW() WHERE cartid = ? AND productid = ?"
 * ; ps = conn.prepareStatement(sqlUpdate); ps.setInt(1, quantity + 1);
 * ps.setDouble(2, price); ps.setInt(3, cartId); ps.setString(4, productId);
 * ps.executeUpdate(); } else { rs.close(); ps.close();
 * 
 * String sqlInsert =
 * "INSERT INTO cart_items (cartid, productid, quantity, price, created_at, updated_at) VALUES (?, ?, 1, ?, NOW(), NOW())"
 * ; ps = conn.prepareStatement(sqlInsert); ps.setInt(1, cartId);
 * ps.setString(2, productId); ps.setDouble(3, price); ps.executeUpdate(); }
 * 
 * } finally { if (rs != null) rs.close(); if (ps != null) ps.close(); if (conn
 * != null) conn.close(); } } }
 */


/*
 * 
 * package DAO;
 * 
 * import Util.DBConnection; import java.sql.*;
 * 
 * public class CartDAO { public int getOrCreateCartId(String userId) throws
 * Exception { Connection conn = DBConnection.getConnection(); int cartId = -1;
 * 
 * String selectSQL = "SELECT cartid FROM cart WHERE userid = ?";
 * PreparedStatement stmt = conn.prepareStatement(selectSQL); stmt.setString(1,
 * userId); ResultSet rs = stmt.executeQuery();
 * 
 * if (rs.next()) { cartId = rs.getInt("cartid"); } else { String insertSQL =
 * "INSERT INTO cart (userid, created_at, updated_at) VALUES (?, NOW(), NOW())";
 * stmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
 * stmt.setString(1, userId); stmt.executeUpdate(); rs =
 * stmt.getGeneratedKeys(); if (rs.next()) { cartId = rs.getInt(1); } }
 * 
 * rs.close(); stmt.close(); conn.close(); return cartId; }
 * 
 * public void addOrUpdateCartItem(int cartId, String productId, double price)
 * throws Exception { Connection conn = DBConnection.getConnection();
 * 
 * String checkSQL =
 * "SELECT quantity FROM cart_items WHERE cartid = ? AND productid = ?";
 * PreparedStatement stmt = conn.prepareStatement(checkSQL); stmt.setInt(1,
 * cartId); stmt.setString(2, productId); ResultSet rs = stmt.executeQuery();
 * 
 * if (rs.next()) { int qty = rs.getInt("quantity"); String updateSQL =
 * "UPDATE cart_items SET quantity = ?, price = ?, updated_at = NOW() WHERE cartid = ? AND productid = ?"
 * ; stmt = conn.prepareStatement(updateSQL); stmt.setInt(1, qty + 1);
 * stmt.setDouble(2, price); stmt.setInt(3, cartId); stmt.setString(4,
 * productId); stmt.executeUpdate(); } else { String insertSQL =
 * "INSERT INTO cart_items (cartid, productid, quantity, price, created_at, updated_at) VALUES (?, ?, 1, ?, NOW(), NOW())"
 * ; stmt = conn.prepareStatement(insertSQL); stmt.setInt(1, cartId);
 * stmt.setString(2, productId); stmt.setDouble(3, price); stmt.executeUpdate();
 * }
 * 
 * rs.close(); stmt.close(); conn.close(); } }
 */
package DAO;

import Model.CartItem;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

	// Change parameter type from String to int
	public int getOrCreateCartId(int userId) throws Exception {
		int cartId = -1;

		try (Connection conn = DBConnection.getConnection()) {
			String selectSQL = "SELECT cartid FROM cart WHERE userid = ?";
			try (PreparedStatement stmt = conn.prepareStatement(selectSQL)) {
				stmt.setInt(1, userId); // Use setInt here
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						return rs.getInt("cartid");
					}
				}
			}

			String insertSQL = "INSERT INTO cart (userid, created_at, updated_at) VALUES (?, NOW(), NOW())";
			try (PreparedStatement stmt = conn.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setInt(1, userId); // Use setInt here
				stmt.executeUpdate();

				try (ResultSet rs = stmt.getGeneratedKeys()) {
					if (rs.next()) {
						cartId = rs.getInt(1);
					} else {
						throw new SQLException("Creating cart failed, no ID obtained.");
					}
				}
			}
		}

		return cartId;
	}

	// Add or update item in cart
	public void addOrUpdateCartItem(int cartId, String productId, double price) throws Exception {
		try (Connection conn = DBConnection.getConnection()) {
			String checkSQL = "SELECT quantity FROM cart_items WHERE cartid = ? AND productid = ?";
			try (PreparedStatement stmt = conn.prepareStatement(checkSQL)) {
				stmt.setInt(1, cartId);
				stmt.setString(2, productId);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						int qty = rs.getInt("quantity");
						String updateSQL = "UPDATE cart_items SET quantity = ?, price = ?, updated_at = NOW() WHERE cartid = ? AND productid = ?";
						try (PreparedStatement updateStmt = conn.prepareStatement(updateSQL)) {
							updateStmt.setInt(1, qty + 1);
							updateStmt.setDouble(2, price);
							updateStmt.setInt(3, cartId);
							updateStmt.setString(4, productId);
							updateStmt.executeUpdate();
						}
					} else {
						String insertSQL = "INSERT INTO cart_items (cartid, productid, quantity, price, created_at, updated_at) VALUES (?, ?, 1, ?, NOW(), NOW())";
						try (PreparedStatement insertStmt = conn.prepareStatement(insertSQL)) {
							insertStmt.setInt(1, cartId);
							insertStmt.setString(2, productId);
							insertStmt.setDouble(3, price);
							insertStmt.executeUpdate();
						}
					}
				}
			}
		}
	}
	
	
	public List<CartItem> getCartItemsByUserId(int userId) {
	    List<CartItem> cartItems = new ArrayList<>();

	    try {
	        Connection conn = DBConnection.getConnection();

	        // First get cart ID for the given user
	        String getCartSQL = "SELECT cartid FROM cart WHERE userid = ?";
	        PreparedStatement cartStmt = conn.prepareStatement(getCartSQL);
	        cartStmt.setInt(1, userId);
	        ResultSet cartRs = cartStmt.executeQuery();

	        if (cartRs.next()) {
	            int cartId = cartRs.getInt("cartid");

	            // Now fetch items using cart ID
	            String sql = "SELECT * FROM cart_items WHERE cartid = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, cartId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                CartItem item = new CartItem();
	                item.setCartItemId(rs.getInt("cartitemid"));
	                item.setCartId(rs.getInt("cartid"));
	                item.setProductId(rs.getInt("productid"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setPrice(rs.getDouble("price")); // Add this line if your model has price
	                cartItems.add(item);
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return cartItems;
	}

	
	public int getCartIdByUserId(int userId) {
	    int cartId = -1;
	    String sql = "SELECT cartId FROM cart WHERE userId = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, userId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            cartId = rs.getInt("cartId");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return cartId;
	}
	
	public boolean removeItemFromCart(int cartId, int productId) {
	    boolean success = false;
	    String sql = "DELETE FROM cart_items WHERE cartId = ? AND productId = ?";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, cartId);
	        stmt.setInt(2, productId);

	        int rowsAffected = stmt.executeUpdate();
	        success = rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return success;
	}
	
	public boolean updateQuantity(int userId, int productId, int delta) {
	    boolean success = false;
	    try (Connection conn = DBConnection.getConnection()) {
	        // Get the cart ID for the user
	        int cartId = getCartIdByUserId(userId);
	        if (cartId == -1) {
	            // No cart found
	            return false;
	        }

	        // Check current quantity of the product in the cart
	        String selectSQL = "SELECT quantity FROM cart_items WHERE cartid = ? AND productid = ?";
	        try (PreparedStatement psSelect = conn.prepareStatement(selectSQL)) {
	            psSelect.setInt(1, cartId);
	            psSelect.setInt(2, productId);
	            try (ResultSet rs = psSelect.executeQuery()) {
	                if (rs.next()) {
	                    int currentQty = rs.getInt("quantity");
	                    int newQty = currentQty + delta;

	                    if (newQty <= 0) {
	                        // Remove the product from cart if quantity <= 0
	                        String deleteSQL = "DELETE FROM cart_items WHERE cartid = ? AND productid = ?";
	                        try (PreparedStatement psDelete = conn.prepareStatement(deleteSQL)) {
	                            psDelete.setInt(1, cartId);
	                            psDelete.setInt(2, productId);
	                            psDelete.executeUpdate();
	                        }
	                    } else {
	                        // Update quantity with new value
	                        String updateSQL = "UPDATE cart_items SET quantity = ?, updated_at = NOW() WHERE cartid = ? AND productid = ?";
	                        try (PreparedStatement psUpdate = conn.prepareStatement(updateSQL)) {
	                            psUpdate.setInt(1, newQty);
	                            psUpdate.setInt(2, cartId);
	                            psUpdate.setInt(3, productId);
	                            psUpdate.executeUpdate();
	                        }
	                    }
	                    success = true;
	                } else if (delta > 0) {
	                    // If item does not exist and delta > 0, add new item with quantity = delta (usually 1)
	                    String insertSQL = "INSERT INTO cart_items (cartid, productid, quantity, price, created_at, updated_at) VALUES (?, ?, ?, 0, NOW(), NOW())";
	                    try (PreparedStatement psInsert = conn.prepareStatement(insertSQL)) {
	                        psInsert.setInt(1, cartId);
	                        psInsert.setInt(2, productId);
	                        psInsert.setInt(3, delta);
	                        psInsert.executeUpdate();
	                        success = true;
	                    }
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return success;
	}



	
}
