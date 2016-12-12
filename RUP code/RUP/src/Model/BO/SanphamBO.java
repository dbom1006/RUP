package Model.BO;

import java.util.ArrayList;

import Model.Bean.ChitietBean;
import Model.Bean.CuocdaugiaBean;
import Model.Bean.MaxBean;
import Model.Bean.SanphamBean;
import Model.Bean.XemphienBean;
import Model.DAO.SanphamDAO;

public class SanphamBO {
	
SanphamDAO s = new SanphamDAO();
	
	public ArrayList<XemphienBean> getsanpham() throws Exception{
		return s.getsanpham();
		
	}
	
	public ArrayList<ChitietBean> getchitiet(String id) throws Exception{
		return s.getchitiet(id);
		
	}
	
	public ArrayList<CuocdaugiaBean> getphien(String id) throws Exception{
		return s.getphien(id);
		
	}
	
	public ArrayList<MaxBean> getmax(String id) throws Exception{
		return s.getmax(id);
		
	}
	
	public boolean updatesanpham(String id, String tensp, String mota, String anh, String tag){
		try {
			if(s.updatesanpham(id, tensp, mota, anh, tag))
				return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean xoasanpham(String id) {
		// TODO Auto-generated method stub
		try {
			if(s.xoasanpham(id)){
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertsanpham(String iduser, String tensanpham, String mota, String anh, String tag) throws Exception {
		// TODO Auto-generated method stub
		if(s.insertsanpham(iduser, tensanpham, mota, anh, tag))
			return true;
		else return false;
		
	}

	public boolean daugia(String iduser, String phien, String format, String daugia) throws Exception {
		if(s.daugia(iduser, phien, format, daugia))
			return true;
		return false;
		
	}




}
