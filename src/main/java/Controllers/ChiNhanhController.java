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

import DAO.ChiNhanhDAO;
import Models.ChiNhanh;

@WebServlet({ "/listChiNhanh", "/insertChiNhanh" })
public class ChiNhanhController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChiNhanhDAO chiNhanhDAO;

	public ChiNhanhController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		chiNhanhDAO = new ChiNhanhDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insertChiNhanh":
				insertChiNhanh(request, response);
				break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
			case "/update":
				updateChiNhanh(request, response);
				break;
			case "/listChiNhanh":
				listChiNhanh(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listChiNhanh(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<ChiNhanh> listChiNhanh = chiNhanhDAO.selectAllChiNhanhS();
		request.setAttribute("listChiNhanh", listChiNhanh);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/adminViewBranch.jsp");
		dispatcher.forward(request, response);
	}

	private void insertChiNhanh(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maCN = request.getParameter("MaCN");
		String tenCN = request.getParameter("TenCN");
		String maGiamDoc = request.getParameter("MaGiamDoc");
		String diaChi = request.getParameter("DiaChi");

		ChiNhanh newChiNhanh = new ChiNhanh(maCN, tenCN, maGiamDoc, diaChi);
		chiNhanhDAO.insertChiNhanh(newChiNhanh);
		response.sendRedirect("listChiNhanh");
	}

	private void updateChiNhanh(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maCN = request.getParameter("MaCN");
		String tenCN = request.getParameter("TenCN");
		String maGiamDoc = request.getParameter("MaGiamDoc");
		String diaChi = request.getParameter("DiaChi");

		ChiNhanh book = new ChiNhanh(maCN, tenCN, maGiamDoc, diaChi);
		chiNhanhDAO.updateChiNhanh(book);
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