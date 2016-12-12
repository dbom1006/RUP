package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.SanphamBO;

/**
 * Servlet implementation class XoaSanPham
 */
@WebServlet("/XoaSanPham")
public class XoaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id =  request.getParameter("id");
		String user =  request.getParameter("user");

		
		try{
			
			SanphamBO sp = new SanphamBO();
			if(sp.xoasanpham(id)){
				
				response.sendRedirect("QuanLy?user="+user);
			}
			
		}catch(Exception e){
			response.getWriter().println("<html><body> Thông báo "+e.getMessage()+"</body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
