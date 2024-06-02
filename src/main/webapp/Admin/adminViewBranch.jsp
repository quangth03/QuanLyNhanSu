<%@page import="java.util.List"%>
<%@page import="Models.ChiNhanh"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>DANH SÁCH CHI NHÁNH</title>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
	<style><%@include file="/css/style.css"%></style>
</head>

<body>

	<div class="header">
		<h1>ADMIN</h1>
		<a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
	</div>

	<div class="container">
		<!-- <iframe src="../navbar.html" class="sidebar" width="200" height="100%"></iframe> -->
		<div class="sidebar">
			<a href="Admin/adminTreeview.jsp" target="_self">Cấu Trúc Công Ty</a>
            <a href="<%=request.getContextPath()%>/listChiNhanh">Quản lý Chi Nhánh</a>
            <a href="<%=request.getContextPath()%>/listAllPhongBan">Quản Lý Phòng Ban</a>
            <a href="<%=request.getContextPath()%>/listAllNhanVien">Quản Lý Nhân Viên</a>
            <a href="Admin/adminImportExcel.jsp">Import Excel</a>
            <a href="<%=request.getContextPath()%>/thongTinCaNhanAdmin">Thông Tin Cá Nhân</a>
		</div>
		<!-- Main Content -->
		<div class="main-content">
			<h2>Xem Danh Sách Chi Nhánh</h2>
			<%
			List<ChiNhanh> listChiNhanh = (List<ChiNhanh>) request.getAttribute("listChiNhanh");
			%>
			<div class="table-container">
				<table class="content-table">
					<thead>
						<tr>
							<th>Mã Chi Nhánh</th>
							<th>Tên Chi Nhánh</th>
							<th>Tên Giám Đốc</th>
							<th>Địa Chỉ</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (ChiNhanh cn : listChiNhanh) {
						%>
						<tr>
							<td><%=cn.getMaCN()%></td>
							<td><%=cn.getTenCN()%></td>
							<td><%=cn.getMaGiamDoc()%></td>
							<td><%=cn.getDiaChi()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<a href="Admin/adminAddBranch.jsp"><button>Thêm Chi Nhánh</button></a>
		</div>
	</div>
</body>

</html>