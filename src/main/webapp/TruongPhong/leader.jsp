<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TRANG CHỦ TRƯỞNG PHÒNG</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>

    <div class="header">
        <h1>TRƯỞNG PHÒNG</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
    </div>

    <div class="container">

        <div class="sidebar">
            <a href="<%=request.getContextPath()%>/listAllNhanVienTheoPB" target="_self">Danh Sách Nhân Viên</a>
            <a href="<%=request.getContextPath()%>/thongTinCaNhanTP">Thông Tin Cá Nhân</a>
            <a href="<%=request.getContextPath()%>/listKhenThuong">Khen Thưởng</a>
            <a href="<%=request.getContextPath()%>/listKyLuat">Kỷ Luật</a>
            <a href="<%=request.getContextPath()%>/listQuaTrinhCongTac">Quá Trình Công Tác</a>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            

        </div>
    </div>
</body>

</html>