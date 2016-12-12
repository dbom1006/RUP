package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BO.SanphamBO;
import Model.Bean.ChitietBean;

/**
 * Servlet implementation class ThemSanPham
 */
@WebServlet("/ThemSanPham")
public class ThemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String iduser =  request.getParameter("iduser");
		String tensanpham =  request.getParameter("tensanpham");
		String mota =  request.getParameter("mota");
		String anh =  request.getParameter("hinhanh");
		String tag =  request.getParameter("tag");
		
		try{
			SanphamBO t = new SanphamBO();
			if(t.insertsanpham(iduser, tensanpham, mota, anh, tag)){
				RequestDispatcher rd = request.getRequestDispatcher("suasanpham.jsp");
				rd.forward(request, response);
			}
			
			
		}
		catch(Exception x){
			response.getWriter().println(iduser+" "+tensanpham+" "+mota+" "+anh+" "+tag);
			response.getWriter().println("<html><body> Thông báo "+x.getMessage()+"</body></html>");
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
