INSERT INTO category (CategoryID, Name, Description) VALUES
(1, 'Clothes', 'Second-hand and vintage clothing items'),
(2, 'Accessories', 'Jewelry, bags, and other fashion accessories');




INSERT INTO products (Name, Description, Price, Stock, DateAdded, CategoryID, AdminID)
VALUES 
-- Clothes
('Vintage Kurta Set', 'Lightly used cotton kurta with dupatta, size M', 1200.00, 5, CURDATE(), 1, 10),
('Denim Jacket', 'Pre-loved Levi’s denim jacket, unisex, size L', 2500.00, 3, CURDATE(), 1, 10),
('Woolen Sweater', 'Wool sweater from Pokhara, size M, excellent condition', 1500.00, 4, CURDATE(), 1, 10),
('Tibetan Style Coat', 'Heavy winter coat with Tibetan patterns, size L', 3200.00, 2, CURDATE(), 1, 10),
('Saree Collection', 'Vintage silk saree with embroidered border', 2200.00, 3, CURDATE(), 1, 10),
('Boho Skirt', 'Colorful cotton skirt, free size', 900.00, 5, CURDATE(), 1, 10),

-- Accessories
('Leather Sling Bag', 'Brown leather sling bag, imported, gently used', 1800.00, 2, CURDATE(), 2, 10),
('Silver Earrings', 'Traditional Newari style silver earrings', 950.00, 6, CURDATE(), 2, 10),
('Woolen Cap', 'Hand-knitted wool cap, various colors', 400.00, 8, CURDATE(), 2, 10),
('Beaded Necklace', 'Colorful beaded necklace from Thamel artisans', 650.00, 5, CURDATE(), 2, 10),
('Embroidered Shawl', 'Warm shawl with Nepali embroidery, cotton blend', 1250.00, 3, CURDATE(), 2, 10);
