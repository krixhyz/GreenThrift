package Model;

import java.util.Date;

public class CartItem {
    private int cartItemId;
    private int cartId;
    private int productId;
    private int quantity;
    private double price;
    private Date createdAt;
    private Date updatedAt;

    // Constructor, getters, setters
    public CartItem() {}
    
    

    public CartItem(int cartItemId, int cartId, int productId, int quantity, double price, Date createdAt,
			Date updatedAt) {
		super();
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	

    public int getCartItemId() { 
    	return cartItemId; 
    }
    
    public void setCartItemId(int cartItemId) { 
    	this.cartItemId = cartItemId; 
    }

    public int getCartId() { 
    	return cartId; 
    }
    
    public void setCartId(int cartId) { 
    	this.cartId = cartId; 
    }

    public int getProductId() { 
    	return productId; 
    }
    
    public void setProductId(int productId) { 
    	this.productId = productId; 
    }

    public int getQuantity() { 
    	return quantity; 
    }
    
    public void setQuantity(int quantity) { 
    	this.quantity = quantity; 
    }

    public double getPrice() { 
    	return price; 
    }
    
    public void setPrice(double price) { 
    	this.price = price; 
    }
}
