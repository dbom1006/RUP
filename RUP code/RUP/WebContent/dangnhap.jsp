<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<title>Đăng nhập hệ thống</title>
<jsp:include page="header.jsp" />
</head>

<body>
  <div class="wrapper">
  <form class="login" action="DangNhap" method="POST">
    <p class="title">Đăng nhập</p>
    <input type="email" name="email" placeholder="Email" autofocus/>
    <i class="fa fa-user"></i>
    <input type="password" name="password" placeholder="Mật khẩu.." />
    <i class="fa fa-key"></i>
    
    <%  if(request.getParameter("id")!=null){ %>
    	
    	<% if(Integer.parseInt(request.getParameter("id"))==1){ %>
    	<p class="btn btn-danger">Tên đăng nhập hoặc mật khẩu không đúng!</p>
    	<% }else { %>
    	<p class="btn btn-danger">Đăng ký thành công vui lòng đăng nhập!</p>
    	
    	
   		<%}
    	
    	}%>
    
    
    <button type="submit">
      <i class="spinner"></i>
      <span class="state">Đăng nhập</span>
    </button>
  </form>
  <footer>Chưa có tài khoản <a href="dangky.jsp">ĐĂNG KÝ</a></footer>
  </p>
</div>


</body>
</html>