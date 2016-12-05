package Model.Bean;

public class SanphamBean {
	
	private String MaSP;
	private String TenSP;
	private String Mota;
	private String Hinhanh;
	private String Tag;
	private String MaTV;
	private String MaPDG;
	public SanphamBean(String maSP, String tenSP, String mota, String hinhanh, String tag, String maTV, String maPDG) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		Mota = mota;
		Hinhanh = hinhanh;
		Tag = tag;
		MaTV = maTV;
		MaPDG = maPDG;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}
	public String getHinhanh() {
		return Hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		Hinhanh = hinhanh;
	}
	public String getTag() {
		return Tag;
	}
	public void setTag(String tag) {
		Tag = tag;
	}
	public String getMaTV() {
		return MaTV;
	}
	public void setMaTV(String maTV) {
		MaTV = maTV;
	}
	public String getMaPDG() {
		return MaPDG;
	}
	public void setMaPDG(String maPDG) {
		MaPDG = maPDG;
	}
	
	

}
