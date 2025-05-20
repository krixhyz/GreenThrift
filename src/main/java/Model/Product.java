package Model;

import java.util.Date;

public class Product {
    private int productID;
    private String name;
    private String description;
    private double price;
    private int stock;
    private Date dateAdded;
    private int categoryID;
    private int adminID;

    // Default constructor
    public Product() {}

    // Constructor without productID and dateAdded (for adding new products)
    public Product(String name, String description, double price, int stock, int categoryID, int adminID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryID = categoryID;
        this.adminID = adminID;
        this.dateAdded = new Date(); // Or leave null and let DB handle it
    }

    // Full constructor (e.g., from database)
    public Product(int productID, String name, String description, double price, int stock, Date dateAdded, int categoryID, int adminID) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.dateAdded = dateAdded;
        this.categoryID = categoryID;
        this.adminID = adminID;
    }

    // Getters and Setters

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

	public void setImageUrl(String string) {
		// TODO Auto-generated method stub
		
	}
}
