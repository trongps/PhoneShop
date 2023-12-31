USE [PhoneShop]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 6/18/2023 10:39:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDM] [nvarchar](5) NOT NULL,
	[TenDM] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
	[DacTinh] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhomTaiKhoan]    Script Date: 6/18/2023 10:39:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhomTaiKhoan](
	[NhomTK] [nvarchar](5) NOT NULL,
	[MoTa] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[NhomTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 6/18/2023 10:39:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](5) NOT NULL,
	[TenSP] [nvarchar](50) NULL,
	[MoTa] [nvarchar](250) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[HinhAnh] [nvarchar](100) NULL,
	[TrangThai] [bit] NULL,
	[MaDM] [nvarchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 6/18/2023 10:39:27 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenTK] [nvarchar](10) NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[TrangThai] [bit] NULL,
	[Email] [nvarchar](50) NULL,
	[NhomTK] [nvarchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[TenTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [TrangThai], [DacTinh]) VALUES (N'DT01', N'Samsung', 1, N'moi1')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [TrangThai], [DacTinh]) VALUES (N'DT02', N'Xiaomi', 1, N'cu')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [TrangThai], [DacTinh]) VALUES (N'DT03', N'iPhone', 1, N'tonkho')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [TrangThai], [DacTinh]) VALUES (N'DT04', N'Oppo', 1, N'abc')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM], [TrangThai], [DacTinh]) VALUES (N'DT05', N'Nokia', 0, N'xyz')
