package Controller;

import java.io.IOException;
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
import Model.Bean.ChitietBean;
import Model.Bean.CuocdaugiaBean;
import Model.Bean.MaxBean;
import Model.Bean.QuanlyBean;
import Model.Bean.XemphienBean;

/**
 * Servlet implementation class QuanLy
 */
@WebServlet("/QuanLy")
public class QuanLy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user =  request.getParameter("user");
		try{
			
			KhachhangBO sp = new KhachhangBO();
			
			String id = sp.getidkhachhang(user);
			
			ArrayList<QuanlyBean> spp = sp.getquanly(user);
			
			request.setAttribute("quanly", spp);
			HttpSession session = request.getSession();
			session.setAttribute("username", user);
			session.setAttribute("iduser", id);

			RequestDispatcher rd = request.getRequestDispatcher("quanly.jsp");
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
