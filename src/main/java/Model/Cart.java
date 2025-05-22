package Model;

import java.util.Date;

public class Cart {
    private int cartId;
    private int userId;
    private Date createdAt;
    private Date updatedAt;

    // Constructor, getters, setters
    public Cart() {}

    public Cart(int cartId, int userId, Date createdAt, Date updatedAt) {
        this.cartId = cartId;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getCartId() { 
    	return cartId; 
    }
    
    public void setCartId(int cartId) { 
    	this.cartId = cartId; 
    }

    public int getUserId() { 
    	return userId; 
    }
    
    public void setUserId(int userId) { 
    	this.userId = userId; 
    }

    public Date getCreatedAt() { 
    	return createdAt; 
    }
    
    public void setCreatedAt(Date createdAt) { 
    	this.createdAt = createdAt; 
    }

    public Date getUpdatedAt() {
    	return updatedAt; 
    }
    
    public void setUpdatedAt(Date updatedAt) { 
    	this.updatedAt = updatedAt; 
    }
}
