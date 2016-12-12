package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import DungChung.CDungChung;
import Model.Bean.CuocdaugiaBean;
import Model.Bean.QuanlyBean;

public class KhachhangDAO {
	public static Connection cn;
	public static void ketnoi() throws Exception{
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		cn = DriverManager.getConnection(CDungChung.url);
		
		
	}
	
	public boolean checkkhachhang(String username, String password) throws Exception{
		ketnoi();
		String sql = "select * from THANHVIEN where TenTV = '"+ username +"' and Password = '"+ password +"'";
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		boolean kq = r.next();
		r.close();
		System.out.println(kq);
		return kq;
	}

	public boolean insertkhachhang(String username, String email, String password) throws Exception{
		ketnoi();
		String sql = "INSERT INTO THANHVIEN (TenTV, Email,Password) VALUES (?,?,?)";
		PreparedStatement cmd = cn.prepareStatement(sql);
		cmd.setString(1, username);
		cmd.setString(2, email);
		cmd.setString(3, password);
		int rs= cmd.executeUpdate();//thực thi
		return true;	
	}
	
	public ArrayList<QuanlyBean> getquanly(String id) throws Exception{
		ketnoi();
		String sql= "SELECT dbo.THANHVIEN.Email, dbo.SANPHAM.TenSP, dbo.SANPHAM.MoTa, dbo.SANPHAM.HinhAnh, dbo.SANPHAM.GanThe "
				+ "FROM     dbo.SANPHAM INNER JOIN "
				+ "dbo.THANHVIEN ON dbo.SANPHAM.MaTV = dbo.THANHVIEN.MaTV "
				+ "WHERE  (dbo.THANHVIEN.Email = N'"+id+"') "
				+ "GROUP BY dbo.THANHVIEN.Email, dbo.SANPHAM.TenSP, dbo.SANPHAM.MoTa, dbo.SANPHAM.HinhAnh, dbo.SANPHAM.GanThe";
		
		PreparedStatement cmd = cn.prepareStatement(sql);
		ResultSet r = cmd.executeQuery();
		ArrayList<QuanlyBean> ds = new ArrayList<QuanlyBean>();
		while(r.next()){
			
			String Email = r.getString("Email");
			String TenSP = r.getString("TenSP");
			String MoTa = r.getString("MoTa");
			String HinhAnh = r.getString("HinhAnh");
			String GanThe = r.getString("GanThe");
			QuanlyBean s = new  QuanlyBean(Email, TenSP, MoTa, HinhAnh, GanThe);
			ds.add(s);
		}
		r.close();
		return ds;
	}
}
