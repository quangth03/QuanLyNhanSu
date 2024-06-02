<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>QUAN LY NHAN VIEN</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/form.css">
</head>

<body>

    <div class="header">
        <h1>XEM THÔNG TIN NHÂN VIÊN</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
    </div>

    <div class="container">
        
        <div class="sidebar">
           	<a href="<%=request.getContextPath()%>/listAllPhongBanTheoCN" >Danh Sách Phòng Ban</a>
            <a href="<%=request.getContextPath()%>/listAllNhanVienTheoCN" >Danh Sách Nhân Viên</a>
            <a href="<%=request.getContextPath()%>/thongTinCaNhanGD">Thông Tin Cá Nhân</a>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <h2>Chỉnh Sửa Nhân Viên</h2>
            <form action="#" method="post">
                <div class="form-group">
                    <label for="field1">MÃ NHÂN VIÊN</label>
                    <input type="text" id="field1" name="field1" required>
                </div>
        
                <div class="form-group">
                    <label for="field2">TÊN NHÂN VIÊN</label>
                    <input type="text" id="field2" name="field2" required>
                </div>

                <div class="form-group">
                    <label for="field3">MÃ CHI NHÁNH</label>
                    <input type="text" id="field2" name="field2" required>
                </div>
        
                <div class="form-group">
                    <label for="field4">MÃ PHÒNG BAN</label>
                    <input type="text" id="field2" name="field2" required>
                </div>

                <div class="form-group">
                    <label for="field5">MÃ TỔ</label>
                    <input type="text" id="field4" name="field4" required>
                </div>
        
                <div class="form-group">
                    <label for="field6">EMAIL</label>
                    <input type="text" id="field4" name="field4" required>
                </div>
        
                <div class="form-group">
                    <label for="field7">SO DIEN THOAI</label>
                    <input type="text" id="field5" name="field5" required>
                </div>

                <div class="form-group">
                    <label for="textareaField">DIA CHI</label>
                    <textarea id="textareaField" name="textareaField" rows="4" required></textarea>
                </div>
               
                <input type="submit" value="Submit">
            </form>

        </div>
    </div>
</body>

</html>