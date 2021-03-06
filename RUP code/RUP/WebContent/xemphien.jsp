<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.Bean.MaxBean"%>
<%@page import="Model.Bean.XemphienBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@page import="Model.Bean.SanphamBean"%>
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
        <li class="dropdown">
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
             <li><a href="QuanLy?user=<%=session.getAttribute("username") %>&iduser=<%=session.getAttribute("iduser")%>">Quản lý sản phẩm</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container-fluid" style="background: #f2f2f2; margin-top: 30px; ">
<div class="row" style="padding: 30px 0px;">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
			<div class="row">
				
	<%
	
					ArrayList<XemphienBean> sp = (ArrayList <XemphienBean>) request.getAttribute("sanpham"); 
								int i=0;
						for(XemphienBean t : sp){ i++; %>
								
								
								
					<div class="col-md-6" style="margin-top: 20px;">
				
				<div class="col-md-12" style="border: 2px dashed #FF5722; background: #fff;">
					<div class="row" style="padding: 10px;">
						<div class="col-md-6">
							<img style="width: 100%;  height: 218px;" src="img/<%out.print(t.getHinhanh()); %>" >
						</div>
						<div class="col-md-6">
							<div class="chitiet" style="text-align: center;">
								<h2><%out.print(t.getTenSP()); %></h2>
								
								<p><h4 style="font-style: italic; color: red;"><%out.print(t.getGiakhoidiem()); %>000 VNĐ</h4></p>
								
								<p><%out.print(t.getMota()); %></p>
								
							
							</div>
						</div>
					</div>

					<div class="row" style="padding: 10px;">
						<div class="col-md-6">
						<input class="tuan" type="hidden" id="<%out.print(i); %>" value="<%out.print(i); %>" title="<%out.print(t.getThoigianketthuc()); %>"/>
						<div class="count" id="<% out.print("defaultCountdown"+i);%>"></div>
						
						</div>
						<div class="col-md-6">
							<a style="text-decoration: none; text-align: center;  margin-top: 0px;"
							class="button button--wayra button--border-medium button--text-upper button--size-s button--text-thick" href="ChiTiet?id=<%out.print(t.getMaSP()); %>">Xem thêm</a>
						</div>
					</div>
					</div>
						
				</div>
				<%} %>
				
				
				
				
				
			</div>
		</div>
		<div class="col-md-2">
		</div>
	</div>
</div>

<script>
	$(function () {
		
		var countItems = $(".tuan").length;
	
		for(var i=1; i<=countItems; i++ ){
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



                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               