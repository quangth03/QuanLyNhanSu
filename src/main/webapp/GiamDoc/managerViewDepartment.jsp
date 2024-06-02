<%@page import="java.util.List"%>
<%@page import="Models.PhongBan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DANH SÁCH PHÒNG BAN</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
	<style><%@include file="/css/table.css"%></style>
</head>

<body>

    <div class="header">
        <h1>GIÁM ĐỐC</h1>
        <a href="<%=request.getContextPath()%>/logout"><button class="logout" type="submit">ĐĂNG XUẤT</button></a>
    </div>

    <div class="container">
        <!-- <iframe src="../navbar.html" class="sidebar" width="200" height="100%"></iframe> -->
        <div class="sidebar">
            <a href="<%=request.getContextPath()%>/listAllPhongBanTheoCN" >Danh Sách Phòng Ban</a>
            <a href="<%=request.getContextPath()%>/listAllNhanVienTheoCN" >Danh Sách Nhân Viên</a>
            <a href="<%=request.getContextPath()%>/thongTinCaNhanGD">Thông Tin Cá Nhân</a>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <h2>Xem Danh Sách Phòng Ban</h2>
            <%List<PhongBan> listAllPhongBanTheoCN = (List<PhongBan>)request.getAttribute("listAllPhongBanTheoCN");%>
            <div class="table-container">
                <table class="content-table">
                    <thead>
                        <tr>
                            <th>Mã Phòng Ban</th>
                            <th>Tên Phòng Ban</th>
                            <th>Tên Trưởng Phòng</th>
                            <th>Tên Phòng Ban Cha</th>
                            <th>Tên Chi Nhánh</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
								for(PhongBan pb : listAllPhongBanTheoCN)
								{%>
								<tr>
									<td><%=pb.getMaPB()%></td>
									<td><%=pb.getTenPB()%></td>
									<td><%=pb.getMaTrPhong()%></td>
									<td><%=pb.getMaPBCha()%></td>
									<td><%=pb.getMaCN()%></td>
                        		</tr> <%}
									
                                 %>
                    </tbody>
                </table>
            </div>
         </div>
    </div>
</body>

</html>