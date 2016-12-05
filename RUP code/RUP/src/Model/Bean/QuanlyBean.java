package Model.Bean;

public class QuanlyBean {
	private String Email;
	private String TenSP;
	private String MoTa;
	private String HinhAnh;
	private String GanThe;
	public QuanlyBean(String email, String tenSP, String moTa, String hinhAnh, String ganThe) {
		super();
		Email = email;
		TenSP = tenSP;
		MoTa = moTa;
		HinhAnh = hinhAnh;
		GanThe = ganThe;
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
