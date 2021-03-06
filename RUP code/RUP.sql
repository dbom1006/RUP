USE [RUP]
GO
/****** Object:  Table [dbo].[CUOCDAUGIA]    Script Date: 30/11/2016 10:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CUOCDAUGIA](
	[MaTV] [int] NOT NULL,
	[MaPDG] [nchar](10) NOT NULL,
	[ThoiDiem] [datetime] NULL,
	[GiaDuocDat] [int] NULL,
 CONSTRAINT [PK_CUOCDAUGIA] PRIMARY KEY CLUSTERED 
(
	[MaTV] ASC,
	[MaPDG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHIENDAUGIA]    Script Date: 30/11/2016 10:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIENDAUGIA](
	[MaPDG] [nchar](10) NOT NULL,
	[TieuDe] [nvarchar](255) NULL,
	[GiaKhoiDiem] [real] NULL,
	[GiaToiThieu] [real] NULL,
	[MoTa] [nvarchar](255) NULL,
	[HinhAnh] [nvarchar](255) NULL,
	[TGBatDau] [datetime] NULL,
	[TGKetThuc] [datetime] NULL,
	[GanThe] [text] NULL,
	[MaTV] [int] NULL,
 CONSTRAINT [PK_PHIENDAUGIA] PRIMARY KEY CLUSTERED 
(
	[MaPDG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 30/11/2016 10:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[MaSP] [nchar](10) NOT NULL,
	[TenSP] [nvarchar](255) NULL,
	[MoTa] [nvarchar](255) NULL,
	[HinhAnh] [nvarchar](50) NULL,
	[GanThe] [nvarchar](255) NULL,
	[MaTV] [int] NULL,
	[MaPDG] [nchar](10) NULL,
 CONSTRAINT [PK_SANPHAM] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[THANHVIEN]    Script Date: 30/11/2016 10:11:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[THANHVIEN](
	[MaTV] [int] IDENTITY(1,1) NOT NULL,
	[TenTV] [nvarchar](50) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [text] NULL,
	[Email] [varchar](45) NULL,
	[SDT] [varchar](12) NULL,
	[SoDu] [real] NULL,
	[TrangThai] [bit] NULL,
	[Password] [varchar](50) NULL,
 CONSTRAINT [PK_THANHVIEN] PRIMARY KEY CLUSTERED 
(
	[MaTV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[CUOCDAUGIA] ([MaTV], [MaPDG], [ThoiDiem], [GiaDuocDat]) VALUES (1, N'1         ', CAST(N'2016-11-29 21:59:45.000' AS DateTime), 17000)
INSERT [dbo].[CUOCDAUGIA] ([MaTV], [MaPDG], [ThoiDiem], [GiaDuocDat]) VALUES (2, N'2         ', CAST(N'2016-11-29 19:56:54.000' AS DateTime), 17100)
INSERT [dbo].[CUOCDAUGIA] ([MaTV], [MaPDG], [ThoiDiem], [GiaDuocDat]) VALUES (3, N'2         ', CAST(N'2016-11-29 19:34:54.000' AS DateTime), 17500)
INSERT [dbo].[PHIENDAUGIA] ([MaPDG], [TieuDe], [GiaKhoiDiem], [GiaToiThieu], [MoTa], [HinhAnh], [TGBatDau], [TGKetThuc], [GanThe], [MaTV]) VALUES (N'          ', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[PHIENDAUGIA] ([MaPDG], [TieuDe], [GiaKhoiDiem], [GiaToiThieu], [MoTa], [HinhAnh], [TGBatDau], [TGKetThuc], [GanThe], [MaTV]) VALUES (N'1         ', N'Iphone7', 10000, 500000, N'Sản phẩm xách tay mới hoàn toàn 100%, nguyên seal.', N'iphone7.png', CAST(N'2016-11-29 18:12:36.000' AS DateTime), CAST(N'2016-11-30 12:12:36.000' AS DateTime), NULL, 1)
INSERT [dbo].[PHIENDAUGIA] ([MaPDG], [TieuDe], [GiaKhoiDiem], [GiaToiThieu], [MoTa], [HinhAnh], [TGBatDau], [TGKetThuc], [GanThe], [MaTV]) VALUES (N'2         ', N'Note 7', 12333, 150000, N'Sản phẩm fullbox 100% chính hãng từ SamSung Việt Nam', N'note7.png', CAST(N'2016-11-30 13:12:36.000' AS DateTime), CAST(N'2016-11-30 13:12:36.000' AS DateTime), NULL, 2)
INSERT [dbo].[SANPHAM] ([MaSP], [TenSP], [MoTa], [HinhAnh], [GanThe], [MaTV], [MaPDG]) VALUES (N'1         ', N'Iphone 7 Plus', N'Sản phẩm xách tay mới hoàn toàn 100%, nguyên seal.', N'iphone7.png', N'iphone7 plus', 1, N'1         ')
INSERT [dbo].[SANPHAM] ([MaSP], [TenSP], [MoTa], [HinhAnh], [GanThe], [MaTV], [MaPDG]) VALUES (N'2         ', N'Galaxy Note 7', N'Sản phẩm fullbox 100% chính hãng từ SamSung Việt Nam', N'note7.png', N'galaxy note 7', 2, N'2         ')
SET IDENTITY_INSERT [dbo].[THANHVIEN] ON 

INSERT [dbo].[THANHVIEN] ([MaTV], [TenTV], [GioiTinh], [NgaySinh], [DiaChi], [Email], [SDT], [SoDu], [TrangThai], [Password]) VALUES (1, N'Ngọc Tuấn', 1, CAST(N'1995-07-16' AS Date), N'Hu?', N'phamnhungoctuan@gmail.com', N'01648645043', 13000, 1, N'12345')
INSERT [dbo].[THANHVIEN] ([MaTV], [TenTV], [GioiTinh], [NgaySinh], [DiaChi], [Email], [SDT], [SoDu], [TrangThai], [Password]) VALUES (2, N'Đào', 1, CAST(N'1994-04-20' AS Date), N'Hu?', N'daodidem@gmail.com', N'01236466456', 200000, 1, NULL)
INSERT [dbo].[THANHVIEN] ([MaTV], [TenTV], [GioiTinh], [NgaySinh], [DiaChi], [Email], [SDT], [SoDu], [TrangThai], [Password]) VALUES (3, N'1', 1, CAST(N'1994-04-20' AS Date), N's', N'sss', N'sss', 45555, 1, NULL)
INSERT [dbo].[THANHVIEN] ([MaTV], [TenTV], [GioiTinh], [NgaySinh], [DiaChi], [Email], [SDT], [SoDu], [TrangThai], [Password]) VALUES (4, N'Đức', NULL, NULL, NULL, N'duclo@gmail.com', NULL, NULL, NULL, N'12345')
INSERT [dbo].[THANHVIEN] ([MaTV], [TenTV], [GioiTinh], [NgaySinh], [DiaChi], [Email], [SDT], [SoDu], [TrangThai], [Password]) VALUES (13, N'phamnhungoctuan@gmail.com', NULL, NULL, NULL, N'phamnhungoctuan1@gmail.com', NULL, NULL, NULL, N'11111')
SET IDENTITY_INSERT [dbo].[THANHVIEN] OFF
ALTER TABLE [dbo].[CUOCDAUGIA]  WITH CHECK ADD  CONSTRAINT [FK_CUOCDAUGIA_PHIENDAUGIA] FOREIGN KEY([MaPDG])
REFERENCES [dbo].[PHIENDAUGIA] ([MaPDG])
GO
ALTER TABLE [dbo].[CUOCDAUGIA] CHECK CONSTRAINT [FK_CUOCDAUGIA_PHIENDAUGIA]
GO
ALTER TABLE [dbo].[CUOCDAUGIA]  WITH CHECK ADD  CONSTRAINT [FK_CUOCDAUGIA_THANHVIEN] FOREIGN KEY([MaTV])
REFERENCES [dbo].[THANHVIEN] ([MaTV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CUOCDAUGIA] CHECK CONSTRAINT [FK_CUOCDAUGIA_THANHVIEN]
GO
ALTER TABLE [dbo].[PHIENDAUGIA]  WITH CHECK ADD  CONSTRAINT [FK_PHIENDAUGIA_THANHVIEN] FOREIGN KEY([MaTV])
REFERENCES [dbo].[THANHVIEN] ([MaTV])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PHIENDAUGIA] CHECK CONSTRAINT [FK_PHIENDAUGIA_THANHVIEN]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD  CONSTRAINT [FK_SANPHAM_PHIENDAUGIA] FOREIGN KEY([MaPDG])
REFERENCES [dbo].[PHIENDAUGIA] ([MaPDG])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SANPHAM] CHECK CONSTRAINT [FK_SANPHAM_PHIENDAUGIA]
GO
ALTER TABLE [dbo].[SANPHAM]  WITH CHECK ADD  CONSTRAINT [FK_SANPHAM_THANHVIEN] FOREIGN KEY([MaTV])
REFERENCES [dbo].[THANHVIEN] ([MaTV])
GO
ALTER TABLE [dbo].[SANPHAM] CHECK CONSTRAINT [FK_SANPHAM_THANHVIEN]
GO
