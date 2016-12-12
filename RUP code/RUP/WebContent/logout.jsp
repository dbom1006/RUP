<% 
	
	String id = request.getParameter("id");
	if(id.equals("1"))
	{
		session.removeAttribute("username");
		session.removeAttribute("iduser");
		response.sendRedirect("dangnhap.jsp");
		return;
	}
	
%>