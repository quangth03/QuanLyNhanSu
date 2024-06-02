<%@page import="Models.QuaTrinhCongTac"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quá Trình Công Tác</title>
<style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>

    <div class="header">
        <h1>XEM Quá Trình Công Tác</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
        <%
        	List<QuaTrinhCongTac> listQuaTrinhCongTac = (List<QuaTrinhCongTac>) request.getAttribute("listQuaTrinhCongTac");
		%>
    </div>

    <div class="container">
        <!-- <iframe src="../navbar.html" class="sidebar" width="200" height="100%"></iframe> -->
        <div class="sidebar">
             <a href="<%=request.getContextPath()%>/listAllNhanVienTheoPB" target="_self">Danh Sách Nhân Viên</a>
            <a href="<%=request.getContextPath()%>/thongTinCaNhanTP">Thông Tin Cá Nhân</a>
            <a href="<%=request.getContextPath()%>/listKhenThuong">Khen Thưởng</a>
            <a href="<%=request.getContextPath()%>/listKyLuat">Kỷ Luật</a>
            <a href="<%=request.getContextPath()%>/listQuaTrinhCongTac">Quá Trình Công Tác</a>
        </div>
        <!-- Main Content -->
        <div class="main-content">
            <div class="table-container">
                <table class="content-table">
                    <thead>
                        <tr>
                            <th>Mã Công Tác</th>
                            <th>Mã Nhân Viên</th>
                            <th>Địa Điểm</th>
                            <th>Thời Gian Bắt Đầu</th>
                            <th>Thời Gian Kết Thúc</th>
                            <th>Công Việc Chính</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
						for (QuaTrinhCongTac kt : listQuaTrinhCongTac) {
						%>
						<tr>
							<td><%=kt.getMaCT()%></td>
							<td><%=kt.getMaNV()%></td>
							<td><%=kt.getDiaDiem()%></td>
							<td><%=kt.getThoiGianBatDau()%></td>
							<td><%=kt.getThoiGianKetThuc()%></td>
							<td><%=kt.getCongViecChinh()%></td>							
						</tr>
						<%
						}
						%>
                    </tbody>
                </table>
            </div>
            <a href="TruongPhong/themCongTac.jsp"><button>Thêm Công Tác</button></a>
        </div>
    </div>
</body>

</html>