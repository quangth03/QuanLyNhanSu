package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.KhenThuong;
import Util.HandleException;
import Util.JDBCUtil;

public class KhenThuongDAO {
	private static final String INSERT_KhenThuong_SQL = "INSERT INTO KhenThuong"
			+ "  (MaKT, MaNV, LyDo, NgayKhen, SoQuyetDinh, NguoiKy) VALUES " + " (?, ?, ?, ?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_KhenThuongS = "SELECT *\r\n" + "FROM KhenThuong\r\n"
			+ "JOIN NhanVien ON KhenThuong.MaNV = NhanVien.MaNV\r\n"
			+ "JOIN PhongBan ON NhanVien.MaPB = PhongBan.MaPB\r\n" + "WHERE PhongBan.MaTrPhong = 'NV09';";
//	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_KhenThuong_SQL = "update KhenThuong set MaKT=?, MaNV=?, LyDo=?, NgayKhen=?, SoQuyetDinh=?, NguoiKy=?;";

	public KhenThuongDAO() {
	}

	public List<KhenThuong> selectAllKhenThuongS() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<KhenThuong> khenThuongS = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtil.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KhenThuongS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maKT = rs.getString("MaKT");
				String maNV = rs.getString("MaNV");
				String lyDo = rs.getString("LyDo");
				String ngayKhen = rs.getString("NgayKhen");
				String soQuyetDinh = rs.getString("SoQuyetDinh");
				String nguoiKy = rs.getString("NguoiKy");
				khenThuongS.add(new KhenThuong(maKT, maNV, lyDo, ngayKhen, soQuyetDinh, nguoiKy));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return khenThuongS;
	}

	public void insertKhenThuong(KhenThuong khenThuong) throws SQLException {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_KhenThuong_SQL);
			preparedStatement.setString(1, khenThuong.getMaKT());
			preparedStatement.setString(2, khenThuong.getMaNV());
			preparedStatement.setString(3, khenThuong.getLyDo());
			preparedStatement.setString(4, khenThuong.getNgayKhen());
			preparedStatement.setString(5, khenThuong.getSoQuyetDinh());
			preparedStatement.setString(6, khenThuong.getNguoiKy());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public boolean updateKhenThuong(KhenThuong khenThuong) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_KhenThuong_SQL);
			statement.setString(1, khenThuong.getMaKT());
			statement.setString(2, khenThuong.getMaNV());
			statement.setString(3, khenThuong.getLyDo());
			statement.setString(4, khenThuong.getNgayKhen());
			statement.setString(5, khenThuong.getSoQuyetDinh());
			statement.setString(6, khenThuong.getNguoiKy());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowUpdated;
	}
}