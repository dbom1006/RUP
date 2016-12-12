package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.KhachhangBO;
import Model.BO.SanphamBO;
import Model.Bean.QuanlyBean;

/**
 * Servlet implementation class UpdateSanPham
 */
@WebServlet("/UpdateSanPham")
public class UpdateSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id =  request.getParameter("id");
		String tensanpham =  request.getParameter("tensanpham");
		String tag =  request.getParameter("tag");
		String anh =  request.getParameter("hinhanh");
		String mota =  request.getParameter("mota");
		
		
		try{
			
			SanphamBO sp = new SanphamBO();
			if(sp.updatesanpham(id, tensanpham, mota, anh, tag)){
				response.sendRedirect("SuaSanPham?id="+id.trim()+"&error=0");
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
