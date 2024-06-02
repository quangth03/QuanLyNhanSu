package Models;

public class QuaTrinhCongTac {
	private String MaCT;
	private String MaNV;
	private String DiaDiem;
	private String ThoiGianBatDau;
	private String ThoiGianKetThuc;
	private String CongViecChinh;

	public QuaTrinhCongTac() {
		super();
	}

	public QuaTrinhCongTac(String maCT, String maNV, String diaDiem, String thoiGianBatDau, String thoiGianKetThuc,
			String congViecChinh) {
		super();
		MaCT = maCT;
		MaNV = maNV;
		DiaDiem = diaDiem;
		ThoiGianBatDau = thoiGianBatDau;
		ThoiGianKetThuc = thoiGianKetThuc;
		CongViecChinh = congViecChinh;
	}

	public String getMaCT() {
		return MaCT;
	}

	public void setMaCT(String maCT) {
		MaCT = maCT;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getDiaDiem() {
		return DiaDiem;
	}

	public void setDiaDiem(String diaDiem) {
		DiaDiem = diaDiem;
	}

	public String getThoiGianBatDau() {
		return ThoiGianBatDau;
	}

	public void setThoiGianBatDau(String thoiGianBatDau) {
		ThoiGianBatDau = thoiGianBatDau;
	}

	public String getThoiGianKetThuc() {
		return ThoiGianKetThuc;
	}

	public void setThoiGianKetThuc(String thoiGianKetThuc) {
		ThoiGianKetThuc = thoiGianKetThuc;
	}

	public String getCongViecChinh() {
		return CongViecChinh;
	}

	public void setCongViecChinh(String congViecChinh) {
		CongViecChinh = congViecChinh;
	}
}
