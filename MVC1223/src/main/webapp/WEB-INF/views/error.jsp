<%@page import="com.koreait.mvc1223.exception.NoticeException"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
이용에 불편을 드려 죄송합니다.<p>

<%RuntimeException e = (RuntimeException)request.getAttribute("e");

out.print(e.getMessage());

%>
</body>
</html>