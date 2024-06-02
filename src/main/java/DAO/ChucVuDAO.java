package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.ChucVu;
import Util.HandleException;
import Util.JDBCUtil;

public class ChucVuDAO {
	private static final String INSERT_ChucVu_SQL = "INSERT INTO ChiNhanh"
			+ "  (MaCN, TenCN, MaGiamDoc, DiaChi) VALUES " + " (?, ?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
//	private static final String SELECT_ALL_ChiNhanhS = "select * from ChiNhanh";
	private static final String SELECT_ALL_ChucVuS = "SELECT * from ChucVu;";
//	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_ChucVu_SQL = "update ChiNhanh set MaCN=?, TenCN=?, MaGiamDoc=?, DiaChi=?;";

	public ChucVuDAO() {
	}

	public List<ChucVu> selectAllChucVuS() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ChucVu> chucVuS = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection connection = JDBCUtil.getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ChucVuS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maCV = rs.getString("MaCV");
				String tenCV = rs.getString("TenCV");
				String luongCoBan = rs.getString("LuongCoBan");
				chucVuS.add(new ChucVu(maCV, tenCV, luongCoBan));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return chucVuS;
	}

//	public void insertChiNhanh(ChiNhanh chiNhanh) throws SQLException {
//		try {
//			Connection conn = JDBCUtil.getConnection();
//			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_ChiNhanh_SQL);
//			preparedStatement.setString(1, chiNhanh.getMaCN());
//			preparedStatement.setString(2, chiNhanh.getTenCN());
//			preparedStatement.setString(3, chiNhanh.getMaGiamDoc());
//			preparedStatement.setString(4, chiNhanh.getDiaChi());
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			HandleException.printSQLException(e);
//		}
//	}
//
//	public boolean updateChiNhanh(ChiNhanh chiNhanh) throws SQLException {
//		boolean rowUpdated = false;
//		try {
//			Connection conn = JDBCUtil.getConnection();
//			PreparedStatement statement = conn.prepareStatement(UPDATE_ChiNhanh_SQL);
//			statement.setString(1, chiNhanh.getMaCN());
//			statement.setString(2, chiNhanh.getTenCN());
//			statement.setString(3, chiNhanh.getMaGiamDoc());
//			statement.setString(4, chiNhanh.getDiaChi());
//			rowUpdated = statement.executeUpdate() > 0;
//		} catch (SQLException e) {
//			HandleException.printSQLException(e);
//		}
//		return rowUpdated;
//	}
}