-- Tạo database
CREATE DATABASE prj301_1820_prjnhomchiikawa
GO

-- Sử dụng database vừa tạo
USE prj301_1820_prjnhomchiikawa
GO

-- Tạo bảng tblUsers
CREATE TABLE tblUsers (
    userID varchar(50) PRIMARY KEY,
    fullName nvarchar(100) NOT NULL,
    roleID char(2) NOT NULL,
    password varchar(50) NOT NULL
);
GO

-- Thêm 3 người dùng mẫu với tên tiếng Việt
INSERT INTO tblUsers (userID, fullName, roleID, password) VALUES
('admin01', N'Quản Trị Viên', 'AD', 'admin123'),
('user001', N'Nguyễn Văn Anh', 'US', 'user123'),
('user002', N'Trần Thị Bình', 'US', 'user456'),
('user003', N'Lê Hoàng Nam', 'US', 'pass789'),
('user004', N'Phạm Thị Hồng', 'US', 'hong999'),
('user005', N'Bùi Văn Dũng', 'US', 'dung555'),
('user006', N'Đặng Minh Khang', 'US', 'khang888'),
('user007', N'Huỳnh Ngọc Lan', 'US', 'lan321'),
('user008', N'Vũ Thị Mai', 'US', 'mai654'),
('user009', N'Trương Quốc Bảo', 'US', 'bao777'),
('user010', N'Ngô Thanh Tùng', 'US', 'tung111');
GO