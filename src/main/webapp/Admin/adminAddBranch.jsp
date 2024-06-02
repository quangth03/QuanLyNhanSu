<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUAN LY CHI NHANH</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
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
            <h2>Thêm Chi Nhánh</h2>
            <form action="../insertChiNhanh" method="post">
                <div class="form-group">
                    <label for="field1">Mã Chi Nhánh</label>
                    <input type="text" id="field1" name="MaCN" required>
                </div>
        
                <div class="form-group">
                    <label for="field2">Tên Chi Nhánh</label>
                    <input type="text" id="field2" name="TenCN" required>
                </div>

                 <div class="form-group">
                    <label for="field2">Mã Giám Đốc</label>
                    <input type="text" id="field2" name="MaGiamDoc" >
                </div>
                
                <div class="form-group">
                    <label for="field2">Địa Chỉ</label>
                    <input type="text" id="field2" name="DiaChi" >
                </div>
        
                <input type="submit" value="Thêm">
            </form>
        </div>
    </div>
</body>

</html>