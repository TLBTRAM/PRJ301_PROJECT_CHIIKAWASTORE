-- Table of Products
CREATE TABLE tblProducts(
    ProductID CHAR(5) PRIMARY KEY,
    Title VARCHAR(200) NOT NULL,
    Brand VARCHAR(100) NOT NULL,
    Category NVARCHAR(100) NOT NULL,
    Price DECIMAL(10,2),
    Quantity INT DEFAULT 0,
    Image TEXT NULL
);

INSERT INTO tblProducts (ProductID, Title, Brand, Category, Price, Quantity) VALUES
('P0001', 'Chiikawa Wearing Cute Pajamas', 'Miniso', 'Clothing', 165000, 20),
('P0002', 'Hachiware Wearing Baseball Jacket', 'Miniso', 'Clothing', 175000, 51),
('P0003', 'Chiikawa Cute Keychain for Phone', 'Mini Good', 'Toys', 15000, 8),
('P0004', 'ChiikawaBaka Phone Case', 'PhoneCase', 'Phone Cases', 285000, 15),
('P0005', 'Chiikawa ATM Card Sticker', 'UnanaunaBank', 'Other', 20000, 12),
('P0006', 'Chiikawa Shoulder Bag', 'Mini Good', 'Stationery', 155000, 20),
('P0007', 'Large Chiikawa Plush Toy', 'Mini Good', 'Toys', 270000, 7),
('P0008', 'Chiikawa Notebook', 'Miniso', 'Stationery', 50000, 9),
('P0009', 'Chiikawa Hair Tie - Rubber Band', 'chiikawajp', 'Other', 60000, 6),
('P0010', 'Chiikawa Sticker Set (100 pieces)', 'chiikawajp', 'Other', 100000, 25),
('P0011', 'Hachiware Plush Toy', 'Mini Good', 'Toys', 220000, 10),
('P0012', 'Chiikawa Fountain Pen', 'Miniso', 'Stationery', 45000, 30),
('P0013', 'Chiikawa Cute Bag', 'Mini Good', 'Clothing', 135000, 15),
('P0014', 'Hachiware Phone Case', 'PhoneCase', 'Phone Cases', 260000, 20),
('P0015', 'Chiikawa Scarf', 'Miniso', 'Clothing', 95000, 18),
('P0016', 'Chiikawa Keychain Strap', 'chiikawajp', 'Toys', 30000, 22),
('P0017', 'Balloon Usagi Plush Toy', 'Mini Good', 'Toys', 185000, 12),
('P0018', 'Chiikawa Kawaii Notebook', 'Miniso', 'Stationery', 55000, 25),
('P0019', 'Hachiware Sticker Set (50 pieces)', 'chiikawajp', 'Other', 80000, 20),
('P0020', 'Chiikawa Charm Bracelet', 'chiikawajp', 'Other', 125000, 8);
GO