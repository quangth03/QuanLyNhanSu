<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>IMPORT EXCEL</title>
    <script src="../js/xlsx.full.min.js"></script>
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
            <div class="table-container">
                <input type="file" id="fileInput" accept=".xlsx, .xls" onchange="handleFile()">

                <table id="excelTable" class="content-table">
                    <!-- Excel table content will be inserted here -->
                </table>

                <script>
                    function handleFile() {
                        const fileInput = document.getElementById('fileInput');
                        const excelTable = document.getElementById('excelTable');

                        const file = fileInput.files[0];

                        if (file) {
                            const reader = new FileReader();

                            reader.onload = function (e) {
                                const data = new Uint8Array(e.target.result);
                                const workbook = XLSX.read(data, { type: 'array' });
                                const sheetName = workbook.SheetNames[0];
                                const sheet = workbook.Sheets[sheetName];

                                const table = XLSX.utils.sheet_to_html(sheet, { id: 'excelTable' });

                                // Insert the table content into the HTML
                                excelTable.innerHTML = table;
                            };

                            reader.readAsArrayBuffer(file);
                        } else {
                            excelTable.innerHTML = ''; // Clear the table if no file is selected
                        }
                    }
                </script>
            </div>
            <button>Them</button>
        </div>
    </div>
</body>

</html>