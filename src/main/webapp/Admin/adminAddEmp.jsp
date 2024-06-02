<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>QUAN LY NHAN VIEN</title>
<style><%@include file="/css/style.css"%></style>
<style><%@include file="/css/form.css"%></style>
<style><%@include file="/css/table.css"%></style>
</head>

<body>

	<div class="header">
		<h1>ADMIN</h1>
		<a href="<%=request.getContextPath()%>/logout"><button
				class="logout" type="submit">ĐĂNG XUẤT</button></a>
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
			<h2>Thêm Nhân Viên</h2>
			<form action="../insertNhanVien" method="post">
				<div class="form-group">
					<label for="field1">Mã Nhân Viên</label> <input type="text"
						id="field1" name="MaNV" required>
				</div>

				<div class="form-group">
					<label for="field2">Mật Khẩu</label> <input type="text"
						id="field2" name="MatKhau" required>
				</div>

				<div class="form-group">
					<label for="field3">Quyền</label>
					<div class="styled-select">
						<select name="Quyen" required>
							<option value="Admin">Admin</option>
							<option value="GiamDoc">Giám Đốc</option>
							<option value="TruongPhong">Trưởng Phòng</option>
							<option value="NhanVien">Nhân Viên</option>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label for="field2">Mã Phòng Ban</label> <input type="text"
						id="field2" name="MaPB">
				</div>

				<div class="form-group">
					<label for="field2">Mã Chức Vụ</label> <input type="text"
						id="field2" name="MaCV">
				</div>

				<div class="form-group">
					<label for="field2">Tên Nhân Viên</label> <input type="text"
						id="field2" name="HoTen">
				</div>
				<div class="form-group">
					<label for="field2">Giới Tính</label> <input type="text"
						id="field2" name="GioiTinh">
				</div>

				<div class="form-group">
					<label for="field2">Ngày Sinh</label> <input type="date"
						id="field2" name="NgSinh">
				</div>

				<div class="form-group">
					<label for="field4">Email</label> <input type="text" id="field4"
						name="Email">
				</div>

				<div class="form-group">
					<label for="field5">Địa Chỉ</label> <input type="text" id="field5"
						name="DiaChi">
				</div>

				<div class="form-group">
					<label for="textareaField">Số Điện Thoại</label> <input type="text"
						name="SDT" rows="4"></input>
				</div>

				<div class="form-group">
					<label for="field4">CCCD</label> <input type="text" id="field4"
						name="CCCD">
				</div>

				<div class="form-group">
					<label for="field5">Ngày Cấp</label> <input type="date" id="field5"
						name="NgayCap">
				</div>

				<div class="form-group">
					<label for="textareaField">Nơi Cấp</label> <input type="text"
						name="NoiCap"></input>
				</div>

				<div class="form-group">
					<label for="textareaField">Dân Tộc</label> <input type="text"
						name="DanToc"></input>
				</div>

				<div class="form-group">
					<label for="textareaField">Tôn Giáo</label> <input type="text"
						name="TonGiao"></input>
				</div>

				<div class="form-group">
					<label for="textareaField">Trạng Thái</label> <input type="text"
						name="TrangThai"></input>
				</div>

				<div class="form-group">
					<label for="textareaField">Ngày Bắt Đầu Làm Việc</label> <input
						type="date" name="NgBatDauLamViec"></input>
				</div>

				<input type="submit" value="Thêm">
			</form>
		</div>
	</div>
</body>

</html>