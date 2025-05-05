
-- Seed data for User table
INSERT INTO `User` (FirstName, LastName, Email, PhoneNumber, UserName, Password, Role) VALUES
('Sita', 'Thapa', 'sita.thapa@gmail.com', '9800000001', 'sitathapa', 'pass123', 'customer'),
('Ram', 'Shrestha', 'ram.shrestha@gmail.com', '9800000002', 'ramshrestha', 'pass456', 'customer'),
('Kiran', 'Basnet', 'kiran.basnet@gmail.com', '9800000003', 'kiranb', 'admin'),
('Laxmi', 'Gurung', 'laxmi.gurung@gmail.com', '9800000004', 'laxmig', 'admin');

-- Seed data for Category table
INSERT INTO Category (Name, Description) VALUES
('Men's Wear', 'Second-hand clothing for men'),
('Women's Wear', 'Used fashion clothing for women'),
('Winter Wear', 'Pre-owned jackets, sweaters and coats'),
('Ethnic Wear', 'Traditional Nepali dresses and sets');

-- Seed data for Products table
INSERT INTO Products (Name, Description, Price, Stock, DateAdded, UserID, CategoryID) VALUES
('Vintage Denim Jacket', 'Men's classic denim jacket in good condition', 1500.00, 10, '2025-05-01', 3, 3),
('Embroidered Kurti', 'Beautiful kurti with traditional embroidery', 1200.00, 15, '2025-05-01', 4, 4),
('Woolen Sweater', 'Thick woolen sweater for winter', 1000.00, 20, '2025-05-01', 3, 3),
('Women's Saree Set', 'Traditional Nepali saree with blouse', 2000.00, 5, '2025-05-01', 4, 4),
('Men's Formal Shirt', 'Used but clean white formal shirt', 700.00, 8, '2025-05-01', 3, 1);

-- Seed data for Cart table
INSERT INTO Cart (UserID) VALUES
(1), (2);

-- Seed data for Cart_items table
INSERT INTO Cart_items (CartID, ProductID, Quantity) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 5, 1);

-- Seed data for Order table
INSERT INTO `Order` (UserID, OrderDate, TotalAmount, Status) VALUES
(1, '2025-05-02', 3900.00, 'Processing'),
(2, '2025-05-02', 700.00, 'Delivered');

-- Seed data for Order_items table
INSERT INTO Order_items (OrderID, ProductID, Quantity, PriceAtPurchase) VALUES
(1, 1, 1, 1500.00),
(1, 2, 2, 1200.00),
(2, 5, 1, 700.00);

-- Seed data for Payment table
INSERT INTO Payment (OrderID, PaymentDate, AmountPaid, PaymentMethod, PaymentStatus) VALUES
(1, '2025-05-02', 3900.00, 'Esewa', 'Paid'),
(2, '2025-05-02', 700.00, 'Cash on Delivery', 'Paid');
