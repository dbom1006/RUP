package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DungChung.CDungChung;
import Model.Bean.ChitietBean;
import Model.Bean.CuocdaugiaBean;
import Model.Bean.MaxBean;
import Model.Bean.SanphamBean;
import Model.Bean.XemphienBean;

public class SanphamDAO {
	
	
	public static Connection cn;
	public static void ketnoi() throws Exception{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection(CDungChung.url);
		
		
	}
	
	
	public ArrayList<XemphienBean> getsanpham() throws Exception{
		ketnoi();
		String sql = "SELECT dbo.CUOCDAUGIA.MaPDG, MAX(dbo.CUOCDAUGIA.GiaDuocDat) AS GiaDatMax, dbo.PHIENDAUGIA.TGKetThuc, dbo.PHIENDAUGIA.HinhAnh, dbo.PHIENDAUGIA.MoTa, dbo.PHIENDAUGIA.TieuDe "
				+ "FROM     dbo.CUOCDAUGIA INNER JOIN "
				+ "dbo.PHIENDAUGIA ON dbo.CUOCDAUGIA.MaPDG = dbo.PHIENDAUGIA.MaPDG "
				+ "GROUP BY dbo.CUOCDAUGIA.MaPDG, dbo.PHIENDAUGIA.TGKetThuc, dbo.PHIENDAUGIA.HinhAnh, dbo.PHIENDAUGIA.MoTa, dbo.PHIENDAUGIA.TieuDe";
		
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		ArrayList<XemphienBean> ds = new ArrayList<XemphienBean>();
		while(r.next()){
			String MaSP = r.getString("MaPDG");
			String TenSP = r.getString("TieuDe");
			String MoTa = r.getString("MoTa");
			String HinhAnh = r.getString("HinhAnh");
			int Giakhoidiem = r.getInt("GiaDatMax");
			
			Date d2 = r.getTimestamp("TGKetThuc");
			DateFormat f1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String d1 = f1.format(d2);

			System.out.println(d1);
			XemphienBean s = new XemphienBean(MaSP, TenSP, MoTa, HinhAnh, Giakhoidiem, d1);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	public ArrayList<ChitietBean> getchitiet(String id) throws Exception{
		ketnoi();
		String sql= "SELECT TOP 1 dbo.SANPHAM.TenSP, dbo.SANPHAM.MaSP, dbo.SANPHAM.MaTV, dbo.CUOCDAUGIA.GiaDuocDat, dbo.PHIENDAUGIA.TGKetThuc,dbo.PHIENDAUGIA.MaPDG, dbo.SANPHAM.MoTa, "
				+ "dbo.SANPHAM.HinhAnh, dbo.THANHVIEN.TenTV, dbo.SANPHAM.GanThe FROM dbo.SANPHAM INNER JOIN "
				+ "dbo.CUOCDAUGIA ON dbo.SANPHAM.MaTV = dbo.CUOCDAUGIA.MaTV "
				+ "INNER JOIN dbo.PHIENDAUGIA "
				+ "ON dbo.SANPHAM.MaPDG = dbo.PHIENDAUGIA.MaPDG AND "
				+ "dbo.CUOCDAUGIA.MaPDG = dbo.PHIENDAUGIA.MaPDG "
				+ "INNER JOIN dbo.THANHVIEN ON dbo.SANPHAM.MaTV = dbo.THANHVIEN.MaTV "
				+ "AND dbo.CUOCDAUGIA.MaTV = dbo.THANHVIEN.MaTV "
				+ "AND dbo.PHIENDAUGIA.MaTV = dbo.THANHVIEN.MaTV WHERE (dbo.SANPHAM.MaSP = N'"+id+"')";
		
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		ArrayList<ChitietBean> ds = new ArrayList<ChitietBean>();
		while(r.next()){
			String MaSP = r.getString("MaSP");
			String TenSP = r.getString("TenSP");
			String MoTa = r.getString("MoTa");
			String HinhAnh = r.getString("HinhAnh");
			Date d1 = r.getTimestamp("TGKetThuc");
			String GiaDuocDat = r.getString("GiaDuocDat");
			String TenTV = r.getString("TenTV");
			String GanThe = r.getString("GanThe");
			String MaPDG = r.getString("MaPDG");

			ChitietBean s = new ChitietBean(TenSP, MaSP, TenTV, GiaDuocDat, d1, MoTa, HinhAnh, GanThe, MaPDG);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	
	public ArrayList<CuocdaugiaBean> getphien(String id) throws Exception{
		ketnoi();
		String sql= "SELECT dbo.CUOCDAUGIA.MaPDG, dbo.CUOCDAUGIA.GiaDuocDat, dbo.THANHVIEN.TenTV "
				+ "FROM     dbo.THANHVIEN INNER JOIN "
				+ "dbo.CUOCDAUGIA ON dbo.THANHVIEN.MaTV = dbo.CUOCDAUGIA.MaTV "
				+ "GROUP BY dbo.CUOCDAUGIA.MaPDG, dbo.CUOCDAUGIA.GiaDuocDat, dbo.THANHVIEN.TenTV "
				+ "HAVING (dbo.CUOCDAUGIA.MaPDG = N'"+id+"')";
		
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		ArrayList<CuocdaugiaBean> ds = new ArrayList<CuocdaugiaBean>();
		while(r.next()){
			
			String TenTV = r.getString("TenTV");
			String GiaDuocDat = r.getString("GiaDuocDat");
			CuocdaugiaBean s = new CuocdaugiaBean(TenTV, GiaDuocDat);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	public ArrayList<MaxBean> getmax(String id) throws Exception{
		ketnoi();
		String sql= "SELECT dbo.CUOCDAUGIA.MaPDG, MAX(dbo.CUOCDAUGIA.GiaDuocDat) AS E "
				+ "FROM     dbo.CUOCDAUGIA INNER JOIN "
				+ "dbo.PHIENDAUGIA ON dbo.CUOCDAUGIA.MaPDG = dbo.PHIENDAUGIA.MaPDG "
				+ "GROUP BY dbo.CUOCDAUGIA.MaPDG "
				+ "HAVING (dbo.CUOCDAUGIA.MaPDG = N'"+ id +"')";
		
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		ArrayList<MaxBean> ds = new ArrayList<MaxBean>();
		while(r.next()){
			
			String GiaDuocDat = r.getString("E");
			MaxBean s = new MaxBean(GiaDuocDat);
			ds.add(s);
		}
		r.close();
		return ds;
	}
	
	
	public boolean updatesanpham(String id, String tensp, String mota, String anh, String tag) throws Exception{
		ketnoi();
		String sql = "UPDATE [dbo].[SANPHAM] SET [TenSP] = ?,[MoTa] = ? ,[HinhAnh] = ?,[GanThe] = ? WHERE [MaSP] = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, tensp);
		cmd.setString(2, mota);
		cmd.setString(3, anh);
		cmd.setString(4, tag);
		cmd.setString(5, id);
		int rs= cmd.executeUpdate();//thực thi
		return true;	
	}


	public boolean xoasanpham(String id) throws Exception {
		// TODO Auto-generated method stub
		ketnoi();
		String sql = "DELETE FROM [dbo].[SANPHAM] WHERE MaSP = ?";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, id);
		int rs= cmd.executeUpdate();//thực thi
		return true;	
	}

	public String getidsp() throws Exception {
		ketnoi();
		String sql = "SELECT TOP 1 [MaSP] FROM [RUP].[dbo].[SANPHAM] ORDER BY [MaSP] DESC";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		String id = "";
		while(r.next()){
			id = r.getString("MaSP");	
		}
		r.close();
		return id;
		
	}

	public boolean insertsanpham(String iduser, String tensanpham, String mota, String anh, String tag) throws Exception {
		ketnoi();
		//int id = Integer.parseInt(getidsp())+1;
		String sql = "INSERT INTO [dbo].[SANPHAM] ([MaSP],[TenSP],[MoTa],[HinhAnh],[GanThe]) VALUES ('3','3','3','3','3')";
		PreparedStatement cmd = cn.prepareStatement(sql);
		String them = "r2";
		cmd.setString(1, them);
		cmd.setString(2, tensanpham);
		cmd.setString(3, mota);
		cmd.setString(4, anh);
		cmd.setString(5, tag);
		int rs= cmd.executeUpdate();//thực thi
		return true;	
	}


	public boolean daugia(String iduser, String phien, String format, String daugia) throws Exception {
		ketnoi();
		String sql = "INSERT INTO [dbo].[CUOCDAUGIA] VALUES (?,?,?,?)";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, iduser);
		cmd.setString(2, phien);
		cmd.setString(3, format);
		cmd.setString(4, daugia);
		int rs= cmd.executeUpdate();//thực thi
		return true;	
		
	}
	
	
}
