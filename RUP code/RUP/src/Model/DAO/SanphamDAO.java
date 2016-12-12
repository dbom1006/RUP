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
		String sql= "SELECT dbo.SANPHAM.TenSP, dbo.SANPHAM.MaSP, dbo.SANPHAM.MaTV, dbo.CUOCDAUGIA.GiaDuocDat, dbo.PHIENDAUGIA.TGKetThuc, dbo.SANPHAM.MoTa, "
				+ "dbo.SANPHAM.HinhAnh, dbo.THANHVIEN.TenTV FROM dbo.SANPHAM INNER JOIN "
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

			ChitietBean s = new ChitietBean(TenSP, MaSP, TenTV, GiaDuocDat, d1, MoTa, HinhAnh);
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
	
	
}
