<%@page import="com.koreait.shoppingmall.domain.Category"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Category> categoryList =(List)request.getAttribute("categoryList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>
	
	<%@ include file="../../inc/head_link.jsp" %>
  <!-- summernote -->
  <link rel="stylesheet" href="/resources/admin/plugins/summernote/summernote-bs4.min.css">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/resources/admin/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
  <%@ include file="../../inc/navbar.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@ include file="../../inc/sidebar.jsp" %>  

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        <div class="row">
        
          <!-- ???????????? ????????? begin -->
          <div class="col-3">
              <div class="card">
              <div class="card-header">
                <h3 class="card-title">Expandable Table Tree</h3>
              </div>
              <!-- ./card-header -->
              <div class="card-body p-0">
                <table class="table table-hover">
                  <tbody>

					<%for(Category category  : categoryList){ %>	
                    <tr data-widget="expandable-table" aria-expanded="true">
                      <td>
                        <%if(category.getDepth()>0){%>
                        	<i class="expandable-table-caret fas fa-caret-right fa-fw" style="margin-left:<%=20*category.getDepth()%>px"></i>
                        <%}%>
                        <a href="javascript:selCategory('<%=category.getCategory_name() %>',  <%=category.getCategory_id() %>)"><%=category.getCategory_name() %></a>
                      </td>
                    </tr>
                    <%} %>
                    
                    <tr>
                      <td>
						<button type="button" class="btn btn-info" onClick="location.href='/admin/category/registform';">???????????? ??????</button>                      
                      </td>
                    </tr>
                    
                  </tbody>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            </div>
          <!-- ???????????? ????????? end -->
          
          <!-- ?????? ????????? begin -->
          <div class="col-9">
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Quick Example</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form name="form1" enctype="multipart/form-data">
                <div class="card-body">
                
                  <div class="form-group">
                    <select class="form-control" id="category_id" name="category.category_id">
                    	<option>???????????? ???????????? ??????</option>
                    </select> 
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="????????? ??????.." name="product_name">
                  </div>
                  
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="?????? ??????.." name="price">
                  </div>
                  
                  <div class="form-group">
                    <textarea id="introduce" placeholder="???????????? ??????" name="introduce">?????? ?????? ??????</textarea>
                  </div>
                  
                  <div class="form-group">
                    <textarea id="detail" name="detail">?????? ?????? ??????</textarea>
                  </div>
                  
                  <div class="form-group">
                  	<div id="preview"></div>
                  	
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" multiple name="imgFiles">
                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                  </div>
                  
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="button" class="btn btn-info" id="bt_regist">??????</button>
                  <button type="button" class="btn btn-info" onClick="location.href='/admin/product/list';">??????</button>
                </div>
              </form>
            </div>
            </div>
          <!-- ?????? ????????? end -->
            
            <!-- /.card -->
          </div>
        </div>
        
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
  <%@ include file="../../inc/footer.jsp" %>  
  

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<%@ include file="../../inc/bottom_link.jsp" %>

<!-- Summernote -->
<script src="/resources/admin/plugins/summernote/summernote-bs4.min.js"></script>

<!-- bs-custom-file-input ?????????????????? ?????????????????? -->
<script src="/resources/admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>

<script>
$(function () {
  bsCustomFileInput.init();
});
</script>
<script>
 $(function () {
    // Summernote
    $('#introduce').summernote();  
    $('#detail').summernote();  
    
    //????????? ???????????? ?????? ????????? 
    
    
    $("input[name='imgFiles']").change(function(){
		preview2(this);		    	
    });
	/*
	document.querySelector("input[name='imgFiles']").addEventListener("change", function(){
		preview(this);		
	});
	*/
	
	$("#bt_regist").click(function(){
		regist();
	});
	
})

//select ??????????????? ????????? ???????????? ????????????!!
function selCategory(category_name, category_id){
	var sel = document.querySelector("#category_id");
	sel.options[0].text=category_name; //???????????? ????????? ????????? ?????? 	
	sel.options[0].value=category_id; //???????????? ????????? ????????? ??? 	
}

function regist(){
	form1.action="/admin/product/regist";
	form1.method="post";
	form1.encoding="multipart/form-data";
	form1.submit();
}
 
//?????????????????? ????????? ??????
function preview2(obj){
	for(var i=0;i<obj.files.length;i++){		
		var reader = new FileReader();
		reader.onload=function(e){
		 $("#preview").append($("<img src='"+e.target.result+"' width='100px'>"));
		 
		}
		reader.readAsDataURL(obj.files[i]);
	}
}

//????????????????????? stream??? ????????????..
function preview(obj){
	console.log("???????????? ???????????? ??????????????? ", obj);
	console.log("obj.files is ", obj.files);
	
	for(var i=0;i<obj.files.length;i++){
		//????????? ?????? ??????????????? ????????????, ??????????????? ?????? ????????? ???????????????!! ????????? ???????????? ????????? ????????? ????????????
		var reader = new FileReader();
		
		reader.onload=function(e){
			console.log("???????????? ?????? e??? ", e);
			
			//div??? ???????????? img ?????? ???????????? ??? ?????? src????????? e.target.result
			var img=document.createElement("img");
			img.src=e.target.result;
			img.style.width=100+"px";
			
			document.getElementById("preview").appendChild(img); //???????????? ????????? ?????? div??? ??????!!
			
		}; //????????? ??? ???????????????, ??????????????? ????????????..
		
		
		reader.readAsDataURL(obj.files[i]); //?????? ???????????????...
	}
}
</script>
</body>
</html>
