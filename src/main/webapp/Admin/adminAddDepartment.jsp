<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUAN LY PHONG BAN</title>
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
            <h2>Thêm Phòng Ban</h2>
            <form action="../insertPhongBan" method="post">
                <div class="form-group">
                    <label for="field1">Mã Phòng Ban</label>
                    <input type="text" id="field1" name="MaPB" >
                </div>
        
                <div class="form-group">
                    <label for="field2">Tên Phòng Ban</label>
                    <input type="text" id="field2" name="TenPB" >
                </div>

                 <div class="form-group">
                    <label for="field2">Mã Chi Nhánh</label>
                    <input type="text" id="field2" name="MaCN" >
                </div>
                
                <div class="form-group">
                    <label for="field2">Mã Trưởng Phòng</label>
                    <input type="text" id="field2" name="MaTrPhong" >
                </div>
                
                 <div class="form-group">
                    <label for="field2">Mã Phòng Ban Cha</label>
                    <input type="text" id="field2" name="MaPBCha" >
                </div>
        
                <input type="submit" value="Thêm">
            </form>
        </div>
    </div>
</body>

</html>