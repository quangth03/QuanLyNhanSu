package Models;

public class NhanVien {
	private String MaNV;
	private String MatKhau;
	private String Quyen;
	private String ChucVu;
	private String TenPB;
	private String TenCN;
	private String MaPB;
	private String MaCV;
	private String MaCN;
	private String HoTen;
	private String GioiTinh;
	private String NgSinh;
	private String Email;
	private String DiaChi;
	private String SDT;
	private String CCCD;
	private String NgayCap;
	private String NoiCap;
	private String DanToc;
	private String TonGiao;
	private String TrangThai;
	private String NgBatDauLamViec;
	private String NgNghiViec;

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV, String matKhau, String quyen, String maPB, String maCV, String hoTen, String gioiTinh,
			String ngSinh, String email, String diaChi, String sDT, String cCCD, String ngayCap, String noiCap,
			String danToc, String tonGiao, String trangThai, String ngBatDauLamViec, String ngNghiViec) {
		super();
		MaNV = maNV;
		MatKhau = matKhau;
		Quyen = quyen;
		MaPB = maPB;
		MaCV = maCV;
		HoTen = hoTen;
		GioiTinh = gioiTinh;
		NgSinh = ngSinh;
		Email = email;
		DiaChi = diaChi;
		SDT = sDT;
		CCCD = cCCD;
		NgayCap = ngayCap;
		NoiCap = noiCap;
		DanToc = danToc;
		TonGiao = tonGiao;
		TrangThai = trangThai;
		NgBatDauLamViec = ngBatDauLamViec;
		NgNghiViec = ngNghiViec;
	}

	public NhanVien(String maNV, String hoTen, String chucVu, String tenPB, String tenCN, String email, String sDT,
			String gioiTinh, String ngSinh, String diaChi, String cCCD, String ngayCap, String noiCap, String danToc,
			String tonGiao, String ngBatDauLamViec, String ngNghiViec) {
		super();
		MaNV = maNV;
		HoTen = hoTen;
		ChucVu = chucVu;
		TenPB = tenPB;
		TenCN = tenCN;
		Email = email;
		SDT = sDT;
		GioiTinh = gioiTinh;
		NgSinh = ngSinh;
		DiaChi = diaChi;
		CCCD = cCCD;
		NgayCap = ngayCap;
		NoiCap = noiCap;
		DanToc = danToc;
		TonGiao = tonGiao;
		NgBatDauLamViec = ngBatDauLamViec;
		NgNghiViec = ngNghiViec;
	}

//	public NhanVien(String hoTen, String chucVu, String tenPB, String tenCN, String email, String sDT, String gioiTinh,
//			String ngSinh, String diaChi, String cCCD, String ngayCap, String noiCap, String danToc, String tonGiao,
//			String ngBatDauLamViec, String ngNghiViec) {
//		super();
//		HoTen = hoTen;
//		ChucVu = chucVu;
//		TenPB = tenPB;
//		TenCN = tenCN;
//		Email = email;
//		SDT = sDT;
//		GioiTinh = gioiTinh;
//		NgSinh = ngSinh;
//		DiaChi = diaChi;
//		CCCD = cCCD;
//		NgayCap = ngayCap;
//		NoiCap = noiCap;
//		DanToc = danToc;
//		TonGiao = tonGiao;
//		NgBatDauLamViec = ngBatDauLamViec;
//		NgNghiViec = ngNghiViec;
//	}

	public NhanVien(String hoTen, String chucVu, String tenPB, String tenCN, String email, String sDT, String gioiTinh,
			String ngSinh, String diaChi, String cCCD, String ngayCap, String noiCap, String danToc, String tonGiao,
			String ngBatDauLamViec, String ngNghiViec) {
		super();
		HoTen = hoTen;
		ChucVu = chucVu;
		TenPB = tenPB;
		TenCN = tenCN;
		Email = email;
		SDT = sDT;
		GioiTinh = gioiTinh;
		NgSinh = ngSinh;
		DiaChi = diaChi;
		CCCD = cCCD;
		NgayCap = ngayCap;
		NoiCap = noiCap;
		DanToc = danToc;
		TonGiao = tonGiao;
	}

