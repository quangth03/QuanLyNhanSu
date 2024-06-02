<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>THÔNG TIN NHÂN VIÊN</title>
	<style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
</head>

<body>
	<%NhanVien nv = (NhanVien)request.getAttribute("nv"); %>
    <div class="header">
        <h1>XEM THÔNG TIN NHÂN VIÊN</h1>
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
        
            <h2>Thông Tin Cá Nhân</h2>
            <form action="<%=request.getContextPath()%>/insert" method="post">
                <div class="form-group">
                    <label for="field1">MÃ NHÂN VIÊN</label>
                    <input type="text" id="field1" name="MaNV" value="<%=nv.getMaNV() %>" required>
                </div>
        
                <div class="form-group">
                    <label for="field2">TÊN NHÂN VIÊN</label>
                    <input type="text" id="field2" name="HoTen" value="<%=nv.getHoTen() %>" required>
                </div>

                <div class="form-group">
                    <label for="field3">CHỨC VỤ</label>
                    <input type="text" id="field3" value="<%=nv.getTenCV() %>" required>
                </div>
        
                <div class="form-group">
                    <label for="field4">TÊN PHÒNG BAN</label>
                    <input type="text" id="field4" value="<%=nv.getTenPB() %>" required>
                </div>

                <div class="form-group">
                    <label for="field5">TÊN CHI NHÁNH</label>
                    <input type="text" id="field5" value="<%=nv.getTenCN() %>" required>
                </div>

                <div class="form-group">
                    <label for="field6">EMAIL</label>
                    <input type="text" id="field6" name="TenCV" value="<%=nv.getEmail() %>" required>
                </div>

                <div class="form-group">
                    <label for="field7">SDT</label>
                    <input type="text" id="field7" name="field7" value="<%=nv.getSDT() %>" required>
                </div>

                <div class="form-group">
                    <label for="field8">GIỚI TÍNH</label>
                    <input type="text" id="field7" name="field7" value="<%=nv.getGioiTinh() %>" required>
                </div>

                <div class="form-group">
                    <label for="field9">NGÀY SINH</label>
                    <input type="date" id="birthday" name="birthday" value="<%=nv.getNgSinh() %>" required>
                </div>
        
                <div class="form-group">
                    <label for="field10">ĐỊA CHỈ</label>
                    <input type="text" id="field8" name="field8" value="<%=nv.getDiaChi() %>" required>
                </div>

                <div class="form-group">
                    <label for="field11">CCCD</label>
                    <input type="text" id="field9" name="field9" value="<%=nv.getCCCD() %>" required>
                </div>
        
                <div class="form-group">
                    <label for="field12">NGÀY CẤP</label>
                    <input type="text" id="field10" name="field10" value="<%=nv.getNgayCap() %>" required>
                </div>

				<div class="form-group">
                    <label for="field12">NƠI CẤP</label>
                    <input type="text" id="field10" name="field10" value="<%=nv.getNoiCap() %>" required>
                </div>	
                
                <div class="form-group">
                    <label for="field12">DÂN TỘC</label>
                    <input type="text" id="field10" name="field10" value="<%=nv.getDanToc() %>" required>
                </div>
                
                <div class="form-group">
                    <label for="field12">TÔN GIÁO</label>
                    <input type="text" id="field10" name="field10" value="<%=nv.getTonGiao() %>" required>
                </div>

                <div class="form-group">
                    <label for="field13">NGÀY BẮT ĐẦU LÀM VIỆC</label>
                    <input type="date" id="startDate" name="startDate" value="<%=nv.getNgBatDauLamViec() %>" required>
                </div>
               
                <input type="submit" value="Cập Nhật">
            </form>

        </div>
    </div>
</body>

</html>