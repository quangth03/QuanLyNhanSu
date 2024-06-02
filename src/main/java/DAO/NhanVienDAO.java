package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.NhanVien;
import Util.HandleException;
import Util.JDBCUtil;

public class NhanVienDAO {
	private static final String INSERT_USERS_SQL = "INSERT INTO NhanVien"
			+ "  (MaNV, MatKhau, Quyen, MaPB, MaCV, HoTen, GioiTinh, NgSinh, Email, DiaChi, SDT, CCCD, NgayCap, NoiCap, DanToc, TonGiao, TrangThai, NgBatDauLamViec, NgNghiViec) VALUES "
			+ " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select * from NhanVien where MaNV = ?";
	private static final String SELECT_USER_BY_ID = "SELECT \r\n" + "    NV.MaNV,\r\n" + "    NV.HoTen,\r\n"
			+ "    CV.TenCV AS ChucVu,\r\n" + "    PB.TenPB,\r\n" + "    CN.TenCN,\r\n" + "    NV.Email,\r\n"
			+ "    NV.SDT,\r\n" + "    NV.GioiTinh,\r\n" + "    NV.NgSinh,\r\n" + "    NV.DiaChi,\r\n"
			+ "    NV.CCCD,\r\n" + "    NV.NgayCap,\r\n" + "    NV.NoiCap,\r\n" + "    NV.DanToc,\r\n"
			+ "    NV.TonGiao,\r\n" + "    NV.NgBatDauLamViec,\r\n" + "    NV.NgNghiViec\r\n" + "FROM NhanVien NV\r\n"
			+ "JOIN ChucVu CV ON NV.MaCV = CV.MaCV\r\n" + "JOIN PhongBan PB ON NV.MaPB = PB.MaPB\r\n"
			+ "JOIN ChiNhanh CN ON PB.MaCN = CN.MaCN\r\n" + "where MaNV = ?";
//	private static final String SELECT_ALL_USERS = "select * from NhanVien";
	private static final String SELECT_ALL_USERS = "SELECT \r\n" + "    NV.MaNV,\r\n" + "    NV.HoTen,\r\n"
			+ "    CV.TenCV AS ChucVu,\r\n" + "    PB.TenPB,\r\n" + "    CN.TenCN,\r\n" + "    NV.Email,\r\n"
			+ "    NV.SDT,\r\n" + "    NV.GioiTinh,\r\n" + "    NV.NgSinh,\r\n" + "    NV.DiaChi,\r\n"
			+ "    NV.CCCD,\r\n" + "    NV.NgayCap,\r\n" + "    NV.NoiCap,\r\n" + "    NV.DanToc,\r\n"
			+ "    NV.TonGiao,\r\n" + "    NV.NgBatDauLamViec,\r\n" + "    NV.NgNghiViec\r\n" + "FROM NhanVien NV\r\n"
			+ "JOIN ChucVu CV ON NV.MaCV = CV.MaCV\r\n" + "JOIN PhongBan PB ON NV.MaPB = PB.MaPB\r\n"
			+ "JOIN ChiNhanh CN ON PB.MaCN = CN.MaCN;";// xem tat ca
	private static final String SELECT_USERS_CN = "SELECT \r\n" + "    NV.MaNV,\r\n" + "    NV.HoTen,\r\n"
			+ "    CV.TenCV AS ChucVu,\r\n" + "    PB.TenPB,\r\n" + "    CN.TenCN,\r\n" + "    NV.Email,\r\n"
			+ "    NV.SDT,\r\n" + "    NV.GioiTinh,\r\n" + "    NV.NgSinh,\r\n" + "    NV.DiaChi,\r\n"
			+ "    NV.CCCD,\r\n" + "    NV.NgayCap,\r\n" + "    NV.NoiCap,\r\n" + "    NV.DanToc,\r\n"
			+ "    NV.TonGiao,\r\n" + "    NV.NgBatDauLamViec,\r\n" + "    NV.NgNghiViec\r\n" + "FROM NhanVien NV\r\n"
			+ "JOIN ChucVu CV ON NV.MaCV = CV.MaCV\r\n" + "JOIN PhongBan PB ON NV.MaPB = PB.MaPB\r\n"
			+ "JOIN ChiNhanh CN ON PB.MaCN = CN.MaCN\r\n" + "WHERE CN.MaGiamDoc = 'NV2';";// xem theo chi nhanh
	private static final String SELECT_USERS_PB = "SELECT \r\n" + "    NV.MaNV,\r\n" + "    NV.HoTen,\r\n"
			+ "    CV.TenCV AS ChucVu,\r\n" + "    PB.TenPB,\r\n" + "    CN.TenCN,\r\n" + "    NV.Email,\r\n"
			+ "    NV.SDT,\r\n" + "    NV.GioiTinh,\r\n" + "    NV.NgSinh,\r\n" + "    NV.DiaChi,\r\n"
			+ "    NV.CCCD,\r\n" + "    NV.NgayCap,\r\n" + "    NV.NoiCap,\r\n" + "    NV.DanToc,\r\n"
			+ "    NV.TonGiao,\r\n" + "    NV.NgBatDauLamViec,\r\n" + "    NV.NgNghiViec\r\n" + "FROM NhanVien NV\r\n"
			+ "JOIN ChucVu CV ON NV.MaCV = CV.MaCV\r\n" + "JOIN PhongBan PB ON NV.MaPB = PB.MaPB\r\n"
			+ "JOIN ChiNhanh CN ON PB.MaCN = CN.MaCN\r\n" + "WHERE PB.MaTrPhong = 'NV09';";// xem theo Phong ban
	private static final String DELETE_USERS_SQL = "delete from NhanVien where MaNV = ?;";
	private static final String UPDATE_USERS_SQL = "update NhanVien set HoTen =?, MaCV=?, MaPB=?,  Email=?,SDT=?, GioiTinh=?, NgSinh=?,  DiaChi=?,  CCCD=?, NgayCap=?, NoiCap=?, DanToc=?, TonGiao=? Where MaNV = ? ;";

