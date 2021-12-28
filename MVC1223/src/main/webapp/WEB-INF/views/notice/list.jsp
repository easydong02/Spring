<%@page import="com.koreait.mvc1223.domain.Notice"%>
<%@page import="com.koreait.shoppingmall.util.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%
	List<Notice> noticeList = (List)request.getAttribute("noticeList");
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
	location.href="/notice/write";
}
</script>
</head>
<body>
<table>
  <tr>
    <th>No</th>
    <th>이미지</th>
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
  <%Notice notice = noticeList.get(curPos++); %>
  <tr>
    <td><%=num--%></td>
    <td><img src= "/resources/data/<%=notice.getFilename()%>" width="40px"></td>
    <td><a href="/notice/detail?notice_id=<%=notice.getNotice_id()%>"><%=notice.getTitle() %></a></td>
    <td><%=notice.getWriter() %></td>
    <td><%=notice.getRegdate() %></td>
    <td><%=notice.getHit()%></td>
  </tr>
  <%} %>
  <tr>
  	<td colspan="6" align="center">
  		<%for(int i =pager.getFirstPage();i<=pager.getLastPage();i++){ %>
  		<%if(i>pager.getTotalPage())break; %>
  		[<%=i %>]
  		<%} %>
  </tr>
  <tr>
  	<td colspan="6">
  		<button onClick="writeForm()" value = "글 등록"></button>
  	</td>
  </tr>
  
</table>

</body>
</html>
