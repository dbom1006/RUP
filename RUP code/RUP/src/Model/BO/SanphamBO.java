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




}
