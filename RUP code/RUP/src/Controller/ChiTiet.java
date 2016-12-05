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
import Model.Bean.CuocdaugiaBean;
import Model.Bean.MaxBean;
import Model.Bean.XemphienBean;

/**
 * Servlet implementation class ChiTiet
 */
@WebServlet("/ChiTiet")
public class ChiTiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTiet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try{
			request.setCharacterEncoding("utf-8");
			String id =  request.getParameter("id");
			
			SanphamBO ss = new SanphamBO();
			ArrayList<MaxBean> s = ss.getmax(id);
			
			
			SanphamBO sp = new SanphamBO();
			ArrayList<ChitietBean> spp = sp.getchitiet(id);
			
			SanphamBO t = new SanphamBO();
			ArrayList<CuocdaugiaBean> cd = t.getphien(id);
			
			request.setAttribute("chitiet", spp);
			request.setAttribute("phien", cd);
			request.setAttribute("max", s);

		
			RequestDispatcher rd = request.getRequestDispatcher("xemchitiet.jsp");
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
