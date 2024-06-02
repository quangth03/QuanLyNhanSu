package Models;

public class ChiNhanh {
	private String MaCN;
	private String TenCN;
	private String MaGiamDoc;
	private String DiaChi;

	public ChiNhanh() {
		super();
	}

	public ChiNhanh(String maCN, String tenCN, String maGiamDoc, String diaChi) {
		super();
		MaCN = maCN;
		TenCN = tenCN;
		MaGiamDoc = maGiamDoc;
		DiaChi = diaChi;
	}

	public String getMaCN() {
		return MaCN;
	}

	public void setMaCN(String maCN) {
		MaCN = maCN;
	}

	public String getTenCN() {
		return TenCN;
	}

	public void setTenCN(String tenCN) {
		TenCN = tenCN;
	}

	public String getMaGiamDoc() {
		return MaGiamDoc;
	}

	public void setMaGiamDoc(String maGiamDoc) {
		MaGiamDoc = maGiamDoc;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
}
