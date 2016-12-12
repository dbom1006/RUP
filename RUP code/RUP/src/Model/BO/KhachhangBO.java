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




	public boolean kiemtrakhachhang(String email, String username) {
		// TODO Auto-generated method stub
		try {
			if(s.kiemtrakhachhang(email, username))
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}


	public String getidkhachhang(String user) throws Exception {
		// TODO Auto-generated method stub
		
			return s.getidkhachhang(user);
		
	}
}
