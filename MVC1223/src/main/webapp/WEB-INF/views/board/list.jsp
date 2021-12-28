<%@page import="com.koreait.mvc1223.domain.Board"%>
<%@page import="com.koreait.shoppingmall.util.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%
	List<Board> boardList = (List)request.getAttribute("boardList");
	Pager pager = (Pager)request.getAttribute("pager");
	
%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}
</style>
<script>
function writeForm(){
	location.href="/board/write";
}
</script>
</head>
<body>
<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>
  <%int curPos =pager.getCurPos();
  		int num = pager.getNum();
  
  %>
  <%for(int i =1;i<=pager.getPageSize();i++){ %>
  <%if(num<1)break; %>
  <%Board board = boardList.get(curPos++); %>
  <tr>
    <td><%=num--%></td>
    
    <td >
    	<%if(board.getDepth()>0){ %>
    	<img src="/resources/images/re.png" width="20px" style="margin-left:<%=10*board.getDepth()%>px">
    	<%} %>
    	<a href="/board/detail?board_id=<%=board.getBoard_id()%>" ><%=board.getTitle() %></a>
    </td>
    <td><%=board.getWriter() %></td>
    <td><%=board.getRegdate() %></td>
    <td><%=board.getHit()%></td>
  </tr>
  <%} %>
  <tr>
  	<td colspan="5" align="center">
  		<%for(int i =pager.getFirstPage();i<=pager.getLastPage();i++){ %>
  		<%if(i>pager.getTotalPage())break; %>
  		[<%=i %>]
  		<%} %>
  </tr>
  <tr>
  	<td colspan="5">
  		<button onClick="writeForm()" value = "글 등록"></button>
  	</td>
  </tr>
  
</table>

</body>
</html>
