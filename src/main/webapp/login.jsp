
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.NhanVien" %>

<!DOCTYPE html>
<html>
<head>
<title>Đăng Nhập</title>

<!-- BIỂU TƯỢNG -->

<link rel="shortcut icon" href="assets/img/book.png">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

<!-- <link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/style.css"> -->

<script>
	
</script>

</head>

<!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

<body>
	<%
		String errMsg = (String) request.getAttribute("errMsg");
		NhanVien account = (NhanVien) session.getAttribute("user");
	%>
	
	<!-- Check session -->
	<% 
	if(account != null){ 
	%>
	<% 
	response.sendRedirect("loginsuccess.jsp"); 
	%>
	<%
	} 
	%>
<form action="<%=request.getContextPath()%>/login" method="post">
	<section class="vh-100" style="background-color: #eee;">
		<div class="container h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">ĐĂNG
										NHẬP</p>

									<form class="mx-1 mx-md-4" id="frmlogin" method="POST" action="index.jsp">

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-floating flex-fill mb-0">
												<input type="text" name="MaNV" class="form-control" />
												<label class="form-label" for="form3Example1c" style="font-size:20px">Tên
													đăng nhập</label>
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-floating flex-fill mb-0">
												<input type="password" name="MatKhau" class="form-control" style="margin-top:10px" />
												<label class="form-label" for="form3Example4c" style="font-size:20px; margin-top:10px">Mật
													khẩu</label>
											</div>
										</div>

										<% if(errMsg != null){ %><p style="color: red; font-weight: bold; text-align: center; font-size:20px"><%=errMsg %></p><%} %>

										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<button type="submit" class="btn btn-primary btn-lg" style="font-size:20px ; margin-top:10px">Đăng
												nhập</button>
										</div>

									</form>
								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

									<img
										src="https://blog.dktcdn.net/files/quan-ly-nhan-su-hieu-qua.jpg"
										class="img-fluid" alt="Sample image">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</form>
</body>
</html>