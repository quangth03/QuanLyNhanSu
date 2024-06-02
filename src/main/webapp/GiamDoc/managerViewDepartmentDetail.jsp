<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>XEM PHÒNG BAN</title>
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/form.css">
</head>

<body>

    <div class="header">
        <h1>GIÁM ĐỐC</h1>
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
            <h2>Xem Chi Tiết Phòng Ban</h2>
            <form action="#" method="post">
                <div class="form-group">
                    <label for="field1">MÃ PHÒNG BAN</label>
                    <input type="text" id="field1" name="field1" required>
                </div>
        
                <div class="form-group">
                    <label for="field2">TÊN PHÒNG BAN</label>
                    <input type="text" id="field2" name="field2" required>
                </div>
    
        
                <div class="form-group">
                    <label for="field4">MÃ TRƯỞNG PHÒNG</label>
                    <input type="text" id="field4" name="field4" required>
                </div>
        
                <div class="form-group">
                    <label for="field5">TÊN TRƯỞNG PHÒNG</label>
                    <input type="text" id="field5" name="field5" required>
                </div>

               
                <input type="submit" value="Submit">
            </form>

        </div>
    </div>
</body>

</html>