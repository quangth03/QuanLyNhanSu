package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.QuaTrinhCongTac;
import Util.HandleException;
import Util.JDBCUtil;

public class QuaTrinhCongTacDAO {
	private static final String INSERT_QuaTrinhCongTac_SQL = "INSERT INTO QuaTrinhCongTac"
			+ "  (MaCT, MaNV, DiaDiem, ThoiGianBatDau, ThoiGianKetThuc, CongViecChinh) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";
//	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_QuaTrinhCongTacS = "SELECT *\\r\\n\" + \"FROM QuaTrinhCongTac\\r\\n\"\r\n"
			+ "			+ \"JOIN NhanVien ON QuaTrinhCongTac.MaNV = NhanVien.MaNV\\r\\n\"\r\n"
			+ "			+ \"JOIN PhongBan ON NhanVien.MaPB = PhongBan.MaPB\\r\\n\" + \"WHERE PhongBan.MaTrPhong = 'NV09';";
//	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_QuaTrinhCongTac_SQL = "update QuaTrinhCongTac set MaCT=?, MaNV=?, DiaDiem=?, ThoiGianBatDau=?, ThoiGianKetThuc=?, CongViecChinh=?;";

	public QuaTrinhCongTacDAO() {
	}

	public List<QuaTrinhCongTac> selectAllQuaTrinhCongTacS() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<QuaTrinhCongTac> quaTrinhCongTacS = new ArrayList<>();
		// Step 1: Establishing a Connection
		try {
			Connection conn = JDBCUtil.getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_QuaTrinhCongTacS);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String maCT = rs.getString("MaCT");
				String maNV = rs.getString("MaNV");
				String diaDiem = rs.getString("DiaDiem");
				String thoiGianBatDau = rs.getString("ThoiGianBatDau");
				String thoiGianKetThuc = rs.getString("ThoiGianKetThuc");
				String congViecChinh = rs.getString("CongViecChinh");
				quaTrinhCongTacS
						.add(new QuaTrinhCongTac(maCT, maNV, diaDiem, thoiGianBatDau, thoiGianKetThuc, congViecChinh));
			}
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return quaTrinhCongTacS;
	}

	public void insertQuaTrinhCongTac(QuaTrinhCongTac quaTrinhCongTac) throws SQLException {
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement(INSERT_QuaTrinhCongTac_SQL);
			preparedStatement.setString(1, quaTrinhCongTac.getMaCT());
			preparedStatement.setString(2, quaTrinhCongTac.getMaNV());
			preparedStatement.setString(3, quaTrinhCongTac.getDiaDiem());
			preparedStatement.setString(4, quaTrinhCongTac.getThoiGianBatDau());
			preparedStatement.setString(5, quaTrinhCongTac.getThoiGianKetThuc());
			preparedStatement.setString(6, quaTrinhCongTac.getCongViecChinh());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
	}

	public boolean updateQuaTrinhCongTac(QuaTrinhCongTac quaTrinhCongTac) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_QuaTrinhCongTac_SQL);
			statement.setString(1, quaTrinhCongTac.getMaCT());
			statement.setString(2, quaTrinhCongTac.getMaNV());
			statement.setString(3, quaTrinhCongTac.getDiaDiem());
			statement.setString(4, quaTrinhCongTac.getThoiGianBatDau());
			statement.setString(5, quaTrinhCongTac.getThoiGianKetThuc());
			statement.setString(6, quaTrinhCongTac.getCongViecChinh());

			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return rowUpdated;
	}
}