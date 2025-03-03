/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mah
 * Created: 04-03-2025
 */

-- Tạo bảng Sách
CREATE TABLE tblProducts(
    ProductID Char(5) PRIMARY KEY,
    Title NVARCHAR(200) NOT NULL,
    Brand NVARCHAR(100) NOT NULL,
    Price DECIMAL(10,2),
    Quantity INT DEFAULT 0,
);

-- Thêm dữ liệu mẫu
INSERT INTO tblProducts (ProductID, Title, Brand, Price, Quantity) VALUES
('P0001', N'Chiikawa Mặc Cute Pajamas', N'Miniso', 165000, 20),
('P0002', N'Hachiware Mặc áo bóng chày', N'Miniso', 175000, 51),
('P0003', N'Móc khóa Chiikawa cute treo điện thoại', N'Mini Good', 15000, 8),
('P0004', N'Ốp lưng ChiikawaBaka', N'PhoneCase', 285000, 15),
('P0005', N'Dán ATM hình Chiikawa', N'UnanaunaBank', 20000, 12),
('P0006', N'Túi đeo Chiikawa', N'Mini Good',155000, 20),
('P0007', N'Gấu bông bự Chiikawa', N'Mini Good', 270000, 7),
('P0008', N'Sổ tay hình Chiikawa', N'Miniso', 50000, 9),
('P0009', N'Chiikawa Dây Buộc Tóc-Dây Cao Su', N'chiikawajp', 60000, 6),
('P0010', N'Sticker Chiikawa 100 hình', N'chiikawajp', 100000, 25);
