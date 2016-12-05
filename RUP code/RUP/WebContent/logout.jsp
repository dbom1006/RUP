<% 
	
	String id = request.getParameter("id");
	if(id.equals("1"))
	{
		session.removeAttribute("username");
		response.sendRedirect("dangnhap.jsp");
		return;
	}
	
%>