package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.PhongBan;
import Util.HandleException;
import Util.JDBCUtil;

public class PhongBanDAO {
	private static final String INSERT_PhongBan_SQL = "INSERT INTO PhongBan"
			+ "  (MaPB, TenPB, MaCN, MaTrPhong, MaPBCha) VALUES " + " (?, ?, ?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
//	private static final String SELECT_ALL_PhongBanS = "select * from PhongBan";
	private static final String SELECT_ALL_PhongBanS = "SELECT \r\n" + "    PB.MaPB,\r\n" + "    PB.TenPB,\r\n"
			+ "    PBCha.TenPBCha,\r\n" + "    TrPhong.HoTen AS TenTrPhong,\r\n" + "    CN.TenCN\r\n"
			+ "FROM PhongBan PB\r\n" + "LEFT JOIN NhanVien TrPhong ON PB.MaTrPhong = TrPhong.MaNV\r\n"
			+ "LEFT JOIN PhongBanCha PBCha ON PB.MaPBCha = PBCha.MaPBCha\r\n"
			+ "LEFT JOIN ChiNhanh CN ON PB.MaCN = CN.MaCN;";
	private static final String SELECT_PhongBanS = "SELECT \r\n" + "    PB.MaPB,\r\n" + "    PB.TenPB,\r\n"
			+ "    PBCha.TenPBCha,\r\n" + "    TrPhong.HoTen AS TenTrPhong,\r\n" + "    CN.TenCN\r\n"
			+ "FROM PhongBan PB\r\n" + "LEFT JOIN NhanVien TrPhong ON PB.MaTrPhong = TrPhong.MaNV\r\n"
			+ "LEFT JOIN PhongBanCha PBCha ON PB.MaPBCha = PBCha.MaPBCha\r\n"
			+ "JOIN ChiNhanh CN ON PB.MaCN = CN.MaCN\r\n" + "WHERE CN.MaGiamDoc = 'NV2';";
	private static final String DELETE_PhongBan_SQL = "delete from PhongBan where MaPB = ?;";
	private static final String UPDATE_PhongBan_SQL = "update PhongBan set MaPB=?, TenPB=?, MaCN=?, MaTrPhong=?, MaPBCha=?;";

	public PhongBanDAO() {
	}

	public List<PhongBan> selectAllPhongBanS() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PhongBan> phongBanS = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_PhongBanS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maPB = rs.getString("MaPB");
				String tenPB = rs.getString("TenPB");
				String tenTrPhong = rs.getString("TenTrPhong");
				String tenPBCha = rs.getString("TenPBCha");
				String tenCN = rs.getString("TenCN");
				phongBanS.add(new PhongBan(maPB, tenPB, tenTrPhong, tenPBCha, tenCN));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return phongBanS;
	}

	public List<PhongBan> selectAllPhongBanTheoCN() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PhongBan> phongBanS = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_PhongBanS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maPB = rs.getString("MaPB");
				String tenPB = rs.getString("TenPB");
				String tenTrPhong = rs.getString("TenTrPhong");
				String tenPBCha = rs.getString("TenPBCha");
				String tenCN = rs.getString("TenCN");
				phongBanS.add(new PhongBan(maPB, tenPB, tenTrPhong, tenPBCha, tenCN));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return phongBanS;
	}

	public void insertPhongBan(PhongBan phongBan) throws SQLException {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_PhongBan_SQL);
			preparedStatement.setString(1, phongBan.getMaPB());
			preparedStatement.setString(2, phongBan.getTenPB());
			preparedStatement.setString(3, phongBan.getMaCN());
			preparedStatement.setString(4, phongBan.getMaTrPhong());
			preparedStatement.setString(5, phongBan.getMaPBCha());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public boolean deletePhongBan(String MaPB) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PhongBan_SQL);) {
			statement.setString(1, MaPB);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updatePhongBan(PhongBan phongBan) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_PhongBan_SQL);
			statement.setString(1, phongBan.getMaPB());
			statement.setString(2, phongBan.getTenPB());
			statement.setString(3, phongBan.getMaCN());
			statement.setString(4, phongBan.getMaTrPhong());
			statement.setString(5, phongBan.getMaPBCha());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowUpdated;
	}
}