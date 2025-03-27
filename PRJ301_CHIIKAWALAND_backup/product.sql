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

-- Insert sample data with updated Brand
INSERT INTO tblProducts (ProductID, Title, Brand, Category, Price, Quantity) VALUES
('P0001', N'Đồ ngủ Chiikawa dễ thương', N'Miniso', N'Quần áo', 165000, 20),
('P0002', N'Hachiware mặc áo khoác bóng chày', N'Miniso', N'Đồ chơi', 175000, 51),
('P0003', N'Móc khóa Chiikawa dễ thương cho điện thoại', N'Mini Good', N'Đồ chơi', 15000, 8),
('P0004', N'Ốp điện thoại ChiikawaBaka', N'ChiikawaCase', N'Ốp điện thoại', 285000, 15),
('P0005', N'Tấm dán thẻ ATM Chiikawa', N'UnanaunaBank', N'Liinh Tiinh', 20000, 12),
('P0006', N'Túi đeo Chiikawa', N'Mini Good', N'Văn phòng phẩm', 155000, 20),
('P0007', N'Gấu bông Chiikawa cỡ lớn', N'Mini Good', N'Đồ chơi', 270000, 7),
('P0008', N'Sổ tay Chiikawa', N'Miniso', N'Văn phòng phẩm', 50000, 9),
('P0009', N'Dây buộc tóc Chiikawa', N'Chiikawajp', N'Liinh Tiinh', 60000, 6),
('P0010', N'Bộ sticker Chiikawa (100 miếng)', N'Chiikawajp', N'Liinh Tiinh', 100000, 25),
('P0011', N'Gấu bông Hachiware', N'Mini Good', N'Đồ chơi', 220000, 10),
('P0012', N'Bút máy Chiikawa', N'Miniso', N'Văn phòng phẩm', 45000, 30),
('P0013', N'Túi Chiikawa dễ thương', N'Mini Good', N'Quần áo', 135000, 15),
('P0014', N'Ốp điện thoại Hachiware', N'ChiikawaCase', N'Ốp điện thoại', 260000, 20),
('P0015', N'Mũ và khăn quàng Chiikawa', N'Miniso', N'Quần áo', 95000, 18),
('P0016', N'Dây móc khóa Chiikawa', N'Chiikawajp', N'Đồ chơi', 30000, 22),
('P0017', N'Mini Usagi', N'Mini Good', N'Đồ chơi', 185000, 12),
('P0018', N'Sổ tay Chiikawa Kawaii', N'Miniso', N'Văn phòng phẩm', 55000, 25),
('P0019', N'Bộ sticker Hachiware (50 miếng)', N'Chiikawajp', N'Liinh Tiinh', 80000, 20),
('P0020', N'Vòng tay Chiikawa', N'Chiikawajp', N'Liinh Tiinh', 125000, 8);

