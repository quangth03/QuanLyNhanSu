<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUẢN LÝ PHÒNG BAN</title>
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
            <h2>Thêm phòng ban</h2>
            <form action="#" method="post">
                <div class="form-group">
                    <label for="field1">Field 1:</label>
                    <input type="text" id="field1" name="field1" required>
                </div>
        
                <div class="form-group">
                    <label for="field2">Field 2:</label>
                    <input type="text" id="field2" name="field2" required>
                </div>
        
                <div class="form-group">
                    <label for="field3">Field 3:</label>
                    <div class="styled-select">
                        <select required>
                            <option value="option1">Option 1</option>
                            <option value="option2">Option 2</option>
                            <option value="option3">Option 3</option>
                            <option value="option4">Option 4</option>
                        </select>
                    </div>
                </div>
        
                <div class="form-group">
                    <label for="field4">Field 4:</label>
                    <input type="text" id="field4" name="field4" required>
                </div>
        
                <div class="form-group">
                    <label for="field5">Field 5:</label>
                    <input type="text" id="field5" name="field5" required>
                </div>

               
                <input type="submit" value="Submit">
            </form>

        </div>
    </div>
</body>

</html>