<%@page import="Models.NhanVien"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUAN LY NHAN VIEN</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>
	<div class="header">
		<h1>ADMIN</h1>
		<a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
	</div>
	<div class="container">
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
			<h2>Xem Danh Sách Nhân Viên</h2>
			<%
			List<NhanVien> listAllNhanVien = (List<NhanVien>) request.getAttribute("listAllNhanVien");
			%>
			<div class="table-container">
				<table class="content-table">
					<thead>
						<tr>
							<th>Mã Nhân Viên</th>
							<th>Tên Nhân Viên</th>
							<th>Chức Vụ</th>
							<th>Tên Phòng Ban</th>
							<th>Tên Chi Nhánh</th>
							<th>Email</th>
							<th>Số Điện Thoại</th>
							<th>Giới Tính</th>
							<th>Ngày Sinh</th>
							<th>Địa Chỉ</th>
							<th>CCCD</th>
							<th>Ngày Cấp</th>
							<th>Nơi Cấp</th>
							<th>Dân Tộc</th>
							<th>Tôn Giáo</th>
							<th>Ngày Bắt Đầu Làm Việc</th>
							<th>Ngày Nghỉ Việc</th>
							<th>Tùy Chọn</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (NhanVien nv : listAllNhanVien) {
						%>
						<tr>
							<td><%=nv.getMaNV()%></td>
							<td><%=nv.getHoTen()%></td>
							<td><%=nv.getTenCV()%></td>
							<td><%=nv.getTenPB()%></td>
							<td><%=nv.getTenCN()%></td>
							<td><%=nv.getEmail()%></td>
							<td><%=nv.getSDT()%></td>
							<td><%=nv.getGioiTinh()%></td>
							<td><%=nv.getNgSinh()%></td>
							<td><%=nv.getDiaChi()%></td>
							<td><%=nv.getCCCD()%></td>
							<td><%=nv.getNgayCap()%></td>
							<td><%=nv.getNoiCap()%></td>
							<td><%=nv.getDanToc()%></td>
							<td><%=nv.getTonGiao()%></td>
							<td><%=nv.getNgBatDauLamViec()%></td>
							<td><%=nv.getNgNghiViec()%></td>
							<td><a href="editNhanVien?maNV=<%=nv.getMaNV()%>">Sửa</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteNhanVien?maNV=<%=nv.getMaNV()%>">Xóa</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
			<a href="Admin/adminAddEmp.jsp"><button>Thêm Nhân Viên</button></a>
		</div>
	</div>
</body>

</html>