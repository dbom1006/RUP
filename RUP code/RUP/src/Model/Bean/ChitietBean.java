package Model.Bean;

import java.util.Date;

public class ChitietBean {
	private String TenSP;
	private String MaSP;
	private String TenTV;
	private String GiaDuocDat;
	private Date TGKetThuc;
	private String MoTa;
	private String Anh;
	private String GanThe;
	private String MaPGD;
	public ChitietBean(String tenSP, String maSP, String tenTV, String giaDuocDat, Date tGKetThuc, String moTa,
			String anh, String ganThe, String maPGD) {
		super();
		TenSP = tenSP;
		MaSP = maSP;
		TenTV = tenTV;
		GiaDuocDat = giaDuocDat;
		TGKetThuc = tGKetThuc;
		MoTa = moTa;
		Anh = anh;
		GanThe = ganThe;
		MaPGD = maPGD;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenTV() {
		return TenTV;
	}
	public void setTenTV(String tenTV) {
		TenTV = tenTV;
	}
	public String getGiaDuocDat() {
		return GiaDuocDat;
	}
	public void setGiaDuocDat(String giaDuocDat) {
		GiaDuocDat = giaDuocDat;
	}
	public Date getTGKetThuc() {
		return TGKetThuc;
	}
	public void setTGKetThuc(Date tGKetThuc) {
		TGKetThuc = tGKetThuc;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public String getGanThe() {
		return GanThe;
	}
	public void setGanThe(String ganThe) {
		GanThe = ganThe;
	}
	public String getMaPGD() {
		return MaPGD;
	}
	public void setMaPGD(String maPGD) {
		MaPGD = maPGD;
	}
	
	
	
	
	
	

}
