package Models;

public class PhongBanCha {
	private String MaPBCha;
	private String TenPBCha;

	public PhongBanCha() {
		super();
	}

	public PhongBanCha(String maPBCha, String tenPBCha) {
		super();
		MaPBCha = maPBCha;
		TenPBCha = tenPBCha;
	}

	public String getMaPBCha() {
		return MaPBCha;
	}

	public void setMaPBCha(String maPBCha) {
		MaPBCha = maPBCha;
	}

	public String getTenPBCha() {
		return TenPBCha;
	}

	public void setTenPBCha(String tenPBCha) {
		TenPBCha = tenPBCha;
	}
}
