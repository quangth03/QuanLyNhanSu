package Models;

public class KhenThuong {
	private String MaKT;
	private String MaNV;
	private String LyDo;
	private String NgayKhen;
	private String SoQuyetDinh;
	private String NguoiKy;

	public KhenThuong() {
		super();
	}

	public KhenThuong(String maKT, String maNV, String lyDo, String ngayKhen, String soQuyetDinh, String nguoiKy) {
		super();
		MaKT = maKT;
		MaNV = maNV;
		LyDo = lyDo;
		NgayKhen = ngayKhen;
		SoQuyetDinh = soQuyetDinh;
		NguoiKy = nguoiKy;
	}

	public String getMaKT() {
		return MaKT;
	}

	public void setMaKT(String maKT) {
		MaKT = maKT;
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

	public String getNgayKhen() {
		return NgayKhen;
	}

	public void setNgayKhen(String ngayKhen) {
		NgayKhen = ngayKhen;
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
