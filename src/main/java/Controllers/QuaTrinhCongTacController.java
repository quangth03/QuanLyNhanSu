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

import DAO.QuaTrinhCongTacDAO;
import Models.QuaTrinhCongTac;

@WebServlet({ "/listQuaTrinhCongTac", "/insertQuaTrinhCongTac" })
public class QuaTrinhCongTacController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuaTrinhCongTacDAO quaTrinhCongTacDAO;

	public QuaTrinhCongTacController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		quaTrinhCongTacDAO = new QuaTrinhCongTacDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertQuaTrinhCongTac":
				insertQuaTrinhCongTac(request, response);
				break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
			case "/update":
				updateQuaTrinhCongTac(request, response);
				break;
			case "/listQuaTrinhCongTac":
				listQuaTrinhCongTac(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listQuaTrinhCongTac(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<QuaTrinhCongTac> listQuaTrinhCongTac = quaTrinhCongTacDAO.selectAllQuaTrinhCongTacS();
		request.setAttribute("listQuaTrinhCongTac", listQuaTrinhCongTac);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TruongPhong/viewQuaTrinhCongTac.jsp");
		dispatcher.forward(request, response);
	}

	private void insertQuaTrinhCongTac(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maCT = request.getParameter("MaCT");
		String maNV = request.getParameter("MaNV");
		String diaDiem = request.getParameter("DiaDiem");
		String thoiGianBatDau = request.getParameter("ThoiGianBatDau");
		String thoiGianKetThuc = request.getParameter("ThoiGianKetThuc");
		String congViecChinh = request.getParameter("CongViecChinh");

		QuaTrinhCongTac newQuaTrinhCongTac = new QuaTrinhCongTac(maCT, maNV, diaDiem, thoiGianBatDau, thoiGianKetThuc,
				congViecChinh);
		quaTrinhCongTacDAO.insertQuaTrinhCongTac(newQuaTrinhCongTac);
		response.sendRedirect("listQuaTrinhCongTac");
	}

	private void updateQuaTrinhCongTac(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maCT = request.getParameter("MaCT");
		String maNV = request.getParameter("MaNV");
		String diaDiem = request.getParameter("DiaDiem");
		String thoiGianBatDau = request.getParameter("ThoiGianBatDau");
		String thoiGianKetThuc = request.getParameter("ThoiGianKetThuc");
		String congViecChinh = request.getParameter("CongViecChinh");

		QuaTrinhCongTac book = new QuaTrinhCongTac(maCT, maNV, diaDiem, thoiGianBatDau, thoiGianKetThuc, congViecChinh);
		quaTrinhCongTacDAO.updateQuaTrinhCongTac(book);
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