<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" content="context/html">
    <title>Home Page</title>
</head>
<body>
	<h1>IMPORT DATA FROM EXCEL</h1>
    <form action="HomeController" method="post">
        Choose Excel File: <input type="file" name="file" />
        <br/>

        <input type="submit" value="Import" />
    </form>
</body>
</html>