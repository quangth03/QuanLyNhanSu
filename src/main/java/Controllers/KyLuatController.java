package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KyLuatDAO;
import Models.KyLuat;

@WebServlet({ "/listKyLuat", "/insertKyLuat" })
public class KyLuatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KyLuatDAO kyLuatDAO;

	public KyLuatController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		kyLuatDAO = new KyLuatDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertKyLuat":
				insertKyLuat(request, response);
				break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
			case "/update":
				updateKyLuat(request, response);
				break;
			case "/listKyLuat":
				listKyLuat(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listKyLuat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<KyLuat> listKyLuat = kyLuatDAO.selectAllKyLuatS();
		request.setAttribute("listKyLuat", listKyLuat);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TruongPhong/viewKyLuat.jsp");
		dispatcher.forward(request, response);
	}

	private void insertKyLuat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maKL = request.getParameter("MaKL");
		String maNV = request.getParameter("MaNV");
		String lyDo = request.getParameter("LyDo");
		String ngayKyLuat = request.getParameter("NgayKyLuat");
		String soQuyetDinh = request.getParameter("SoQuyetDinh");
		String nguoiKy = request.getParameter("NguoiKy");

		KyLuat newKyLuat = new KyLuat(maKL, maNV, lyDo, ngayKyLuat, soQuyetDinh, nguoiKy);
		kyLuatDAO.insertKyLuat(newKyLuat);
		response.sendRedirect("listKyLuat");
	}

	private void updateKyLuat(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maKL = request.getParameter("MaKL");
		String maNV = request.getParameter("MaNV");
		String lyDo = request.getParameter("LyDo");
		String ngayKyLuat = request.getParameter("NgayKyLuat");
		String soQuyetDinh = request.getParameter("SoQuyetDinh");
		String nguoiKy = request.getParameter("NguoiKy");
		KyLuat book = new KyLuat(maKL, maNV, lyDo, ngayKyLuat, soQuyetDinh, nguoiKy);
		kyLuatDAO.updateKyLuat(book);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}