<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Say Hello to WHO.</title>
</head>
<body>
	<img src="<%=request.getContextPath()%>/images/RoyElephant.png" width="128" height="128" />
	${sayHello}
</body>
</html>