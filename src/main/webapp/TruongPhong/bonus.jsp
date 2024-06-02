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
            <h2>Thêm Khen Thưởng</h2>
            <form action="../insertKhenThuong" method="post">
                <div class="form-group">
                    <label for="field1">MÃ KHEN THƯỞNG</label>
                    <input type="text" id="field1" name="MaKT" required>
                </div>

                <div class="form-group">
                    <label for="field2">MÃ NHÂN VIÊN</label>
                    <input type="text" id="field2" name="MaNV" required>
                </div>


                <!-- <div class="form-group">
                    <label for="field3">TÊN NHÂN VIÊN</label>
                    <input type="text" id="field2" name="field3" required>
                </div> -->

                <div class="form-group">
                    <label for="textareaField">LÝ DO</label>
                    <textarea id="textareaField" name="LyDo" rows="4" required></textarea>
                </div>

                <div class="form-group">
                    <label for="field4">NGÀY KHEN</label>
                    <input type="date" id="birthday" name="NgayKhen" required>
                </div>
                
                <div class="form-group">
                    <label for="field4">SỐ QUYẾT ĐỊNH</label>
                    <input type="text" id="birthday" name="SoQuyetDinh" required>
                </div>

                <div class="form-group">
                    <label for="field5">TÊN NGƯỜI KÝ</label>
                    <input type="text" id="field4" name="NguoiKy" required>
                </div>

                <button type="submit">THÊM</button>

            </form>

        </div>
    </div>
</body>

</html>