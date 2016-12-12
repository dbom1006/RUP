package Model.Bean;

public class QuanlyBean {
	private String MaSP;
	private String Email;
	private String TenSP;
	private String MoTa;
	private String HinhAnh;
	private String GanThe;
	public QuanlyBean(String maSP, String email, String tenSP, String moTa, String hinhAnh, String ganThe) {
		super();
		MaSP = maSP;
		Email = email;
		TenSP = tenSP;
		MoTa = moTa;
		HinhAnh = hinhAnh;
		GanThe = ganThe;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}
	public String getGanThe() {
		return GanThe;
	}
	public void setGanThe(String ganThe) {
		GanThe = ganThe;
	}
	
	
	
	

}
