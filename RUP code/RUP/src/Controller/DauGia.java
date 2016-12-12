package Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.KhachhangBO;
import Model.BO.SanphamBO;
import Model.Bean.QuanlyBean;

/**
 * Servlet implementation class DauGia
 */
@WebServlet("/DauGia")
public class DauGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DauGia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sp =  request.getParameter("sp");
		String daugia =  request.getParameter("daugia");
		String iduser =  request.getParameter("iduser");
		String phien =  request.getParameter("phien");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
	
		
		
		try{
			SanphamBO t = new SanphamBO();
			t.daugia(iduser, phien, dtf.format(now),daugia);
		
			RequestDispatcher rd = request.getRequestDispatcher("ChiTiet?id="+sp);
			rd.forward(request, response);
		}catch(Exception e){
			response.getWriter().println(""+iduser);
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
