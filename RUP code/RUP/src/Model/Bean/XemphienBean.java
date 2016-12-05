package Model.Bean;

import java.util.Date;

public class XemphienBean {
	
	private String MaSP;
	private String TenSP;
	private String Mota;
	private String Hinhanh;
	private int Giakhoidiem;
	private String Thoigianketthuc;
	public XemphienBean(String maSP, String tenSP, String mota, String hinhanh, int giakhoidiem,
			String thoigianketthuc) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		Mota = mota;
		Hinhanh = hinhanh;
		Giakhoidiem = giakhoidiem;
		Thoigianketthuc = thoigianketthuc;
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
	public int getGiakhoidiem() {
		return Giakhoidiem;
	}
	public void setGiakhoidiem(int giakhoidiem) {
		Giakhoidiem = giakhoidiem;
	}
	public String getThoigianketthuc() {
		return Thoigianketthuc;
	}
	public void setThoigianketthuc(String thoigianketthuc) {
		Thoigianketthuc = thoigianketthuc;
	}
	
	
	
	

}
