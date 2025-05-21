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
    private String imageUrl;

    // Default constructor
    public Product() {}

    // Constructor for adding new products (without productID and dateAdded)
    public Product(String name, String description, double price, int stock, int categoryID, int adminID, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.categoryID = categoryID;
        this.adminID = adminID;
        this.imageUrl = imageUrl;
        this.dateAdded = new Date(); // Set current date, or let DB handle it
    }

    // Full constructor (e.g., from database)
    public Product(int productID, String name, String description, double price, int stock, Date dateAdded, int categoryID, int adminID, String imageUrl) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.dateAdded = dateAdded;
        this.categoryID = categoryID;
        this.adminID = adminID;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}