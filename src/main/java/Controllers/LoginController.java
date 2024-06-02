package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import Models.NhanVien;

@WebServlet({ "/login", "/logout" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDAO;

	public LoginController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		loginDAO = new LoginDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		session.removeAttribute("userA");
//		response.sendRedirect("login.jsp");
		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Bước 1: Lấy data từ form người dùng
		String MaNV = request.getParameter("MaNV");
		String MatKhau = request.getParameter("MatKhau");

		// Bước 2: Khởi tạo model
		NhanVien account = new NhanVien();
		account.setMaNV(MaNV);
		account.setMatKhau(MatKhau);

		// Bước 3: Kết nối CSDL -> trả kết quả
		try {
			NhanVien acc = new NhanVien();
			acc = loginDAO.onLogin(account);

			if (acc != null) {
				HttpSession session = request.getSession();
				session.setAttribute("maNV", MaNV);
				String quyen = acc.getQuyen();
				switch (quyen) {
				case "NhanVien":
					RequestDispatcher dispatcher = request.getRequestDispatcher("NhanVien/employee.jsp");
					dispatcher.forward(request, response);
//					response.sendRedirect("NhanVien/EmployeeInfo.jsp");
					break;
				case "GiamDoc":
					RequestDispatcher dispatcher1 = request.getRequestDispatcher("GiamDoc/manager.jsp");
					dispatcher1.forward(request, response);
//					response.sendRedirect("GiamDoc/manager.jsp");
					break;
				case "TruongPhong":
					RequestDispatcher dispatcher2 = request.getRequestDispatcher("TruongPhong/leader.jsp");
					dispatcher2.forward(request, response);
//					response.sendRedirect("TruongPhong/leader.jsp");
					break;
				case "Admin":
					RequestDispatcher dispatcher3 = request.getRequestDispatcher("Admin/admin.jsp"); // dua minh den
																										// form jsp
					dispatcher3.forward(request, response);
//					response.sendRedirect("Admin/adminViewEmp.jsp");// dua den servlet /login
					break;
				default:
					response.sendRedirect("login.jsp");
					break;
				}
//				HttpSession session = request.getSession();
//				session.setAttribute("nhanvien", acc);
//				response.sendRedirect("form-admin.jsp");
			} else {
				request.setAttribute("errMsg", "Thông tin đăng nhập không chính xác!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
//				HttpSession session = request.getSession();
				// session.setAttribute("user", username);
				// response.sendRedirect("login.jsp");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	private void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
////		HttpSession session = request.getSession();
////		session.invalidate();
////		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
////		dispatcher.forward(request, response);
//		RequestDispatcher dispatcher4 = request.getRequestDispatcher("logout.jsp"); // dua minh den
//		// form jsp
//		dispatcher4.forward(request, response);
//	}
}
