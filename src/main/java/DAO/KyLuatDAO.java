package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.KyLuat;
import Util.HandleException;
import Util.JDBCUtil;

public class KyLuatDAO {
	private static final String INSERT_KyLuat_SQL = "INSERT INTO KyLuat"
			+ "  (MaKL, MaNV, LyDo, NgayKyLuat, SoQuyetDinh, NguoiKy) VALUES " + " (?, ?, ?, ?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_KyLuatS = "SELECT *\r\n" + "FROM KyLuat\r\n"
			+ "JOIN NhanVien ON KyLuat.MaNV = NhanVien.MaNV\r\n" + "JOIN PhongBan ON NhanVien.MaPB = PhongBan.MaPB\r\n"
			+ "WHERE PhongBan.MaTrPhong = 'NV09';";
//	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_KyLuat_SQL = "update KyLuat set MaKL=?, MaNV=?, LyDo=?, NgayKyLuat=?, SoQuyetDinh=?, NguoiKy=?;";

	public KyLuatDAO() {
	}

	public List<KyLuat> selectAllKyLuatS() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<KyLuat> kyLuatS = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtil.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KyLuatS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maKL = rs.getString("MaKL");
				String maNV = rs.getString("MaNV");
				String lyDo = rs.getString("LyDo");
				String ngayKyLuat = rs.getString("NgayKyLuat");
				String soQuyetDinh = rs.getString("SoQuyetDinh");
				String nguoiKy = rs.getString("NguoiKy");
				kyLuatS.add(new KyLuat(maKL, maNV, lyDo, ngayKyLuat, soQuyetDinh, nguoiKy));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return kyLuatS;
	}

	public void insertKyLuat(KyLuat kyLuat) throws SQLException {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_KyLuat_SQL);
			preparedStatement.setString(1, kyLuat.getMaKL());
			preparedStatement.setString(2, kyLuat.getMaNV());
			preparedStatement.setString(3, kyLuat.getLyDo());
			preparedStatement.setString(4, kyLuat.getNgayKyLuat());
			preparedStatement.setString(5, kyLuat.getSoQuyetDinh());
			preparedStatement.setString(6, kyLuat.getNguoiKy());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public boolean updateKyLuat(KyLuat kyLuat) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_KyLuat_SQL);
			statement.setString(1, kyLuat.getMaKL());
			statement.setString(2, kyLuat.getMaNV());
			statement.setString(3, kyLuat.getLyDo());
			statement.setString(4, kyLuat.getNgayKyLuat());
			statement.setString(5, kyLuat.getSoQuyetDinh());
			statement.setString(6, kyLuat.getNguoiKy());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowUpdated;
	}
}
