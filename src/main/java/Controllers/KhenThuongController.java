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

import DAO.KhenThuongDAO;
import Models.KhenThuong;

@WebServlet({ "/listKhenThuong", "/insertKhenThuong" })
public class KhenThuongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KhenThuongDAO khenThuongDAO;

	public KhenThuongController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		khenThuongDAO = new KhenThuongDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertKhenThuong":
				insertKhenThuong(request, response);
				break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
			case "/update":
				updateKhenThuong(request, response);
				break;
			case "/listKhenThuong":
				listKhenThuong(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listKhenThuong(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<KhenThuong> listKhenThuong = khenThuongDAO.selectAllKhenThuongS();
		request.setAttribute("listKhenThuong", listKhenThuong);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TruongPhong/viewKhenThuong.jsp");
		dispatcher.forward(request, response);
	}

	private void insertKhenThuong(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String maKT = request.getParameter("MaKT");
		String maNV = request.getParameter("MaNV");
		String lyDo = request.getParameter("LyDo");
		String ngayKhen = request.getParameter("NgayKhen");
		String soQuyetDinh = request.getParameter("SoQuyetDinh");
		String nguoiKy = request.getParameter("NguoiKy");

		KhenThuong newKhenThuong = new KhenThuong(maKT, maNV, lyDo, ngayKhen, soQuyetDinh, nguoiKy);
		khenThuongDAO.insertKhenThuong(newKhenThuong);
		RequestDispatcher dispatcher = request.getRequestDispatcher("listKhenThuong");
		dispatcher.forward(request, response);
	}

	private void updateKhenThuong(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maKT = request.getParameter("MaKT");
		String maNV = request.getParameter("MaNV");
		String lyDo = request.getParameter("LyDo");
		String ngayKhen = request.getParameter("NgayKhen");
		String soQuyetDinh = request.getParameter("SoQuyetDinh");
		String nguoiKy = request.getParameter("NguoiKy");

		KhenThuong book = new KhenThuong(maKT, maNV, lyDo, ngayKhen, soQuyetDinh, nguoiKy);
		khenThuongDAO.updateKhenThuong(book);
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