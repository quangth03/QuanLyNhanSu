package Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PhongBanDAO;
import Models.PhongBan;

/**
 * Servlet implementation class PhongBanController
 */
@WebServlet({ "/listAllPhongBan", "/listAllPhongBanTheoCN", "/insertPhongBan" })
public class PhongBanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PhongBanDAO phongBanDAO;

	public PhongBanController() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		phongBanDAO = new PhongBanDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newPhongBan":
				showNewForm(request, response);
				break;
			case "/insertPhongBan":
				insertPhongBan(request, response);
				break;
			case "/deletePhongBan":
				deletePhongBan(request, response);
				break;
			case "/editPhongBan":
//                    showEditForm(request, response);
				break;
			case "/updatePhongBan":
				updatePhongBan(request, response);
				break;
			case "/listAllPhongBan":
				listAllPhongBan(request, response);
				break;
			case "/listAllPhongBanTheoCN":
				listAllPhongBanTheoCN(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

	}

	private void listAllPhongBan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<PhongBan> listAllPhongBan = phongBanDAO.selectAllPhongBanS();
		request.setAttribute("listAllPhongBan", listAllPhongBan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/adminViewDepartment.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllPhongBanTheoCN(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<PhongBan> listAllPhongBanTheoCN = phongBanDAO.selectAllPhongBanTheoCN();
		request.setAttribute("listAllPhongBanTheoCN", listAllPhongBanTheoCN);
		RequestDispatcher dispatcher = request.getRequestDispatcher("GiamDoc/managerViewDepartment.jsp");
		dispatcher.forward(request, response);
	}

	private void insertPhongBan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maPB = request.getParameter("MaPB");
		String tenPB = request.getParameter("TenPB");
		String maCN = request.getParameter("MaCN");
		String maTrPhong = request.getParameter("MaTrPhong");
		String maPBCha = request.getParameter("MaPBCha");

		PhongBan newPhongBan = new PhongBan(maPB, tenPB, maCN, maTrPhong, maPBCha);
		phongBanDAO.insertPhongBan(newPhongBan);
		response.sendRedirect("listAllPhongBan");
	}

	private void updatePhongBan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maPB = request.getParameter("MaPB");
		String tenPB = request.getParameter("TenPB");
		String maCN = request.getParameter("MaCN");
		String maTrPhong = request.getParameter("MaTrPhong");
		String maPBCha = request.getParameter("MaPBCha");

		PhongBan book = new PhongBan(maPB, tenPB, maCN, maTrPhong, maPBCha);
		phongBanDAO.updatePhongBan(book);
		response.sendRedirect("listPB");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("");
		dispatcher.forward(request, response);
	}

	private void deletePhongBan(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String MaPB = request.getParameter("MaPB");
		phongBanDAO.deletePhongBan(MaPB);
		response.sendRedirect("listPB");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