//	public NhanVien(String maNV, String hoTen, String chucVu, String tenPB, String tenCN, String email, String sDT,
//			String gioiTinh, String ngSinh, String diaChi, String cCCD, String ngayCap, String noiCap, String danToc,
//			String tonGiao) {
//		super();
//		MaNV = maNV;
//		HoTen = hoTen;
//		ChucVu = chucVu;
//		TenPB = tenPB;
//		TenCN = tenCN;
//		Email = email;
//		SDT = sDT;
//		GioiTinh = gioiTinh;
//		NgSinh = ngSinh;
//		DiaChi = diaChi;
//		CCCD = cCCD;
//		NgayCap = ngayCap;
//		NoiCap = noiCap;
//		DanToc = danToc;
//		TonGiao = tonGiao;
//	}

	public NhanVien(String maNV, String hoTen, String maCV, String maPB, String email, String sDT, String gioiTinh,
			String ngSinh, String diaChi, String cCCD, String ngayCap, String noiCap, String danToc, String tonGiao) {
		super();
		MaNV = maNV;
		HoTen = hoTen;
		MaCV = maCV;
		MaPB = maPB;
		Email = email;
		SDT = sDT;
		GioiTinh = gioiTinh;
		NgSinh = ngSinh;
		DiaChi = diaChi;
		CCCD = cCCD;
		NgayCap = ngayCap;
		NoiCap = noiCap;
		DanToc = danToc;
		TonGiao = tonGiao;
	}

	public String getChucVu() {
		return ChucVu;
	}

	public void setChucVu(String chucVu) {
		ChucVu = chucVu;
	}

	public String getMaCN() {
		return MaCN;
	}

	public void setMaCN(String maCN) {
		MaCN = maCN;
	}

	public String getTenCV() {
		return ChucVu;
	}

	public void setTenCV(String tenCV) {
		ChucVu = tenCV;
	}

	public String getTenPB() {
		return TenPB;
	}

	public void setTenPB(String tenPB) {
		TenPB = tenPB;
	}

	public String getTenCN() {
		return TenCN;
	}

	public void setTenCN(String tenCN) {
		TenCN = tenCN;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public String getQuyen() {
		return Quyen;
	}

	public void setQuyen(String quyen) {
		Quyen = quyen;
	}

	public String getMaPB() {
		return MaPB;
	}

	public void setMaPB(String maPB) {
		MaPB = maPB;
	}

	public String getMaCV() {
		return MaCV;
	}

	public void setMaCV(String maCV) {
		MaCV = maCV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public String getNgSinh() {
		return NgSinh;
	}

	public void setNgSinh(String ngSinh) {
		NgSinh = ngSinh;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getCCCD() {
		return CCCD;
	}

	public void setCCCD(String cCCD) {
		CCCD = cCCD;
	}

	public String getNgayCap() {
		return NgayCap;
	}

	public void setNgayCap(String ngayCap) {
		NgayCap = ngayCap;
	}

	public String getNoiCap() {
		return NoiCap;
	}

	public void setNoiCap(String noiCap) {
		NoiCap = noiCap;
	}

	public String getDanToc() {
		return DanToc;
	}

	public void setDanToc(String danToc) {
		DanToc = danToc;
	}

	public String getTonGiao() {
		return TonGiao;
	}

	public void setTonGiao(String tonGiao) {
		TonGiao = tonGiao;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public String getNgBatDauLamViec() {
		return NgBatDauLamViec;
	}

	public void setNgBatDauLamViec(String ngBatDauLamViec) {
		NgBatDauLamViec = ngBatDauLamViec;
	}

	public String getNgNghiViec() {
		return NgNghiViec;
	}

	public void setNgNghiViec(String ngNghiViec) {
		NgNghiViec = ngNghiViec;
	}
}
