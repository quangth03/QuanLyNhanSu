package Models;

public class ChucVu {
	private String MaCV;
	private String TenCV;
	private String LuongCoBan;

	public ChucVu() {
		super();
	}

	public ChucVu(String maCV, String tenCV, String luongCoBan) {
		super();
		MaCV = maCV;
		TenCV = tenCV;
		LuongCoBan = luongCoBan;
	}

	public String getMaCV() {
		return MaCV;
	}

	public void setMaCV(String maCV) {
		MaCV = maCV;
	}

	public String getTenCV() {
		return TenCV;
	}

	public void setTenCV(String tenCV) {
		TenCV = tenCV;
	}

	public String getLuongCoBan() {
		return LuongCoBan;
	}

	public void setLuongCoBan(String luongCoBan) {
		LuongCoBan = luongCoBan;
	}
}
