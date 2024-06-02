<%@page import="Models.KyLuat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KỶ LUẬT </title>
<style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>

    <div class="header">
        <h1>XEM DANH SÁCH Kỷ Luật</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
        <%
        	List<KyLuat> listKyLuat = (List<KyLuat>) request.getAttribute("listKyLuat");
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
                            <th>Mã Kỷ Luật</th>
                            <th>Mã Nhân Viên</th>
                            <th>Lý Do</th>
                            <th>Ngày Quyết Định</th>
                            <th>Số Quyết Định</th>
                            <th>Người Ký</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
						for (KyLuat kt : listKyLuat) {
						%>
						<tr>
							<td><%=kt.getMaKL()%></td>
							<td><%=kt.getMaNV()%></td>
							<td><%=kt.getLyDo()%></td>
							<td><%=kt.getNgayKyLuat()%></td>
							<td><%=kt.getSoQuyetDinh()%></td>
							<td><%=kt.getNguoiKy()%></td>							
						</tr>
						<%
						}
						%>
                    </tbody>
                </table>
            </div>
            <a href="TruongPhong/penalize.jsp"><button>Thêm Kỷ Luật</button></a>
        </div>
    </div>
</body>

</html>