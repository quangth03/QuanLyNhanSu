<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TRANG CHỦ</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>
	<div class="header">
        <h1>Nhân Viên</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
    </div>

    <div class="container">

        <div class="sidebar">
            <a href="<%=request.getContextPath()%>/thongTinCaNhan">Thông Tin Cá Nhân</a>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            

        </div>
    </div>
</body>

</html>