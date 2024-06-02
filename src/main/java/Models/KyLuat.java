package Models;

public class KyLuat {
	private String MaKL;
	private String MaNV;
	private String LyDo;
	private String NgayKyLuat;
	private String SoQuyetDinh;
	private String NguoiKy;

	public KyLuat() {
		super();
	}

	public KyLuat(String maKL, String maNV, String lyDo, String ngayKyLuat, String soQuyetDinh, String nguoiKy) {
		super();
		MaKL = maKL;
		MaNV = maNV;
		LyDo = lyDo;
		NgayKyLuat = ngayKyLuat;
		SoQuyetDinh = soQuyetDinh;
		NguoiKy = nguoiKy;
	}

	public String getMaKL() {
		return MaKL;
	}

	public void setMaKL(String maKL) {
		MaKL = maKL;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getLyDo() {
		return LyDo;
	}

	public void setLyDo(String lyDo) {
		LyDo = lyDo;
	}

	public String getNgayKyLuat() {
		return NgayKyLuat;
	}

	public void setNgayKyLuat(String ngayKyLuat) {
		NgayKyLuat = ngayKyLuat;
	}

	public String getSoQuyetDinh() {
		return SoQuyetDinh;
	}

	public void setSoQuyetDinh(String soQuyetDinh) {
		SoQuyetDinh = soQuyetDinh;
	}

	public String getNguoiKy() {
		return NguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		NguoiKy = nguoiKy;
	}
}
