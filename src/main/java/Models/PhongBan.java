package Models;

public class PhongBan {
	private String MaPB;
	private String TenPB;
	private String MaTrPhong;
	private String MaPBCha;
	private String MaCN;

	public PhongBan() {
		super();
	}

	public PhongBan(String maPB, String tenPB, String maTrPhong, String maPBCha, String maCN) {
		super();
		MaPB = maPB;
		TenPB = tenPB;
		MaTrPhong = maTrPhong;
		MaPBCha = maPBCha;
		MaCN = maCN;
	}

	public String getMaPB() {
		return MaPB;
	}

	public void setMaPB(String maPB) {
		MaPB = maPB;
	}

	public String getTenPB() {
		return TenPB;
	}

	public void setTenPB(String tenPB) {
		TenPB = tenPB;
	}

	public String getMaPBCha() {
		return MaPBCha;
	}

	public void setMaPBCha(String maPBCha) {
		MaPBCha = maPBCha;
	}

	public String getMaCN() {
		return MaCN;
	}

	public void setMaCN(String maCN) {
		MaCN = maCN;
	}

	public String getMaTrPhong() {
		return MaTrPhong;
	}

	public void setMaTrPhong(String maTrPhong) {
		MaTrPhong = maTrPhong;
	}
}
