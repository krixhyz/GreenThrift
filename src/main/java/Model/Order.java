
package Model;

import java.math.BigDecimal;
import java.sql.Date;

public class Order {
    private int orderID;
    private Date orderDate;
    private BigDecimal totalAmount;
    private String orderStatus;
    private Integer userID;
    private String paymentMethod;
    private String address;
    private String fullName;
    private String phone;   
    private int productID;  
    private int quantity; 

    // Getters and Setters
    public int getOrderID() { return orderID; }
    public void setOrderID(int orderID) { this.orderID = orderID; }
    
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    
    public Integer getUserID() { return userID; }
    public void setUserID(Integer userID) { this.userID = userID; }
    
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    
    public int getProductID() { return productID; }
    public void setProductID(int productID) { this.productID = productID; }
    
    public int getQuantity() { return quantity; }  
    public void setQuantity(int quantity) {       
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity must be at least 1");
        }
        this.quantity = quantity;
    }
    
    @Override
    public String toString() {
        return "Order{" +
               "orderID=" + orderID +
               ", userID=" + userID +
               ", productID=" + productID +
               ", fullName='" + fullName + '\'' +
               ", address='" + address + '\'' +
               ", phone='" + phone + '\'' +
               ", paymentMethod='" + paymentMethod + '\'' +
               ", totalAmount=" + totalAmount +
               ", orderStatus='" + orderStatus + '\'' +
               ", orderDate=" + orderDate +
               '}';
    }
}