GO
INSERT [dbo].[NhomTaiKhoan] ([NhomTK], [MoTa], [TrangThai]) VALUES (N'KH', N'Khách Hàng', 1)
INSERT [dbo].[NhomTaiKhoan] ([NhomTK], [MoTa], [TrangThai]) VALUES (N'QTV', N'Quản trị viên', 1)
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'IP01', N'iPhone 14 Pro Max', N'Máy Trang Bị Con Chip Apple A16 Bionic Vô Cùng Mạnh Mẽ, Đi Kèm Theo Đó Là Thiết Kế Hình Màn Hình Mới, Hứa Hẹn Mang Lại Những Trải Nghiệm Đầy Mới Mẻ Cho Người Dùng IPhone.', 20, 27090000, N'https://cdn1.viettelstore.vn/Images/Product/ProductImage/1896224739.jpeg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'IP02', N'iPhone 13', N'Máy trang bị con chip Apple A16 Bionic vô cùng mạnh mẽ, đi kèm theo đó là thiết kế hình màn hình mới, hứa hẹn mang lại những trải nghiệm đầy mới mẻ cho người dùng iPhone.', 50, 17090000, N'https://cdn1.viettelstore.vn/images/Product/ProductImage/medium/iPhone-13-Pro-PRM-grn-1.jpg', 1, N'DT03')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'IP03', N'iPhone 12', N'Apple đã chính thức giới thiệu đến người dùng cũng như iFan thế hệ iPhone 12 series mới với hàng loạt tính năng bứt phá', 30, 19990000, N'https://www.duchuymobile.com/images/detailed/37/xanh-la_e4eu-h7_k9ab-0u.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'IP04', N'iPhone SE', N'Apple đã chính thức giới thiệu đến người dùng cũng như iFan thế hệ iPhone se series mới với hàng loạt tính năng bứt phá', 40, 7990000, N'https://cdn.tgdd.vn/Products/Images/42/244141/iphone-se-2022-1-1.jpg', 1, N'DT03')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'IP05', N'iPhone XR', N'Màu xanh dương', 25, 14490000, N'https://product.hstatic.net/200000489025/product/thumb-tgmc_0cbda72f2e0e4f5ab180ce9fd297594c.png', 1, N'DT03')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'IP06', N'iPhone 11', N'Màu đen', 15, 17990000, N'https://www.duchuymobile.com/images/thumbnails/180/180/detailed/27/128gb-my.jpg', 1, N'DT03')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'NK01', N'Nokia G22', N'Thiết Kế Xanh Làm Từ Vật Liệu Thân Thiện Môi Trường. Tiên Phong Giá Trị Bền Vững Theo Thời Gian', 20, 3990000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/d/g/dgtyi8899_.jpg', 1, N'DT05')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'NK02', N'Nokia C21 Plus 2GB 64GB', N'C21 Plus mang trong mình viên pin có dung lượng 5050 mAh, bạn có thể sử dụng liên tục xuyên suốt cả ngày. Đi kèm với đó là chuẩn sạc Micro USB 10 W', 30, 1790000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/n/o/nokia-c21-plus-600x600.jpg', 1, N'DT05')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'NK03', N'Nokia C31 4GB 128GB', N'Điện thoại sở hữu màn hình kích thước lớn lên đến 6.7 inch với thiết kế notch hình giọt nước và viền mỏng, giúp tối ưu màn hình để mang tới không gian hiển thị', 25, 5990000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/1/_/1_250_1.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'NK04', N'NOKIA 7.2 64GB', N'Màn hình: IPS LCD, 6.3", Full HD+ <br> Hệ điều hành: Android 9 Pie (Android One) <br>Camera sau: Chính 48 MP & Phụ 8 MP, 5 MP <br> Camera trước: 20 MP <br>', 40, 7990000, N'https://img.nhabanhang.com/sp/f/295982/nokia-7-2-64gb-486.jpg', 1, N'DT05')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'NK05', N'Nokia C3', N'C31 có ngôn ngữ thiết kế khá giống với các sản phẩm điện thoại Nokia trước đây, với lối thiết kế vân nổi ở phần mặt lưng giúp mang lại cho thiết bị khả năng hạn chế các vết xước', 35, 1990000, N'https://cdn.tgdd.vn/Products/Images/42/292717/nokia-c31-xanh-1-1.jpg', 1, N'DT05')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'NK06', N'Nokia 2.4', N'Là một trong những sản phẩm nổi bật trong phân khúc tầm trung so với các sản phẩm khác. Nokia 2.4 mang đến 1 cách nhìn hoàn toàn mới cho người dùng cả về ngoại hình lẫn chất lượng bên trong.', 15, 2990000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/n/o/nokia-2.4_1_.jpg', 1, N'DT05')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'OP01', N'OPPO Find X5 Pro 5G', N'Máy được hãng cho ra mắt với một diện mạo độc lạ chưa từng có, cùng với đó là những nâng cấp về chất lượng ở camera nhờ sự hợp tác với nhà sản xuất máy ảnh Hasselblad.', 20, 29990000, N'https://cdn.tgdd.vn/Products/Images/42/250622/oppo-find-x5-pro-trang-1.jpg', 1, N'DT04')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'OP02', N'Oppo A93', N'OPPO A93 được trang bị chipset MediaTek Helio P95 tốc độ CPU đạt 2.2 GHz với sức mạnh như thế này thì A93 sẽ không làm bạn thất vọng khi có thể hoạt động tốt với nhiều ứng dụng', 30, 6990000, N'https://cdn.tgdd.vn/Products/Images/42/229056/oppo-a93-trang-14-600x600.jpg', 1, N'DT04')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'OP03', N'Oppo Reno6', N'Sau khi ra mắt OPPO Reno5 chưa lâu thì OPPO lại cho ra mẫu smartphone mới mang tên OPPO Reno6 với hàng loạt cải tiến mới về ngoại hình bên ngoài lẫn hiệu năng bên trong', 25, 10990000, N'https://cdn.tgdd.vn/Products/Images/42/236186/oppo-reno6-bac-1-org.jpg', 1, N'DT04')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'OP04', N'Oppo A53 5G', N'OPPO A53 trang bị màn hình LTPS IPS LCD độ phân giải Full HD+ hỗ trợ dải màu rộng, từ đó hình ảnh hiển thị có sắc màu đa dạng hơn, tỷ lệ màn hình so với thân máy là 90.5%, tốc độ làm tươi 90 Hz và tốc độ lấy mẫu cảm ứng 120 Hz. ', 40, 4490000, N'https://cdn.tgdd.vn/Products/Images/42/231414/oppo-a53-5g-600x600-2-600x600.jpg', 1, N'DT04')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'OP05', N'Oppo A74 5G', N'OPPO A74 5G có thiết kế đặc trưng thường thấy ở các mẫu điện thoại OPPO được ra mắt gần đây, dải sáng phản chiếu đẹp mắt tạo điểm nhấn ở mặt lưng, các đường nét vuốt mỏng dần về cạnh viền', 35, 6990000, N'https://cdn.tgdd.vn/Products/Images/42/236559/oppo-a74-5g-bac-1-org.jpg', 1, N'DT04')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'OP06', N'Oppo F17 Pro', N'Là phiên bản mới nhất của dòng F-series, lần này OPPO F17 Pro được nâng cấp hơn với thiết kế mới siêu mỏng, cụm camera vô cùng mạnh mẽ, công nghệ sạc nhanh VOOC', 15, 7990000, N'https://cdn.tgdd.vn/Products/Images/42/227545/oppo-f17-pro-040320-020342-600x600.jpg', 1, N'DT04')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'SS01', N'Samsung Galaxy S21', N'Máy mỏng 7.9 mm và nhẹ chỉ 177 g, dễ dàng sử dụng bằng 1 tay kể cả với các bạn nữ với lòng bàn tay nhỏ, cho thao tác sử dụng thuận tiện, linh hoạt, cũng tiện bảo quản và mang theo.', 50, 20990000, N'https://cdn.tgdd.vn/Products/Images/42/233090/samsung-galaxy-s21-fe-xanh-1.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'SS02', N'Samsung Galaxy A72', N'Samsung A72 sở hữu thiết kế có nhiều nét tương đồng với những người đàn anh trước đó của mình. A72 có kích thước vô cùng nhỏ gọn, các cạnh viền được thiết kế bo cong', 30, 10990000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/s/a/samsung-galaxy-a72-30.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'SS03', N'Samsung Galaxy A52', N'Samsung Galaxy A52 được khoác lên một diện mạo mới, không còn vẻ bóng bẩy như thế hệ trước, mẫu điện thoại quay về với mặt lưng phẳng được phủ nhám hạn chế dấu vân tay', 40, 7990000, N'https://cdn.tgdd.vn/Products/Images/42/228967/samsung-galaxy-a52-trang-1-org.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'SS04', N'Samsung Galaxy Note 20', N'Màn hình 6.7 inch mở ra góc nhìn lớn hơn, rộng hơn để bạn có thể tận hưởng mọi thước phim, “chiến” game, xử lý hình ảnh, video,… hoàn hảo. Samsung luôn sử dụng những công nghệ tiên tiến nhất cho các sản phẩm smartphone của mình', 20, 16990000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/m/i/mint_final.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'SS05', N'Samsung Galaxy Z Fold2', N'Samsung Z Fold 2 được thiết kế với các góc cạnh được bo cong hoàn hảo mang lại sự chắc chắn khi sử dụng. Tương tư Galaxy Fold đời đầu, thế hệ thứ hai tiếp tục được thiết kế với cơ chế gập theo chiều dọc.', 10, 50990000, N'https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/g/a/galaxy-z-fold2-5g-1.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'SS06', N'Samsung Galaxy M31', N'Dung lượng pin siêu khổng lồ 6000 mAh, 4 camera 64MP đẳng cấp và rất nhiều bất ngờ thú vị khác đang chờ đón bạn trên Samsung Galaxy M31, chiếc điện thoại giá tầm trung nhưng mang lại những trải nghiệm cao cấp.', 35, 5990000, N'https://cdn.tgdd.vn/Products/Images/42/229907/samsung-galaxy-m31-prime-124720-084712-600x600.jpg', 1, N'DT01')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'XM01', N'Xiaomi Mi 11', N'Xiaomi Mi 11, mẫu smartphone cao cấp hàng đầu của Xiaomi với vi xử lý Snapdragon 888 siêu mạnh mẽ, hỗ trợ mạng 5G tân tiến nhất cùng với thiết kế hiện đại, sang trọng. ', 50, 15990000, N'https://cdn.hoanghamobile.com/i/preview/Uploads/2021/03/05/image-removebg-preview-9.png', 1, N'DT02')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'XM02', N'Xiaomi Redmi Note 10', N'Camera 48 MP, chip rồng Snapdragon 678 mạnh mẽ cùng nhiều nâng cấp như dung lượng pin 5.000 mAh và hỗ trợ sạc nhanh 33 W tiện lợi', 30, 4990000, N'https://cdn.tgdd.vn/Products/Images/42/222758/xiaomi-redmi-note-10-trang-1-org.jpg', 1, N'DT02')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'XM03', N'Xiaomi Poco X3 Pro', N'Thiết kế khá độc đáo với cụm camera, màn hình mượt mà như lụa, pin khủng, sạc cực nhanh và loa chất lượng', 40, 6990000, N'https://cdn.tgdd.vn/Products/Images/42/235486/xiaomi-poco-x3-pro-600x600-1-600x600.jpg', 1, N'DT02')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'XM04', N'Xiaomi Mi 11 Lite', N'Một phiên bản có ngoại hình rất giống với Xiaomi Mi 11 Lite được ra mắt trước đây. Chiếc smartphone này của Xiaomi mang trong mình một hiệu năng ổn định', 20, 8990000, N'https://cdn.tgdd.vn/Products/Images/42/249427/xiaomi-11-lite-5g-ne-1-1.jpg', 1, N'DT02')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'XM05', N'Xiaomi Redmi Note 9', N'Chiếc smartphone hoàn toàn mới từ nhà Xiaomi, thuộc phân khúc giá rẻ nhưng lại hội tụ đủ các yếu tố như viên pin khủng, dàn camera ấn tượng', 10, 4490000, N'https://cdn.tgdd.vn/Products/Images/42/231462/xiaomi-redmi-note-9-4g-600x600-1-600x600.jpg', 1, N'DT02')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [MoTa], [SoLuong], [DonGia], [HinhAnh], [TrangThai], [MaDM]) VALUES (N'XM06', N'Xiaomi Black Shark 3', N'Diện mạo Black Shark 3 lấy cảm hứng thiết kế từ “chữ X” với 2 phần hình học tam giác được bố trí đối xứng', 35, 11990000, N'https://cdn.tgdd.vn/Products/Images/42/217844/xiaomi-black-shark-3-600x600-2-600x600.jpg', 1, N'DT02')
GO
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [TrangThai], [Email], [NhomTK]) VALUES (N'admin', N'123', 1, N'admin1@myphone.com', N'QTV ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [TrangThai], [Email], [NhomTK]) VALUES (N'khacv', N'12345', 1, N'kha@myphone.com', N'QTV ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [TrangThai], [Email], [NhomTK]) VALUES (N'thuyen', N'12345', 1, N'thuyen@myphone.com', N'QTV ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [TrangThai], [Email], [NhomTK]) VALUES (N'trongps', N'12345', 1, N'trongps@myphone.com', N'QTV ')
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([MaDM])
REFERENCES [dbo].[DanhMuc] ([MaDM])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([NhomTK])
REFERENCES [dbo].[NhomTaiKhoan] ([NhomTK])
GO
