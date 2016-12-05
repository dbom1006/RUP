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
import Model.Bean.MaxBean;
import Model.Bean.SanphamBean;
import Model.Bean.XemphienBean;



/**
 * Servlet implementation class HienThiServlet
 */
@WebServlet("/SanPham")
public class SanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			request.setCharacterEncoding("utf-8");

			SanphamBO sp = new SanphamBO();
			ArrayList<XemphienBean> spp = sp.getsanpham();
			
	
			
			request.setAttribute("sanpham", spp);

		
			RequestDispatcher rd = request.getRequestDispatcher("xemphien.jsp");
			rd.forward(request, response);
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
