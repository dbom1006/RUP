<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.Bean.MaxBean"%>
<%@page import="Model.Bean.CuocdaugiaBean"%>
<%@page import="Model.Bean.ChitietBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Xem phiên đấu giá</title>
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


<div class="container-fluid" style="background: #f2f2f2;     padding-top: 15px;">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		
		<%
	
					ArrayList<ChitietBean> sp = (ArrayList <ChitietBean>) request.getAttribute("chitiet"); 
								int i=0;
						for(ChitietBean t : sp){ i++; %>
						
						
			<div class="row">
				<div class="col-md-5">
					<img style="width:100%" src="img/<%out.print(t.getAnh()); %>" />
				</div>
				<div class="col-md-1">
				</div>
				<div class="col-md-6">
					<h2><%out.print(t.getTenSP()); %></h2>
					
					<%
	
					ArrayList<MaxBean> a = (ArrayList <MaxBean>) request.getAttribute("max"); 
								
						for(MaxBean b : a){  %>
						
						
					<p><i class="fa fa-user fa-lg" aria-hidden="true">   <%out.print(t.getTenTV()); %></i></p>
					<p style="color: red; font-weight: 700; font-style: italic; font-size: 30px;"><%out.print(b.getGiaDuocDat()); %>.000 VNĐ</p>
					<hr style="    border-top: 2px solid #000">
					
					<p>Bước giá: 100.000</p>
					
					<div class="row">
					<div class="col-md-5">
						<form role="form">
						 		<div class="input-group" style="width:100%">
									               	<span class="input-group-btn">
									                  	<button class="btn btn-white btn-minuse" type="button">-</button>
									               	</span>
									               	<input type="text" class="form-control no-padding add-color text-center height-25" maxlength="3" value="<%out.print(b.getGiaDuocDat()); %>">
									               	<span class="input-group-btn">
									                  	<button class="btn btn-red btn-pluss" type="button">+</button>
									               	</span>
							 </div><!-- /input-group -->
						</form>
					<%} %>
					</div>
					<div class="col-md-2">
							<button type="button" class="btn btn-danger">
								Đấu giá
							</button>
					</div>
					<div class="col-md-4">
					<button type="button" class="btn btn-success">
								Hủy
							</button>
					</div>
					</div>
					
					<hr style="    border-top: 2px solid #000">
					
					<div class="row">
					<div class="col-md-6">
						<table class="table table-hover">
						  
						  <tr>
						  	<th>ID</th>
						  	<th>User</th>
						  	<th>Số Tiền</th>
						  </tr>
					<%
	
					ArrayList<CuocdaugiaBean> tt = (ArrayList <CuocdaugiaBean>) request.getAttribute("phien"); 
								int j=0;
						for(CuocdaugiaBean s : tt){ j++; %>
						  <tr>
						  	<td><% out.print(j); %></td>
						  	<td><%out.print(s.getTenTV()); %></td>
						  	<td><%out.print(s.getGiaDuocDat()); %></td>
						  </tr>
						  <% } %>
						</table>
					</div>
					
					<div class="col-md-6" style="border: 1px solid #000; padding-top: 15px;padding-bottom: 15px;">
					<style>
						.is-countdown {
							     border: none !important;
							    background-color: none !important;
							}
					
					</style>
					
						<i class="fa fa-clock-o fa-3x" aria-hidden="true"> Kết thúc</i>
						<input class="tuan" type="hidden" id="<%out.print(i); %>" value="<%out.print(i); %>" title="<%out.print(t.getTGKetThuc()); %>"/>
						<div class="count" id="<% out.print("defaultCountdown"+i); %>"></div>
					</div>
					</div>
						
					
					
				</div>
			</div>
		</div>
		<div class="col-md-2">
		</div>
		
		
	</div>
	
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<hr style="    border-top: 2px solid #000">
			<h2 style="text-align: center;'">Mô tả</h2>
				<p style="background: #fff; padding: 15px;"><%out.print(t.getMoTa()); %></p>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	
	
</div>

<% } %>

<script>

$( document ).ready(function() {
    
	$('.btn-minuse').on('click', function(){            $(this).parent().siblings('input').val(parseInt($(this).parent().siblings('input').val()) - 100)
	})

	$('.btn-pluss').on('click', function(){            $(this).parent().siblings('input').val(parseInt($(this).parent().siblings('input').val()) + 100)
	})
	    
});



	$(function () {
		
		var countItems = $(".tuan").length;
	
		for(var i=0; i<=countItems; i++ ){
			var date = $("#"+i).attr('title');
			var austDay = new Date(date);
			console.log(austDay);
			var id = $("#"+i).val();
			$('#defaultCountdown'+id).countdown({until: austDay});
		}
		
	});
</script>

</body>
</html>