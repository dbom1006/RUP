<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="Model.Bean.ChitietBean"%>
<%@page import="Model.Bean.QuanlyBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Quản lý đấu giá</title>
<jsp:include page="header.jsp" />
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="brand" href="#" style="height: 50px;
    padding: 15px 15px;
    font-size: 18px;
    line-height: 20px;
        color: #1b926c;"><i class="fa fa-money fa-3x" aria-hidden="true"></i></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><h2 style="
        margin-top: 9px;
    margin-bottom: 10px;">Daugiaonline.com</h2></li>
       <li  style="padding-left: 30px;"><a href="SanPham" >Trang chủ</a></li>
        <li  class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Danh mục <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Nhập từ khóa..">
        </div>
        <button type="submit" class="btn btn-success">Tìm</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
       <li class="dropdown">
     <% if(session.getAttribute("username")!=null){  %>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=session.getAttribute("username") %> <span class="caret"></span></a>
          <% } %>
          <ul class="dropdown-menu">
            <li><a href="logout.jsp?id=1">Logout</a></li>
             <li><a href="QuanLy?user=<%=session.getAttribute("username") %>">Quản lý sản phẩm</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container-fluid" style="background: #f2f2f2; padding: 20px;">
	<div class="row">
	<div class="col-md-1">
			
		</div>
		<div class="col-md-2" style="border-right: 1px solid #333;">
		<style>
			ul.t li{
			list-style-type: none;
			margin-top: 30px;
			}
		
		</style>
			<ul class="t">
			
				<li><i class="fa fa-info-circle fa-2x" aria-hidden="true">  Thông tin</i></li>
				<li><i class="fa fa-gift fa-2x" aria-hidden="true">  Sản phẩm</i></li>
				<li><i class="fa fa-money fa-2x" aria-hidden="true">  Đấu giá</i></li>
			</ul>
		</div>
		<div class="col-md-9">
			<h3 class="text-center">
				Sửa sản phẩm
			</h3>
			<div class="row">
				<div class="col-md-1">
				</div>
				<div class="col-md-10">
					
						<%
						
						
					ArrayList<ChitietBean> sp = (ArrayList <ChitietBean>) request.getAttribute("suasp"); 
								
						for(ChitietBean t : sp){ %>
						
					<form class="form-horizontal" role="form" method="POST" action="UpdateSanPham?id=<% out.print(t.getMaSP().trim()); %>">
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">Tên Sản Phẩm</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="tensanpham" id="inputEmail3" value="<% out.print(t.getTenSP()); %>" placeholder="Tên Sản Phẩm">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">Mô tả</label>
					    <div class="col-sm-10">
					    <textarea class="form-control" rows="5" name="mota" id="comment"><% out.print(t.getMoTa()); %></textarea>

					      
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">Hình Ảnh</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="hinhanh" id="inputPassword3" value="<% out.print(t.getAnh()); %>" placeholder="Hình Ảnh">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">Tag</label>
					    <div class="col-sm-10">
					      <input type="text" class="form-control" name="tag" id="inputPassword3" value="<% out.print(t.getGanThe()); %>" placeholder="Tag">
					    </div>
					  </div>
					  
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label"></label>
					    <div class="col-sm-10">
					      <%if(request.getParameter("error")!=null){ %>
					 
					    <p class="btn-success" style="width: 27%;padding: 10px;text-align: center;">Update thành công dữ liệu!</p>
					  <%} %>
					    </div>
					  </div>
					  
					    
					  
					  <div class="form-group">
					  
					
					    <div class="col-sm-offset-2 col-sm-4">
					      <button type="submit" class="btn btn-success">Đồng ý</button>
					      	      <a href="QuanLy?user=<%=session.getAttribute("username") %>" class="btn btn-danger">Trở lại</a>
					    </div>
					  </div>
					  
					  
					  
					  
					</form>
					
					<% } %>
						
						
						
				</div>
				<div class="col-md-1">
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>