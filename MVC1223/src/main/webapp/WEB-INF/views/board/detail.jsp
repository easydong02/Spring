<%@page import="com.koreait.mvc1223.domain.Board"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
Board board =(Board)request.getAttribute("board");

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
function update(){
	if(confirm("수정하시겠어요?")){
		form1.action="/board/update";
		form1.method="post";
		form1.submit();
	}
}
function del(){
	if(confirm("삭제하시겠어요?")){
		form1.action="/board/delete";
		form1.method="get";
		form1.submit();
	}
}

//답변을 작성할 수 있는 폼
function replyForm(){
	form1.action="/reply/form";
	form1.method="post";
	form1.submit();
}

</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form name ="form1">
  
    <input type="hidden" 	name="board_id" value = "<%=board.getBoard_id()%>">
    <input type="text" 	 	name="team" 	value = "<%=board.getTeam()%>">
    <input type="text"  	name="step" 	value = "<%=board.getStep()%>">
    <input type="text" 		name="depth" 	value = "<%=board.getDepth()%>">
    
    <input type="text"  name="title" value = "<%=board.getTitle()%>">

    <input type="text"  name="writer" value = "<%=board.getWriter()%>">
	
    <textarea			name="content"  style="height:200px"><%=board.getContent()%></textarea>

    <input type="button" value="답변달기" onClick="replyForm()">
    <input type="button" value="수정" onClick="update()">
    <input type="button" value="삭제" onClick="del()">
    <input type="button" value="목록" onClick="history.back()">
  </form>
</div>

</body>
</html>