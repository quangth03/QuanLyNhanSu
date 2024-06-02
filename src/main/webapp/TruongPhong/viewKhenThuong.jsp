<%@page import="Models.KhenThuong"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KHEN THƯỞNG</title>
<style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>

    <div class="header">
        <h1>XEM DANH SÁCH KHEN THƯỞNG</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
        <%
        	List<KhenThuong> listKhenThuong = (List<KhenThuong>) request.getAttribute("listKhenThuong");
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
                            <th>Mã Khen Thưởng</th>
                            <th>Mã Nhân Viên</th>
                            <th>Lý Do</th>
                            <th>Ngày Quyết Định</th>
                            <th>Số Quyết Định</th>
                            <th>Người Ký</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
						for (KhenThuong kt : listKhenThuong) {
						%>
						<tr>
							<td><%=kt.getMaKT()%></td>
							<td><%=kt.getMaNV()%></td>
							<td><%=kt.getLyDo()%></td>
							<td><%=kt.getNgayKhen()%></td>
							<td><%=kt.getSoQuyetDinh()%></td>
							<td><%=kt.getNguoiKy()%></td>							
						</tr>
						<%
						}
						%>
                    </tbody>
                </table>
            </div>
            <a href="TruongPhong/bonus.jsp"><button>Thêm Khen Thưởng</button></a>
        </div>
    </div>
</body>

</html>