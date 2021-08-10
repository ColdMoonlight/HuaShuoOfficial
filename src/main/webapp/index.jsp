<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% pageContext.setAttribute("APP_PATH" , request.getContextPath()); %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Admin</title>
	</head>
	<body class="c-app">
		
		<!-- custom script -->
		<script> window.location.href = "${APP_PATH}/login.html"; </script>
	</body>
</html>