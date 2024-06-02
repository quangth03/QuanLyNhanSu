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
import javax.servlet.http.HttpSession;

import DAO.ChiNhanhDAO;
import DAO.ChucVuDAO;
import DAO.NhanVienDAO;
import DAO.PhongBanDAO;
import Models.ChiNhanh;
import Models.ChucVu;
import Models.NhanVien;
import Models.PhongBan;

@WebServlet({ "/listAllNhanVien", "/listAllNhanVienTheoCN", "/listAllNhanVienTheoPB", "/editNhanVien",
		"/deleteNhanVien", "/insertNhanVien", "/thongTinCaNhan", "/updateNhanVien", "/thongTinCaNhanAdmin",
		"/thongTinCaNhanGD", "/thongTinCaNhanTP" })
public class NhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NhanVienDAO nhanVienDAO;
	private PhongBanDAO phongBanDAO;
	private ChiNhanhDAO chiNhanhDAO;
	private ChucVuDAO chucVuDAO;

	public NhanVienController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		nhanVienDAO = new NhanVienDAO();
		phongBanDAO = new PhongBanDAO();
		chiNhanhDAO = new ChiNhanhDAO();
		chucVuDAO = new ChucVuDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newNhanVien":
				showNewForm(request, response);
				break;
			case "/insertNhanVien":
				insertNhanVien(request, response);
				break;
			case "/deleteNhanVien":
				deleteNhanVien(request, response);
				break;
			case "/editNhanVien":
				showEditForm(request, response);
				break;
			case "/updateNhanVien":
				updateNhanVien(request, response);
				break;
			case "/listAllNhanVien":
				listAllNhanVien(request, response);
				break;
			case "/listAllNhanVienTheoCN":
				listAllNhanVienTheoCN(request, response);
				break;
			case "/listAllNhanVienTheoPB":
				listAllNhanVienTheoPB(request, response);
				break;
			case "/thongTinCaNhan":
				selectNhanVien(request, response);
				break;
			case "/thongTinCaNhanAdmin":
				selectNhanVien1(request, response);
				break;
			case "/thongTinCaNhanGD":
				selectNhanVien2(request, response);
				break;
			case "/thongTinCaNhanTP":
				selectNhanVien3(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		request.setCharacterEncoding("UTF-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
	}

	private void selectNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		String maNV = (String) session.getAttribute("maNV");
		System.out.print(maNV);
		NhanVien nv = nhanVienDAO.selectNhanVien(maNV);
		request.setAttribute("nv", nv);
//		System.out.print(nv.getCCCD());
		RequestDispatcher dispatcher = request.getRequestDispatcher("NhanVien/EmployeeInfo.jsp");
		dispatcher.forward(request, response);
	}

	private void selectNhanVien1(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		String maNV = (String) session.getAttribute("maNV");
		System.out.print(maNV);
		NhanVien nv = nhanVienDAO.selectNhanVien(maNV);
		request.setAttribute("nv", nv);
//		System.out.print(nv.getCCCD());
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/adminInfo.jsp");
		dispatcher.forward(request, response);
	}

	private void selectNhanVien2(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		String maNV = (String) session.getAttribute("maNV");
		System.out.print(maNV);
		NhanVien nv = nhanVienDAO.selectNhanVien(maNV);
		request.setAttribute("nv", nv);
//		System.out.print(nv.getCCCD());
		RequestDispatcher dispatcher = request.getRequestDispatcher("GiamDoc/managerInfo.jsp");
		dispatcher.forward(request, response);
	}

	private void selectNhanVien3(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		String maNV = (String) session.getAttribute("maNV");
		System.out.print(maNV);
		NhanVien nv = nhanVienDAO.selectNhanVien(maNV);
		request.setAttribute("nv", nv);
//		System.out.print(nv.getCCCD());
		RequestDispatcher dispatcher = request.getRequestDispatcher("TruongPhong/leaderInfo.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<NhanVien> listAllNhanVien = nhanVienDAO.selectAllNhanViens();
		request.setAttribute("listAllNhanVien", listAllNhanVien);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/adminViewEmp.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllNhanVienTheoCN(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<NhanVien> listAllNhanVienTheoCN = nhanVienDAO.selectAllNhanVienTheoCN();
		request.setAttribute("listAllNhanVienTheoCN", listAllNhanVienTheoCN);
		RequestDispatcher dispatcher = request.getRequestDispatcher("GiamDoc/managerViewEmp.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllNhanVienTheoPB(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<NhanVien> listAllNhanVienTheoPB = nhanVienDAO.selectAllNhanVienTheoPB();
		request.setAttribute("listAllNhanVienTheoPB", listAllNhanVienTheoPB);
		RequestDispatcher dispatcher = request.getRequestDispatcher("TruongPhong/leaderViewEmp.jsp");
		dispatcher.forward(request, response);
	}

	private void insertNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maNV = request.getParameter("MaNV");
		String matkhau = request.getParameter("MatKhau");
		String quyen = request.getParameter("Quyen");
		String maPB = request.getParameter("MaPB");
		String maCV = request.getParameter("MaCV");
		String hoTen = request.getParameter("HoTen");
		String gioiTinh = request.getParameter("GioiTinh");
		String ngSinh = request.getParameter("NgSinh");
		String email = request.getParameter("Email");
		String diaChi = request.getParameter("DiaChi");
		String sDT = request.getParameter("SDT");
		String cCCD = request.getParameter("CCCD");
		String ngayCap = request.getParameter("NgayCap");
		String noiCap = request.getParameter("NoiCap");
		String danToc = request.getParameter("DanToc");
		String tonGiao = request.getParameter("TonGiao");
		String trangThai = request.getParameter("TrangThai");
		String ngBatDauLamViec = request.getParameter("NgBatDauLamViec");
		String ngNghiViec = request.getParameter("NgNghiViec");

		NhanVien newNhanVien = new NhanVien(maNV, matkhau, quyen, maPB, maCV, hoTen, gioiTinh, ngSinh, email, diaChi,
				sDT, cCCD, ngayCap, noiCap, danToc, tonGiao, trangThai, ngBatDauLamViec, ngNghiViec);
		nhanVienDAO.insertNhanVien(newNhanVien);
		response.sendRedirect("listAllNhanVien");
	}

	private void updateNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maNV = request.getParameter("MaNV");
		String hoTen = request.getParameter("HoTen");
		String tenCV = request.getParameter("chucvu");
//		String tenPB = request.getParameter("TenPB");
		String maPB = request.getParameter("phongban");
//		String tenCN = request.getParameter("chinhanh");
		String email = request.getParameter("Email");
		String sDT = request.getParameter("SDT");
		String gioiTinh = request.getParameter("GioiTinh");
		String ngSinh = request.getParameter("NgSinh");
		String diaChi = request.getParameter("DiaChi");
		String cCCD = request.getParameter("CCCD");
		String ngayCap = request.getParameter("NgayCap");
		String noiCap = request.getParameter("NoiCap");
		String danToc = request.getParameter("DanToc");
		String tonGiao = request.getParameter("TonGiao");
		System.out.print(hoTen);
		NhanVien updateNV = new NhanVien(maNV, hoTen, tenCV, maPB, email, sDT, gioiTinh, ngSinh, diaChi, cCCD, ngayCap,
				noiCap, danToc, tonGiao);
		nhanVienDAO.updateNhanVien(updateNV);

		response.sendRedirect("listAllNhanVien");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String maNV = request.getParameter("maNV");
		NhanVien existingUser = nhanVienDAO.selectNhanVien(maNV);
		List<ChiNhanh> cn = chiNhanhDAO.selectAllChiNhanhS();
		List<PhongBan> pb = phongBanDAO.selectAllPhongBanTheoCN();
		List<ChucVu> cv = chucVuDAO.selectAllChucVuS();
		RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/adminEditEmp.jsp");
		request.setAttribute("maNV", existingUser);
		request.setAttribute("listPB", pb);
		request.setAttribute("listCN", cn);
		request.setAttribute("listCV", cv);
		dispatcher.forward(request, response);

	}

	private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String maNV = request.getParameter("maNV");
		nhanVienDAO.deleteNhanVien(maNV);
		response.sendRedirect("listAllNhanVien");
	}

}
