<%@page import="com.koreait.mvc1223.domain.Board"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
Board board = (Board)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script>
function regist(){
	//답변 등록 요청
	form1.action="/reply/regist";
	form1.method="post";
	form1.submit();
}
</script>
</head>
<body>

<h3>답변 폼</h3>

<div class="container">
  <form name ="form1">
  	<input type="hidden" 	name="board_id" value = "<%=board.getBoard_id()%>">
    <input type="text" 	 	name="team" 	value = "<%=board.getTeam()%>">
    <input type="text"  	name="step" 	value = "<%=board.getStep()%>">
    <input type="text" 		name="depth" 	value = "<%=board.getDepth()%>">
  	
  
    <input type="text"  name="title" 	placeholder="Your name..">
    <input type="text"  name="writer" 	placeholder="Your last name..">
    <textarea			name="content" 	placeholder="Write something.." style="height:200px"></textarea>
	<p>
    <input type="button" value="답변등록" onClick="regist()">
  </form>
</div>

</body>
</html>