	public NhanVienDAO() {
	}

	public List<NhanVien> selectAllNhanViens() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<NhanVien> nhanViens = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_USERS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String hoTen = rs.getString("HoTen");
				String chucVu = rs.getString("ChucVu");
				String tenPB = rs.getString("TenPB");
				String tenCN = rs.getString("TenCN");
				String email = rs.getString("Email");
				String sdt = rs.getString("SDT");
				String gioiTinh = rs.getString("GioiTinh");
				String ngSinh = rs.getString("NgSinh");
				String diaChi = rs.getString("DiaChi");
				String cCCD = rs.getString("CCCD");
				String ngayCap = rs.getString("NgayCap");
				String noiCap = rs.getString("NoiCap");
				String danToc = rs.getString("DanToc");
				String tonGiao = rs.getString("TonGiao");
				String ngBatDauLamViec = rs.getString("NgBatDauLamViec");
				String ngNghiViec = rs.getString("NgNghiViec");
				nhanViens.add(new NhanVien(maNV, hoTen, chucVu, tenPB, tenCN, email, sdt, gioiTinh, ngSinh, diaChi,
						cCCD, ngayCap, noiCap, danToc, tonGiao, ngBatDauLamViec, ngNghiViec));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return nhanViens;
	}

	public List<NhanVien> selectAllNhanVienTheoCN() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<NhanVien> nhanViens = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_CN);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String hoTen = rs.getString("HoTen");
				String chucVu = rs.getString("ChucVu");
				String tenPB = rs.getString("TenPB");
				String tenCN = rs.getString("TenCN");
				String email = rs.getString("Email");
				String sdt = rs.getString("SDT");
				String gioiTinh = rs.getString("GioiTinh");
				String ngSinh = rs.getString("NgSinh");
				String diaChi = rs.getString("DiaChi");
				String cCCD = rs.getString("CCCD");
				String ngayCap = rs.getString("NgayCap");
				String noiCap = rs.getString("NoiCap");
				String danToc = rs.getString("DanToc");
				String tonGiao = rs.getString("TonGiao");
				String ngBatDauLamViec = rs.getString("NgBatDauLamViec");
				String ngNghiViec = rs.getString("NgNghiViec");
				nhanViens.add(new NhanVien(maNV, hoTen, chucVu, tenPB, tenCN, email, sdt, gioiTinh, ngSinh, diaChi,
						cCCD, ngayCap, noiCap, danToc, tonGiao, ngBatDauLamViec, ngNghiViec));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return nhanViens;
	}

	public List<NhanVien> selectAllNhanVienTheoPB() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<NhanVien> nhanViens = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USERS_PB);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String hoTen = rs.getString("HoTen");
				String chucVu = rs.getString("ChucVu");
				String tenPB = rs.getString("TenPB");
				String tenCN = rs.getString("TenCN");
				String email = rs.getString("Email");
				String sdt = rs.getString("SDT");
				String gioiTinh = rs.getString("GioiTinh");
				String ngSinh = rs.getString("NgSinh");
				String diaChi = rs.getString("DiaChi");
				String cCCD = rs.getString("CCCD");
				String ngayCap = rs.getString("NgayCap");
				String noiCap = rs.getString("NoiCap");
				String danToc = rs.getString("DanToc");
				String tonGiao = rs.getString("TonGiao");
				String ngBatDauLamViec = rs.getString("NgBatDauLamViec");
				String ngNghiViec = rs.getString("NgNghiViec");
				nhanViens.add(new NhanVien(maNV, hoTen, chucVu, tenPB, tenCN, email, sdt, gioiTinh, ngSinh, diaChi,
						cCCD, ngayCap, noiCap, danToc, tonGiao, ngBatDauLamViec, ngNghiViec));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return nhanViens;
	}

	public NhanVien selectNhanVien(String maNV) {
		NhanVien nhanVien = null;
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_USER_BY_ID);
			preparedStatement.setString(1, maNV);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String MaNV = rs.getString("MaNV");
				String hoTen = rs.getString("HoTen");
				String chucVu = rs.getString("ChucVu");
				String tenPB = rs.getString("TenPB");
				String tenCN = rs.getString("TenCN");
				String email = rs.getString("Email");
				String sdt = rs.getString("SDT");
				String gioiTinh = rs.getString("GioiTinh");
				String ngSinh = rs.getString("NgSinh");
				String diaChi = rs.getString("DiaChi");
				String cCCD = rs.getString("CCCD");
				String ngayCap = rs.getString("NgayCap");
				String noiCap = rs.getString("NoiCap");
				String danToc = rs.getString("DanToc");
				String tonGiao = rs.getString("TonGiao");
				String ngBatDauLamViec = rs.getString("NgBatDauLamViec");
				String ngNghiViec = rs.getString("NgNghiViec");
				nhanVien = new NhanVien(MaNV, hoTen, chucVu, tenPB, tenCN, email, sdt, gioiTinh, ngSinh, diaChi, cCCD,
						ngayCap, noiCap, danToc, tonGiao, ngBatDauLamViec, ngNghiViec);
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return nhanVien;
	}

	public void insertNhanVien(NhanVien nhanVien) throws SQLException {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, nhanVien.getMaNV());
			preparedStatement.setString(2, nhanVien.getMatKhau());
			preparedStatement.setString(3, nhanVien.getQuyen());
			preparedStatement.setString(4, nhanVien.getMaPB());
			preparedStatement.setString(5, nhanVien.getMaCV());
			preparedStatement.setString(6, nhanVien.getHoTen());
			preparedStatement.setString(7, nhanVien.getGioiTinh());
			preparedStatement.setString(8, nhanVien.getNgSinh());
			preparedStatement.setString(9, nhanVien.getEmail());
			preparedStatement.setString(10, nhanVien.getDiaChi());
			preparedStatement.setString(11, nhanVien.getSDT());
			preparedStatement.setString(12, nhanVien.getCCCD());
			preparedStatement.setString(13, nhanVien.getNgayCap());
			preparedStatement.setString(14, nhanVien.getNoiCap());
			preparedStatement.setString(15, nhanVien.getDanToc());
			preparedStatement.setString(16, nhanVien.getTonGiao());
			preparedStatement.setString(17, nhanVien.getTrangThai());
			preparedStatement.setString(18, nhanVien.getNgBatDauLamViec());
			preparedStatement.setString(19, nhanVien.getNgNghiViec());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public boolean deleteNhanVien(String maNV) throws SQLException {
		boolean rowDeleted = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_USERS_SQL);
			statement.setString(1, maNV);
			rowDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowDeleted;
	}

	public boolean updateNhanVien(NhanVien nhanVien) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_USERS_SQL);
			System.out.print(nhanVien.getMaCV());
//			statement.setString(2, nhanVien.getMatKhau());
//			statement.setString(3, nhanVien.getQuyen());
//			statement.setString(1, nhanVien.getMaNV());
			statement.setString(1, nhanVien.getHoTen());
			statement.setString(2, nhanVien.getMaCV());
			statement.setString(3, nhanVien.getMaPB());
//			statement.setString(4, nhanVien.getMaCN());
			statement.setString(4, nhanVien.getEmail());
			statement.setString(5, nhanVien.getSDT());
			statement.setString(6, nhanVien.getGioiTinh());
			statement.setString(7, nhanVien.getNgSinh());
			statement.setString(8, nhanVien.getDiaChi());
			statement.setString(9, nhanVien.getCCCD());
			statement.setString(10, nhanVien.getNgayCap());
			statement.setString(11, nhanVien.getNoiCap());
			statement.setString(12, nhanVien.getDanToc());
			statement.setString(13, nhanVien.getTonGiao());
//			statement.setString(17, nhanVien.getTrangThai());
//			statement.setString(18, nhanVien.getNgBatDauLamViec());
//			statement.setString(19, nhanVien.getNgNghiViec());
			statement.setString(14, nhanVien.getMaNV());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowUpdated;
	}
}
