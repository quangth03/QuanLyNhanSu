<%@page import="Models.PhongBan"%>
<%@page import="java.util.List"%>
<%@page import="Models.ChiNhanh"%>
<%@page import="DAO.TreeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DANH SÁCH CÔNG TY</title>
    <style><%@include file="/css/style.css"%></style>
	<style><%@include file="/css/form.css"%></style>
<link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.css" rel="stylesheet" type="text/css"/>
<style>
summary {
  display: block;
  cursor: pointer;
  outline: 0; 
}

summary::-webkit-details-marker {
    display: none;
  }

body {
  background-color: white;
  color: black;  
  font-size: 1.6rem;
  font-family: arial;
  margin: 0;
  padding: 0;
}

.TongThe{
	position: absolute;
	height: 100%;
	width: 100%;
	overflow: scroll;
}

.tree-nav__item {
  display: block;
  white-space: nowrap;
  color: black;
  position: relative;
}
.tree-nav__item.is-expandable::before {
  border-left: 1px solid #333;
  content: "";
  height: 100%;
  left: 0.8rem;
  position: absolute;
  top: 2.4rem;
  height: calc(100% - 2.4rem);
}
.tree-nav__item .tree-nav__item {
  margin-left: 2.4rem;
}
.tree-nav__item.is-expandable[open] > .tree-nav__item-title::before {
  font-family: "ionicons";
  transform: rotate(90deg);
}
.tree-nav__item.is-expandable > .tree-nav__item-title {
  padding-left: 2.4rem;
}
.tree-nav__item.is-expandable > .tree-nav__item-title::before {
  position: absolute;
  will-change: transform;
  transition: transform 300ms ease;
  font-family: "ionicons";
  color: black;
  font-size: 1.1rem;
  content: "\f125";
  left: 0;
  display: inline-block;
  width: 1.6rem;
  text-align: center;
}

.tree-nav__item-title {
  cursor: pointer;
  display: block;
  outline: 0;
  color: black;
  font-size: 1.5rem;
  line-height: 3.2rem;
}
.tree-nav__item-title .icon {
  display: inline;
  padding-left: 1.6rem;
  margin-right: 0.8rem;
  color: black;
  font-size: 1.4rem;
  position: relative;
}
.tree-nav__item-title .icon::before {
  top: 0;
  position: absolute;
  left: 0;
  display: inline-block;
  width: 1.6rem;
  text-align: center;
}

.tree-nav__item-title::-webkit-details-marker {
  display: none;
}
</style>
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
<div class="main-content">
<div class="TongThe">
<%
TreeDAO controll = new TreeDAO();
List<ChiNhanh> listCN = controll.LayDSChiNhanh();
%>
<nav class="tree-nav">
	<a class="tree-nav__item-title">
	    <i class="icon ion-android-star"></i>
	    Cơ cấu công ty (<%=listCN.size() %> chi nhánh)
	 </a>
<%
for(ChiNhanh cn : listCN)
{
	List<PhongBan> ListPB = controll.LayDSPhongBan(cn.getMaCN());
	%>
	<details class="tree-nav__item is-expandable">
		<summary class="tree-nav__item-title"><%=cn.getMaCN()%>: <%=cn.getTenCN() %> (<%=ListPB.size() %> phòng ban)</summary>
			<div class="tree-nav__item">
					<%
						for(PhongBan pb : ListPB)
						{
							%>
							<a class="tree-nav__item-title "><i></i><%=pb.getMaPB()%>: <%=pb.getTenPB() %></a>
							<%
						}
						%>
			</div>	
		
	</details>
	<%
}
%>
</nav>
</div>
</div>
</div>
</body>
</html>