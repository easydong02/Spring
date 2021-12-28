<%@ page contentType="text/html;charset=UTF-8"%>
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
	form1.action="/notice/regist";
	form1.method="post";
	form1.encoding="multipart/form-data"; //html은 enctype= ~~
	form1.submit();
}
function uploadSend(){
	form1.action="/notice/upload";
	form1.method="post";
	form1.encoding="multipart/form-data"; //html은 enctype= ~~
	form1.submit();
}
</script>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form name ="form1">
    <input type="text"  name="title" placeholder="Your name..">

    <input type="text"  name="writer" placeholder="Your last name..">

    <textarea				name="content" placeholder="Write something.." style="height:200px"></textarea>
	<input type="file" name="myFile"> 
	<p>
    <input type="button" value="Submit" onClick="regist()">
    <input type="button" value="업로드" onClick="uploadSend()">
  </form>
</div>

</body>
</html>
