<%@page import="Models.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUAN LY NHAN VIEN</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
            
            <%NhanVien nv = (NhanVien)request.getAttribute("maNV"); %>
            <h2>Sửa Nhân Viên</h2>
            	<form action="./updateNhanVien" method="post">
                <div class="form-group">
                    <label for="field1">Mã Nhân Viên</label>
                    <input type="text" id="field1" name="MaNV" value="<% if(nv!=null){%><%=nv.getMaNV() %><%}%>" required>
                </div>
        
                <div class="form-group">
                    <label for="field2">Tên Nhân Viên</label>
                    <input type="text" id="field2" name="HoTen" value="<% if(nv!=null){%><%=nv.getHoTen() %><%}%>" required>
                </div>

                <%-- <div class="form-group">
                    <label for="field2">Chức Vụ</label>
                    <input type="text" id="field2" name="TenCV" value="<% if(nv!=null){%><%=nv.getTenCV() %><%}%>" >
                </div> --%>
                
                 <%-- <div class="form-group">
                    <label for="field2">Phòng Ban</label>
                    <input type="text" id="field2" name="TenPB" value="<% if(nv!=null){%><%=nv.getTenPB() %><%}%>" >
                </div> --%>
                
                <%--  <div class="form-group">
                    <label for="chinhanh">Chi Nhánh</label>
				        <input type="hidden" id="TenCN" name="TenCN">
				        <select id="chinhanh" name="chinhanh">
				            <c:forEach var="cn" items="${listCN}">
				                <option value="${cn.getMaCN()}">${cn.getTenCN()}</option>			             
				            </c:forEach>  
				        </select>
                </div> --%>
                
                <%-- <div class="form-group">
                    <label for="field2">Phòng Ban</label>
                    <input type="text" id="field2" name="TenPB" value="<% if(nv!=null){%><%=nv.getTenPB() %><%}%>" >
                </div> --%>
                
                <div class="form-group">
                    <label for="chucvu">Chức Vụ</label>
				        <input type="hidden" id="TenCV" name="TenCV">
				        <select id="chucvu" name="chucvu">
				            <c:forEach var="cv" items="${listCV}">
				                <option value="${cv.getMaCV()}">${cv.getTenCV()}</option>			             
				            </c:forEach>  
				        </select>
                </div>
                
                <div class="form-group">
                    <label for="phongban">Phòng Ban</label>
				        <input type="hidden" id="TenPB" name="TenPB">
				        <select id="phongban" name="phongban">
				            <c:forEach var="pb" items="${listPB}">
				                <option value="${pb.getMaPB()}">${pb.getTenPB()}</option>			             
				            </c:forEach>  
				        </select>
                </div>
                
                
               
                
                <div class="form-group">
                    <label for="field4">Email</label>
                    <input type="text" id="field4" name="Email" value="<% if(nv!=null){%><%=nv.getEmail() %><%}%>">
                </div>
                
                 <div class="form-group">
                    <label for="textareaField">Số Điện Thoại</label>
                    <input type	="text" name="SDT"  value="<% if(nv!=null){%><%=nv.getSDT() %><%}%>">
                </div>
                
                <div class="form-group">
                    <label for="field2">Giới Tính</label>
                    <input type="text" id="field2" name="GioiTinh" value="<% if(nv!=null){%><%=nv.getGioiTinh() %><%}%>">
                </div>
                
                <div class="form-group">
                    <label for="field2">Ngày Sinh</label>
                    <input type="date" id="field2" name="NgSinh" value="<% if(nv!=null){%><%=nv.getNgSinh() %><%}%>">
                </div>
                
                
                <div class="form-group">
                    <label for="field5">Địa Chỉ</label>
                    <input type="text" id="field5" name="DiaChi" value="<% if(nv!=null){%><%=nv.getDiaChi() %><%}%>">
                </div>
                
                <div class="form-group">
                    <label for="field4">CCCD</label>
                    <input type="text" id="field4" name="CCCD" value="<% if(nv!=null){%><%=nv.getCCCD() %><%}%>">
                </div>
        
                <div class="form-group">
                    <label for="field5">Ngày Cấp</label>
                    <input type="date" id="field5" name="NgayCap" value="<% if(nv!=null){%><%=nv.getNgayCap() %><%}%>">
                </div>

                <div class="form-group">
                    <label for="textareaField">Nơi Cấp</label>
                    <input type="text" name="NoiCap" value="<% if(nv!=null){%><%=nv.getNoiCap() %><%}%>" >
                </div>
                
                <div class="form-group">
                    <label for="textareaField">Dân Tộc</label>
                    <input type="text" name="DanToc" value="<% if(nv!=null){%><%=nv.getDanToc() %><%}%>" >
                </div>
                
                <div class="form-group">
                    <label for="textareaField">Tôn Giáo</label>
                    <input type="text" name="TonGiao" value="<% if(nv!=null){%><%=nv.getTonGiao() %><%}%>">
                </div>
        
                <input type="submit" value="Cập Nhật">
            </form>
        </div>
    </div>
    <script>
	    var phongbanSelect = document.getElementById('phongban');
	    var tenPhongBanInput = document.getElementById('TenPB');
	
	    // Hàm cập nhật giá trị
	    function updateTenPhongBan() {
	        var selectedOption = phongbanSelect.options[phongbanSelect.selectedIndex];
	        tenPhongBanInput.value = selectedOption.text;
	    }
	
	    // Cập nhật giá trị ngay khi trang tải lên
	    updateTenPhongBan();
	
	    // Cập nhật giá trị khi người dùng thay đổi lựa chọn
	    phongbanSelect.addEventListener('change', updateTenPhongBan);
	    //
	    
	    
	    var chucvuSelect = document.getElementById('chucvu');
	    var tenChucVuInput = document.getElementById('TenCV');
	
	    // Hàm cập nhật giá trị
	    function updateTenChucVu() {
	        var selectedOption = chucvuSelect.options[chucvuSelect.selectedIndex];
	        tenChucVuInput.value = selectedOption.text;
	    }
	
	    // Cập nhật giá trị ngay khi trang tải lên
	    updateTenChucVu();
	
	    // Cập nhật giá trị khi người dùng thay đổi lựa chọn
	    chucvuSelect.addEventListener('change', updateTenChucVu);
	</script>
</body>

</html>