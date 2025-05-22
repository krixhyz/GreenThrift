package DAO;

import Model.Order;
import Util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    // Insert new order
    public boolean placeOrder(Order order) {
        String sql = "INSERT INTO orders (UserID, full_name, payment_method, address, " +
                     "total_amount, order_status, order_date, phone, product_id) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, order.getUserID());
            stmt.setString(2, order.getFullName());
            stmt.setString(3, order.getPaymentMethod());
            stmt.setString(4, order.getAddress());
            stmt.setBigDecimal(5, order.getTotalAmount());

            String status = order.getPaymentMethod().startsWith("Online") ? "Paid" : "Pending";
            stmt.setString(6, status);

            stmt.setTimestamp(7, new Timestamp(order.getOrderDate().getTime()));
            stmt.setString(8, order.getPhone());
            stmt.setInt(9, order.getProductID());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        order.setOrderID(rs.getInt(1));
                        return true;
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error placing order: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    // Get total order count
    public static int getOrderCount() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM orders";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            System.err.println("Error counting orders: " + e.getMessage());
            e.printStackTrace();
        }

        return count;
    }

    // Get recent N orders
    public static List<Order> getRecentOrders(int limit) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT orderID, userID, full_name, order_date, total_amount, " +
                     "payment_method, order_status FROM orders ORDER BY order_date DESC LIMIT ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, limit);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getInt("orderID"));
                order.setUserID(rs.getInt("userID"));
                order.setFullName(rs.getString("full_name"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setTotalAmount(rs.getBigDecimal("total_amount"));
                order.setPaymentMethod(rs.getString("payment_method"));
                order.setOrderStatus(rs.getString("order_status"));

                orders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // Get single order by ID
    public Order getOrderById(int orderId) {
        String sql = "SELECT * FROM orders WHERE OrderID = ?";
        Order order = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                order = new Order();
                order.setOrderID(rs.getInt("OrderID"));
                order.setUserID(rs.getInt("UserID"));
                order.setFullName(rs.getString("full_name"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setProductID(rs.getInt("product_id"));
                order.setTotalAmount(rs.getBigDecimal("total_amount"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setPaymentMethod(rs.getString("payment_method"));
                order.setOrderStatus(rs.getString("order_status"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
}
