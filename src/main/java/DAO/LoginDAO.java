package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Models.NhanVien;
import Util.HandleException;
import Util.JDBCUtil;

public class LoginDAO {
	public NhanVien onLogin(NhanVien loginData) throws ClassNotFoundException {
		NhanVien account = null;

		try {
			// Bước 1: Mở chuỗi kết nối đến MySQL
			Connection conn = JDBCUtil.getConnection();
			// Bước 2: Khởi tạo Prepare Statement
			PreparedStatement preparedStatement = conn
					.prepareStatement("select MaNV, MatKhau, Quyen from nhanvien where MaNV = ? and MatKhau = ?");
			preparedStatement.setString(1, loginData.getMaNV());
			preparedStatement.setString(2, loginData.getMatKhau());

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				account = new NhanVien();
				account.setMaNV(rs.getString(1));
				account.setQuyen(rs.getString(3));
			}
			// Bước 3: Đóng kết nối
			conn.close();
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return account;
	}
}
