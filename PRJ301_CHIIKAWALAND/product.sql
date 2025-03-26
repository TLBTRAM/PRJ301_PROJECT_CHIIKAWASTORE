-- Create table
CREATE TABLE tblProducts(
    ProductID CHAR(5) PRIMARY KEY,
    Title NVARCHAR(200) NOT NULL,
    Brand NVARCHAR(100) NOT NULL,
    Category NVARCHAR(100) NOT NULL,
    Price DECIMAL(10,2),
    Quantity INT DEFAULT 0,
    Image TEXT NULL
);

-- Insert sample data with Category in English
INSERT INTO tblProducts (ProductID, Title, Brand, Category, Price, Quantity) VALUES
('P0001', N'Chiikawa Wearing Cute Pajamas', N'Miniso', N'Clothing', 165000, 20),
('P0002', N'Hachiware Wearing Baseball Jacket', N'Miniso', N'Clothing', 175000, 51),
('P0003', N'Chiikawa Cute Keychain for Phone', N'Mini Good', N'Toys', 15000, 8),
('P0004', N'ChiikawaBaka Phone Case', N'PhoneCase', N'Phone Cases', 285000, 15),
('P0005', N'Chiikawa ATM Card Sticker', N'UnanaunaBank', N'Other', 20000, 12),
('P0006', N'Chiikawa Shoulder Bag', N'Mini Good', N'Stationery', 155000, 20),
('P0007', N'Large Chiikawa Plush Toy', N'Mini Good', N'Toys', 270000, 7),
('P0008', N'Chiikawa Notebook', N'Miniso', N'Stationery', 50000, 9),
('P0009', N'Chiikawa Hair Tie - Rubber Band', N'chiikawajp', N'Other', 60000, 6),
('P0010', N'Chiikawa Sticker Set (100 pieces)', N'chiikawajp', N'Other', 100000, 25),
('P0011', N'Hachiware Plush Toy', N'Mini Good', N'Toys', 220000, 10),
('P0012', N'Chiikawa Fountain Pen', N'Miniso', N'Stationery', 45000, 30),
('P0013', N'Chiikawa Cute Tote Bag', N'Mini Good', N'Clothing', 135000, 15),
('P0014', N'Hachiware Phone Case', N'PhoneCase', N'Phone Cases', 260000, 20),
('P0015', N'Chiikawa Scarf', N'Miniso', N'Clothing', 95000, 18),
('P0016', N'Chiikawa Keychain Strap', N'chiikawajp', N'Toys', 30000, 22),
('P0017', N'Mini Usagi Plush Toy', N'Mini Good', N'Toys', 185000, 12),
('P0018', N'Chiikawa Kawaii Notebook', N'Miniso', N'Stationery', 55000, 25),
('P0019', N'Hachiware Sticker Set (50 pieces)', N'chiikawajp', N'Other', 80000, 20),
('P0020', N'Chiikawa Charm Bracelet', N'chiikawajp', N'Other', 125000, 8);
