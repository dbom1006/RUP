package Model.BO;

import java.util.ArrayList;

import Model.Bean.QuanlyBean;
import Model.Bean.XemphienBean;
import Model.DAO.KhachhangDAO;
import Model.DAO.SanphamDAO;

public class KhachhangBO {
	KhachhangDAO s = new KhachhangDAO();
	public boolean checkkhachhang(String username, String password) throws Exception{
		return s.checkkhachhang(username, password);
	}
	
	
	public boolean insert(String username, String email, String password) throws Exception{
		return s.insertkhachhang(username, email, password);
		
	}
	
	
	public ArrayList<QuanlyBean> getquanly(String email) throws Exception{
		return s.getquanly(email);
		
	}
}
