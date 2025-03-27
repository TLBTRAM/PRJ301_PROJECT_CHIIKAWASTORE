-- Tạo database
CREATE DATABASE prj301_1820_prjnhomchiikawa_final
GO

-- Sử dụng database vừa tạo
USE prj301_1820_prjnhomchiikawa_final
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
('user01', N'Nguyễn Văn Anh', 'US', 'user123'),
('user02', N'Trần Thị Bình', 'US', 'user456'),
('user03', N'Lê Hoàng Nam', 'US', 'pass789'),
('user04', N'Phạm Thị Hồng', 'US', 'hong999');