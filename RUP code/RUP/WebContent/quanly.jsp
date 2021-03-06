<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
     <% if(session.getAttribute("username")!=null && session.getAttribute("iduser")!=null){  %>
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=session.getAttribute("username") %> <span class="caret"></span></a>
          <% } %>
          <ul class="dropdown-menu">
            <li><a href="logout.jsp?id=1">Logout</a></li>
             <li><a href="QuanLy?user=<%=session.getAttribute("username") %>&iduser=<%=session.getAttribute("iduser")%>">Quản lý sản phẩm</a></li>
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
				<li><a href="QuanLy?user=<%=session.getAttribute("username") %>"><i class="fa fa-gift fa-2x" aria-hidden="true">  Sản phẩm</i></a></li>
				<li><i class="fa fa-money fa-2x" aria-hidden="true">  Đấu giá</i></li>
			</ul>
		</div>
		<div class="col-md-9">
			<h3 class="text-center">
				Quản lý sản phẩm
			</h3>
			<div class="row">
				<div class="col-md-1">
				</div>
				<div class="col-md-10">
					<p><a href="themsanpham.jsp?iduser=<%=session.getAttribute("iduser")%>" class="btn btn-info">Thêm sản phẩm</a></p>
					<table class="table">
						<thead>
					
						
						
							<tr>
								<th>
									#
								</th>
								<th>
									Tên
								</th>
								<th>
									Mô tả
								</th>
								<th>
									Hình ảnh
								</th>
								<th>
									Tag
								</th>
								<th>
									
								</th>
							</tr>
						</thead>
						<tbody>
							<%
	
					ArrayList<QuanlyBean> sp = (ArrayList <QuanlyBean>) request.getAttribute("quanly"); 
								int i=0;
						for(QuanlyBean t : sp){ i++; %>
							<tr>
								<td>
									<% out.print(i); %>
								</td>
								<td>
									<% out.print(t.getTenSP()); %>
								</td>
								<td>
									<% out.print(t.getMoTa()); %>
								</td>
								<td>
									<% out.print(t.getHinhAnh()); %>
								</td>
								<td>
									<% out.print(t.getGanThe()); %>
								</td>
								<td>
									<a href="SuaSanPham?id=<% out.print(t.getMaSP()); %>"><i class="fa fa-pencil" style="color: green;" aria-hidden="true"></i></a>
									<a href="XoaSanPham?id=<% out.print(t.getMaSP().trim()); %>&user=<%=session.getAttribute("username") %>"><i class="fa fa-trash" style="color: red; margin-left: 10px;" aria-hidden="true"></i></a>
								
								</td>
							</tr>
							<% } %>
						
						</tbody>
					</table>
				</div>
				<div class="col-md-1">
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>