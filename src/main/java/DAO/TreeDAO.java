package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.ChiNhanh;
import Models.PhongBan;
import Util.HandleException;
import Util.JDBCUtil;

public class TreeDAO {
	public TreeDAO() {
		super();
	}

	public List<ChiNhanh> LayDSChiNhanh() {
		List<ChiNhanh> list = new ArrayList<>();
		String query = "select * from ChiNhanh;";

		try (Connection connection = JDBCUtil.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaCN = rs.getString("MaCN");
				String TenCN = rs.getString("TenCN");
				String MaGiamDoc = rs.getString("MaGiamDoc");
				String DiaChi = rs.getString("DiaChi");
				ChiNhanh cn = new ChiNhanh(MaCN, TenCN, MaGiamDoc, DiaChi);
				list.add(cn);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return list;
	}

	public List<PhongBan> LayDSPhongBan(String Macn) {
		List<PhongBan> list = new ArrayList<>();
		String query = "select * from PhongBan where MaCN = '" + Macn + "';";

		try (Connection connection = JDBCUtil.getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String MaPB = rs.getString("MaPB");
				String TenPB = rs.getString("TenPB");
				String MaCN = rs.getString("MaCN");
				String MaTrrPhong = rs.getString("MaTrPhong");
				String MaPBCha = rs.getString("MaPBCha");
				PhongBan pb = new PhongBan(MaPB, MaCN, TenPB, MaTrrPhong, MaPBCha);
				list.add(pb);
			}
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			HandleException.printSQLException(e);
		}
		return list;
	}
}