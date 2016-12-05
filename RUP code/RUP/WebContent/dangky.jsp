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
  <form class="login" action="DangKy" method="POST">
    <p class="title">Đăng ký</p>
    <input type="text" name="username" placeholder="Tên đăng nhập" autofocus/>
    <i class="fa fa-user"></i>
    <input type="password" name="password" placeholder="Mật khẩu" />
    <i class="fa fa-key"></i>
    <input type="email" name="email" placeholder="Email" />
    <i class="fa fa-envelope"></i>
    <button type="submit">
      <i class="spinner"></i>
      <span class="state">Đăng ký</span>
    </button>
  </form>
  <footer>Đã có tài khoản <a  href="dangnhap.jsp">ĐĂNG NHẬP</a></footer>
  </p>
</div>


</body>
</html>