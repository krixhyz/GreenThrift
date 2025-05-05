--CREATE DATABASE coursework;
--USE coursework;

-- Create users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    role VARCHAR(20) NOT NULL DEFAULT 'user',
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone_number VARCHAR(15),
    image_path VARCHAR(255)
);

-- Create category table
CREATE TABLE category (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Description TEXT
);

-- Create products table
CREATE TABLE products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Description TEXT,
    Price DECIMAL(10,2),
    Stock INT,
    DateAdded DATE,
    CategoryID INT,
    AdminID INT,
    FOREIGN KEY (CategoryID) REFERENCES category(CategoryID),
    FOREIGN KEY (AdminID) REFERENCES users(id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Create cart table
CREATE TABLE cart (
    CartID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES users(id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Create cart_items table
CREATE TABLE cart_items (
    CartItemID INT AUTO_INCREMENT PRIMARY KEY,
    CartID INT,
    ProductID INT,
    Quantity INT,
    FOREIGN KEY (CartID) REFERENCES cart(CartID),
    FOREIGN KEY (ProductID) REFERENCES products(ProductID)
);

-- Create order table
CREATE TABLE `order` (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDate DATE,
    TotalAmount DECIMAL(10,2),
    Status VARCHAR(50),
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES users(id) ON DELETE SET NULL ON UPDATE CASCADE
);

-- Create order_items table
CREATE TABLE order_items (
    OrderItemID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    ProductID INT,
    Quantity INT,
    PriceAtPurchase DECIMAL(10,2),
    FOREIGN KEY (OrderID) REFERENCES `order`(OrderID),
    FOREIGN KEY (ProductID) REFERENCES products(ProductID)
);

-- Create payment table
CREATE TABLE payment (
    PaymentID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    PaymentDate DATE,
    AmountPaid DECIMAL(10,2),
    PaymentMethod VARCHAR(50),
    PaymentStatus VARCHAR(50),
    FOREIGN KEY (OrderID) REFERENCES `order`(OrderID)
);